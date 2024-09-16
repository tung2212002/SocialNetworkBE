package com.tungong.socialnetwork.infrastructure.mapper;

import com.tungong.socialnetwork.domain.model.enums.EReactionType;
import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.enums.EReactionTypeEntity;

public interface EReactionTypeMapperETD {
    EReactionType toDomain(EReactionTypeEntity eReactionTypeEntity) ;

    EReactionTypeEntity toEntity(EReactionType eReactionType) ;
}
