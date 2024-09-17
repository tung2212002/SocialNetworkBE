package com.tungong.socialnetwork.infrastructure.adapter.output.persistence.auth;


import com.tungong.socialnetwork.application.port.output.auth.OtpPort;
import com.tungong.socialnetwork.common.customException.CustomException;
import com.tungong.socialnetwork.common.customException.ErrorCode;
import com.tungong.socialnetwork.infrastructure.adapter.output.repository.redis.RedisUserRegisterRepository;
import com.tungong.socialnetwork.infrastructure.payload.dto.DeviceInfoDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.redis.UserRegisterDataDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.user.UserRegisterDto;
import com.tungong.socialnetwork.infrastructure.payload.request.auth.RegisterRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OtpAdapter implements OtpPort {
    private final RedisUserRegisterRepository redisUserRegisterRepository;
    private final JavaMailSender mailSender;

    @Override
    public UserRegisterDataDto getOtpData(String email, String otp, DeviceInfoDto device) {
        System.out.println("1");
        List<String> keys = redisUserRegisterRepository.getAllKeyByPrefix(email);
        System.out.println("2");
        for (String key : keys) {
            System.out.println("4");
            System.out.println(key);
            UserRegisterDataDto userRegisterDataDto = redisUserRegisterRepository.getFullKey(key);
            System.out.println("5");
            System.out.println(userRegisterDataDto);
            System.out.println(userRegisterDataDto.getFingerprinting());
            System.out.println(userRegisterDataDto.getAgent());
            System.out.println(userRegisterDataDto.getIp());
            if (userRegisterDataDto.getFingerprinting().equals(device.getFingerprinting())
                    && userRegisterDataDto.getAgent().equals(device.getAgent())
                    && userRegisterDataDto.getIp().equals(device.getIp())) {
                System.out.println("6");
                return userRegisterDataDto;
            }
        }
        System.out.println("3");
        return null;
    }

    @Override
    public void deleteAllOtpDataForEmail(String email) {
        redisUserRegisterRepository.deleteAllByPrefix(email);
    }

    @Override
    public void deleteOtpData(String email, DeviceInfoDto device) {
        List<String> keys = redisUserRegisterRepository.getAllKeyByPrefix(email);
        for (String key : keys) {
            UserRegisterDataDto userRegisterDataDto = redisUserRegisterRepository.get(key);
            if (userRegisterDataDto != null && userRegisterDataDto.getOtp().equals(device.getIp()) && userRegisterDataDto.getIp().equals(device.getIp())) {
                redisUserRegisterRepository.delete(key);
                return;
            }
        }
    }

    @Override
    public void incrementOtpDataCount(String email, DeviceInfoDto device) {
        List<String> keys = redisUserRegisterRepository.getAllKeyByPrefix(email);
        for (String key : keys) {
            UserRegisterDataDto userRegisterDataDto = redisUserRegisterRepository.getFullKey(key);
            if (userRegisterDataDto != null && userRegisterDataDto.getIp().equals(device.getIp())) {
                userRegisterDataDto.setCount(userRegisterDataDto.getCount() + 1);
                redisUserRegisterRepository.updateFullKey(key, userRegisterDataDto);
                return;
            }
        }
    }

    @Override
    public void saveOtp(RegisterRequest registerRequest, String otp, DeviceInfoDto device) {
        List<String> keys = redisUserRegisterRepository.getAllKeyByPrefix(registerRequest.getEmail());
        for (String key : keys) {
            UserRegisterDataDto userRegisterDataDto = redisUserRegisterRepository.getFullKey(key);
            if (userRegisterDataDto != null
                    && userRegisterDataDto.getIp().equals(device.getIp())
                    && userRegisterDataDto.getAgent().equals(device.getAgent())
                    && userRegisterDataDto.getFingerprinting().equals(device.getFingerprinting())) {
                userRegisterDataDto.setOtp(otp);
                redisUserRegisterRepository.deleteFullKey(key);
            }
        }
        UserRegisterDto userRegisterDto = new UserRegisterDto().builder()
                .email(registerRequest.getEmail())
                .password(registerRequest.getPassword())
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .build();
        UserRegisterDataDto userRegisterDataDto = new UserRegisterDataDto().builder()
                .user(userRegisterDto)
                .otp(otp)
                .count(0)
                .fingerprinting(device.getFingerprinting())
                .agent(device.getAgent())
                .ip(device.getIp())
                .build();

        redisUserRegisterRepository.createWithTTL(registerRequest.getEmail() + otp, userRegisterDataDto);
    }

    @Override
    public String generateOtp() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(1000000));
    }

    @Async
    @Override
    public void sendOtpEmail(String email, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Your OTP Code");
        message.setText("Your OTP code is: " + otp);

        try {
            mailSender.send(message);
            System.out.println("OTP: " + otp);
        } catch (MailException e) {
            throw new CustomException(ErrorCode.EXCEPTION_ERROR);
        }
    }
}
