package model;

import java.io.Serializable;

public class Vegetable implements Serializable, Cloneable {

	private int id;
	private String name;
	private String season;
	private int price;
	private String taste;
	private String ex;

	public Vegetable() {}
	public Vegetable(int id, String name, String season,
			int price, String taste, String ex) {

		this.id = id;
		this.name = name;
		this.season = season;
		this.price = price;
		this.taste = taste;
		this.ex = ex;
	}
	public Vegetable clone() {
		Vegetable veg = new Vegetable(
				id, name, season, price, taste, ex);
		return veg;
	}
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getName() {return name;};
	public void setName(String name) {this.name = name;}
	public String getSeason() {return season;}
	public void setSeason(String season) {this.season = season;};
	public int getPrice() {return price;}
	public void setPrice(int price) {this.price = price;}
	public String getTaste() {return taste;}
	public void setTaste(String taste) {this.taste = taste;}
	public String getEx() {return ex;}
	public void setEx(String ex) {this.ex = ex;}
}

