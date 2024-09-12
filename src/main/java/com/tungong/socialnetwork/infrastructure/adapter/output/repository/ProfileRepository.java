package com.tungong.socialnetwork.infrastructure.adapter.output.repository;

import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.user.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
}
