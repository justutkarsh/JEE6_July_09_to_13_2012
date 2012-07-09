package com.durasoft.domain;

public class GuessingGame {
	private int target;
	private int attempts;
	private String message;
	private boolean gameOver;
	public GuessingGame(){
		target = (int)(Math.random() * 100);
	}
	public void play(int guess){
		attempts++;
		if(guess > target)
			message = "Aim Lower";
		if(guess < target)
			message = "Aim Higher";
		if(guess == target){
			message = "You have got it in " + attempts + " attempts";
			gameOver = true;
		}
	}
	public int getAttempts() {
		return attempts;
	}
	public String getMessage() {
		return message;
	}
	public boolean isGameOver() {
		return gameOver;
	}
}
