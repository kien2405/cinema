package com.example.cinema.mapper;

import com.example.cinema.dto.request.UserCreateRequest;
import com.example.cinema.dto.response.UserResponse;
import com.example.cinema.entity.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toUser(UserCreateRequest request);
    UserResponse toUserResponse(UserEntity user);
}
