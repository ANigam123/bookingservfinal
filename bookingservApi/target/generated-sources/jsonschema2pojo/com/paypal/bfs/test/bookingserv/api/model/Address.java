
package com.paypal.bfs.test.bookingserv.api.model;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Address object
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "line1",
    "line2",
    "city",
    "state",
    "zip_code"
})
public class Address {

    /**
     * Address Line 1
     * (Required)
     * 
     */
    @JsonProperty("line1")
    @JsonPropertyDescription("Address Line 1")
    @NotNull
    private String line1;
    /**
     * Address Line 2
     * 
     */
    @JsonProperty("line2")
    @JsonPropertyDescription("Address Line 2")
    private String line2;
    /**
     * City
     * (Required)
     * 
     */
    @JsonProperty("city")
    @JsonPropertyDescription("City")
    @NotNull
    private String city;
    /**
     * State
     * (Required)
     * 
     */
    @JsonProperty("state")
    @JsonPropertyDescription("State")
    @NotNull
    private String state;
    /**
     * Zip Code
     * (Required)
     * 
     */
    @JsonProperty("zip_code")
    @JsonPropertyDescription("Zip Code")
    @NotNull
    private Integer zipCode;

    /**
     * Address Line 1
     * (Required)
     * 
     */
    @JsonProperty("line1")
    public String getLine1() {
        return line1;
    }

    /**
     * Address Line 1
     * (Required)
     * 
     */
    @JsonProperty("line1")
    public void setLine1(String line1) {
        this.line1 = line1;
    }

    /**
     * Address Line 2
     * 
     */
    @JsonProperty("line2")
    public String getLine2() {
        return line2;
    }

    /**
     * Address Line 2
     * 
     */
    @JsonProperty("line2")
    public void setLine2(String line2) {
        this.line2 = line2;
    }

    /**
     * City
     * (Required)
     * 
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     * City
     * (Required)
     * 
     */
    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * State
     * (Required)
     * 
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * State
     * (Required)
     * 
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Zip Code
     * (Required)
     * 
     */
    @JsonProperty("zip_code")
    public Integer getZipCode() {
        return zipCode;
    }

    /**
     * Zip Code
     * (Required)
     * 
     */
    @JsonProperty("zip_code")
    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Address.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("line1");
        sb.append('=');
        sb.append(((this.line1 == null)?"<null>":this.line1));
        sb.append(',');
        sb.append("line2");
        sb.append('=');
        sb.append(((this.line2 == null)?"<null>":this.line2));
        sb.append(',');
        sb.append("city");
        sb.append('=');
        sb.append(((this.city == null)?"<null>":this.city));
        sb.append(',');
        sb.append("state");
        sb.append('=');
        sb.append(((this.state == null)?"<null>":this.state));
        sb.append(',');
        sb.append("zipCode");
        sb.append('=');
        sb.append(((this.zipCode == null)?"<null>":this.zipCode));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
