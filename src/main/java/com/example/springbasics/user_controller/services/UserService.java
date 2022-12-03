package com.example.springbasics.user_controller.services;

import com.example.springbasics.user_controller.dto.userDTO;
import com.example.springbasics.user_controller.entity.UserEntity;
import com.example.springbasics.user_controller.interfaces.IUserService;
import com.example.springbasics.user_controller.repositary.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public userDTO createUser(userDTO userDetails) {
        UserEntity userData=new UserEntity();

        BeanUtils.copyProperties(userDetails,userData );
        System.out.println(userData+"data");
        userData.setPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
        UserEntity savedData=userRepository.save(userData);
        userDTO response=new userDTO();
        System.out.println(response);
        BeanUtils.copyProperties(savedData,response);
        return response;
    }
    public UserEntity getUser(String email){
        return userRepository.findByEmail(email);
    }
    public boolean checkPassword(String password,String hashedPassword){
        return bCryptPasswordEncoder.matches(password,hashedPassword);
    }

}
