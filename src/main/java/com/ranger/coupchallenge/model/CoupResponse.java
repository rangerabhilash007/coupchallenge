package com.ranger.coupchallenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoupResponse {
	@JsonProperty("fleet_engineers")
	private int fleetEngineer;

	public CoupResponse(final int fleetEngineer) {
		this.fleetEngineer = fleetEngineer;
	}

	public int getFleetEngineer() {
		return fleetEngineer;
	}

	public void setFleetEngineer(int fleetEngineer) {
		this.fleetEngineer = fleetEngineer;
	}

}
