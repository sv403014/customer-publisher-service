package com.prokarma.assignment.publisher.customer.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.prokarma.assignment.publisher.customer.domain.CustomerAddress;
import com.prokarma.assignment.publisher.customer.domain.CustomerRequest;
import com.prokarma.assignment.publisher.customer.domain.CustomerStatus;
import com.prokarma.assignment.publisher.customer.kafka.domain.KafkaCustomerRequest;

@ExtendWith(MockitoExtension.class)
class DefaultCustomerPublisherRequestConverterTest {

    @InjectMocks
    private DefaultCustomerPublisherRequestConverter defaultCustomerRequestConverter;

    @Test
    void testConvert() {
        KafkaCustomerRequest request = defaultCustomerRequestConverter.convert(getCustomerData());
        assertEquals("EE89878765", request.getCustomerNumber());
    }

    @Test
    void testMaskKafkaCustomerRequest() {
        KafkaCustomerRequest request = defaultCustomerRequestConverter
                .maskKafkaCustomerRequest(getKafkaCustomerRequestForMaskingOnly());
        assertEquals("EE8987****", request.getCustomerNumber());
        assertEquals("**-**-1988", request.getBirthdate());
        assertEquals("****i.shaik999@gmail.com", request.getEmail());
    }

    private CustomerRequest getCustomerData() {

        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setCustomerNumber("EE89878765");
        customerRequest.setFirstName("Shafi123");
        customerRequest.setLastName("Shaik1234");
        customerRequest.setBirthdate("11-02-1988");
        customerRequest.setCountry("India");
        customerRequest.setCountryCode("IN");
        customerRequest.setMobileNumber("9898767654");
        customerRequest.setEmail("sshafi@gmail.com");
        customerRequest.setCustomerStatus(CustomerStatus.OPEN);

        CustomerAddress address = new CustomerAddress();
        address.setAddressLine1("address1");
        address.setAddressLine2("address2");
        address.setStreet("Street");
        address.setPostalCode("76767");

        customerRequest.setAddress(address);

        return customerRequest;
    }

    private KafkaCustomerRequest getKafkaCustomerRequestForMaskingOnly() {
        KafkaCustomerRequest customerRequest = new KafkaCustomerRequest();
        customerRequest.setCustomerNumber("EE89878765");
        customerRequest.setBirthdate("11-02-1988");
        customerRequest.setEmail("shafi.shaik999@gmail.com");

        return customerRequest;
    }
}
