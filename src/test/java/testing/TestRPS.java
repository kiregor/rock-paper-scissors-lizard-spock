package testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.RPS;

public class TestRPS {
	private RPS rockPaperScissors = new RPS();
	
	@Test
	public void testString() {
		String result = rockPaperScissors.takeTurn();
		boolean check = false;
		
		if(result.equals("Rock") || result.equals("Paper") || result.equals("Scissors") || result.equals("Lizard") || result.equals("Spock"))
			check = true;
		
		assert(check);
	}
	
	@Test
	public void testUserTurn()
	{
		String result = rockPaperScissors.takeUserTurn();
		boolean check = false;
		
		if(result.equals("Rock") || result.equals("Paper") || result.equals("Scissors") || result.equals("Lizard") || result.equals("Spock"))
			check = true;
			
		
		assertEquals(check, true);
	}
	
	@Test
	public void testWinner() {	
		
		String result = rockPaperScissors.checkWinner();
		boolean check = false;
		
		if(result.equals("Player") || result.equals("Computer") || result.equals("Its a Tie"))
			check = true;
		
		assertEquals(check, true);
	}
}
