package com.example.realmtestingjava.mapper;

import com.example.realmtestingjava.data.api.User;
import com.example.realmtestingjava.data.db.UserEntity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserEntity entity);

    UserEntity toEntity(User user);
}
