package com.tungong.socialnetwork.domain.event.user;

import com.tungong.socialnetwork.domain.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserEvent {
    private User user;
}