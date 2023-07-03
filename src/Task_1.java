//Imports packages
import java.awt.*;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class Task_1 {

	//Creates variables
	private ImageIcon paper;
	private int frame_width, frame_height, password_num, clue;
	private String shape;
	private String[] password;
	public Rectangle2D [] handle;
	public boolean [] handle_open;
	
	//Constructor that brings in frame width, frame height, task code, and computer task passwords
	Task_1(int Frame_width, int Frame_height, String Shape, int Clue, String [] Password, int Password_num)
	{
		//Initializes variables
		frame_width = Frame_width;
		frame_height = Frame_height;

		paper = new ImageIcon("paper.png");

		password = Password;
		password_num = Password_num;
		
		handle = new Rectangle2D.Double[3];
		handle_open = new  boolean [3];

		for (int i = 0; i < handle.length; i++)
		{
			handle[i] = new Rectangle2D.Double((1000 - 12) / 2 - 30, (700 - 35) / 2 + 100 + 5, 60, 25);
		}
		
		shape = Shape;
		clue = Clue;
	}
	
	//Draws drawer 1. Brings in graphics2d object
	public void draw_drawer_1(Graphics2D g2)
	{
		g2.setStroke(new BasicStroke(10));

		//Draws open drawer with paper
		if (handle_open[0])
		{
			g2.setColor(Color.black);
			g2.draw(new Rectangle2D.Double(frame_width / 2 - 150, frame_height / 2 + 100, 300, 100));

			g2.setColor(new Color(139,69,19));
			g2.fill(new Rectangle2D.Double(frame_width / 2 - 150, frame_height / 2 + 100, 300, 100));

			g2.drawImage(paper.getImage(), frame_width / 2 + 40, frame_height / 2 + 100 + 20, null);
		}

		//Draws drawer
		g2.setColor(Color.black);
		g2.draw(new Rectangle2D.Double(frame_width / 2 - 200, frame_height / 2 - 100, 400, 200));

		g2.setColor(new Color(139,69,19));
		g2.fill(new Rectangle2D.Double(frame_width / 2 - 200, frame_height / 2 - 100, 400, 200));

		g2.setColor(Color.black);
		g2.draw(handle[0]);

		g2.setColor(Color.gray);
		g2.fill(handle[0]);
	}
	
	//Draws drawer 2. Brings in graphics2d object
	public void draw_drawer_2(Graphics2D g2)
	{
		g2.setStroke(new BasicStroke(10));

		//Draws open drawer with paper
		if (handle_open[1])
		{
			g2.setColor(Color.black);
			g2.draw(new Rectangle2D.Double(frame_width / 2 - 150, frame_height / 2 + 100, 300, 100));

			g2.setColor(new Color(139,69,19));
			g2.fill(new Rectangle2D.Double(frame_width / 2 - 150, frame_height / 2 + 100, 300, 100));

			g2.drawImage(paper.getImage(), frame_width / 2 - 80, frame_height / 2 + 100 + 10, null);
		}

		//Draws drawer
		g2.setColor(Color.black);
		g2.draw(new Rectangle2D.Double(frame_width / 2 - 200, frame_height / 2 - 100, 400, 200));

		g2.setColor(new Color(139,69,19));
		g2.fill(new Rectangle2D.Double(frame_width / 2 - 200, frame_height / 2 - 100, 400, 200));

		g2.setColor(Color.black);
		g2.draw(handle[1]);

		g2.setColor(Color.gray);
		g2.fill(handle[1]);
	}
	
	//Draws drawer 3. Brings in graphics2d object
	public void draw_drawer_3(Graphics2D g2)
	{
		g2.setStroke(new BasicStroke(10));

		//Draws open drawer
		if (handle_open[2])
		{
			g2.setColor(Color.black);
			g2.draw(new Rectangle2D.Double(frame_width / 2 - 150, frame_height / 2 + 100, 300, 100));

			g2.setColor(new Color(139,69,19));
			g2.fill(new Rectangle2D.Double(frame_width / 2 - 150, frame_height / 2 + 100, 300, 100));
		}

		//Draws drawer
		g2.setColor(Color.black);
		g2.draw(new Rectangle2D.Double(frame_width / 2 - 200, frame_height / 2 - 100, 400, 200));

		g2.setColor(new Color(139,69,19));
		g2.fill(new Rectangle2D.Double(frame_width / 2 - 200, frame_height / 2 - 100, 400, 200));

		g2.setColor(Color.black);
		g2.draw(handle[2]);

		g2.setColor(Color.gray);
		g2.fill(handle[2]);
	}
	
	//Detects mouse press during drawer 1 task. Brings in mouse x and y position
	public void drawer_1(int x, int y)
	{
		//Sees if the mouse clicked the handle of the drawer
		if (handle_open[0] == false)
		{
			if (handle[0].contains(x, y))
			{
				//Sets handle open to true and redraws the handle mask
				handle_open[0] = true;

				handle[0] = new Rectangle2D.Double((1000 - 12) / 2 - 30, (700 - 35) / 2 + 100 + 100 + 5, 60, 25);
			}
		}
		else
		{
			//Shows a JOptionPane of a code if the mouse clicked the paper
			if (x >= frame_width / 2 + 40 && x <= frame_width / 2 + 40 + paper.getIconWidth() && y >= frame_height / 2 + 100 + 20 && y <= frame_height / 2 + 100 + 20 + paper.getIconHeight())
			{
				JOptionPane.showMessageDialog(null, "There was a message on the paper.\n\nIt said: " + shape + " " + clue, "PAPER", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	//Detects mouse press during drawer 2 task. Brings in mouse x and y position
	public void drawer_2(int x, int y)
	{
		//Sees if the mouse clicked the handle of the drawer
		if (handle_open[1] == false)
		{
			if (handle[1].contains(x, y))
			{
				//Sets handle open to true and redraws the handle mask
				handle_open[1] = true;

				handle[1] = new Rectangle2D.Double((1000 - 12) / 2 - 30, (700 - 35) / 2 + 100 + 100 + 5, 60, 25);
			}
		}
		else
		{	
			//Shows a JOptionPane of a code if the mouse clicked the paper
			if (x >= frame_width / 2 - 80 && x <= frame_width / 2 - 80 + paper.getIconWidth() && y >= frame_height / 2 + 100 + 10 && y <= frame_height / 2 + 100 + 10 + paper.getIconHeight())
			{
				JOptionPane.showMessageDialog(null, "There was a message on the paper.\n\nIt said: " + password[password_num], "PAPER", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	//Detects mouse press during drawer 3 task. Brings in mouse x and y position
	public void drawer_3(int x, int y)
	{
		if (handle_open[2] == false)
		{
			//Sees if the mouse clicked the handle of the drawer
			if (handle[2].contains(x, y))
			{
				//Sets handle open to true and redraws the handle mask
				handle_open[2] = true;

				handle[2] = new Rectangle2D.Double((1000 - 12) / 2 - 30, (700 - 35) / 2 + 100 + 100 + 5, 60, 25);
			}
		}
	}
}
