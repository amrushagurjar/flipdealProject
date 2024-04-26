//package com.example.UserServiceApp.security;
//
//import com.example.UserServiceApp.model.Usermodel;
//import com.example.UserServiceApp.repository.UserRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class CustomUserDetailService implements UserDetailsService {
//
//    private UserRepository userRepository;
//
//    public CustomUserDetailService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<Usermodel> optionalUser = userRepository.findByEmailID(email);
//        if(optionalUser.isEmpty()){
//            throw new UsernameNotFoundException("User does not exists");
//        }
//        Usermodel usermodel = optionalUser.get();
//        return new CustomSpringUserDetails(usermodel);
//    }
//}
