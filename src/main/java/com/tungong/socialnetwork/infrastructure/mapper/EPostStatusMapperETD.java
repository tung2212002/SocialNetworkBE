package com.tungong.socialnetwork.infrastructure.mapper;

import com.tungong.socialnetwork.domain.model.enums.EPostStatus;
import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.enums.EPostStatusEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EPostStatusMapperETD {
  EPostStatus toDomain(EPostStatusEntity ePostStatusEntity) ;

  EPostStatusEntity toEntity(EPostStatus ePostStatus) ;
}
