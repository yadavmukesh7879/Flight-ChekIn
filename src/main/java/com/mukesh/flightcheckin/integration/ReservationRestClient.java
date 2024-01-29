package com.mukesh.flightcheckin.integration;

import com.mukesh.flightcheckin.integration.dto.Reservation;
import com.mukesh.flightcheckin.integration.dto.UpdateReservationRequest;

public interface ReservationRestClient {
	public Reservation findReservation(Long id);

	public Reservation updateReservation(UpdateReservationRequest request);

}
