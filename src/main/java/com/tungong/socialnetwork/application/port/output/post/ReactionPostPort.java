package com.tungong.socialnetwork.application.port.output.post;

import com.tungong.socialnetwork.domain.model.enums.EReactionType;
import com.tungong.socialnetwork.domain.model.post.PostReaction;
import com.tungong.socialnetwork.infrastructure.payload.request.PaginationRequest;
import com.tungong.socialnetwork.infrastructure.payload.request.post.GetReactionRequest;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ReactionPostPort {
    PostReaction getByPostIdAndUserId(Long postId, Long userId);

    PostReaction save(PostReaction reactionPost);

    void delete(PostReaction reactionPost);

    List<PostReaction> getByPostId(Long postId);

    List<Map<EReactionType, Set<PostReaction>>> getGroupByPostId(Long postId);

    List<PostReaction> getByPostIdAndListBlock(Long postId, GetReactionRequest getReactionRequest, List<Long> blockIds);

    List<Object[]> getInteractions(Long userId, PaginationRequest paginationRequest);
}