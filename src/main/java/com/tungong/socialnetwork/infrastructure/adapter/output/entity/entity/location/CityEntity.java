package com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.location;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Table(name = "city")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String code;

    String nameWithType;

    String slug;

    String type;

    String country;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    List<DistrictEntity> districts;
}
