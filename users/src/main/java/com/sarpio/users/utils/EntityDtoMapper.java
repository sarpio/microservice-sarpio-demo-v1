package com.sarpio.users.utils;

import com.sarpio.users.controller.dto.CustomerDTO;
import com.sarpio.users.entity.CustomerEntity;
import org.springframework.beans.BeanUtils;

public class EntityDtoMapper {

    public static CustomerEntity map(CustomerDTO dto) {
        CustomerEntity entity = new CustomerEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
    public static CustomerDTO map(CustomerEntity entity) {
        CustomerDTO dto = new CustomerDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
