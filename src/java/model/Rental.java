package model;
// Generated 07/06/2019 21:27:19 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Rental generated by hbm2java
 */
public class Rental  implements java.io.Serializable {


     private int rentalId;
     private Customer customer;
     private Inventory inventory;
     private Staff staff;
     private Date rentalDate;
     private Date returnDate;
     private Date lastUpdate;
     private Set<Payment> payments = new HashSet<Payment>(0);

    public Rental() {
    }

	
    public Rental(int rentalId, Customer customer, Inventory inventory, Staff staff, Date rentalDate, Date lastUpdate) {
        this.rentalId = rentalId;
        this.customer = customer;
        this.inventory = inventory;
        this.staff = staff;
        this.rentalDate = rentalDate;
        this.lastUpdate = lastUpdate;
    }
    public Rental(int rentalId, Customer customer, Inventory inventory, Staff staff, Date rentalDate, Date returnDate, Date lastUpdate, Set<Payment> payments) {
       this.rentalId = rentalId;
       this.customer = customer;
       this.inventory = inventory;
       this.staff = staff;
       this.rentalDate = rentalDate;
       this.returnDate = returnDate;
       this.lastUpdate = lastUpdate;
       this.payments = payments;
    }
   
    public int getRentalId() {
        return this.rentalId;
    }
    
    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }
    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Inventory getInventory() {
        return this.inventory;
    }
    
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public Staff getStaff() {
        return this.staff;
    }
    
    public void setStaff(Staff staff) {
        this.staff = staff;
    }
    public Date getRentalDate() {
        return this.rentalDate;
    }
    
    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }
    public Date getReturnDate() {
        return this.returnDate;
    }
    
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    public Date getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public Set<Payment> getPayments() {
        return this.payments;
    }
    
    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }




}


