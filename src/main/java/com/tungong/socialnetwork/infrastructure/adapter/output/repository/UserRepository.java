package com.tungong.socialnetwork.infrastructure.adapter.output.repository;

import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);

    Boolean existsByEmail(String email);

    @Modifying
    @Transactional
    @Query("update UserEntity u set u.password = ?1 where u.id = ?2")
    void updatePassword(String password, Long userId);


    @Modifying
    @Transactional
    @Query("update UserEntity u set u.isPublic = ?1 where u.id = ?2")
    void updateIsPublic(Boolean isPublic, Long userId);

    @Modifying
    @Transactional
    @Query("update UserEntity u set u.profilePicture = ?1 where u.id = ?2")
    void updateProfilePicture(String profilePicture, Long userId);

    @Modifying
    @Transactional
    @Query("update UserEntity u set u.coverPicture = ?1 where u.id = ?2")
    void updateCoverPicture(String coverPicture, Long userId);
}
