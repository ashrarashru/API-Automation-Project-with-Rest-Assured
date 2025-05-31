package Classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateUserModel {

    @JsonProperty("firstName")
    private String fName;

    @JsonProperty("phoneNumber")
    private String phn;

    @JsonProperty("itemName")
    private String item;

    private String quantity;
    private String amount;
    private String purchaseDate;
    private String month;
    private String remarks;


    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getPhn() {
        return phn;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }


    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    // Update User
    public UpdateUserModel(String firstName, String phoneNumber){
        this.fName = firstName;
        this.phn = phoneNumber;
    }

    public UpdateUserModel(String item, String quantity, String amount, String purchaseDate, String month, String remarks){
        this.item = item;
        this.quantity = quantity;
        this.amount = amount;
        this.purchaseDate = purchaseDate;
        this.month = month;
        this.remarks = remarks;
    }

    public UpdateUserModel() {

    }

}
