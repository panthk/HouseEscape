//Imports packages
import java.awt.*;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class Background {

	//Creates variables
	private ImageIcon background, imagePre, blackScreen, blackScreenSmall, door_pic, computer_desk, book_shelf, cage, drawer_pic, box_tv, nintendo_table;
	private ImageIcon[] playerDown, playerRight, playerLeft, playerUp;
	private Image imageImg;
	private final int DOWN = 0, RIGHT = 1, UP = 2, LEFT = 3;
	private int panelWidth, panelHeight, level;
	private int xPosBackground, yPosBackground, xPosVision, yPosVision, xPosVisionSmall, yPosVisionSmall, xPosPlayer, yPosPlayer;
	private int x_pos_task_0, y_pos_task_0, x_pos_task_2, y_pos_task_2, x_pos_task_3, y_pos_task_3, x_pos_task_4, y_pos_task_4, x_pos_task_5, y_pos_task_5;
	private int animation, speed, dir;
	private int [] x_pos_task_1, y_pos_task_1;
	private Rectangle2D player, door, task_0, task_2, task_3, task_4, task_5;
	private Rectangle2D [] tasks, task_1;
	private boolean collision, left, right, up, down;

	//Constructor that takes in screen width, screen height, and level
	public Background(int width, int height, int Level)
	{		
		//Initializes variables
		level = Level;
		panelWidth = width;
		panelHeight = height;

		//Sets the backround picture depending on the level
		if (level == 1)
		{
			imagePre = new ImageIcon("Level 1.png");
			imageImg = imagePre.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
			background = new ImageIcon(imageImg);
		}
		else if (level == 2)
		{
			imagePre = new ImageIcon("Level 2.png");
			imageImg = imagePre.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
			background = new ImageIcon(imageImg);
		}
		else if (level == 3)
		{
			imagePre = new ImageIcon("Level 3.png");
			imageImg = imagePre.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
			background = new ImageIcon(imageImg);
		}

		//Creates pictures
		imagePre = new ImageIcon("blackScreen.png");
		imageImg = imagePre.getImage().getScaledInstance(3400, 2160, Image.SCALE_DEFAULT);
		blackScreen = new ImageIcon(imageImg);
		
		imagePre = new ImageIcon("blackScreen.png");
		imageImg = imagePre.getImage().getScaledInstance((int)(imagePre.getIconWidth() * 1.15), (int)(imagePre.getIconHeight() * 1.15), Image.SCALE_DEFAULT);
		blackScreenSmall = new ImageIcon(imageImg);

		imagePre = new ImageIcon("door.png");
		imageImg = imagePre.getImage().getScaledInstance(112, 150, Image.SCALE_DEFAULT);
		door_pic = new ImageIcon(imageImg);

		book_shelf = new ImageIcon("book_shelf.png");
		drawer_pic = new ImageIcon("drawer.png");
		computer_desk = new ImageIcon("computer_desk.png");
		cage = new ImageIcon("cage.png");
		box_tv = new ImageIcon("box_tv.png");
		nintendo_table = new ImageIcon("nintendo_table.png");

		xPosBackground = (panelWidth) / 2 - (background.getIconWidth() / 2);
		yPosBackground = (panelHeight) / 2 - (background.getIconHeight() / 2);

		xPosVision = (panelWidth) / 2 - blackScreen.getIconWidth() / 2;
		yPosVision = (panelHeight) / 2 - blackScreen.getIconHeight() / 2;

		xPosVisionSmall = (panelWidth) / 2 - blackScreenSmall.getIconWidth() / 2;
		yPosVisionSmall = (panelHeight) / 2 - blackScreenSmall.getIconHeight() / 2;

		playerDown = new ImageIcon [4];
		playerRight = new ImageIcon [4];
		playerLeft = new ImageIcon [4];
		playerUp = new ImageIcon [4];

		//Creates an array of pictures for the player animation
		for (int i = 0; i < playerDown.length; i++)
		{
			imagePre = new ImageIcon("player/down/" + (i + 1) + ".png");
			imageImg = imagePre.getImage().getScaledInstance(imagePre.getIconWidth() / 6, imagePre.getIconHeight() / 6, Image.SCALE_DEFAULT);
			playerDown[i] = new ImageIcon(imageImg);

			imagePre = new ImageIcon("player/right/" + (i + 1) + ".png");
			imageImg = imagePre.getImage().getScaledInstance(imagePre.getIconWidth() / 6, imagePre.getIconHeight() / 6, Image.SCALE_DEFAULT);
			playerRight[i] = new ImageIcon(imageImg);

			imagePre = new ImageIcon("player/left/" + (i + 1) + ".png");
			imageImg = imagePre.getImage().getScaledInstance(imagePre.getIconWidth() / 6, imagePre.getIconHeight() / 6, Image.SCALE_DEFAULT);
			playerLeft[i] = new ImageIcon(imageImg);

			imagePre = new ImageIcon("player/up/" + (i + 1) + ".png");
			imageImg = imagePre.getImage().getScaledInstance(imagePre.getIconWidth() / 6, imagePre.getIconHeight() / 6, Image.SCALE_DEFAULT);
			playerUp[i] = new ImageIcon(imageImg);
		}

		//Sets variables
		animation = 3;
		speed = 4;

		dir = 0;

		xPosPlayer = panelWidth / 2 - get_image().getIconWidth() / 2;
		yPosPlayer = panelHeight / 2 - get_image().getIconHeight() / 2;

		player = new Rectangle2D.Double(xPosPlayer, yPosPlayer, get_image().getIconWidth(), get_image().getIconHeight());

		x_pos_task_1 = new int [3];
		y_pos_task_1 = new int [3];
		task_1 = new Rectangle2D.Double [3];

		tasks = new Rectangle2D [level + 6];

		//Randomizes each task's location and make sure they aren't overlapping. If they are, re randomize the locations
		while (true)
		{
			door = new Rectangle2D.Double(xPosBackground + background.getIconWidth() - door_pic.getIconWidth() - 100, yPosBackground + background.getIconHeight() - door_pic.getIconHeight() - 100, door_pic.getIconWidth(), door_pic.getIconHeight());

			tasks[0] = door;

			for (int i = 0; i < task_1.length; i++)
			{
				x_pos_task_1[i] = (int)(Math.random() * (background.getIconWidth() - drawer_pic.getIconWidth()));
				y_pos_task_1[i] = (int)(Math.random() * (background.getIconHeight() - drawer_pic.getIconHeight()));

				task_1[i] = new Rectangle2D.Double(xPosBackground + x_pos_task_1[i], yPosBackground + y_pos_task_1[i], drawer_pic.getIconWidth(), drawer_pic.getIconHeight());
				tasks[i + 2] = task_1[i];
			}

			x_pos_task_0 = (int)(Math.random() * (background.getIconWidth() - book_shelf.getIconWidth()));
			y_pos_task_0 = (int)(Math.random() * (background.getIconHeight() - book_shelf.getIconHeight()));
			task_0 = new Rectangle2D.Double(xPosBackground + x_pos_task_0, yPosBackground + y_pos_task_0, book_shelf.getIconWidth(), book_shelf.getIconHeight());

			tasks[1] = task_0;

			x_pos_task_2 = (int)(Math.random() * (background.getIconWidth() - computer_desk.getIconWidth()));
			y_pos_task_2 = (int)(Math.random() * (background.getIconHeight() - computer_desk.getIconHeight()));
			task_2 = new Rectangle2D.Double(xPosBackground + x_pos_task_2, yPosBackground + y_pos_task_2, computer_desk.getIconWidth(), computer_desk.getIconHeight());

			tasks[5] = task_2;

			x_pos_task_3 = (int)(Math.random() * (background.getIconWidth() - cage.getIconWidth()));
			y_pos_task_3 = (int)(Math.random() * (background.getIconHeight() - cage.getIconHeight()));
			task_3 = new Rectangle2D.Double(xPosBackground + x_pos_task_3, yPosBackground + y_pos_task_3, cage.getIconWidth(), cage.getIconHeight());

			tasks[6] = task_3;

			if (level >= 2)
			{
				x_pos_task_4 = (int)(Math.random() * (background.getIconWidth() - box_tv.getIconWidth()));
				y_pos_task_4 = (int)(Math.random() * (background.getIconHeight() - box_tv.getIconHeight()));
				task_4 = new Rectangle2D.Double(xPosBackground + x_pos_task_4, yPosBackground + y_pos_task_4, box_tv.getIconWidth(), box_tv.getIconHeight());

				tasks[7] = task_4;
			}

			if (level >= 3)
			{
				x_pos_task_5 = (int)(Math.random() * (background.getIconWidth() - nintendo_table.getIconWidth()));
				y_pos_task_5 = (int)(Math.random() * (background.getIconHeight() - nintendo_table.getIconHeight()));
				task_5 = (new Rectangle2D.Double(xPosBackground + x_pos_task_5, yPosBackground + y_pos_task_5, nintendo_table.getIconWidth(), nintendo_table.getIconHeight()));
				
				tasks[8] = task_5;
			}

			for (int i = 0; i < tasks.length - 1; i++)
			{
				for (int j = (i + 1); j < tasks.length; j++)
				{
					if (tasks[i].intersects(tasks[j]))
					{
						collision = true;

						break;
					}
				}

				if (collision)
				{
					break;
				}
			}

			if (collision)
			{
				collision = false;
				continue;
			}

			break;
		}
	}

	//Draws background. Brings in graphics2d object
	public void drawBackground(Graphics2D g2)
	{
		g2.drawImage(background.getImage(), xPosBackground, yPosBackground, null);
	}
	//Draws vision. Brings in graphics2d object
	public void drawVision(Graphics2D g2)
	{
		g2.drawImage(blackScreen.getImage(), xPosVision, yPosVision, null);
		g2.drawImage(blackScreenSmall.getImage(), xPosVisionSmall, yPosVisionSmall, null);
	}
	//Draws task based on the level. Brings in graphics2d object
	public void drawTasks(Graphics2D g2)
	{
		for (int i = 0; i < task_1.length; i++)
		{
			g2.drawImage(drawer_pic.getImage(), xPosBackground + x_pos_task_1[i], yPosBackground + y_pos_task_1[i], null);
		}
		g2.drawImage(book_shelf.getImage(), xPosBackground + x_pos_task_0, yPosBackground + y_pos_task_0, null);
		g2.drawImage(computer_desk.getImage(), xPosBackground + x_pos_task_2, yPosBackground + y_pos_task_2, null);
		g2.drawImage(cage.getImage(), xPosBackground + x_pos_task_3, yPosBackground + y_pos_task_3, null);
		if (level >= 2)
		{
			g2.drawImage(box_tv.getImage(), xPosBackground + x_pos_task_4, yPosBackground + y_pos_task_4, null);
		}
		if (level >= 3)
		{
			g2.drawImage(nintendo_table.getImage(), xPosBackground + x_pos_task_5, yPosBackground + y_pos_task_5, null);
		}
		g2.drawImage(door_pic.getImage(), xPosBackground + background.getIconWidth() - door_pic.getIconWidth() - 100, yPosBackground + background.getIconHeight() - door_pic.getIconWidth() - 100, null);
	}
	//Draws player
	public void drawPlayer(Graphics2D g2)
	{
		g2.drawImage(get_image().getImage(), xPosPlayer, yPosPlayer, null);
	}
	
	//Moves the character
	public void move()
	{
		//Sees if up is true
		if (up)
		{
			//Sets direction to up if player isn't also holding down
			if (down == false)
			{
				dir = UP;
			}

			//Increases the y position of the background by the speed. This makes it seem like the player is moving up when in reality the background is moving down
			yPosBackground += speed;

			//If the y position of the background is less than 0, move the player up instead of the background down
			if (yPosBackground > 0)
			{
				yPosBackground = 0;
				yPosPlayer -= speed;
			}
			//Sets the y position of the player to 0 if they are out of the frame
			if (yPosPlayer < 0)
			{
				yPosPlayer = 0;
			}
			//If the player is below the middle of the screen, the player is moved up instead of the screen moving down
			if (yPosPlayer > panelHeight / 2 - get_image().getIconHeight() / 2)
			{
				yPosBackground -= speed;
				yPosPlayer -= speed;
			}
		}
		//Sees if down is true
		if (down)
		{
			//Sets direction to down if player isn't also holding up
			if (up == false)
			{
				dir = DOWN;
			}

			//Decreases the y position of the background by the speed. This makes it seem like the player is moving down when in reality the background is moving up
			yPosBackground -= speed;

			//If the y position of the background is more than the frame height, move the player down instead of the background up
			if (yPosBackground < -background.getIconHeight() + panelHeight)
			{
				yPosBackground = -background.getIconHeight() + panelHeight;
				yPosPlayer += speed;
			}
			//Sets the y position of the player to the panel height minus the image if they are out of the frame
			if (yPosPlayer + get_image().getIconHeight() > panelHeight)
			{
				yPosPlayer = panelHeight - get_image().getIconHeight();
			}
			//If the player is above the middle of the screen, the player is moved down instead of the screen moving up
			if (yPosPlayer < panelHeight / 2 - get_image().getIconHeight() / 2)
			{
				yPosBackground += speed;
				yPosPlayer += speed;
			}
		}
		//Sees if left is true
		if (left)
		{
			//Sets direction to left if player isn't also holding right
			if (right == false)
			{
				dir = LEFT;
			}

			//Increases the x position of the background by the speed. This makes it seem like the left is moving down when in reality the background is moving right
			xPosBackground += speed;

			if (xPosBackground > 0)
			{
				xPosBackground = 0;
				xPosPlayer -= speed;
			}
			if (xPosPlayer < 0)
			{
				xPosPlayer = 0;
			}
			if (xPosPlayer > panelWidth / 2 - get_image().getIconWidth() / 2)
			{
				xPosBackground -= speed;
				xPosPlayer -= speed;
			}
		}
		if (right)
		{
			if (left == false)
			{
				dir = RIGHT;
			}

			xPosBackground -= speed;

			if (xPosBackground < -background.getIconWidth() + panelWidth)
			{
				xPosBackground = -background.getIconWidth() + panelWidth;
				xPosPlayer += speed;
			}
			if (xPosPlayer + get_image().getIconWidth() > panelWidth)
			{
				xPosPlayer = panelWidth - get_image().getIconWidth();
			}

			if (xPosPlayer < panelWidth / 2 - get_image().getIconWidth() / 2)
			{
				xPosBackground += speed;
				xPosPlayer += speed;
			}
		}
		
		xPosVisionSmall = xPosPlayer + get_image().getIconWidth() / 2 - blackScreenSmall.getIconWidth() / 2;
		yPosVisionSmall = yPosPlayer + get_image().getIconHeight() / 2 - blackScreenSmall.getIconHeight() / 2;
		xPosVision = xPosPlayer + get_image().getIconWidth() / 2 - blackScreen.getIconWidth() / 2;
		yPosVision = yPosPlayer + get_image().getIconHeight() / 2 - blackScreen.getIconHeight() / 2;
	}

	//Returns task 0 hitbox
	public Rectangle2D task_0_hitbox()
	{
		task_0 = new Rectangle2D.Double(xPosBackground + x_pos_task_0, yPosBackground + y_pos_task_0, book_shelf.getIconWidth(), book_shelf.getIconHeight());

		return task_0;
	}
	//Returns selected task 1 hitbox
	public Rectangle2D task_1_hitbox(int i)
	{
		task_1[i] = new Rectangle2D.Double(xPosBackground + x_pos_task_1[i], yPosBackground + y_pos_task_1[i], drawer_pic.getIconWidth(), drawer_pic.getIconHeight());

		return task_1[i];
	}
	//Returns task 2 hitbox
	public Rectangle2D task_2_hitbox()
	{
		task_2 = new Rectangle2D.Double(xPosBackground + x_pos_task_2, yPosBackground + y_pos_task_2, computer_desk.getIconWidth(), computer_desk.getIconHeight());

		return task_2;
	}
	//Returns task 3 hitbox
	public Rectangle2D task_3_hitbox()
	{
		task_3 = new Rectangle2D.Double(xPosBackground + x_pos_task_3, yPosBackground + y_pos_task_3, cage.getIconWidth(), cage.getIconHeight());

		return task_3;
	}
	//Returns task 4 hitbox
	public Rectangle2D task_4_hitbox()
	{
		task_4 = new Rectangle2D.Double(xPosBackground + x_pos_task_4, yPosBackground + y_pos_task_4, box_tv.getIconWidth(), box_tv.getIconHeight());

		return task_4;
	}
	//Returns task 5 hitbox
	public Rectangle2D task_5_hitbox()
	{
		task_5 = (new Rectangle2D.Double(xPosBackground + x_pos_task_5, yPosBackground + y_pos_task_5, nintendo_table.getIconWidth(), nintendo_table.getIconHeight()));
		
		return task_5;
	}
	//Returns door hitbox
	public Rectangle2D door_hitbox()
	{
		door = new Rectangle2D.Double(xPosBackground + background.getIconWidth() - door_pic.getIconWidth() - 100, yPosBackground + background.getIconHeight() - door_pic.getIconHeight() - 100, door_pic.getIconWidth(), door_pic.getIconHeight());

		return door;
	}
	//Returns player hitbox
	public Rectangle2D player_hitbox()
	{
		player = new Rectangle.Double(xPosPlayer, yPosPlayer, get_image().getIconWidth(), get_image().getIconHeight());

		return player;
	}

	//Constantly changes what picture is being played when moving
	public void animation()
	{
		animation++;

		if (animation > 3)
		{
			animation = 0;
		}		
	}

	//Sets up to the boolean given
	public void setUp(boolean bool)
	{
		up = bool;
	}
	//Sets down to the boolean given
	public void setDown(boolean bool)
	{
		down = bool;
	}
	//Sets left to the boolean given
	public void setLeft(boolean bool)
	{
		left = bool;
	}
	//Sets right to the boolean given
	public void setRight(boolean bool)
	{
		right = bool;
	}

	//Gets the corresponding image based on what direction the player is facing in
	public ImageIcon get_image()
	{
		ImageIcon picture = null;

		if (dir == LEFT)
		{
			//Gives a still image if player is not moving. If the player is moving, gives the correct picture
			if (left == false || right)
			{
				picture = playerLeft[1];
			}
			else
			{
				picture = playerLeft[animation];
			}
		}
		else if (dir == RIGHT)
		{
			//Gives a still image if player is not moving. If the player is moving, gives the correct picture
			if (right == false || left)
			{
				picture = playerRight[1];
			}
			else
			{
				picture = playerRight[animation];
			}
		}
		else if (dir == UP)
		{
			//Gives a still image if player is not moving. If the player is moving, gives the correct picture
			if (up == false || down)
			{
				picture = playerUp[1];
			}
			else
			{
				picture = playerUp[animation];
			}
		}
		else if (dir == DOWN)
		{
			//Gives a still image if player is not moving. If the player is moving, gives the correct picture
			if (down == false || up)
			{
				picture = playerDown[1];
			}
			else
			{
				picture = playerDown[animation];
			}
		}

		//Returns the picture
		return picture;
	}
	
	//Gets background x
	public int getBackgroundX()
	{
		return xPosBackground;
	}	
	//Gets background y
	public int getBackgroundY()
	{
		return yPosBackground;
	}
	//Gets background width
	public int getBackgroundWidth()
	{
		return background.getIconWidth();
	}
	//Gets background height
	public int getBackgroundHeight()
	{
		return background.getIconHeight();
	}
	//Gets player x
	public int getPlayerX()
	{
		return xPosPlayer;
	}
	//Gets player y
	public int getPlayerY()
	{
		return yPosPlayer;
	}
}