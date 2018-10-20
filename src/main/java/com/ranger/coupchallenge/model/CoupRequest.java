package com.ranger.coupchallenge.model;

import java.util.Arrays;

public class CoupRequest {
	int[] scooters;
	int managerCapacity;
	int engineerCapacity;

	public int[] getScooters() {
		return scooters;
	}

	public void setScooters(int[] scooters) {
		this.scooters = scooters;
	}

	public int getManagerCapacity() {
		return managerCapacity;
	}

	public void setManagerCapacity(int managerCapacity) {
		this.managerCapacity = managerCapacity;
	}

	public int getEngineerCapacity() {
		return engineerCapacity;
	}

	public void setEngineerCapacity(int engineerCapacity) {
		this.engineerCapacity = engineerCapacity;
	}

	@Override
	public String toString() {
		return "CoupRequest [scooters=" + Arrays.toString(scooters) + ", managerCapacity=" + managerCapacity
				+ ", engineerCapacity=" + engineerCapacity + "]";
	}

}
