package com.tungong.socialnetwork.domain.model.user;

import com.tungong.socialnetwork.domain.model.enums.EUserRole;
import com.tungong.socialnetwork.domain.model.enums.EUserStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    Long id;

    String firstName;

    String lastName;

    String email;

    String password;

    String profilePicture;

    String coverPicture;

    Boolean isPublic;

    EUserStatus status;

    EUserRole role;
    Instant createdAt;

    Instant updatedAt;

    Instant lastLogin;

    Instant deletedAt;

    public User(String firstName, String lastName, String email, String password, String profilePicture, String coverPicture, Boolean isPublic, EUserStatus status, Instant createdAt, Instant updatedAt, Instant lastLogin, Instant deletedAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isPublic = true;
        this.status = EUserStatus.ACTIVE;
        this.role = EUserRole.USER;
        this.createdAt = Instant.now();
    }
}
