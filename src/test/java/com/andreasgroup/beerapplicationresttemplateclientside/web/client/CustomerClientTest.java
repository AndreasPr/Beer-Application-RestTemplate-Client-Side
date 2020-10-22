package com.andreasgroup.beerapplicationresttemplateclientside.web.client;

import com.andreasgroup.beerapplicationresttemplateclientside.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created on 21/Oct/2020 to beer-application-resttemplate-client-side
 */
@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;

    @Test
    void getCustomerById() {
        CustomerDto customerDto = customerClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void testNewCustomer() {
        // given
        CustomerDto customerDto = CustomerDto.builder().name("Test Andreas inserted").build();

        URI uri = customerClient.saveNewCustomer(customerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpdateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Test Andreas Updated").build();
        customerClient.updateCustomer(UUID.randomUUID(),customerDto);
    }

    @Test
    void testDeleteCustomer() {
        customerClient.deleteCustomer(UUID.randomUUID());
    }
}
