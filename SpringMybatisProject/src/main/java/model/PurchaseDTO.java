package model;

import java.util.Date;

public class PurchaseDTO {
	String purchaseNum;
	String memId;
	String purchaseTotprice;
	String purchaseAddr;
	String 	purchaseMethod;
	String purchaseRequest;
	String receiverName;
	String receiverPhone;
	Date purchaseDate;
	public String getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(String purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getPurchaseTotprice() {
		return purchaseTotprice;
	}
	public void setPurchaseTotprice(String purchaseTotprice) {
		this.purchaseTotprice = purchaseTotprice;
	}
	public String getPurchaseAddr() {
		return purchaseAddr;
	}
	public void setPurchaseAddr(String purchaseAddr) {
		this.purchaseAddr = purchaseAddr;
	}
	public String getPurchaseMethod() {
		return purchaseMethod;
	}
	public void setPurchaseMethod(String purchaseMethod) {
		this.purchaseMethod = purchaseMethod;
	}
	public String getPurchaseRequest() {
		return purchaseRequest;
	}
	public void setPurchaseRequest(String purchaseRequest) {
		this.purchaseRequest = purchaseRequest;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	
}
