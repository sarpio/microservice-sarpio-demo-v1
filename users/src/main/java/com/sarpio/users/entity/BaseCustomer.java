package com.sarpio.users.entity;

import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseCustomer {
    private String uuid = UUID.randomUUID().toString();
}
