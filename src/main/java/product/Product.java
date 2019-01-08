package product;
/**
 Class represents product object
 */
public class Product {
	private int id;
	private String name;
	private String brand;
	private String color;
	private String description;
	private double price;
	private double minPrice = 0;
	private double maxPrice = 0;
	
	public Product(String name, String brand, String color, String description, double price) {
		super();
		this.name = name;
		this.brand = brand;
		this.color = color;
		this.description = description;
		this.price = price;
	}
	
	public Product() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

}
