package com.tungong.socialnetwork.application.port.output;


import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface CloudPort {
    Map uploadImageByFile(MultipartFile file);

    Map uploadImageByFile(MultipartFile file, Long size);

    String extractUrl(Map data);

    String extractPublicId(Map data);

    String extractByKey(Map data, String key);

    boolean deleteImageByUrl(String url);
}
