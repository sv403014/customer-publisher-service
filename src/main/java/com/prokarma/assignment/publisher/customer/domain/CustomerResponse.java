package com.prokarma.assignment.publisher.customer.domain;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CustomerResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
        date = "2021-01-20T14:24:49.326Z")



public class CustomerResponse {
    @JsonProperty("status")
    private String status = null;

    @JsonProperty("message")
    private String message = null;

    public CustomerResponse status(String status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     * 
     * @return status
     **/
    @ApiModelProperty(example = "success", required = true, value = "")
    @NotNull


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CustomerResponse message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get message
     * 
     * @return message
     **/
    @ApiModelProperty(example = "success message", required = true, value = "")
    @NotNull


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomerResponse cutomerResponse = (CustomerResponse) o;
        return Objects.equals(this.status, cutomerResponse.status)
                && Objects.equals(this.message, cutomerResponse.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CutomerResponse {\n");

        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

