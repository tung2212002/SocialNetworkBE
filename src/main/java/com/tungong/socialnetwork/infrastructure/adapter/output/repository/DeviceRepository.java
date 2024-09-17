package com.tungong.socialnetwork.infrastructure.adapter.output.repository;

import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.user.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity, Long> {
    Optional<DeviceEntity> findById(Long id);

    @Query("SELECT d FROM DeviceEntity d WHERE d.fingerprinting = :fingerprinting AND d.agent = :agent AND d.ip = :ip AND d.userEntity.id = :userId")
    DeviceEntity findByFingerprintingAndAgentAndIpAndUserEntityId(String fingerprinting, String agent, String ip, Long userId);
}
