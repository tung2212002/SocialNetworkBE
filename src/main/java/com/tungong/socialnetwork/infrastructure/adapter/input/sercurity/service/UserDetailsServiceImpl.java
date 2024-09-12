package com.tungong.socialnetwork.infrastructure.adapter.input.sercurity.service;

import com.tungong.socialnetwork.infrastructure.adapter.output.entity.entity.user.UserEntity;
import com.tungong.socialnetwork.infrastructure.adapter.output.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null)
            throw new UsernameNotFoundException("User Not Found with email: " + email);

        return new UserDetailsImpl(user);
    }
}
