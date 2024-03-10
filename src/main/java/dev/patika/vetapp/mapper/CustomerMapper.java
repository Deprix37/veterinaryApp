package dev.patika.vetapp.mapper;

import dev.patika.vetapp.dto.CustomerRequest;
import dev.patika.vetapp.dto.CustomerResponse;
import dev.patika.vetapp.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface CustomerMapper {

    Customer asEntity(CustomerRequest request);

    CustomerResponse asResponse(Customer customer);

    void update(@MappingTarget Customer customer, CustomerRequest request);

    List<CustomerResponse> asResponseList(List<Customer> customerList);
}
