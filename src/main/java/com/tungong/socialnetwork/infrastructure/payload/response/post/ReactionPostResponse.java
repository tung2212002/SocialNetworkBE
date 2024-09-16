package com.tungong.socialnetwork.infrastructure.payload.response.post;

import com.tungong.socialnetwork.domain.model.enums.EReactionType;
import com.tungong.socialnetwork.infrastructure.payload.dto.post.ReactionCountDto;
import com.tungong.socialnetwork.infrastructure.payload.dto.post.ReactionUserDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReactionPostResponse {
    String role;

    Long roleId;

    List<ReactionUserDto> users;

    List<ReactionCountDto> reactions;

    @Builder
    public ReactionPostResponse(String role, Long roleId, List<ReactionUserDto> users, List<ReactionCountDto> reactions) {
        this.role = role != null ? role : "post";
        this.roleId = roleId;
        this.users = users;
        this.reactions = reactions;
    }
}
