package org.MUM.Cargo;

public class Package 
{
	double number;
	String description;
	double weight;
	String zone;
	ACarrier carrier;

	Package(String description,  double weight, String zone)
	{
		this.description=description;
		this.weight=weight;
		this.zone=zone;
		this.number= Math.random();
	}


	//getters and setters
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public double getNumber() {
		return number;
	}


	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

}
