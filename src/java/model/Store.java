package model;
// Generated 07/06/2019 21:27:19 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Store generated by hbm2java
 */
public class Store  implements java.io.Serializable {


     private int storeId;
     private Address address;
     private Staff staff;
     private Date lastUpdate;

    public Store() {
    }

    public Store(int storeId, Address address, Staff staff, Date lastUpdate) {
       this.storeId = storeId;
       this.address = address;
       this.staff = staff;
       this.lastUpdate = lastUpdate;
    }
   
    public int getStoreId() {
        return this.storeId;
    }
    
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
    public Address getAddress() {
        return this.address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    public Staff getStaff() {
        return this.staff;
    }
    
    public void setStaff(Staff staff) {
        this.staff = staff;
    }
    public Date getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }




}


