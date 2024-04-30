package com.example.flipDeal.Controller;

import com.example.flipDeal.Service.UserService;
import com.example.flipDeal.dtos.Userdto;
import com.example.flipDeal.dtos.ValidateTokenRequestdto;
import com.example.flipDeal.dtos.loginRequestdto;
import com.example.flipDeal.dtos.signUprequestDto;
import com.example.flipDeal.model.SessionStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Users")
@Controller
@CrossOrigin(allowedHeaders = "*" ,origins="*")
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
