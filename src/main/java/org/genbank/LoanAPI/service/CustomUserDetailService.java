package org.genbank.LoanAPI.service;

import org.genbank.LoanAPI.model.UserInfo;
import org.genbank.LoanAPI.model.UserPrincipal;
import org.genbank.LoanAPI.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Component
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserInfo user = userInfoRepository
                .findByUsername(userName);

        if(user == null){
            throw new UsernameNotFoundException("Username not Found "+userName);
        }


        return new UserPrincipal(user);
    }
}
