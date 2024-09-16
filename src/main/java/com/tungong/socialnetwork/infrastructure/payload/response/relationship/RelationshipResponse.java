package com.tungong.socialnetwork.infrastructure.payload.response.relationship;

import com.tungong.socialnetwork.infrastructure.payload.dto.relationship.FriendShipUserDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RelationshipResponse {
    private List<FriendShipUserDto> users;

    private Long quantity;
}
