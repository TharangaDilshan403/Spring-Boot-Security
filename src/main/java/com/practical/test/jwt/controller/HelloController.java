package com.practical.test.jwt.controller;

import com.practical.test.jwt.dto.UserDTO;
import com.practical.test.jwt.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping
    public String save(){
        return "Success..";
    }


//    jwt
    @PostMapping("/authenticate")
    public String generateToken(@RequestBody UserDTO userDTO) throws  Exception{

        try{
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDTO.getUserName(),userDTO.getUserPassword())
        );
    }catch (Exception ex){
            throw new Exception("Invalid user name and password...");
        }
        return jwtUtility.generateToken(userDTO.getUserName());
    }

}
