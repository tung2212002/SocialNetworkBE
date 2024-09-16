package com.tungong.socialnetwork.application.port.input.post;

import com.tungong.socialnetwork.infrastructure.payload.dto.post.ImagePostDto;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImagePostInput {
    int MAX_LENGTH_GENERATE = 8;

    ImagePostDto createImage(MultipartFile image, String tail);

    @Async
    void deleteImagePost(List<ImagePostDto> imagePost);
}
