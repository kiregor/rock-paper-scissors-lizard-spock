package main;

import java.util.Random;
import java.util.Scanner;

public class RPS {
	
	int gamesPlayed, compWins, userWins, ties, rockPicks, paperPicks, scissorPicks, percentPicked, lizardPicks, spockPicks;
	String mostPicked = "None";
	
	public String takeTurn() {
		Random rand = new Random();
		
		int random = rand.nextInt(5);
		
		String[] option = {"Rock", "Paper", "Scissors", "Lizard", "Spock"};
		
		return option[random];
	}
	
	public String takeAITurn() {
		Random rand = new Random();
		int random = rand.nextInt(2);
		String[] option = {};
		mostPickedChecker();
		
		switch(mostPicked) {
			case "Rock":
				option = new String[]{"Paper", "Spock"};
				break;
			case "Paper":
				option = new String[]{"Scissors", "Lizard"};
				break;
			case "Scissors":
				option = new String[]{"Rock", "Spock"};
				break;
			case "Lizard":
				option = new String[]{"Rock", "Scissors"};
				break;
			case "Spock":
				option = new String[]{"Paper", "Lizard"};
				break;
			case "None":
				option = new String[]{"Rock", "Paper", "Scissors", "Lizard", "Spock"};
				random = rand.nextInt(5);
		}
		
		return option[random];
	}
	
	public String takeUserTurn()
	{
		System.out.println("Choose either Rock, Paper, Scissors, Lizard, Spock");
		Scanner s = new Scanner(System.in);
		String userInput = s.nextLine();
		
		return userInput;
	}
	
	public String checkWinner() {
		String winner = "";
		
		String computerTurn = takeTurn();
		String playerTurn = takeUserTurn();
		
		System.out.println("The Computer chose: " + computerTurn);
		System.out.println("You chose: " + playerTurn);
		
		switch (playerTurn) {
			case "Rock":
				switch (computerTurn) {
				case "Rock":
					winner = "Its a Tie";
					rockPicks+=2;
					break;
				case "Paper":
					winner = "Computer";
					rockPicks++;
					paperPicks++;
					break;
				case "Scissors":
					winner = "Player";
					rockPicks++;
					scissorPicks++;
					break;
				case "Lizard":
					winner = "Player";
					rockPicks++;
					lizardPicks++;
					break;
				case "Spock":
					winner = "Computer";
					rockPicks++;
					spockPicks++;
					break;
				}
				break;
			case "Paper":
				switch (computerTurn) {
				case "Rock":
					winner = "Player";
					rockPicks++;
					paperPicks++;
					break;
				case "Paper":
					winner = "Its a Tie";
					paperPicks+=2;
					break;
				case "Scissors":
					winner = "Computer";
					paperPicks++;
					scissorPicks++;
					break;
				case "Lizard":
					winner = "Computer";
					paperPicks++;
					lizardPicks++;
					break;
				case "Spock":
					winner = "Player";
					paperPicks++;
					spockPicks++;
					break;
				}
				break;
			case "Scissors":
				switch (computerTurn) {
				case "Rock":
					winner = "Computer";
					rockPicks++;
					scissorPicks++;
					break;
				case "Paper":
					winner = "Player";
					paperPicks++;
					scissorPicks++;
					break;
				case "Scissors":
					winner = "Its a Tie";
					scissorPicks+=2;
					break;
				case "Lizard":
					winner = "Player";
					scissorPicks++;
					lizardPicks++;
					break;
				case "Spock":
					winner = "Computer";
					scissorPicks++;
					spockPicks++;
					break;
				}
				break;
			case "Lizard":
				switch (computerTurn) {
				case "Rock":
					winner = "Computer";
					rockPicks++;
					lizardPicks++;
					break;
				case "Paper":
					winner = "Player";
					paperPicks++;
					lizardPicks++;
					break;
				case "Scissors":
					winner = "Player";
					lizardPicks++;
					scissorPicks++;
					break;
				case "Lizard":
					winner = "Its a Tie";
					lizardPicks+=2;
					break;
				case "Spock":
					winner = "Player";
					lizardPicks++;
					spockPicks++;
					break;
				}
				break;
			case "Spock":
				switch (computerTurn) {
				case "Rock":
					winner = "Player";
					rockPicks++;
					spockPicks++;
					break;
				case "Paper":
					winner = "Computer";
					paperPicks++;
					spockPicks++;
					break;
				case "Scissors":
					winner = "Player";
					scissorPicks++;
					spockPicks++;
					break;
				case "Lizard":
					winner = "Computer";
					spockPicks++;
					lizardPicks++;
					break;
				case "Spock":
					winner = "Its a Tie";
					spockPicks+=2;
					break;
				}
				break;
		}
		
		System.out.println(winner);
		return winner;
	}
	
	public void gameLoop() {
		boolean keepPlaying = true;
		while(keepPlaying) {
			System.out.println("Rock, Paper, Scissors, Lizard, Spock");
			String winner = this.checkWinner();
			
			switch(winner) {
				case "Computer":
					compWins++;
					break;
				case "Player":
					userWins++;
					break;
				case "Its a Tie":
					ties++;
					break;
			}
			
			System.out.println("Would you like to continue? (Y/n)");
			Scanner s = new Scanner(System.in);
			String userInput = s.nextLine();
			if(userInput.equals("n") || userInput.equals("N")) {
				keepPlaying = false;
			}
			
		}
		
		mostPickedChecker();
		
		System.out.println("Total games played: " + gamesPlayed);
		System.out.println("The computer won: " + compWins + " " + (compWins*100/gamesPlayed) + "%");
		System.out.println("The player won: " + userWins + " " + (userWins*100/gamesPlayed) + "%");
		System.out.println("You tied: " + ties + " " + (ties*100/gamesPlayed) + "%");
		System.out.println("Most picked: " + mostPicked + " " + percentPicked + "%");
	}
	
	public void mostPickedChecker() {
		gamesPlayed = compWins + userWins + ties;
		
		if(rockPicks > paperPicks & rockPicks > scissorPicks & rockPicks > lizardPicks & rockPicks > spockPicks) {
			mostPicked = "Rock";
			percentPicked = rockPicks*100/(gamesPlayed*2);
		}
		else if(paperPicks > scissorPicks & paperPicks > rockPicks & paperPicks > lizardPicks & paperPicks > spockPicks) {
			mostPicked = "Paper";
			percentPicked = paperPicks*100/(gamesPlayed*2);
		}
		else if(scissorPicks > rockPicks & scissorPicks > paperPicks & scissorPicks > lizardPicks & scissorPicks > spockPicks) {
			mostPicked = "Scissors";
			percentPicked = scissorPicks*100/(gamesPlayed*2);
		}
		else if(lizardPicks > scissorPicks & lizardPicks > rockPicks & lizardPicks > rockPicks & lizardPicks > spockPicks) {
			mostPicked = "Lizard";
			percentPicked = lizardPicks*100/(gamesPlayed*2);
		}
		else if(spockPicks > rockPicks & spockPicks > paperPicks & spockPicks > lizardPicks & spockPicks > rockPicks) {
			mostPicked = "Spock";
			percentPicked = spockPicks*100/(gamesPlayed*2);
		}
		else {
			mostPicked = "None";
			percentPicked = 0;
		}
	}
	
	public static void main(String[] args) {
		RPS game = new RPS();
		game.gameLoop();
	}
	
}
