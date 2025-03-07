package com.hieu.SpringJPA.controller;

import com.hieu.SpringJPA.dto.request.ApiResponse;
import com.hieu.SpringJPA.dto.request.UserCreationRequest;
import com.hieu.SpringJPA.dto.request.UserUpdateRequest;
import com.hieu.SpringJPA.dto.response.UserResponse;
import com.hieu.SpringJPA.entity.User;
import com.hieu.SpringJPA.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request){
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));
        return  apiResponse;
    }

    @GetMapping
    List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable("userId") String userId){
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    UserResponse updateUser(@PathVariable String userId, @RequestBody  UserUpdateRequest request){
        return userService.updateUser(userId,request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId){
       userService.deleteUser(userId);
       return "User has been deleted";
    }

}
