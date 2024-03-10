package dev.patika.vetapp.service;

import dev.patika.vetapp.base.BaseService;
import dev.patika.vetapp.dto.CustomerRequest;
import dev.patika.vetapp.dto.CustomerResponse;
import dev.patika.vetapp.entity.Customer;
import dev.patika.vetapp.mapper.CustomerMapper;
import dev.patika.vetapp.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService implements BaseService<Customer, CustomerRequest, CustomerResponse> {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    @Override
    public CustomerResponse save(CustomerRequest request) {
        return customerMapper.asResponse(
                customerRepository.save(customerMapper.asEntity(request))
        );

    }

    @Override
    public CustomerResponse findById(Long id) {
        return customerMapper.asResponse(findByIdEntity(id));
    }

    @Override
    public CustomerResponse update(Long id, CustomerRequest request) {
        Customer customerFromDb = findByIdEntity(id);
        customerMapper.update(customerFromDb, request);
        return customerMapper.asResponse(customerRepository.save(customerFromDb));
    }

    @Override
    public void deleteById(Long id) {
        Customer customer = findByIdEntity(id);
        customerRepository.delete(customer);
    }

    @Override
    public Customer findByIdEntity(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer is not found"));
    }

    @Override
    public List<CustomerResponse> findAll() {
        return customerMapper.asResponseList(customerRepository.findAll());
    }

    public List<CustomerResponse> findByName(String name) {
        return customerMapper.asResponseList(customerRepository.findAllByName(name));
    }
}
