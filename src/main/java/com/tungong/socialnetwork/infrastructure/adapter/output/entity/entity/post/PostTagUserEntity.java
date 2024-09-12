package com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.post;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostTagUserEntity {
    Long id;

    @Column(nullable = false)
    Long postId;

    @Column(nullable = false)
    Long userId;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false, insertable = false, updatable = false)
//    @JoinColumn(name = "post_id", nullable = false)
//    PostEntity postEntity;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false, insertable = false, updatable = false)
//    @JoinColumn(name = "user_id", nullable = false)
//    UserEntity userEntity;
}
