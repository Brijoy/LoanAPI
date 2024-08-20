package org.genbank.LoanAPI.repository;

import org.genbank.LoanAPI.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {

    UserInfo  findByUsername(String userName);
    /*Optional<UserInfo>  findByUsername(String userName);
    Optional<UserInfo>  findByEmail(String email);*/

}
