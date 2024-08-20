package org.genbank.LoanAPI.service;

import org.genbank.LoanAPI.model.UserInfo;
import org.genbank.LoanAPI.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder encoder ;

    public UserInfo save(UserInfo userInfo) {
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        return userInfoRepository.save(userInfo);
    }

    public String verifyUser(UserInfo userInfo){
    	System.out.println("UserInfo>>> "+userInfo.toString());
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        userInfo.getUsername(),userInfo.getPassword()));
        System.out.println("authentication>>> "+ authentication);

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(userInfo.getUsername());
        }
        return "Failed";
    }
}
