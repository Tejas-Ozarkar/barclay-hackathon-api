package com.barclay.hackathon.jwt.mappers;


import com.barclay.SwaggerCodgen.model.AuthResponse;
import com.barclay.SwaggerCodgen.model.UserDto;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDto toDto(User user);
    User toEntity(UserDto dto);
    AuthResponse toAuthResponse(User user);
}