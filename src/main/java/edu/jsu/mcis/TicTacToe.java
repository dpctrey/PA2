package edu.jsu.mcis;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

public class TicTacToe extends JFrame 
{
    public enum Mark {EMPTY, X, O, TIE}
    private boolean xTurn = true;
    public final int time = 1000;
    private static final long serialVersionUID = 1L;
    public final int size = 3;
    private final JButton[][] fButton = new JButton[size][size];
    private final Mark[][] gBoard = new Mark[size][size];
    
    public TicTacToe() 
    {
        initComponents();
    }
	
    public void mark(int r, int c)
    {
        if (gBoard[r][c] == Mark.EMPTY)
		{
			if (xTurn == true)
			{
				
				fButton[r][c].setLabel("X");
				fButton[r][c].setText("X");
				gBoard[r][c] = Mark.X;
				xTurn = false;
				Mark t = isWinner(Mark.X);
			}
			else 
			{
				
				int timeTwo = 1000;
				fButton[r][c].setLabel("O");
				fButton[r][c].setText("O");
				gBoard[r][c] = Mark.O;
				xTurn = true;
				Mark k = isWinner(Mark.O);
			}
		}
	}
	
    private void initComponents() 
    {
		for (int r = 0; r < size; r++)
		{
			for(int c = 0; c < size; c++)
			{
				fButton[r][c] = new JButton();
				fButton[r][c].setName("Location" + r + c);
                gBoard[r][c] = Mark.EMPTY;
			}
		}
		
        fButton[0][0].addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                mark(0, 0);
            }
        });
        fButton[0][1].addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                mark(0,1);
            }
        });
        fButton[0][2].addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                mark(0,2);
            }
        });
        fButton[1][0].addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                mark(1,0);
            }
        });
        fButton[1][1].addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                mark(1,1);
            }
        });
        fButton[1][2].addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                mark(1,2);
            }
        });
         fButton[2][0].addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                mark(2,0);
            }
        });
        fButton[2][1].addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
				mark(2,1);
            }
        });
        fButton[2][2].addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                mark(2,2);
            }
        });
        pack();
        setLocationRelativeTo(getOwner());
	}
    public Mark isWinner(Mark m)
	{
		boolean hasWon = false;
		if (((gBoard[0][0] == m) && (gBoard[0][1] == m)
			&& (gBoard[0][2] == m)) || ((gBoard[0][0] == m) && (gBoard[1][1] == m)
			&& (gBoard[2][2] == m)) || ((gBoard[0][0] == m) && (gBoard[1][0] == m)
			&& (gBoard[2][0] == m)) || ((gBoard[0][2] == m) && (gBoard[1][1] == m)
			&& (gBoard[2][0] == m)) || ((gBoard[1][0] == m) && (gBoard[1][1] == m)
			&& (gBoard[1][2] == m)) || ((gBoard[0][1] == m) && (gBoard[1][1] == m)
			&& (gBoard[2][1] == m)) || ((gBoard[2][0] == m) && (gBoard[2][1] == m)
			&& (gBoard[2][2] == m)) || ((gBoard[0][2] == m) && (gBoard[2][2] == m)
			&& (gBoard[2][2] == m)))
		{	            
			hasWon = true;	
		}
		if (isTie() == true)
		{
			m = Mark.TIE;
			String r = markString(m);
			ActionListener aListen = new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent evt) 
				{
					JOptionPane.showMessageDialog(null, "The winner is " + r , "Game Over", JOptionPane.PLAIN_MESSAGE);
					resetBoard();
				}
			};
			Timer myTimer = new Timer(time, aListen);
			myTimer.setRepeats(false);
			myTimer.start();	
		}
		if (hasWon)
		{
			String t = markString(m);
			ActionListener aListen = new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent evt) 
				{
					JOptionPane.showMessageDialog(null, "The winner is " + t , "Game Over", JOptionPane.PLAIN_MESSAGE);
					resetBoard();
				}
			};
			Timer myTimer = new Timer(time, aListen);
			myTimer.setRepeats(false);
			myTimer.start();
		}
		else
		{	            
			m = Mark.EMPTY;
		}
		return m;
	}
	 
    public void resetBoard()
	{
        for (int r = 0; r < size; r++)
		{
			for (int c = 0; c < size; c++)
			{
				gBoard[r][c] = Mark.EMPTY;
				fButton[r][c].setText("");
				xTurn = true;
			}
		}
    }
    
    public boolean isTie()
	{
        for (int r = 0; r < size; r++)
		{
            for (int c = 0; c < size; c++)
			{
                if (gBoard[r][c] == Mark.EMPTY)
				{
                    return false;
                }
            }
        }
        return true;
    }
	
    public String markString(Mark m)
	{
        if (m == Mark.X)
		{
            return "X";
        }
        else if (m == Mark.O)
		{
            return "O";
        }
        else if (m == Mark.TIE)
		{
            return "TIE";
        }
        return "Empty";
    }
	
    public static void main(String[] args) 
    {
        JFrame gameFrame = new JFrame("Tic Tac Toe");
        gameFrame.setLayout(new GridLayout(3,3));
		gameFrame.setSize(400,400);
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        TicTacToe ticFrame = new TicTacToe();
        for (int i = 0; i < 3; i++)
		{
            for (int j = 0; j < 3; j++)
			{
                gameFrame.add(ticFrame.fButton[i][j]);
            }
        }
        gameFrame.pack();
        gameFrame.setVisible(true);
    }
}

