package com.tungong.socialnetwork.application.port.input.post;

import ai.djl.translate.TranslateException;
import ai.onnxruntime.OrtException;
import com.amazonaws.services.pinpoint.model.MessageResponse;
import com.tungong.socialnetwork.infrastructure.payload.request.PaginationRequest;
import com.tungong.socialnetwork.infrastructure.payload.request.post.CommentPostRequest;
import com.tungong.socialnetwork.infrastructure.payload.request.post.ReplyCommentRequest;
import com.tungong.socialnetwork.infrastructure.payload.request.post.UpdateCommentRequest;
import com.tungong.socialnetwork.infrastructure.payload.response.post.ActivityInteractionResponse;
import com.tungong.socialnetwork.infrastructure.payload.response.post.CommentResponse;

import java.util.List;

public interface CommentPostInput {
    CommentResponse createCommentRoot(CommentPostRequest comment) throws TranslateException, OrtException;

    CommentResponse createCommentReply(ReplyCommentRequest comment) throws TranslateException, OrtException;

    List<CommentResponse> getCommentsByPostId(Long id, PaginationRequest paginationRequest);

    List<ActivityInteractionResponse> getListCommentInteractions(PaginationRequest paginationRequest);

    CommentResponse getCommentById(Long id);

    List<CommentResponse> getCommentChildByParentId(Long id, PaginationRequest paginationRequest);

    MessageResponse deleteComment(Long id);

    CommentResponse updateComment(Long id, UpdateCommentRequest comment) throws TranslateException, OrtException;
}
