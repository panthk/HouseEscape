//Imports packages
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class Task_5 {

	//Creates variables
	private ImageIcon image_pre, tv;
	private Image image_img;
	private int frame_width, frame_height, clue, countdown_count, score, gravity, fall, y_pos_player, x_pos_cacti, player_height, y_pos_cacti, speed, show;
	private String shape;
	private Rectangle2D player;
	private Rectangle2D [] obstacles;
	private boolean task_5_start, countdown, ground, crouch, task_5_win;

	//Constructor that brings in frame width, frame height, and task code
	Task_5(int Frame_width, int Frame_height, String Shape, int Clue)
	{
		//Initializes variables
		frame_width = Frame_width;
		frame_height = Frame_height;

		image_pre = new ImageIcon("nintendo_switch.png");
		image_img = image_pre.getImage().getScaledInstance((int)(image_pre.getIconWidth() / 1.2), (int)(image_pre.getIconHeight() / 1.2), Image.SCALE_DEFAULT);
		tv = new ImageIcon(image_img);

		shape = Shape;
		clue = Clue;

		countdown_count = 10;
		score = 0;

		gravity = 1;
		fall = 0;
		y_pos_player = frame_height / 2 + 158 - 50;
		player_height = 50;

		x_pos_cacti = frame_width / 2 + 275;
		y_pos_cacti = frame_height / 2 + + 158 - 50;
		speed = 12;
		show = 0;

		player = new Rectangle2D.Double(frame_width / 2 - 275 + 50, y_pos_player, 50 , player_height);

		obstacles = new Rectangle2D [4];

		obstacles[0] = new Rectangle2D.Double(x_pos_cacti, y_pos_cacti, 50, 50);
		obstacles[1] = new Rectangle2D.Double(x_pos_cacti, y_pos_cacti, 70, 50);
		obstacles[2] = new Rectangle2D.Double(x_pos_cacti, y_pos_cacti - 10, 40, 60);
		obstacles[3] = new Rectangle2D.Double(x_pos_cacti, y_pos_cacti - 5, 50, 25);
	}

	//Draws task. Brings in graphics2d object and font metrics object
	public void draw(Graphics2D g2, FontMetrics fm)
	{	
		//Draws tv
		g2.setColor(Color.white);
		g2.fill(new Rectangle2D.Double(frame_width / 2 - 275, frame_height / 2 - 175, 550, 350));
		g2.drawImage(tv.getImage(), frame_width / 2 - tv.getIconWidth() / 2 - 5, frame_height / 2 - tv.getIconHeight() / 2 - 10, null);

		//Draws start screen if task hasn't started
		if (task_5_start == false)
		{
			g2.setColor(Color.black);
			g2.drawString("Press Space to Start", frame_width / 2 - fm.stringWidth("Press Space to Start") / 2, frame_height / 2 + fm.getAscent() / 2 - fm.getAscent());
		}
		else
		{
			//Draws win screen if player has won the task
			if (task_5_win == true)
			{
				g2.setColor(Color.black);

				g2.drawString("You Won! Your code is:", frame_width / 2 - fm.stringWidth("You Won! Your code is:") / 2, frame_height / 2 + fm.getAscent() / 2 - fm.getAscent());
				g2.drawString(shape + " " + clue, frame_width / 2 - fm.stringWidth(shape + " " + clue) / 2, frame_height / 2 + fm.getAscent() / 2 + fm.getAscent());
			}
			else if (countdown == true)
			{
				g2.setColor(Color.black);

				//Draws instructions and countdown
				if (countdown_count >= 4)
				{
					g2.drawString("Press W to jump", frame_width / 2 - fm.stringWidth("Press W to jump") / 2, frame_height / 2 + fm.getAscent() / 2 - fm.getAscent() - fm.getAscent());
					g2.drawString("Press S to crouch", frame_width / 2 - fm.stringWidth("Press S to crouch") / 2, frame_height / 2 + fm.getAscent() / 2 - fm.getAscent() / 2);
					g2.drawString("Avoid 10 obstacles to win", frame_width / 2 - fm.stringWidth("Avoid 10 obstacles to win") / 2, frame_height / 2 + fm.getAscent() / 2 + fm.getAscent() / 2 + fm.getAscent() / 2);
				}
				else
				{
					g2.drawString(Integer.toString(countdown_count), frame_width / 2 - fm.stringWidth(Integer.toString(countdown_count)) / 2, frame_height / 2 + fm.getAscent() / 2);
				}
			}
			else
			{
				//Draws score
				g2.setColor(Color.white);
				g2.fill(new Rectangle2D.Double(frame_width / 2 - 275, frame_height / 2 - 175, 550, 350));
				g2.setColor(Color.black);
				g2.drawString("Score: " + score, frame_width / 2 - fm.stringWidth("Score: " + score) / 2, frame_height / 2 - 165 + fm.getAscent());

				//Draws player and obstacle
				g2.fill(player);
				g2.fill(obstacles[show]);

				//Redraws tv
				g2.drawImage(tv.getImage(), frame_width / 2 - tv.getIconWidth() / 2 - 5, frame_height / 2 - tv.getIconHeight() / 2 - 10, null);
			}
		}
	}

	//Detects key pressed while in task. Brings in keyevent e
	public void key_pressed(KeyEvent e)
	{
		//Starts task and timer if space is pressed and game hasn't started
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			task_5_start = true;

			if (countdown == false && countdown_count > 0)
			{
				countdown = true;

				House_Escape.second_timer_2.start();
			}
		}
		if (task_5_start == true)
		{
			//Jumps if w is pressed, the game has started, player is on the ground, and the player is not crouching
			if (e.getKeyCode() == KeyEvent.VK_W)
			{
				if (countdown_count <= 0 && ground == true && crouch == false)
				{
					fall = -13;
					ground = false;
				}
			}
			//Crouches if s is pressed, the game has started and the player is on the ground
			if (e.getKeyCode() == KeyEvent.VK_S)
			{
				if (ground == true)
				{
					crouch = true;
					fall = 50;
				}
			}
		}

	}

	//Detects key released while in task. Brings in keyevent e
	public void key_released(KeyEvent e)
	{
		//If s is released, crouch is set to false
		if (e.getKeyCode() == KeyEvent.VK_S)
		{
			crouch = false;
		}
	}

	//Redraws player mask and obstacle mask when the timer restarts
	public void task_timer()
	{
		//Increases fall by gravity int and y pos by fall int. This makes the player speed up when falling mimicking gravity
		fall += gravity;

		y_pos_player += fall;

		x_pos_cacti -= speed;

		//Shortens the player if crouch is true
		if (crouch == true)
		{
			y_pos_player = y_pos_player - 25;

			player_height = 25;
		}
		else
		{
			player_height = 50;
		}

		//Sets ground to true if the player mask is below the bottom of the tv. Also resets player y
		if (y_pos_player + player_height > frame_height / 2 + 158)
		{
			y_pos_player = frame_height / 2 + 158 - player_height;

			ground = true;
		}

		//If the obstacle leaves the left side of the tv screen, resets the obstacle
		if (x_pos_cacti < frame_width / 2 - 275 - 90)
		{
			obstacle_reset();

			//Increases score
			score++;

			//Sets score to win and stops timers if score is more than or equal to 10
			if (score >= 10)
			{
				task_5_win = true;

				House_Escape.second_timer_2.stop();
				House_Escape.task_5_timer.stop();
			}
		}

		//If the obstacle hits the player, the obstacle resets
		if (obstacles[show].intersects(player))
		{
			obstacle_reset();
		}

		//Remakes the player and obstacle masks
		player = new Rectangle2D.Double(frame_width / 2 - 275 + 50, y_pos_player, 50, player_height);
		obstacles[0] = new Rectangle2D.Double(x_pos_cacti, y_pos_cacti, 50, 50);
		obstacles[1] = new Rectangle2D.Double(x_pos_cacti, y_pos_cacti, 70, 50);
		obstacles[2] = new Rectangle2D.Double(x_pos_cacti, y_pos_cacti - 10, 40, 60);
		obstacles[3] = new Rectangle2D.Double(x_pos_cacti, y_pos_cacti - 25, 50, 45);
	}

	//Countsdown when timer restarts
	public void count()
	{
		countdown_count--;

		//Starts game if countdown is 0
		if (countdown_count == 0)
		{
			countdown = false;
			House_Escape.task_5_timer.start();
		}
	}

	//Sets obstacle x pos to the right of the screen and randomizes which obstacle is shown
	public void obstacle_reset()
	{
		x_pos_cacti = frame_width / 2 + 275;

		show = (int)(Math.random() * 4);
	}
}
