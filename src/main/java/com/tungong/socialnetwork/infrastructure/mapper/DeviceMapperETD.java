package com.tungong.socialnetwork.infrastructure.mapper;

import com.tungong.socialnetwork.domain.model.enums.EDeviceType;
import com.tungong.socialnetwork.domain.model.user.Device;
import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.enums.EDeviceTypeEntity;
import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.user.DeviceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface DeviceMapperETD {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "userId", source = "userEntity.id")
    @Mapping(target = "deviceType", source = "deviceType", qualifiedByName = "mapDeviceTypeToDomain")
    Device toDomain(DeviceEntity entity);

    @Mapping(target = "deviceType", source = "deviceType", qualifiedByName = "mapDeviceTypeToEntity")
    DeviceEntity toEntity(Device device);

    @Named("mapDeviceTypeToEntity")
    default EDeviceTypeEntity mapDeviceTypeToEntity(EDeviceType deviceType) {
        if (deviceType == null) {
            return null;
        }
        return EDeviceTypeEntity.valueOf(deviceType.name());
    }

    @Named("mapDeviceTypeToDomain")
    default EDeviceType mapDeviceTypeToDomain(EDeviceTypeEntity deviceTypeEntity) {
        if (deviceTypeEntity == null) {
            return null;
        }
        return EDeviceType.valueOf(deviceTypeEntity.name());
    }
}

