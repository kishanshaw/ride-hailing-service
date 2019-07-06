package com.xridesbookingdetails.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//This is the entity that describes the record to be dealt in our case.
@Document(collection = "Rides")
public class Ride {
	
	
	/*
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 */	
	
	@Id
	private String id;
	
	/* @Column(name = "user_id") */
	private int user_id;
	
	/* @Column(name = "vehicle_model_id") */
	private int vehicle_model_id;
	
	/*
	 * @Column(name = "package_id", nullable = true)
	 */	private String package_id;
	
	/* @Column(name = "travel_type_id") */	
	private int travel_type_id;
	
	/* @Column(name = "from_area_id", nullable = true) */
	private String from_area_id;
	
	/* @Column(name = "to_area_id", nullable = true) */
	private String to_area_id;
	
	/* @Column(name = "from_city_id", nullable = true) */
	private String from_city_id;
	
	/* @Column(name = "to_city_id", nullable = true) */
	private String to_city_id;
	
	/* @Column(name = "from_date") */
	private String from_date;
	
	/* @Column(name = "to_date", nullable = true) */
	private String to_date;
	
	/* @Column(name = "online_booking") */
	private int online_booking;
	
	
	/* @Column(name = "mobile_site_booking") */
	private int mobile_site_booking;
	
	/* @Column(name = "booking_created") */
	private String booking_created;
	
	
	/* @Column(name = "from_lat", nullable = true) */
	private String from_lat;
	
	/* @Column(name = "from_long", nullable = true) */
	private String from_long;
	
	/* @Column(name = "to_lat", nullable = true) */
	private String to_lat;
	
	/* @Column(name = "to_long", nullable = true) */
	private String to_long;
	
	/* @Column(name = "car_cancellation") */
	private int car_cancellation;

	public Ride() {}

	public String getId() {
		return id;
	}

	public void setId(String i) {
		this.id = i;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getVehicle_model_id() {
		return vehicle_model_id;
	}

	public void setVehicle_model_id(int vehicle_model_id) {
		this.vehicle_model_id = vehicle_model_id;
	}

	public String getPackage_id() {
		return package_id;
	}

	public void setPackage_id(String package_id) {
		this.package_id = package_id;
	}

	public int getTravel_type_id() {
		return travel_type_id;
	}

	public void setTravel_type_id(int travel_type_id) {
		this.travel_type_id = travel_type_id;
	}

	public String getFrom_area_id() {
		return from_area_id;
	}

	public void setFrom_area_id(String from_area_id) {
		this.from_area_id = from_area_id;
	}

	public String getTo_area_id() {
		return to_area_id;
	}

	public void setTo_area_id(String to_area_id) {
		this.to_area_id = to_area_id;
	}

	public String getFrom_city_id() {
		return from_city_id;
	}

	public void setFrom_city_id(String from_city_id) {
		this.from_city_id = from_city_id;
	}

	public String getTo_city_id() {
		return to_city_id;
	}

	public void setTo_city_id(String to_city_id) {
		this.to_city_id = to_city_id;
	}

	public String getFrom_date() {
		return from_date;
	}

	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}

	public String getTo_date() {
		return to_date;
	}

	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}

	public int getOnline_booking() {
		return online_booking;
	}

	public void setOnline_booking(int online_booking) {
		this.online_booking = online_booking;
	}

	public int getMobile_site_booking() {
		return mobile_site_booking;
	}

	public void setMobile_site_booking(int mobile_site_booking) {
		this.mobile_site_booking = mobile_site_booking;
	}

	public String getBooking_created() {
		return booking_created;
	}

	public void setBooking_created(String booking_created) {
		this.booking_created = booking_created;
	}

	public String getFrom_lat() {
		return from_lat;
	}

	public void setFrom_lat(String from_lat) {
		this.from_lat = from_lat;
	}

	public String getFrom_long() {
		return from_long;
	}

	public void setFrom_long(String from_long) {
		this.from_long = from_long;
	}

	public String getTo_lat() {
		return to_lat;
	}

	public void setTo_lat(String to_lat) {
		this.to_lat = to_lat;
	}

	public String getTo_long() {
		return to_long;
	}

	public void setTo_long(String to_long) {
		this.to_long = to_long;
	}

	public int getCar_cancellation() {
		return car_cancellation;
	}

	public void setCar_cancellation(int car_cancellation) {
		this.car_cancellation = car_cancellation;
	}

	public Ride(int user_id, int vehicle_model_id, String package_id, int travel_type_id, String from_area_id,
			String to_area_id, String from_city_id, String to_city_id, String from_date, String to_date,
			int online_booking, int mobile_site_booking, String booking_created, String from_lat, String from_long,
			String to_lat, String to_long, int car_cancellation) {
		super();
		this.user_id = user_id;
		this.vehicle_model_id = vehicle_model_id;
		this.package_id = package_id;
		this.travel_type_id = travel_type_id;
		this.from_area_id = from_area_id;
		this.to_area_id = to_area_id;
		this.from_city_id = from_city_id;
		this.to_city_id = to_city_id;
		this.from_date = from_date;
		this.to_date = to_date;
		this.online_booking = online_booking;
		this.mobile_site_booking = mobile_site_booking;
		this.booking_created = booking_created;
		this.from_lat = from_lat;
		this.from_long = from_long;
		this.to_lat = to_lat;
		this.to_long = to_long;
		this.car_cancellation = car_cancellation;
	}

	public void setId(int i) {
		// TODO Auto-generated method stub
		
	}
	
	

}
	
	
	
	

	





		
	


