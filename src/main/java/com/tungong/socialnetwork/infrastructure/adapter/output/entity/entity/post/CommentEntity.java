package com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.post;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Table(name = "comment")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    Long postId;

    @Column(nullable = false)
    Long userId;

    Long rootCommentId;

    String url;

    String content;

    Long reactionQuantity = 0L;

    Long replyQuantity = 0L;

    Instant createdAt;

    Instant updatedAt;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false, insertable = false, updatable = false)
//    @JoinColumn(name = "post_id", nullable = false)
//    PostEntity postEntity;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false, insertable = false, updatable = false)
//    @JoinColumn(name = "user_id", nullable = false)
//    UserEntity userEntity;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false, insertable = false, updatable = false)
//    @JoinColumn(name = "root_comment_id", nullable = false)
//    CommentEntity rootCommentEntity;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "commentEntity")
//    List<CommentReactionEntity> commentReactionEntities;

    public CommentEntity(Long postId, Long userId, String content, Long rootCommentId, String url) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.rootCommentId = rootCommentId;
        this.url = url;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = Instant.now();
    }

}
