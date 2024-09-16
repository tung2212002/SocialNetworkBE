package com.tungong.socialnetwork.infrastructure.adapter.output.persistence.auth;

import com.tungong.socialnetwork.application.port.output.user.ProfilePort;
import com.tungong.socialnetwork.domain.model.user.Profile;
import com.tungong.socialnetwork.domain.model.user.User;
import com.tungong.socialnetwork.infrastructure.adapter.output.repository.ProfileRepository;
import com.tungong.socialnetwork.infrastructure.adapter.output.repository.UserRepository;
import com.tungong.socialnetwork.infrastructure.payload.dto.user.ProfileStateDto;
import com.tungong.socialnetwork.infrastructure.payload.mapper.UserMapperETD;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileAdapter implements ProfilePort {
    final UserRepository userRepository;
    final ProfileRepository profileRepository;

    final UserMapperETD userMapperETD;

    @Override
    public User getUserById(Long id) {
        return userMapperETD.toDomain(userRepository.findById(id).orElse(null));
    }

    @Override
    public Profile getProfileById(Long id) {
        return userMapperETD.toDomain(profileRepository.findById(id).orElse(null));
    }

    @Override
    public User setProfilePrivacyById(Boolean state, Long userId) {
        return null;
    }

    @Override
    public Boolean setProfileStateById(ProfileStateDto profileStateDto, Long userId) {
        return null;
    }

    @Override
    public String saveProfilePicture(String profilePicture, Long id) {
        return null;
    }

    @Override
    public String saveCoverPicture(String coverPicture, Long id) {
        return null;
    }
}
