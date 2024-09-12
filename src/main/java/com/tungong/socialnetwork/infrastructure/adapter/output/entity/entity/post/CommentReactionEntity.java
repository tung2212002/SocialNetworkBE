package com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.post;

import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.enums.EReactionTypeEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Table(name = "comment_reaction")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentReactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    Long commentId;

    @Column(nullable = false)
    Long userId;

    @Enumerated(EnumType.STRING)
    EReactionTypeEntity reactionType;

    Instant createdAt;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
//    @JoinColumn(name = "comment_id", nullable = false, insertable = false, updatable = false)
//    CommentEntity commentEntity;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
//    UserEntity userEntity;

    public CommentReactionEntity(Long commentId, Long userId, EReactionTypeEntity reactionType) {
        this.commentId = commentId;
        this.userId = userId;
        this.reactionType = reactionType;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = Instant.now();
    }
}
