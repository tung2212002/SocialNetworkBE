package com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.user;

import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.enums.EUserRoleEntity;
import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.enums.EUserStatusEntity;
import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.friendship.FriendshipEntity;
import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.post.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@Table(name = "user")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String firstName;

    @Column(nullable = false)
    String lastName;

    @Column(unique = true)
    String email;

    @Column(nullable = false)
    String password;

    String profilePicture;

    String coverPicture;

    Boolean isPublic = true;

    @Enumerated(EnumType.STRING)
    EUserStatusEntity status = EUserStatusEntity.ACTIVE;

    @Enumerated(EnumType.STRING)
    EUserRoleEntity role = EUserRoleEntity.USER;

    Instant createdAt;

    Instant updatedAt;

    Instant lastLogin;

    Instant deletedAt;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<DeviceEntity> devices;

    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    ProfileEntity profile;

//    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    List<PostEntity> posts;

//    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    List<FriendshipEntity> friendships;

//    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    List<CommentEntity> comments;

//    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    List<PostReactionEntity> postReactions;

//    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    List<CommentReactionEntity> commentReactions;

//    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    List<PostTagUserEntity> postTagUsers;

    public UserEntity(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = Instant.now();
        if (this.status == null) {
            this.status = EUserStatusEntity.ACTIVE;
        }
        if (this.role == null) {
            this.role = EUserRoleEntity.USER;
        }
        if (this.profile == null) {
            this.profile = new ProfileEntity();
            this.profile.setUserEntity(this);
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = Instant.now();
    }
}
