package com.tungong.socialnetwork.application.port.input.post;

import com.tungong.socialnetwork.infrastructure.payload.request.PaginationRequest;
import com.tungong.socialnetwork.infrastructure.payload.request.post.ReactionRequest;
import com.tungong.socialnetwork.infrastructure.payload.response.post.ActivityInteractionResponse;
import com.tungong.socialnetwork.infrastructure.payload.response.post.ReactionPostResponse;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ReactionPostInput {
    ReactionPostResponse reactionPost(Long id, ReactionRequest reactionRequest);

    ReactionPostResponse getListReaction(Long postId, PaginationRequest paginationRequest);

    List<ActivityInteractionResponse> getListReactionInteractions(PaginationRequest paginationRequest);
}