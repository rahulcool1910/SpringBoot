package com.example.springbasics.user_controller;


import com.example.springbasics.user_controller.dto.userDTO;
import com.example.springbasics.user_controller.dto.userPasswordModel;
import com.example.springbasics.user_controller.entity.UserEntity;
import com.example.springbasics.user_controller.models.userDetailsRequestModel;
import com.example.springbasics.user_controller.response.userResponse;
import com.example.springbasics.user_controller.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("/user")

public class userController {
    @Autowired()
    UserService userService;

//    @Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;
    String user="default";
    @GetMapping
    @RequestMapping("/test")
    public String getUserDummy()  {

        return user;
    }
    @GetMapping
    public userResponse getUser(@RequestBody userDetailsRequestModel data) throws Exception {
        System.out.println(data+" : Email" );
        UserEntity userDetails=userService.getUser(data.getEmail());
        if(userDetails == null) throw new Exception("Not found");
        userResponse response=new userResponse();
        BeanUtils.copyProperties(userDetails,response);
        return response;
    }

    @PostMapping
    public userResponse setUser(@RequestBody userDetailsRequestModel userDetails){

        System.out.println(userDetails);
        userDTO userData=new userDTO();
        BeanUtils.copyProperties(userDetails,userData);
        userDTO createdUser= userService.createUser(userData);
        userResponse response = new userResponse();
        BeanUtils.copyProperties(createdUser,response);
        return response;
    }

    @PostMapping()
    @RequestMapping("/check")
    public boolean authenticateUser(@RequestBody userPasswordModel userData){
        System.out.println(userData);
        UserEntity entity= userService.getUser(userData.getEmail());
        System.out.println(entity);
        System.out.println(entity.getPassword());

        return userService.checkPassword(userData.getPassword(),entity.getPassword());
    }
}



