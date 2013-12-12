package tr.com.obss.counrty.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Capital {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String country;
	private String capital;
	private double latitude;
	private double longitude;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public Capital(String country, String capital, double latitude,
			double longitude) {
		super();
		this.country = country;
		this.capital = capital;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public Capital() {
		super();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return country + ":" +capital + ":" +latitude + ":" +longitude ;
	}
	

}
