package com.tungong.socialnetwork.application.port.input.user;

import com.tungong.socialnetwork.infrastructure.payload.dto.user.ProfileStateDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.user.UserDto;
import com.tungong.socialnetwork.infrastructure.payload.request.user.SetProfileStateRequest;
import com.tungong.socialnetwork.infrastructure.payload.request.user.UpdateProfileRequest;
import org.springframework.web.multipart.MultipartFile;

public interface ProfilePortInput {
    UserDto getProfile(Long id);

    UserDto updateProfile(UpdateProfileRequest updateProfileRequest);

    UserDto setStateProfile(ProfileStateDto profileStateDto);

    UserDto setPublicProfile(SetProfileStateRequest profileStateDto);

    UserDto updateProfilePicture(MultipartFile file);

    UserDto updateCoverPicture(MultipartFile background);
}
