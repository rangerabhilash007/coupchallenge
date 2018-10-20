package com.ranger.coupchallenge;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ranger.coupchallenge.service.CoupSolverService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoupChallengeApplicationTests {

	@Autowired
	CoupSolverService coupSolverService;

	@Test
	public void testLinearStrategy() {
		testcoupSolverServiceWithValidInput();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLinearStrategyInput() {
		testcoupSolverServiceWithInvalidInput();
	}

	private void testcoupSolverServiceWithValidInput() {
		Assert.assertEquals(coupSolverService.solve(new int[] { 12 }, 12, 5), 0);
		Assert.assertEquals(coupSolverService.solve(new int[] { 0 }, 12, 5), 0);
		Assert.assertEquals(coupSolverService.solve(new int[] { 15, 10 }, 12, 5), 3);
		Assert.assertEquals(coupSolverService.solve(new int[] { 11, 15, 13 }, 9, 5), 7);
		Assert.assertEquals(coupSolverService.solve(new int[] { 11, 15, 9 }, 9, 15), 2);

	}

	private void testcoupSolverServiceWithInvalidInput() {
		coupSolverService.solve(new int[] { 10, 10 }, 0, 10);
		coupSolverService.solve(new int[] { 10, 10 }, 1000, 10);
		coupSolverService.solve(new int[] { 10, 10 }, -100, 10);

		coupSolverService.solve(new int[] { 10, 10 }, 10, 0);
		coupSolverService.solve(new int[] { 10, 10 }, 10, 1001);
		coupSolverService.solve(new int[] { 10, 10 }, -100, 1001);

		coupSolverService.solve(new int[] { -10 }, 10, 10);
		coupSolverService.solve(new int[] { 1001 }, 10, 10);

		final int[] scooters = new int[101];
		Arrays.fill(scooters, 0);

		coupSolverService.solve(scooters, 10, 10);
	}

}
