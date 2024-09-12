package com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.post;

import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.enums.EPostStatusEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Table(name = "post")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    Long userId;

    @Column(columnDefinition = "TEXT")
    String content;

    @Enumerated(EnumType.STRING)
    EPostStatusEntity status;

    Long reactionQuantity = 0L;

    Long commentQuantity = 0L;

    Instant createdAt;

    Instant updatedAt;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id", insertable = false, updatable = false)
//    UserEntity userEntity;

//    @OneToMany(mappedBy = "postEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    List<PostImageEntity> postImages;

//    @OneToMany(mappedBy = "postEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    List<PostReactionEntity> postReactions;

//    @OneToMany(mappedBy = "postEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    List<PostCommentEntity> postComments;

//    @OneToMany(mappedBy = "postEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    List<PostTagUserEntity> postTagUsers;

    public PostEntity(Long userId, String content, EPostStatusEntity status) {
        this.userId = userId;
        this.content = content;
        this.status = status;
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
