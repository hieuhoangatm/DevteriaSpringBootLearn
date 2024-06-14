package com.hieu.SpringJPA.mapper;

import com.hieu.SpringJPA.dto.request.UserCreationRequest;
import com.hieu.SpringJPA.dto.request.UserUpdateRequest;
import com.hieu.SpringJPA.dto.response.UserResponse;
import com.hieu.SpringJPA.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "Spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    @Mapping(source = "firstname", target = "lastname")
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget  User user, UserUpdateRequest request);
}
