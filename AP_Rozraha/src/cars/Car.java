package cars;

import java.io.Serializable;

public class Car implements Serializable{
	private static final long serialVersionUID = 1L;
	private String make;
	private String model;
	private int releaseYear;
	private int engineHorsePower;
	private int numberOfSits;
	private String marketCategory;////
	private String style;
	private int highwayMpg;
	private int cityMpg;
	private int price;
	private double accelerationToOneHundred;////
	
	@Override
	public String toString() {
		
		return String.format("%-20s%-25s%-15d%-15d%-15.1f%-15d%-20s%-15d%-15d%-15d%s", make, model, releaseYear, engineHorsePower,
							 accelerationToOneHundred, numberOfSits, style, highwayMpg, cityMpg, price, marketCategory);
	}
	
	public Car(String data[]) {
		make = data[0];
		model = data[1];
		releaseYear = Integer.parseInt(data[2]);
		try { engineHorsePower = Integer.parseInt(data[4]);}catch(NumberFormatException e) {engineHorsePower = 175;}
		try { numberOfSits = Integer.parseInt(data[8]);}catch(NumberFormatException e) {numberOfSits = 4;}
		if(numberOfSits == 3) numberOfSits = 6;
		marketCategory = data[9];
		style = data[11];
		highwayMpg = Integer.parseInt(data[12]);
		cityMpg = Integer.parseInt(data[13]);
		price = Integer.parseInt(data[15]);
		accelerationToOneHundred = calculateSpeed();
	}

	public Car() {
		
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getEngineHorsePower() {
		return engineHorsePower;
	}

	public void setEngineHorsePower(int engineHorsePower) {
		this.engineHorsePower = engineHorsePower;
	}

	public int getNumberOfSits() {
		return numberOfSits;
	}

	public void setNumberOfSits(int numberOfSits) {
		this.numberOfSits = numberOfSits;
	}

	public String getMarketCategory() {
		return marketCategory;
	}

	public void setMarketCategory(String marketCategory) {
		this.marketCategory = marketCategory;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public int getHighwayMpg() {
		return highwayMpg;
	}

	public void setHighwayMpg(int highwayMpg) {
		this.highwayMpg = highwayMpg;
	}

	public int getCityMpg() {
		return cityMpg;
	}

	public void setCityMpg(int cityMpg) {
		this.cityMpg = cityMpg;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public double getAccelerationToOneHundred() {
		return accelerationToOneHundred;
	}

	public void setAccelerationToOneHundred(double accelerationToOneHundred) {
		this.accelerationToOneHundred = accelerationToOneHundred;
	}
	
	private double calculateSpeed() {
		double acceleration = 2.7744 + (805.6311 / this.engineHorsePower); 
		
		return acceleration;
	}
	
}
