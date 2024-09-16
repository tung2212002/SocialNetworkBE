package com.tungong.socialnetwork.application.port.input.post;

import com.tungong.socialnetwork.infrastructure.payload.request.PaginationRequest;
import com.tungong.socialnetwork.infrastructure.payload.request.post.ReactionRequest;
import com.tungong.socialnetwork.infrastructure.payload.response.post.ReactionCommentResponse;

public interface ReactionCommentInput {
    ReactionCommentResponse reactionComment(Long commentId, ReactionRequest reactionRequest);

    ReactionCommentResponse getListReaction(Long id, PaginationRequest paginationRequest);
}
