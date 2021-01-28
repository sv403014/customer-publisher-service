package com.prokarma.assignment.publisher.customer.domain;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CustomerRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
        date = "2021-01-20T14:24:49.326Z")



public class CustomerRequest {
    @JsonProperty("customerNumber")
    private String customerNumber = null;

    @JsonProperty("firstName")
    private String firstName = null;

    @JsonProperty("lastName")
    private String lastName = null;

    @JsonProperty("birthdate")
    private String birthdate = null;

    @JsonProperty("country")
    private String country = null;

    @JsonProperty("countryCode")
    private String countryCode = null;

    @JsonProperty("mobileNumber")
    private String mobileNumber = null;

    @JsonProperty("email")
    private String email = null;

    @JsonProperty("customerStatus")
    private CustomerStatus customerStatus = null;

    @JsonProperty("address")
    private CustomerAddress address = null;

    public CustomerRequest customerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
        return this;
    }

    /**
     * Get customerNumber
     * 
     * @return customerNumber
     **/
    @ApiModelProperty(example = "C000000001", required = true, value = "")
    @NotNull

    @Pattern(regexp = "^[0-9a-zA-Z]{10}")
    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public CustomerRequest firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Get firstName
     * 
     * @return firstName
     **/
    @ApiModelProperty(example = "First name", required = true, value = "")
    @NotNull

    @Size(min = 10, max = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public CustomerRequest lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Get lastName
     * 
     * @return lastName
     **/
    @ApiModelProperty(example = "Last name", required = true, value = "")
    @NotNull

    @Size(min = 10, max = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CustomerRequest birthdate(String birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    /**
     * Get birthdate
     * 
     * @return birthdate
     **/
    @ApiModelProperty(example = "30-12-2000", required = true, value = "")
    @NotNull

    @Pattern(regexp = "[0-9]{2}-[0-9]{2}-[0-9]{4}")
    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public CustomerRequest country(String country) {
        this.country = country;
        return this;
    }

    /**
     * Get country
     * 
     * @return country
     **/
    @ApiModelProperty(example = "India", required = true, value = "")
    @NotNull


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public CustomerRequest countryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    /**
     * Get countryCode
     * 
     * @return countryCode
     **/
    @ApiModelProperty(example = "IN", required = true, value = "")
    @NotNull

    @Size(max = 2)
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public CustomerRequest mobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    /**
     * Get mobileNumber
     * 
     * @return mobileNumber
     **/
    @ApiModelProperty(example = "5555551216", required = true, value = "")
    @NotNull

    @Size(max = 10)
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public CustomerRequest email(String email) {
        this.email = email;
        return this;
    }

    /**
     * Get email
     * 
     * @return email
     **/
    @ApiModelProperty(example = "abc@gmail.com", required = true, value = "")
    @NotNull

    @Size(max = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CustomerRequest customerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
        return this;
    }

    /**
     * Get customerStatus
     * 
     * @return customerStatus
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid

    public CustomerStatus getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }

    public CustomerRequest address(CustomerAddress address) {
        this.address = address;
        return this;
    }

    /**
     * Get address
     * 
     * @return address
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid

    public CustomerAddress getAddress() {
        return address;
    }

    public void setAddress(CustomerAddress address) {
        this.address = address;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomerRequest customerRequest = (CustomerRequest) o;
        return Objects.equals(this.customerNumber, customerRequest.customerNumber)
                && Objects.equals(this.firstName, customerRequest.firstName)
                && Objects.equals(this.lastName, customerRequest.lastName)
                && Objects.equals(this.birthdate, customerRequest.birthdate)
                && Objects.equals(this.country, customerRequest.country)
                && Objects.equals(this.countryCode, customerRequest.countryCode)
                && Objects.equals(this.mobileNumber, customerRequest.mobileNumber)
                && Objects.equals(this.email, customerRequest.email)
                && Objects.equals(this.customerStatus, customerRequest.customerStatus)
                && Objects.equals(this.address, customerRequest.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerNumber, firstName, lastName, birthdate, country, countryCode,
                mobileNumber, email, customerStatus, address);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CustomerRequest {\n");

        sb.append("    customerNumber: ").append(toIndentedString(customerNumber)).append("\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    birthdate: ").append(toIndentedString(birthdate)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
        sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
        sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    customerStatus: ").append(toIndentedString(customerStatus)).append("\n");
        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first
     * line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

