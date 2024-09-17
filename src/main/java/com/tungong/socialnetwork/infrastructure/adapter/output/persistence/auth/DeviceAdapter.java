package com.tungong.socialnetwork.infrastructure.adapter.output.persistence.auth;

import com.tungong.socialnetwork.application.port.output.user.DevicePort;
import com.tungong.socialnetwork.domain.model.user.Device;
import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.user.DeviceEntity;
import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.user.UserEntity;
import com.tungong.socialnetwork.infrastructure.adapter.output.repository.DeviceRepository;
import com.tungong.socialnetwork.infrastructure.adapter.output.repository.UserRepository;
import com.tungong.socialnetwork.infrastructure.adapter.output.repository.redis.RedisDeviceRepository;
import com.tungong.socialnetwork.infrastructure.mapper.DeviceMapperETD;
import com.tungong.socialnetwork.infrastructure.payload.dto.DeviceInfoDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeviceAdapter implements DevicePort {
    final DeviceRepository deviceRepository;
    final UserRepository userRepository;

    final DeviceMapperETD deviceMapperETD;
    final RedisDeviceRepository redisDeviceRepository;

    @Override
    public Device save(Device device) {
        DeviceEntity deviceEntity = deviceMapperETD.toEntity(device);
        System.out.println(device.getUserId());
        UserEntity userEntity = userRepository.findById(device.getUserId()).orElseThrow();
        System.out.println(userEntity.getId());
        deviceEntity.setUserEntity(userEntity);
        System.out.println("deviceEntity: " + deviceEntity.getUserEntity().getId());
        return deviceMapperETD.toDomain(deviceRepository.save(deviceEntity));
    }

    @Override
    public Device get(DeviceInfoDto device, Long userId) {
        DeviceEntity deviceEntity = deviceRepository.findByFingerprintingAndAgentAndIpAndUserEntityId(device.getFingerprinting(), device.getAgent(), device.getIp(), userId);
        return deviceMapperETD.toDomain(deviceEntity);
    }

    @Override
    public String generateOtp() {
        Random random = new Random();
        return String.format("%02d", random.nextInt(1000000));
    }

    @Override
    public void saveOtp(String otp, String userEmail, DeviceInfoDto device) {
        redisDeviceRepository.createWithTTL(userEmail + "_"+ otp, device);
    }
}
