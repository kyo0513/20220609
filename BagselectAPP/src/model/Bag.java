package model;

public class Bag {
	private String name;
	private String bagImage;
	private String feeling;
	private String price;

	public Bag() {	}

	public Bag(String name, String bagImage, String feeling, String price) {
		this.name = name;
		this.bagImage = bagImage;
		this.feeling = feeling;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBagImage() {
		return bagImage;
	}

	public void setBagImage(String bagImage) {
		this.bagImage = bagImage;
	}

	public String getFeeling() {
		return feeling;
	}

	public void setFeeling(String feeling) {
		this.feeling = feeling;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
