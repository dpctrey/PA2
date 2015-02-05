package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;
import edu.jsu.mcis.TicTacToe.Mark;


public class TicTest
{
	
	@Test
	public void testAllWins(){
		boolean bOne = false;
		TicTacToe ticFrame = new TicTacToe();
		ticFrame.mark(0,0);
		ticFrame.mark(1,2);
		ticFrame.mark(1,1);
		ticFrame.mark(2,1);
		ticFrame.mark(2,2);
		if (ticFrame.isWinner(Mark.X) == Mark.X)
		{
			bOne = true;
		}
		assertTrue(bOne);
		bOne = false;
		ticFrame.resetBoard();
		ticFrame.mark(0,0);
		ticFrame.mark(1,1);
		ticFrame.mark(0,1);
		ticFrame.mark(1,2);
		ticFrame.mark(0,2);
		if (ticFrame.isWinner(Mark.X) == Mark.X)
		{
			bOne = true;
		}
		assertTrue(bOne);
		bOne = false;
		ticFrame.resetBoard();
		ticFrame.mark(0,0);
		ticFrame.mark(1,1);
		ticFrame.mark(1,0);
		ticFrame.mark(1,2);
		ticFrame.mark(2,0);
		if (ticFrame.isWinner(Mark.X) == Mark.X)
		{
			bOne = true;
		}
		assertTrue(bOne);
		bOne = false;
		ticFrame.resetBoard();
		ticFrame.mark(1,0);
		ticFrame.mark(2,0);
		ticFrame.mark(1,1);
		ticFrame.mark(2,2);
		ticFrame.mark(1,2);
		if (ticFrame.isWinner(Mark.X) == Mark.X)
		{
			bOne = true;
		}
		assertTrue(bOne);
		bOne = false;
		ticFrame.resetBoard();
		ticFrame.mark(2,0);
		ticFrame.mark(1,1);
		ticFrame.mark(2,1);
		ticFrame.mark(1,2);
		ticFrame.mark(2,2);
		if (ticFrame.isWinner(Mark.X) == Mark.X)
		{
			bOne = true;
		}
		assertTrue(bOne);
		bOne = false;
		ticFrame.resetBoard();
		ticFrame.mark(0,1);
		ticFrame.mark(1,0);
		ticFrame.mark(1,1);
		ticFrame.mark(1,2);
		ticFrame.mark(2,1);
		if (ticFrame.isWinner(Mark.X) == Mark.X)
		{
			bOne = true;
		}
		assertTrue(bOne);
		bOne = false;
		ticFrame.resetBoard();
		ticFrame.mark(0,2);
		ticFrame.mark(1,1);
		ticFrame.mark(1,2);
		ticFrame.mark(0,1);
		ticFrame.mark(2,2);
		if (ticFrame.isWinner(Mark.X) == Mark.X)
		{
			bOne = true;
		}
		assertTrue(bOne);
		bOne = false;
		ticFrame.resetBoard();
		ticFrame.mark(0,2);
		ticFrame.mark(0,1);
		ticFrame.mark(1,1);
		ticFrame.mark(1,2);
		ticFrame.mark(2,0);
		if (ticFrame.isWinner(Mark.X) == Mark.X)
		{
			bOne = true;
		}
		assertTrue(bOne);
	}
	
	@Test
	public void testmarkString()
	{
		boolean b= false;
		TicTacToe tic = new TicTacToe();
		String str = tic.markString(Mark.O);
		if (str == "O")
		{
			b = true;
		}
		assertTrue(b);
		b= false;
		str = tic.markString(Mark.X);
		if (str == "X")
		{
			b = true;
		}
		assertTrue(b);
		b= false;
		str = tic.markString(Mark.TIE);
		if (str == "TIE")
		{
			b = true;
		}
		assertTrue(b);
		b= false;
		str = tic.markString(Mark.EMPTY);
		if (str == "Empty")
		{
			b = true;
		}
		assertTrue(b);
	}
	
	@Test
	public void testTie()
	{
		boolean b = false;
		TicTacToe tac = new TicTacToe();
		tac.mark(0,0);
		tac.mark(1,1);
		tac.mark(0,1);
		tac.mark(0,2);
		tac.mark(2,0);
		tac.mark(1,0);
		tac.mark(1,2);
		tac.mark(2,1);
		tac.mark(2,2);
		b = tac.isTie();
		assertTrue(b);
	}
}