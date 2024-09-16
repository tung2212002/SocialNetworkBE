package com.tungong.socialnetwork.application.port.output.post;

import com.tungong.socialnetwork.domain.model.post.Comment;
import com.tungong.socialnetwork.infrastructure.payload.request.PaginationRequest;

import java.util.List;

public interface CommentPostPort {
    Comment save(Comment comment);

    Comment getById(Long id);

    List<Comment> getListByPostId(Long id, List<Long> blockIds, PaginationRequest paginationRequest);

    List<Comment> getListByRootId(Long id, List<Long> blockIds, PaginationRequest paginationRequest);

    List<Comment> getListByUserId(Long id, PaginationRequest paginationRequest);

    void deleteById(Long id);

    void increaseCommentCount(Long id);

    void decreaseCommentCount(Long id, Long quantity);

    void increaseReactionCount(Long id);

    void decreaseReactionCount(Long id, Long quantity);
}
