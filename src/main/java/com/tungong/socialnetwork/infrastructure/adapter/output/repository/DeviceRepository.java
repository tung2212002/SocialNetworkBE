package com.tungong.socialnetwork.infrastructure.adapter.output.repository;

import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.user.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity, Long> {
    Optional<DeviceEntity> findById(Long id);
}
