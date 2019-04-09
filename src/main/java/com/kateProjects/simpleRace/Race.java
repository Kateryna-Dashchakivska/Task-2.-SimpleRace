package com.kateProjects.simpleRace;
import java.util.Arrays;
import java.util.Comparator;

public class Race {

	static final int totalNumberOfCars = 10;
	static final int totalWinners = 3;
	static final int totalDuration = 20;
	static int startDistance = 0;
	static RaceCar[] cars = new RaceCar[totalNumberOfCars];

	public static void startRace() {

		for (int i = 0; i < totalNumberOfCars; i++) {
			RaceCar carThread = new RaceCar();
			carThread.setName("Car" + (i + 1));
			carThread.setDuration(totalDuration);
			carThread.setDistance(startDistance);
			cars[i] = carThread;
			carThread.start();
		}

		for(int i = 0; i < totalNumberOfCars; i++) {
			try {
				cars[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}

		sortCars(cars);
		printWinners(totalWinners);
	}

	public static void printWinners(int totalWinners) {
		System.out.println("\nThe race is FINISHED!!!\n"); 
		System.out.println("Total time: " + totalDuration + "seconds"); 
		System.out.println("\nTop " + totalWinners + " WINNERS:\n");

		for (int i = 0; i < totalWinners; i++) {
			System.out.println(cars[i].getName() + " has passed the distance: " + cars[i].getDistance() + "m!" + " It takes: " +(i + 1) + " place!");
		}
	}

	public static RaceCar[] sortCars (RaceCar[] raceCars) {   //rename according to acs/desc
		Arrays.sort(raceCars, new Comparator<RaceCar>() {
			public int compare(RaceCar car1, RaceCar car2) {
				if (car1.getDistance() > car2.getDistance())
					return -1;
				if (car1.getDistance() < car2.getDistance())
					return 1;
				return 0;
			}
		});
		return raceCars;
	}
}
