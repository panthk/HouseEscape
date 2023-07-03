//Imports packages
import java.awt.*;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class Task_3 {

	//Creates variables
	private ImageIcon cage_closed, cage_open, key_pic, paper;
	private int frame_width, frame_height, clue, x_pos_key, y_pos_key;
	private String shape;
	private Rectangle2D lock, key_hitbox;
	private boolean open;

	//Constructor that brings in frame width, frame height, and task code
	Task_3(int Frame_width, int Frame_height, String Shape, int Clue)
	{
		//Initializes variables
		frame_width = Frame_width;
		frame_height = Frame_height;

		cage_open = new ImageIcon("cage_open.png");
		cage_closed = new ImageIcon("cage_closed.png");
		key_pic = new ImageIcon("key.png");
		paper = new ImageIcon("paper.png");

		x_pos_key = 200;
		y_pos_key = 200;

		lock = new Rectangle2D.Double((1000 - 12) / 2 - cage_closed.getIconWidth() / 2 + cage_closed.getIconWidth() - 20, (700 - 35) / 2 - cage_closed.getIconHeight() / 2 + cage_closed.getIconHeight() / 2 + 20, 20, 30);
		key_hitbox = new Rectangle2D.Double(x_pos_key, y_pos_key, key_pic.getIconWidth(), key_pic.getIconHeight());

		clue = Clue;
		shape = Shape;
	}

	//Draws task. Brings ins graphics2d object
	public void draw(Graphics2D g2)
	{
		//Draws paper
		g2.drawImage(paper.getImage(), frame_width / 2 - cage_closed.getIconWidth() / 2 + 70, frame_height / 2 - cage_closed.getIconWidth() / 2 + 80, null);

		//Draws open or closed cage with key depending on if the cage is open or closed
		if (open == false)
		{
			g2.drawImage(cage_closed.getImage(), frame_width / 2 - cage_closed.getIconWidth() / 2, frame_height / 2 - cage_closed.getIconWidth() / 2, null);

			g2.drawImage(key_pic.getImage(), x_pos_key, y_pos_key, null);
		}
		else
		{
			g2.drawImage(cage_open.getImage(), frame_width / 2 - cage_closed.getIconWidth() / 2, frame_height / 2 - cage_closed.getIconWidth() / 2, null);
		}	
	}
	
	//Remakes key mask
	public void key_hitbox()
	{
		key_hitbox = new Rectangle2D.Double(x_pos_key, y_pos_key, key_pic.getIconWidth(), key_pic.getIconHeight());
	}

	//Detects mouse press when inside task. Brings in mouse x and y
	public void mouse_pressed(int x, int y)
	{
		//Shows JOptionPane of task code if the mouse clicked the paper
		if (open)
		{
			if (x >= frame_width / 2 - cage_closed.getIconWidth() / 2 + 70 && x <= frame_width / 2 - cage_closed.getIconWidth() / 2 + 70 + paper.getIconWidth() && y >= frame_height / 2 - cage_closed.getIconWidth() / 2 + 80 && y <= frame_height / 2 - cage_closed.getIconWidth() / 2 + 80 + paper.getIconHeight())
			{
				JOptionPane.showMessageDialog(null, "There is a message on the paper.\n\nIt says: " + shape + " " + clue, "PAPAER", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	//Detects mouse dragged when inside task. Brings in mouse x and y
	public void mouse_dragged(int x, int y)
	{
		//Moves the key picture to the middle of the mouse if the mouse dragged it
		if (key_hitbox.contains(x, y))
		{
			x_pos_key = x - key_pic.getIconWidth() / 2;
			y_pos_key = y - key_pic.getIconHeight() / 2;

			//Opens the lock if the key intersects it
			if (key_hitbox.intersects(lock))
			{
				open = true;
			}
		}
	}
}
