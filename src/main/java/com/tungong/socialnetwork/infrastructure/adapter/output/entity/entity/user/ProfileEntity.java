package com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.user;

import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.enums.EGenderEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Table(name = "profile")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileEntity {
    @Id
    private Long userId;

    LocalDate birthDate;

    String phoneNumber;

    @Enumerated(EnumType.STRING)
    EGenderEntity gender;

    String address;

    Integer cityId;

    Integer districtId;

    String school;

    String job;

    String company;

    String bio;

    Boolean isBirthDatePublic;

    Boolean isPhoneNumberPublic;

    Boolean isGenderPublic;

    Boolean isAddressPublic;

    Boolean isCityPublic;

    Boolean isDistrictPublic;

    Boolean isSchoolPublic;

    Boolean isJobPublic;

    Boolean isCompanyPublic;

    Boolean isBioPublic;

    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "user_id", nullable = false)
    UserEntity user;
}
