package com.tungong.socialnetwork.domain.event.post;

import com.tungong.socialnetwork.domain.model.post.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostUpdateEvent {
    private Post post;
}
