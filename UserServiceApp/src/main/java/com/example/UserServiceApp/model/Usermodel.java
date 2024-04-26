package com.example.UserServiceApp.model;

import com.example.UserServiceApp.dtos.Userdto;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Usermodel extends BaseClass{
    private String name;
    private String emailID;
    private String password;

    public Userdto from(Usermodel user){
        Userdto userdto = new Userdto();
        userdto.setEmailID(user.getEmailID());
        userdto.setId(user.getId());
        userdto.setName(user.getName());
        userdto.setPassword(user.getPassword());
        return  userdto;
    }
}
