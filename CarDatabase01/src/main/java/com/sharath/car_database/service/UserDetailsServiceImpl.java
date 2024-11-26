package com.sharath.car_database.service;

import com.sharath.car_database.domain.AppUser;
import com.sharath.car_database.domain.AppUserRepository;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AppUserRepository appUserRepository;


    public UserDetailsServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<AppUser> appUser = appUserRepository.findByUsername(username);

        UserBuilder builder = null;

        if (appUser.isPresent()) {
            AppUser currentUser = appUser.get();
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(currentUser.getPassword());
            builder.roles(currentUser.getRole());
        }
        else {
            throw new UsernameNotFoundException("user not found");
        }

        return builder.build();
    }
}
