package com.prokarma.assignment.publisher.customer.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.prokarma.assignment.publisher.customer.converter.DefaultCustomerPublisherRequestConverter;
import com.prokarma.assignment.publisher.customer.domain.CustomerAddress;
import com.prokarma.assignment.publisher.customer.domain.CustomerRequest;
import com.prokarma.assignment.publisher.customer.domain.CustomerStatus;
import com.prokarma.assignment.publisher.customer.exceptions.GlobalExceptionHandler;
import com.prokarma.assignment.publisher.customer.service.CustomerPublisherService;
import com.prokarma.assignment.publisher.customer.util.ObjectMapperUtil;

@ExtendWith(MockitoExtension.class)
class CustomerPublisherControllerTest {

    @InjectMocks
    private CustomerPublisherController customerController;

    @Mock
    private CustomerPublisherService customerService;

    @Mock
    private DefaultCustomerPublisherRequestConverter defaultCustomerRequestConverter;

    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController)
                .setControllerAdvice(new GlobalExceptionHandler()).build();
    }

    @Test
    void testSaveCustomerData() throws Exception {
        mockMvc.perform(post("/customer/publish").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(ObjectMapperUtil.returnJsonFromObject(getCustomerData()))
                .headers(buildHttpHeaders())).andExpect(status().is(200));

    }

    @Test
    void testSaveCustomerDataWhenWrongUrlPrivideThenReturn404StatusCode() throws Exception {
        mockMvc.perform(post("/customer/publish/v1").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(ObjectMapperUtil.returnJsonFromObject(getCustomerData()))
                .headers(buildHttpHeaders())).andExpect(status().is(404));
    }

    private HttpHeaders buildHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "bearer 83e1743e-c637-4e3f-b100-4ff2560bc29c");
        headers.set("Activity-Id", "customer-transaction");
        headers.set("Transaction-Id", "retail-customer-app");
        return headers;
    }

    private CustomerRequest getCustomerData() {

        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setCustomerNumber("EE89878765");
        customerRequest.setFirstName("shafi12345");
        customerRequest.setLastName("shaik12345");
        customerRequest.setBirthdate("11-02-1988");
        customerRequest.setCountry("India");
        customerRequest.setCountryCode("IN");
        customerRequest.setMobileNumber("9866853904");
        customerRequest.setEmail("shafi.shaik999@gmail.com");
        customerRequest.setCustomerStatus(CustomerStatus.OPEN);

        CustomerAddress address = new CustomerAddress();
        address.setAddressLine1("line1");
        address.setAddressLine2("line2");
        address.setStreet("Street");
        address.setPostalCode("76767");

        customerRequest.setAddress(address);


        return customerRequest;
    }

}
