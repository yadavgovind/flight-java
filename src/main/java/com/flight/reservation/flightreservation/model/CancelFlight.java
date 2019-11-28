package com.flight.reservation.flightreservation.model;

import java.time.LocalDate;

public class CancelFlight extends AbstractEntity{

	private LocalDate cancelDate;

	public LocalDate getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(LocalDate cancelDate) {
		this.cancelDate = cancelDate;
	}
	
	
}
