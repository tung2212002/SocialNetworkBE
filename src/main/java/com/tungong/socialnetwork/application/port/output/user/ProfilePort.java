package com.tungong.socialnetwork.application.port.output.user;

import com.tungong.socialnetwork.domain.model.user.Profile;
import com.tungong.socialnetwork.domain.model.user.User;
import com.tungong.socialnetwork.infrastructure.payload.dto.user.ProfileStateDto;

public interface ProfilePort {
    User getUserById(Long id);

    Profile getProfileById(Long id);

    User setProfilePrivacyById(Boolean state, Long userId);

    Boolean setProfileStateById(ProfileStateDto profileStateDto, Long userId);

    String saveProfilePicture(String profilePicture, Long id);

    String saveCoverPicture(String coverPicture, Long id);
}
