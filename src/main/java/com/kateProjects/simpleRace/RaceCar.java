package com.kateProjects.simpleRace;

import java.util.Random;

public class RaceCar extends Thread {

	private int duration;
	private int speed;
	private int time;
	private int distance;

	public void setDuration(int sec) {
		this.duration = sec;
	}
	public int getDuration() {
		return this.duration;
	}
	public void setSpeed(int s) {
		this.speed = s;
	}
	public int getSpeed() {
		return this.speed;
	}
	public void setTime(int t) {
		this.time = t;
	}
	public int getTime() {
		return this.time;
	}
	public void setDistance(int d) {
		this.distance = d;
	}
	public int getDistance() {
		return this.distance;
	}

	public int raceDistance() {
		this.time = 0;
		while (time < duration) {
			this.time++;
			Random random = new Random();
			int minSpeed = 1;
			this.speed = random.nextInt(minSpeed + 100);
			this.distance = this.speed * this.time;
			System.out.println(this.getName() + ":   " + "Speed: " + this.getSpeed() + "m/s" + "   Distance: " + this.getDistance() + "m");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
		return this.distance;
	}

	@Override
	public void run() {
		System.out.println(this.getName() + " is starting the race.......");
		this.raceDistance();
	}

}
