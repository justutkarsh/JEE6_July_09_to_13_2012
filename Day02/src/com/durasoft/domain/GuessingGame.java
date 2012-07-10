package com.durasoft.domain;

import java.util.HashMap;

public class GuessingGame {
	private int target;
	private int attempts;
	private String message;
	private boolean gameOver;
	private HashMap<String, String> history;
	
	
	public GuessingGame(){
		target = (int)(Math.random() * 100);
		System.out.println(target);
		history = new HashMap<String, String>();
	}
	public void play(int guess){
		attempts++;
		history.put(""+attempts,guess+"");
		if(guess > target)
			message = "Aim Lower";
		if(guess < target)
			message = "Aim Higher";
		if(guess == target){
			message = "You have got it in " + attempts + " attempts";
			gameOver = true;
		}
	}
	
	
	public HashMap<String, String> getHistory() {
		return history;
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
