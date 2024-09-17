package com.tungong.socialnetwork.domain.event.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RemoveUserEvent {
    private String email;
}
