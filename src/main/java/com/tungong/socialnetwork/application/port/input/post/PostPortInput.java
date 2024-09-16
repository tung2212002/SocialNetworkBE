package com.tungong.socialnetwork.application.port.input.post;

import ai.djl.translate.TranslateException;
import ai.onnxruntime.OrtException;
import com.tungong.socialnetwork.infrastructure.payload.request.PaginationRequest;
import com.tungong.socialnetwork.infrastructure.payload.request.post.CreateOrUpdatePostRequest;
import com.tungong.socialnetwork.infrastructure.payload.response.post.InteractionResponse;
import com.tungong.socialnetwork.infrastructure.payload.response.post.PostResponse;

import java.util.List;

public interface PostPortInput {
    List<PostResponse> getPostsByUserId(Long id, PaginationRequest paginationRequest);

    List<InteractionResponse> getPostsByInteractions();

    List<InteractionResponse> getPostsTagMe(PaginationRequest paginationRequest);

    PostResponse getPostByPostId(Long id);

    PostResponse createPost(CreateOrUpdatePostRequest createPostRequest) throws TranslateException, OrtException;

    PostResponse updatePost(Long postId, CreateOrUpdatePostRequest updatePostRequest) throws TranslateException, OrtException;

    String deletePost(Long id);

    List<PostResponse> getPostsSuggest(PaginationRequest paginationRequest);
}
