package com.example.UserServiceApp.Controller;

import com.example.UserServiceApp.Service.UserService;
import com.example.UserServiceApp.dtos.Userdto;
import com.example.UserServiceApp.dtos.ValidateTokenRequestdto;
import com.example.UserServiceApp.dtos.loginRequestdto;
import com.example.UserServiceApp.dtos.signUprequestDto;
import com.example.UserServiceApp.model.Session;
import com.example.UserServiceApp.model.SessionStatus;
import com.example.UserServiceApp.model.Usermodel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Users")
@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signUp")
    public Userdto SignUp(@RequestBody signUprequestDto requestDto){
        Userdto userdto = userService.signup(requestDto.getEmailID(),requestDto.getPassword());
        return  userdto;
    }

    @PostMapping("/login")
    public ResponseEntity<Userdto> login(@RequestBody loginRequestdto loginRequest){
         return userService.login(loginRequest.getEmailID(),loginRequest.getPassword());
    }

    @PostMapping("/validate")
    public ResponseEntity<SessionStatus> validate(@RequestBody ValidateTokenRequestdto tokenRequestdto){
          SessionStatus session = userService.validate(tokenRequestdto.getToken());
          return  new ResponseEntity<>(session, HttpStatus.OK);
    }
}
