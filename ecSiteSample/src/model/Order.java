package model;

import java.io.Serializable;
import java.util.Map;

public class Order implements Serializable {

	private String date;
	private String name;
	private String mail;
	private String phone;
	private String address;
	private int sum;
	private Map<String, Vegetable[]> basket;

	public Order() {}
	public Order(String date, String name, String mail, String phone,
			String address, int sum, Map<String, Vegetable[]> basket) {
		this.date = date;
		this.name = name;
		this.mail = mail;
		this.phone = phone;
		this.address = address;
		this.sum = sum;
		this.basket = basket;
	}

	public String getDate() {return date;}
	public String getName() {return name;}
	public String getMail() {return mail;}
	public String getPhone() {return phone;}
	public String getAddress() {return address;}
	public int getSum() {return sum;}
	public Map<String, Vegetable[]> getBasket() {return basket;}
	public void setDate (String date) {this.date = date;}
	public void setName (String name) {this.name = name;}
	public void setMail (String mail) {this.mail = mail;}
	public void setPhone (String phone) {this.phone = phone;}
	public void setAddress (String address) {this.address = address;}
	public void setSum (int sum) {this.sum = sum;}
	public void setBasket (Map<String, Vegetable[]> basket) {this.basket = basket;}


}
