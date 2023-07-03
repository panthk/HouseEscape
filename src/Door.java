//Imports packages
import javax.swing.JOptionPane;

public class Door {

	//Creates variables
	private int clues, key, answer;
	private String hold;
	
	//Constructor that brings in amount of clues and door code
	Door(int Clues, int Key)
	{
		//Initializes variables
		clues = Clues;
		key = Key;
		answer = -2;
		
		System.out.println(key);
	}

	public boolean interact()
	{
		//Initializes win variable
		boolean win = false;
		
		//Creates input dialog for the key
		try
		{
			hold = JOptionPane.showInputDialog(null, "There is a " + clues + " digit lock on the door:", "Door", JOptionPane.INFORMATION_MESSAGE);

			//Tries to convert string input to int input
			answer = Integer.parseInt(hold);
		}
		catch (Exception e1)
		{
			//Sets answer to -2 if input can't be converted
			answer = -2;
		}

		//Sees if answer isn't nothing
		if (hold != null)
		{
			//Tells the user they unlocked the door if they entered the right code
			if (answer == key)
			{
				JOptionPane.showMessageDialog(null, "The door unlocked.", "Door", JOptionPane.INFORMATION_MESSAGE);
				
				win = true;
			}
			//Tells the user nothing happened if they entered the wrong code
			else
			{
				JOptionPane.showMessageDialog(null, "Nothing Happened", "Door", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		//Returns win
		return win;
	}
}

