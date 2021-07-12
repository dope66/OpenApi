package model;
//자기(command)가 갖고있는 값을 테이블로 전달하는 애 DTO는 테이블에 있는 값이랑 같아야됨
//디비에 값을 전달받거나 전달하기 위해서 
public class GoodsDTO {
	Long prodNum;
	String prodName;
	Long prodPrice;
	String prodImage;
	String prodDetail;
	String prodCapacity;
	String prudSupplyer;
	Long prodDelFee;
	String recommend;
	String employeeId;
	String ctgr;
	
	public Long getProdNum() {
		return prodNum;
	}
	public void setProdNum(Long prodNum) {
		this.prodNum = prodNum;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public Long getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(Long prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getProdImage() {
		return prodImage;
	}
	public void setProdImage(String prodImage) {
		this.prodImage = prodImage;
	}
	public String getProdDetail() {
		return prodDetail;
	}
	public void setProdDetail(String prodDetail) {
		this.prodDetail = prodDetail;
	}
	public String getProdCapacity() {
		return prodCapacity;
	}
	public void setProdCapacity(String prodCapacity) {
		this.prodCapacity = prodCapacity;
	}
	public String getPrudSupplyer() {
		return prudSupplyer;
	}
	public void setPrudSupplyer(String prudSupplyer) {
		this.prudSupplyer = prudSupplyer;
	}
	public Long getProdDelFee() {
		return prodDelFee;
	}
	public void setProdDelFee(Long prodDelFee) {
		this.prodDelFee = prodDelFee;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getCtgr() {
		return ctgr;
	}
	public void setCtgr(String ctgr) {
		this.ctgr = ctgr;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	
}
