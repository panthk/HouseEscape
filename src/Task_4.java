//Imports packages
import java.awt.*;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class Task_4 {

	//Creates variables
	private ImageIcon image_pre, tv, duck_hunt, bird;
	private Image image_img;
	private int frame_width, frame_height, clue, countdown_count, count, score,  x_pos_bird, y_pos_bird;
	private String shape;
	private boolean task_4_start, countdown, shot, task_4_win;

	//Constructor that brings in frame width, frame height, and task code
	Task_4(int Frame_width, int Frame_height, String Shape, int Clue)
	{
		//Initializes variables
		frame_width = Frame_width;
		frame_height = Frame_height;

		image_pre = new ImageIcon("tv.png");
		image_img = image_pre.getImage().getScaledInstance(800, 1000, Image.SCALE_DEFAULT);
		tv = new ImageIcon(image_img);

		image_pre = new ImageIcon("duckhunt.png");
		image_img = image_pre.getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT);
		duck_hunt = new ImageIcon(image_img);
		
		image_pre = new ImageIcon("bird.png");
		image_img = image_pre.getImage().getScaledInstance((int)(image_pre.getIconWidth() / 1.5), (int)(image_pre.getIconHeight() / 1.5), Image.SCALE_DEFAULT);
		bird = new ImageIcon(image_img);

		shape = Shape;
		clue = Clue;

		countdown_count = 8;
		count = 0;
		score = 0;
		x_pos_bird = (1000 - 12) / 2 - bird.getIconWidth() / 2;
		y_pos_bird = (700 - 35) / 2 - bird.getIconHeight() / 2;
	}

	//Draws task. Brings in graphics2d object and fontmetrics object
	public void draw(Graphics2D g2, FontMetrics fm)
	{
		//Draws tv image
		g2.drawImage(tv.getImage(), frame_width / 2 - tv.getIconWidth() / 2 - 5, frame_height / 2 - tv.getIconHeight() / 2 + 40, null);
		g2.setColor(Color.white);
		g2.fill(new Rectangle2D.Double(frame_width / 2 - 350, frame_height / 2 - 250, 700, 500));
		g2.drawImage(duck_hunt.getImage(), frame_width / 2 - duck_hunt.getIconWidth() / 2, frame_height / 2 - duck_hunt.getIconHeight() / 2, null);

		//Draws start screen if game hasn't started
		if (task_4_start == false)
		{
			g2.setColor(Color.black);
			g2.drawString("Click to Start", frame_width / 2 - fm.stringWidth("Click to Start") / 2, frame_height / 2 + fm.getAscent() / 2 - fm.getAscent());
		}
		else
		{
			//Draws win screen if win is true
			if (task_4_win == true)
			{
				g2.setColor(Color.black);

				g2.drawString("You Won! Your code is:", frame_width / 2 - fm.stringWidth("You Won! Your code is:") / 2, frame_height / 2 + fm.getAscent() / 2 - fm.getAscent());
				g2.drawString(shape + " " + clue, frame_width / 2 - fm.stringWidth(shape + " " + clue) / 2, frame_height / 2 + fm.getAscent() / 2 + fm.getAscent());
			}
			//Displays instructions
			else if (countdown == true)
			{
				g2.setColor(Color.black);

				if (countdown_count >= 4)
				{
					g2.drawString("Click the birds to shoot them", frame_width / 2 - fm.stringWidth("Click the birds to shoot them") / 2, frame_height / 2 + fm.getAscent() / 2 - fm.getAscent());
					g2.drawString("Shoot 10 birds to win", frame_width / 2 - fm.stringWidth("Shoot 10 birds to win") / 2, frame_height / 2 + fm.getAscent() / 2 + fm.getAscent());
				}
				else
				{
					g2.drawString(Integer.toString(countdown_count), frame_width / 2 - fm.stringWidth(Integer.toString(countdown_count)) / 2, frame_height / 2 + fm.getAscent() / 2);
				}
			}
			//Draws bird if shot is true
			else if (shot == true)
			{
				g2.drawImage(bird.getImage(), x_pos_bird, y_pos_bird, null);

				//Draws score
				g2.setColor(Color.black);
				g2.drawString("Score: " + score, frame_width / 2 - fm.stringWidth("Score: " + score) / 2, frame_height / 2 - 250 + fm.getAscent());
			}
			//Draws score
			else
			{
				g2.setColor(Color.black);
				g2.drawString("Score: " + score, frame_width / 2 - fm.stringWidth("Score: " + score) / 2, frame_height / 2 - 250 + fm.getAscent());
			}
		}

	}

	////Decreases countdown
	public void count()
	{
		countdown_count--;

		//Starts game if countdown is 0
		if (countdown_count == 0)
		{
			countdown = false;
			House_Escape.shot_timer.start();
		}
	}

	//Randomizes bird position
	public void bird_randomize()
	{
		//Increases count
		count++;

		//Randomizes bird once every 4 times
		if (count % 4 == 1)
		{					
			x_pos_bird = (int)(Math.random() * (700 - bird.getIconWidth()) + (frame_width / 2 - 350));;
			y_pos_bird = (int)(Math.random() * (500 - bird.getIconHeight()) + (frame_height / 2 - 250));;

			shot = true;				
		}
		//Sets shot to false once every 4 times
		else if (count % 4 == 0)
		{		
			shot = false;
		}
	}

	//Detects mouse press when inside task. Brings in mouse x and y
	public void mouse_pressed(int x, int y)
	{
		//Starts task and timer
		task_4_start = true;

		if (countdown == false && countdown_count > 0)
		{
			countdown = true;

			House_Escape.second_timer.start();
		}

		//Sees if mouse clicked the bird if shot is true
		if (shot == true)
		{
			if (x >= x_pos_bird && x <= x_pos_bird + bird.getIconWidth() && y >= y_pos_bird && y <= y_pos_bird + bird.getIconHeight())
			{
				//Sets shot to false and increases score
				shot = false;

				score++;

				//Sets win to true if score is 10 or more
				if (score >= 10)
				{
					task_4_win = true;

					House_Escape.second_timer.stop();
					House_Escape.shot_timer.stop();
				}
			}
		}
	}

}
