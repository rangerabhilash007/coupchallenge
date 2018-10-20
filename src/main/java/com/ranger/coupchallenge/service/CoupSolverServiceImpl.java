package com.ranger.coupchallenge.service;

import org.springframework.stereotype.Service;

@Service
public class CoupSolverServiceImpl implements CoupSolverService {

	void validateInput(final int[] scooters, final int managerCapacity, final int engineerCapacity) {
		if (scooters.length < 1 || scooters.length > 100)
			throw new IllegalArgumentException(
					"Invalid scooter district amount. Please provide scooter district amount between 1 and 100");

		if (managerCapacity < 1 || managerCapacity > 999)
			throw new IllegalArgumentException(
					"Invalid manager capacity. Please provide manager capacity value between 1 and 999");

		if (engineerCapacity < 1 || engineerCapacity > 1000)
			throw new IllegalArgumentException(
					"Invalid engineer capacity. Please provide engineer capacity value between 1 and 1000");
	}

	void validateScooterAmount(final int[] scooters, final int index) {
		if (index >= scooters.length)
			return;

		if (scooters[index] < 0 || scooters[index] > 1000)
			throw new IllegalArgumentException("Illegal scooter amount; expected amount between 0 and 1000");
	}

	int requiredEngineers(final int scooters, final int engineerCapacity) {
		if (scooters <= 0)
			return 0;

		final int result = scooters / engineerCapacity;

		return scooters % engineerCapacity > 0 ? result + 1 : result;
	}

	@Override
	public int solve(final int[] scooters, final int managerCapacity, final int engineerCapacity) {
		validateInput(scooters, managerCapacity, engineerCapacity);

		int maxEngineers = 0;

		for (int i = 0; i < scooters.length; ++i) {
			validateScooterAmount(scooters, i);

			maxEngineers += requiredEngineers(scooters[i], engineerCapacity);
		}

		int result = maxEngineers;

		for (int i = 0; i < scooters.length; ++i) {
			int min = requiredEngineers(scooters[i] - managerCapacity, engineerCapacity);
			int max = requiredEngineers(scooters[i], engineerCapacity);

			result = Math.min(result, maxEngineers - (max - min));
		}

		return result;
	}

}
