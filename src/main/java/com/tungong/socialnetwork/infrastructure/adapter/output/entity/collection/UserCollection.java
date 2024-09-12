package com.tungong.socialnetwork.infrastructure.adapter.output.entity.collection;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCollection {
    @Id
    String id;

    Long userId;

    Boolean isDeleted = false;

    Instant lastActiveAt;

    public UserCollection(Long userId) {
        this.userId = userId;
    }
}
