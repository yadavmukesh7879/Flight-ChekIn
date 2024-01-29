package com.mukesh.flightcheckin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mukesh.flightcheckin.integration.ReservationRestClient;
import com.mukesh.flightcheckin.integration.dto.Reservation;
import com.mukesh.flightcheckin.integration.dto.UpdateReservationRequest;

@Controller
public class CheckInControllers {
	@Autowired
	private ReservationRestClient reservationRestClient;

	@RequestMapping("/showStartCheckIn")
	public String showStartCheckIn() {
		return "showStartCheckIn";
	}

	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam("reservationId") Long reservationId, ModelMap modelMap) {

		Reservation findReservation = reservationRestClient.findReservation(reservationId);
		modelMap.addAttribute("reservation", findReservation);

		return "displayReservationDetails";

	}

	@RequestMapping("/completeCheckIn")
	public String completeCheckIn(@RequestParam("reservationId") Long reservationId,
			@RequestParam("numberOfBags") int numberOfBags, ModelMap modelMap) {

		UpdateReservationRequest updateReservationRequest = new UpdateReservationRequest();
		updateReservationRequest.setId(reservationId);
		updateReservationRequest.setCheckedIn(true);
		updateReservationRequest.setNumberOfBags(numberOfBags);
		reservationRestClient.updateReservation(updateReservationRequest);
		modelMap.addAttribute("msg", "Check in completed Successfully.....!!!");
		return "checkInConfirmation";
	}
}
