package com.tungong.socialnetwork.application.port.output.post;

import com.tungong.socialnetwork.domain.model.post.PostImage;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface ImagePostPort {
    void deleteById(Long id);

    @Async
    void deleteAllInRedisByTail(String tail);

    PostImage save(PostImage postImage);

    List<PostImage> saveAll(List<PostImage> postImages);

    List<PostImage> getAllByPostId(Long id);
}
