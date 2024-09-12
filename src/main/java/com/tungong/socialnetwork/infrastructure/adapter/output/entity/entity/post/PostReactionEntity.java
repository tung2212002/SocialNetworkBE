package com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.post;

import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.enums.EReactionTypeEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Table(name = "post_reaction")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostReactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    Long postId;

    @Column(nullable = false)
    Long userId;

    @Enumerated(EnumType.STRING)
    EReactionTypeEntity reactionType;

    Instant createdAt;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "post_id", nullable = false, insertable = false, updatable = false)
//    PostEntity postEntity;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
//    UserEntity userEntity;

    public PostReactionEntity(Long postId, Long userId, EReactionTypeEntity reactionType) {
        this.postId = postId;
        this.userId = userId;
        this.reactionType = reactionType;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = Instant.now();
    }
}
