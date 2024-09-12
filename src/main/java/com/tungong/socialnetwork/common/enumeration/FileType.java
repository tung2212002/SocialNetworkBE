package com.tungong.socialnetwork.common.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.MediaType;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum FileType {
    JPG("jpg", MediaType.IMAGE_JPEG),
    JPEG("jpeg", MediaType.IMAGE_JPEG),
    PNG("png", MediaType.IMAGE_PNG),
    GIF("gif", MediaType.IMAGE_GIF),
    PDF("pdf", MediaType.APPLICATION_PDF),
    DOC("txt", MediaType.TEXT_PLAIN);

    private final String extension;

    private final MediaType mediaType;

    public static MediaType getMediaType(String fileName) {
        int index = fileName.lastIndexOf(".");
        String extension = index == -1 ? "" : fileName.substring(index + 1);
        return Arrays.stream(values())
                .filter(fileType -> fileType.getExtension().equals(extension))
                .findFirst()
                .map(FileType::getMediaType)
                .orElse(MediaType.APPLICATION_OCTET_STREAM);
    }

    public static boolean isImage(String fileName) {
        return getMediaType(fileName).getType().equals("image");
    }
}
