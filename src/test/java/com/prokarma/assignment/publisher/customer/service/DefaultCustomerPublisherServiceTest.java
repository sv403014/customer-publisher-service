package com.prokarma.assignment.publisher.customer.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.kafka.common.errors.TimeoutException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;
import com.prokarma.assignment.publisher.customer.converter.DefaultCustomerPublisherRequestConverter;
import com.prokarma.assignment.publisher.customer.domain.CustomerAddress;
import com.prokarma.assignment.publisher.customer.domain.CustomerRequest;
import com.prokarma.assignment.publisher.customer.domain.CustomerResponse;
import com.prokarma.assignment.publisher.customer.domain.CustomerStatus;
import com.prokarma.assignment.publisher.customer.exceptions.ApplicationRuntimeException;

@ExtendWith(MockitoExtension.class)
class DefaultCustomerPublisherServiceTest {

    @InjectMocks
    private DefaultCustomerPublisherService defaultCustomerService;

    @Mock
    private KafkaTemplate<String, CustomerRequest> kafkaTemplate;

    @Mock
    private DefaultCustomerPublisherRequestConverter defaultCustomerRequestConverter;


    @Test
    void testInvokeCustomerResponse() {

        CustomerResponse customerResponse =
                defaultCustomerService.publishCustomerRequest(getCustomerData());

        assertEquals("success", customerResponse.getStatus());
    }

    @Test
    void testInvokeCustomerResponseWithError() {

        Mockito.doThrow(new TimeoutException()).when(kafkaTemplate).send(Mockito.any(),
                Mockito.any());

        assertThrows(ApplicationRuntimeException.class,
                () -> defaultCustomerService.publishCustomerRequest(null));
    }

    private CustomerRequest getCustomerData() {

        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setCustomerNumber("EE89878765");
        customerRequest.setFirstName("shafi1");
        customerRequest.setLastName("shaik1234");
        customerRequest.setBirthdate("11-02-1988");
        customerRequest.setCountry("India");
        customerRequest.setCountryCode("IN");
        customerRequest.setMobileNumber("9900853904");
        customerRequest.setEmail("shafi.shaik999@gmail.com");
        customerRequest.setCustomerStatus(CustomerStatus.OPEN);

        CustomerAddress address = new CustomerAddress();
        address.setAddressLine1("Line 1");
        address.setAddressLine2("Line 2");
        address.setStreet("Street 5");
        address.setPostalCode("76767");

        customerRequest.setAddress(address);

        return customerRequest;
    }

}
