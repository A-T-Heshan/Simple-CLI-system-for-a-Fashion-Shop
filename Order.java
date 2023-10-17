import java.util.*;

public class Order {

    private String orderID;
    private String phoneNumber;
    private String size;
    private int quantity;
    private int amount;
    private int status;

    public Order(String orderID, String phoneNumber, String size, int quantity, int amount, int status) {
        this.orderID = orderID;
        this.phoneNumber = phoneNumber;
        this.size = size;
        this.quantity = quantity;
        this.amount = amount;
        this.status = status;
    }
    
    public String getID(){
        return this.orderID;
    }
    
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    
    public String getSize(){
        return this.size;
    }
    
    public int getQTY(){
        return this.quantity;
    }
    
    public int getAmount(){
        return this.amount;
    }
    public int getStatus(){
        return this.status;
    }
    
    public void setStatus(int status){
        this.status = status;
    }
}
