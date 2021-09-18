package com.sarpio.users.entity;

import lombok.*;

import javax.persistence.*;



@ToString
@RequiredArgsConstructor
@Entity(name = "customers")
@Getter
@Setter
public class CustomerEntity extends BaseCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email", unique = true)
    private String email;
}
