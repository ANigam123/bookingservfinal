
package com.paypal.bfs.test.bookingserv.api.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Booking resource
 * <p>
 * Booking resource object
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "first_name",
    "last_name",
    "date_of_birth",
    "checkin_datetime",
    "checkout_datetime",
    "total_price",
    "deposit",
    "address"
})
public class Booking {

    /**
     * Booking id
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Booking id")
    private Integer id;
    /**
     * First name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    @JsonPropertyDescription("First name")
    @Size(min = 1, max = 255)
    @NotNull
    private String firstName;
    /**
     * Last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    @JsonPropertyDescription("Last name")
    @Size(min = 1, max = 255)
    @NotNull
    private String lastName;
    /**
     * Date of Birth
     * (Required)
     * 
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("date_of_birth")
    @JsonPropertyDescription("Date of Birth")
    @NotNull
    private Date dateOfBirth;
    /**
     * Checkin DateTime
     * (Required)
     * 
     */
    @JsonProperty("checkin_datetime")
    @JsonPropertyDescription("Checkin DateTime")
    @NotNull
    private Date checkinDatetime;
    /**
     * Checkout DateTime
     * (Required)
     * 
     */
    @JsonProperty("checkout_datetime")
    @JsonPropertyDescription("Checkout DateTime")
    @NotNull
    private Date checkoutDatetime;
    /**
     * Total Price
     * (Required)
     * 
     */
    @JsonProperty("total_price")
    @JsonPropertyDescription("Total Price")
    @NotNull
    private BigDecimal totalPrice;
    /**
     * Deposit
     * (Required)
     * 
     */
    @JsonProperty("deposit")
    @JsonPropertyDescription("Deposit")
    @NotNull
    private BigDecimal deposit;
    /**
     * Address object
     * 
     */
    @JsonProperty("address")
    @JsonPropertyDescription("Address object")
    @Valid
    private Address address;

    /**
     * Booking id
     * 
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * Booking id
     * 
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * First name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    /**
     * First name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    /**
     * Last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Date of Birth
     * (Required)
     * 
     */
    @JsonProperty("date_of_birth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Date of Birth
     * (Required)
     * 
     */
    @JsonProperty("date_of_birth")
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Checkin DateTime
     * (Required)
     * 
     */
    @JsonProperty("checkin_datetime")
    public Date getCheckinDatetime() {
        return checkinDatetime;
    }

    /**
     * Checkin DateTime
     * (Required)
     * 
     */
    @JsonProperty("checkin_datetime")
    public void setCheckinDatetime(Date checkinDatetime) {
        this.checkinDatetime = checkinDatetime;
    }

    /**
     * Checkout DateTime
     * (Required)
     * 
     */
    @JsonProperty("checkout_datetime")
    public Date getCheckoutDatetime() {
        return checkoutDatetime;
    }

    /**
     * Checkout DateTime
     * (Required)
     * 
     */
    @JsonProperty("checkout_datetime")
    public void setCheckoutDatetime(Date checkoutDatetime) {
        this.checkoutDatetime = checkoutDatetime;
    }

    /**
     * Total Price
     * (Required)
     * 
     */
    @JsonProperty("total_price")
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * Total Price
     * (Required)
     * 
     */
    @JsonProperty("total_price")
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Deposit
     * (Required)
     * 
     */
    @JsonProperty("deposit")
    public BigDecimal getDeposit() {
        return deposit;
    }

    /**
     * Deposit
     * (Required)
     * 
     */
    @JsonProperty("deposit")
    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    /**
     * Address object
     * 
     */
    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    /**
     * Address object
     * 
     */
    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Booking.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("firstName");
        sb.append('=');
        sb.append(((this.firstName == null)?"<null>":this.firstName));
        sb.append(',');
        sb.append("lastName");
        sb.append('=');
        sb.append(((this.lastName == null)?"<null>":this.lastName));
        sb.append(',');
        sb.append("dateOfBirth");
        sb.append('=');
        sb.append(((this.dateOfBirth == null)?"<null>":this.dateOfBirth));
        sb.append(',');
        sb.append("checkinDatetime");
        sb.append('=');
        sb.append(((this.checkinDatetime == null)?"<null>":this.checkinDatetime));
        sb.append(',');
        sb.append("checkoutDatetime");
        sb.append('=');
        sb.append(((this.checkoutDatetime == null)?"<null>":this.checkoutDatetime));
        sb.append(',');
        sb.append("totalPrice");
        sb.append('=');
        sb.append(((this.totalPrice == null)?"<null>":this.totalPrice));
        sb.append(',');
        sb.append("deposit");
        sb.append('=');
        sb.append(((this.deposit == null)?"<null>":this.deposit));
        sb.append(',');
        sb.append("address");
        sb.append('=');
        sb.append(((this.address == null)?"<null>":this.address));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
