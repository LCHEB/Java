package day11.product;
/* 중복된 제품명 x
 * 
 */
public class Product {
	//제품명, 수량, 금액 - 구매금액, 기본판맨금액, 할인금액
	
	//getter, setter, 제품정보 출력, 제품 할인금액 수정
	
	//생성자 : 제품명, 수량, 금액이 주어진 생성자
	
	private int amount, buyPrice, price, salePrice;
	private String name;
	
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void print() {
		System.out.print("제품명 : " + name + ", 수량 : " + amount + ", 가격 : " + salePrice);
	}
	
	public void updateSalePrice(int price) {
		salePrice = price;
	}
	public Product(int amount, int buyPrice, int price, String name) {
		this.amount = amount;
		this.buyPrice = buyPrice;
		this.price = price;
		this.name = name;
	}
	public void updateAmount(int amount) {
		this.amount += amount;
	}
	
	public boolean equals(String name) {
		return this.name.equals(name);
	}
	
	
}
