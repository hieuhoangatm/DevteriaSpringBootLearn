package com.hieu.SpringJPA.service;

import com.hieu.SpringJPA.dto.request.UserCreationRequest;
import com.hieu.SpringJPA.dto.request.UserUpdateRequest;
import com.hieu.SpringJPA.dto.response.UserResponse;
import com.hieu.SpringJPA.entity.User;
import com.hieu.SpringJPA.exception.AppException;
import com.hieu.SpringJPA.exception.ErrorCode;
import com.hieu.SpringJPA.mapper.UserMapper;
import com.hieu.SpringJPA.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;
    public User createUser(UserCreationRequest request){
        if(userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return userRepository.save(user);
    }

    public UserResponse updateUser(String userId, UserUpdateRequest request){
        User user = userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found"));

        userMapper.updateUser(user,request);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(String userId){
        userRepository.deleteById(userId);
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public UserResponse getUser(String id){
        return userMapper.toUserResponse(userRepository.findById(id)
                            .orElseThrow(()->new RuntimeException("user not found")));
    }
}
