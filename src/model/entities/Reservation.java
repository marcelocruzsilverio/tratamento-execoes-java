package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public Reservation() {
	}
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkIn;
	}

	public Date getCheckout() {
		return checkOut;
	}
	
	public long duration() {
		long diffMilissegundos = checkOut.getTime() - checkIn.getTime();
		long diffDays = TimeUnit.DAYS.convert(diffMilissegundos, TimeUnit.MILLISECONDS);
		return diffDays;
	}
	
	public void updateDates(Date checkin, Date checkout) {
		this.checkIn = checkin;
		this.checkOut = checkout;
	}

	
	@Override
	public String toString() {
		return "Reservation: Room " + roomNumber + ", checkin: "
									+ sdf.format(checkIn)
									+ ", checkout: "
									+ sdf.format(checkOut) 
									+ ", " + duration() + " nights";
	}
	

}
