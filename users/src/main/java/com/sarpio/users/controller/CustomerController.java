package com.sarpio.users.controller;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

import com.sarpio.users.utils.EntityDtoMapper;
import com.sarpio.users.entity.CustomerEntity;
import com.sarpio.users.service.CustomerService;
import com.sarpio.users.controller.dto.CustomerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerEntity> customersEntityList = customerService.findAllCustomers();
        List<CustomerDTO> customersDtoList =
                customersEntityList
                        .stream()
                        .map(EntityDtoMapper::map)
                        .collect(Collectors.toList());
        return ResponseEntity.ok(customersDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@Valid @PathVariable long id) {
        CustomerDTO customerById = customerService.getCustomerById(id);
        return ResponseEntity.ok(customerById);
    }

    @PostMapping("/")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody
                                                      @Valid CustomerDTO dto) {
        return customerService.createCustomer(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomerById(@Valid @PathVariable("id") Long id) {
        return customerService.deleteCustomerById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomerById(@RequestBody @Valid CustomerDTO dto,
                                                          @Valid @PathVariable("id") Long id) {
        return customerService.updateCustomerById(id, dto);
    }
}
