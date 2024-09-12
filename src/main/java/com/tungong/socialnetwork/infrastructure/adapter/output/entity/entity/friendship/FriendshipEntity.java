package com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.friendship;

import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.enums.EFriendshipStatusEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Table(name = "friendship")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FriendshipEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    Long userInitiatorId;

    @Column(nullable = false)
    Long userReceiverId;

    @Enumerated(EnumType.STRING)
    EFriendshipStatusEntity status;

    Instant createdAt;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_initiator_id", nullable = false, insertable = false, updatable = false)
//    UserEntity userInitiatorEntity;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_receiver_id", nullable = false, insertable = false, updatable = false)
//    UserEntity userReceiverEntity;

    public FriendshipEntity(Long userInitiatorId, Long userReceiverId, EFriendshipStatusEntity status) {
        this.userInitiatorId = userInitiatorId;
        this.userReceiverId = userReceiverId;
        this.status = status;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = Instant.now();
    }
}
