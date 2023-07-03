//Imports packages
import java.awt.*;

import javax.swing.*;

public class Task_2 {

	//Creates variables
	private ImageIcon image_pre, computer;
	private Image image_img;
	private int frame_width, frame_height, password_num, clue;
	private String shape;
	private String [] password;

	//Constructor that brings in frame width, frame height, task code, and computer task passwords
	Task_2(int Frame_width, int Frame_height, String Shape, int Clue, String [] Password, int Password_num)
	{
	// Creates variables
		frame_width = Frame_width;
		frame_height = Frame_height;

		image_pre = new ImageIcon("computer.png");
		image_img = image_pre.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
		computer = new ImageIcon(image_img);

		password = Password;
		password_num = Password_num;

		clue = Clue;
		shape = Shape;
	}

	//Draws task. Brings in graphics2d object
	public void draw(Graphics2D g2)
	{
		//Draws computer image
		g2.drawImage(computer.getImage(), frame_width / 2 - computer.getIconWidth() / 2, frame_height / 2 - computer.getIconHeight() / 2 + 50, null);
	}

	//Shows computer task JOptionPane
	public void task_interact()
	{
		//Tries to get a string output
		try
		{
			//Sets string variable to input
			String hold = JOptionPane.showInputDialog(null, "ENTER PASSWORD", "TERMINAL", JOptionPane.INFORMATION_MESSAGE);

			//If input equals the password, displays the task code
			if (hold.equalsIgnoreCase(password[password_num]))
			{
				JOptionPane.showMessageDialog(null, "PASSSWORD ACCEPTED\n\nYOUR CODE IS: " + shape + " " + clue, "TERMINAL", JOptionPane.INFORMATION_MESSAGE);
			}
			//If input doesn't equal the password, tells the player they inputed the wrong password
			else
			{
				JOptionPane.showMessageDialog(null, "ERROR -- INCORECT PASSWORD", "TERMINAL", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		catch (Exception e1)
		{
			
		}
	}
}
