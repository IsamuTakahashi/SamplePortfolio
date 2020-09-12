package model;

import java.io.Serializable;
import java.util.Map;

public class Order implements Serializable  {

	private int id;
	private String date;
	private String name;
	private String mail;
	private String phone;
	private String address;
	private Map<String, Integer> orderQuantity;

	public Order() {}
	public Order(int id, String date, String name, String mail,
			String phone, String address, Map<String, Integer> orderQuantity) {
		this.id = id;
		this.date = date;
		this.name = name;
		this.mail = mail;
		this.phone = phone;
		this.address = address;
		this.orderQuantity = orderQuantity;
	}

	public int getId() {return id;}
	public String getDate() {return date;}
	public String getName() {return name;}
	public String getMail() {return mail;}
	public String getPhone() {return phone;}
	public String getAddress() {return address;}
	public Map<String, Integer> getOrderQuantity() {return orderQuantity;}
	public void setId(int id) {this.id = id;}
	public void setDate(String date) {this.date = date;}
	public void setName(String name) {this.name = name;}
	public void setMail(String mail) {this.mail = mail;}
	public void setPhone(String phone) {this.phone = phone;}
	public void setAddress(String address) {this.address = address;}
	public void setOrderQuantity(Map<String, Integer> orderQuantity) {
		this.orderQuantity = orderQuantity;}

}
