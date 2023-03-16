package com.example.realmtestingjava.mapper;

import com.example.realmtestingjava.data.api.Product;
import com.example.realmtestingjava.data.db.ProductEntity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toProduct (ProductEntity entity);

    ProductEntity toEntity(Product product);
}
