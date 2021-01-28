package com.prokarma.assignment.publisher.customer.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.prokarma.assignment.publisher.customer.domain.CustomerAddress;
import com.prokarma.assignment.publisher.customer.domain.CustomerRequest;
import com.prokarma.assignment.publisher.customer.domain.CustomerStatus;

@ExtendWith(MockitoExtension.class)
class ObjectMapperUtilTest {
    @Test
    void testJSONString() {
        String expectedString =
                "{\"customerNumber\":\"EE89878765\",\"firstName\":\"shafi\",\"lastName\":\"shaik\",\"birthdate\":\"11-02-1988\",\"country\":\"India\",\"countryCode\":\"IN\",\"mobileNumber\":\"9900853904\",\"email\":\"shafi.shaik999@gmail.com\",\"customerStatus\":\"Open\",\"address\":{\"addressLine1\":\"Line 1\",\"addressLine2\":\"Line 2\",\"street\":\"Street 5\",\"postalCode\":\"76767\"}}";

        String result = ObjectMapperUtil.returnJsonFromObject(getCustomerData());

        assertEquals(expectedString, result);
    }


    private CustomerRequest getCustomerData() {

        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setCustomerNumber("EE89878765");
        customerRequest.setFirstName("shafi");
        customerRequest.setLastName("shaik");
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
