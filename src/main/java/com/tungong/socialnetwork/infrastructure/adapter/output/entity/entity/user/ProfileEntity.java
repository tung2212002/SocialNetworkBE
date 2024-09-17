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

    Boolean isBirthDatePublic = true;

    Boolean isPhoneNumberPublic = true;

    Boolean isGenderPublic = true;

    Boolean isAddressPublic = true;

    Boolean isCityPublic = true;

    Boolean isDistrictPublic = true;

    Boolean isSchoolPublic = true;

    Boolean isJobPublic = true;

    Boolean isCompanyPublic = true;

    Boolean isBioPublic = true;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id", nullable = false)
    UserEntity userEntity;
}
