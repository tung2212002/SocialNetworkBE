package com.tungong.socialnetwork.domain.event.comment;

import com.tungong.socialnetwork.domain.model.post.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentCreateEvent {
    private Comment comment;
}
