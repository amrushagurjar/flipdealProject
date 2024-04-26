package com.example.UserServiceApp.security;

//import com.example.UserServiceApp.model.Usermodel;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//public class CustomSpringUserDetails implements UserDetails {
//
//     private Usermodel usermodel;
//
//    public CustomSpringUserDetails(Usermodel usermodel) {
//        this.usermodel = usermodel;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return this.usermodel.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return this.usermodel.getName();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
