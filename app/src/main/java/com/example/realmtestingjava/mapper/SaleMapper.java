package com.example.realmtestingjava.mapper;

import com.example.realmtestingjava.data.api.Sale;
import com.example.realmtestingjava.data.db.SaleEntity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface SaleMapper {

    SaleMapper INSTANCE = Mappers.getMapper(SaleMapper.class);

    Sale toSale (SaleEntity entity);

    SaleEntity toEntity(Sale sale);
}
