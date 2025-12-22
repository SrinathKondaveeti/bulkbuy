package com.bulkbuy.security.service;


import com.bulkbuy.entity.BulkBuyUserEntity;
import com.bulkbuy.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BulkBuyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String emailIdOrMobileNumber) throws UsernameNotFoundException {


        BulkBuyUserEntity bulkBuyUserEntity = userRepository.findByEmailId(emailIdOrMobileNumber)
                .orElseGet(() -> userRepository.findByMobileNumber(emailIdOrMobileNumber)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found with username or email: " + emailIdOrMobileNumber)));

        return bulkBuyUserEntity;

    }
}
