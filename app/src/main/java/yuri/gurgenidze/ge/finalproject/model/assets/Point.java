
package yuri.gurgenidze.ge.finalproject.model.assets;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Point implements AssetInterface {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("ProductName")
    @Expose
    private String productName;
    @SerializedName("OrderNo")
    @Expose
    private Integer orderNo;
    @SerializedName("Amount")
    @Expose
    private Integer amount;
    @SerializedName("ProdType")
    @Expose
    private String prodType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    @Override
    public String getProdName() {
        return productName;
    }

    @Override
    public String getAmmount() {
        return amount.toString();
    }
}
