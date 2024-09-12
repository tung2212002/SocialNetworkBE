package com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.user;

import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.enums.EDeviceTypeEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Table(name = "device")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeviceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

//    @Column(nullable = false)
//    Long userId;

    String fingerprinting;

    String deviceInfo;

    @Enumerated(EnumType.STRING)
    EDeviceTypeEntity deviceType;

    Instant createdAt;

    Instant updatedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    UserEntity userEntity;

    @PrePersist
    public void prePersist() {
        this.createdAt = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = Instant.now();
    }
}
