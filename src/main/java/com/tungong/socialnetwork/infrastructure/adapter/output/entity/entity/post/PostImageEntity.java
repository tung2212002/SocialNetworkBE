package com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.post;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Table(name = "post_image")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    Long postId;

    @Column(nullable = false)
    String url;

    @Column(nullable = false, columnDefinition = "TINYINT")
    @Size(min = 1, max = 20)
    Integer position;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "post_id", nullable = false, insertable = false, updatable = false)
//    PostEntity postEntity;
}
