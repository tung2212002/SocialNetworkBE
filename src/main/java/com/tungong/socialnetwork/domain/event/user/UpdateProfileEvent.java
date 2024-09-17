package com.tungong.socialnetwork.domain.event.user;

import com.tungong.socialnetwork.domain.model.user.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateProfileEvent {
    private Profile profile;
}
