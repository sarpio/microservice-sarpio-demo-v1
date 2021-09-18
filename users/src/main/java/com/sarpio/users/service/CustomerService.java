package com.sarpio.users.service;

import com.sarpio.users.controller.dto.CustomerDTO;
import com.sarpio.users.entity.CustomerEntity;
import com.sarpio.users.repository.CustomerRepository;
import com.sarpio.users.utils.EntityDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<CustomerEntity> findAllCustomers() {
        return customerRepository.findAll();
    }

    public CustomerDTO getCustomerById(long id) {
        CustomerEntity entity = customerRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer with ID: " + id + " not found"));
        return EntityDtoMapper.map(entity);
    }

    public ResponseEntity<CustomerDTO> createCustomer(CustomerDTO dto) {
        CustomerEntity entity = EntityDtoMapper.map(dto);
        customerRepository.save(entity);
        return ResponseEntity.ok(EntityDtoMapper.map(entity));
    }

    public ResponseEntity<String> deleteCustomerById(Long id) {

        try {
            customerRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<CustomerDTO> updateCustomerById(Long id, CustomerDTO dto) {
        CustomerEntity entity = customerRepository
                .findById(id).orElseThrow(() ->
                        new EntityNotFoundException("Customer with ID: " + id + " not found"));
        CustomerEntity map = EntityDtoMapper.map(dto);
        map.setId(id);
        if (map.getEmail() == null) map.setEmail(entity.getEmail());
        if (map.getFirstName() == null) map.setFirstName(entity.getFirstName());
        if (map.getLastName() == null) map.setLastName(entity.getLastName());
        customerRepository.save(map);
        return ResponseEntity.ok(EntityDtoMapper.map(map));
    }
}
