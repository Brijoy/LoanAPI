package org.genbank.LoanAPI.controller;

import org.genbank.LoanAPI.model.UserInfo;
import org.genbank.LoanAPI.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("hello")
public class HomeController {


    @Autowired
    UserInfoService userInfoService;

  
	/*
	 * @Autowired private JwtService jwtService;
	 */

    @GetMapping("/users")
    public String helloUser(HttpServletRequest httpServletRequest){
        return "Hello User"+httpServletRequest.getSession().getId();
    }

    @GetMapping("/admin")
    public String helloAdmin(){
        return "Hello Admin";
    }

    @PostMapping("/addNewUser")
    public UserInfo addNewUser(@RequestBody UserInfo userInfo){

		return userInfoService.save(userInfo);

    }

    @GetMapping("/csrf-token")
    public CsrfToken csrfFilter(HttpServletRequest httpServletRequest){
        return (CsrfToken) httpServletRequest.getAttribute("_csrf");
    }

    @PostMapping("/login")
    public String verifyuser(@RequestBody UserInfo userInfo){
        return userInfoService.verifyUser(userInfo);
    }
}
