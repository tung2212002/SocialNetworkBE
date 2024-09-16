package com.tungong.socialnetwork.application.port.output.post;

import com.tungong.socialnetwork.domain.model.enums.EReactionType;
import com.tungong.socialnetwork.domain.model.post.CommentReaction;
import com.tungong.socialnetwork.infrastructure.payload.request.post.GetReactionRequest;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ReactionCommentPort {
    CommentReaction getByCommentIdAndUserId(Long commentId, Long userId);

    CommentReaction save(CommentReaction commentReaction);

    void delete(CommentReaction reactionComment);

    List<CommentReaction> getByCommentId(Long commentId, List<Long> blockIds);

    List<Map<EReactionType, Set<CommentReaction>>> getGroupByCommentId(Long id);

    List<CommentReaction> getByCommentIdAndListBlock(Long commentId, GetReactionRequest getReactionRequest, List<Long> blockIds);
}