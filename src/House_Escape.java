 * PROGRAM DESCRIPTION:
 * This is a puzzle-like escape room. When the program starts, the player will be presented with a title screen with background music playing. After pressing space, instructions will be shown to the player.
 * The player will need to use the WASD keys to move around the room. The player will then need to use space and escape to enter and exit tasks. The player will need to use their mouse and keyboard in various ways in the tasks to complete them.
 * Completing each task will give the player a digit or a hint for a future task or code. Completing all the tasks in the room will give the player the digits and the order of a code that they will then need to input into the door in the bottom right corner.
 * If they do this correctly, they will be able to move to the next room where there is one more task than before. After the player opens 3 doors, they win the game and are presented with a win screen like the title screen and background music playing again.
 * There will also be an enemy that will be following the player. If the enemy touches the player, the player loses a life and is presented with a death screen.
 * Pressing space in this death screen will reload the current level with a newly generated code with new task placements. If the player runs out of lives, they will be forced to exit the game meaning they have to restart from the first level.
 * The player will be safe for the first 10 seconds after they restart a level or enter a new one. After which, the enemy will slowly approach the player. After each 10 seconds, the enemy randomly teleports across the room, but he can’t teleport too close to the player.
 * If the enemy is close to the player, a ghost sound effect will be played indicating that he’s nearby. When the player enters the first level, the intro music stops playing and ambient music will start. The player can also hear footsteps if they move around the room.
 * The first room has one book task, 3 drawer tasks, one computer task, one cage task, and  one door task. The book task requires the user to use the a and d keys to flip through the pages of a book. Eventually, the player will find a set of shapes in descending order.
 * This order will tell the player which digits come in which order. The drawer tasks require the player to click the handle of the drawer. If they do, the drawer will be permanently open. One of the 3 drawers will have a paper with a shape and one of the digits.
 * Another drawer will have a paper with the password for the computer task. The 3rd drawer will have nothing in it. The computer task will require the user to input a password into a JOptionPane.
 * This password can be found in one of the drawers. If the user enters the right password, a JOptionPane of a shape and digit will be shown. In the cage task, the player will need to drag a key over to a lock on a cage.
 * Only then can they access the paper locked inside the cage which has another shape and digit. The door task will require the player to enter a digit code in a JOptionPane. If the player inputs the wrong code, nothing happens.
 * If the player inputs the right code, a JOptionPane will tell the player they opened the door. After, a new level loads with a new task, map, task placement, and code. Each task in the previous level will carry over into the next level with a different code each time.
 * The 2nd level will introduce a duck hunt task. In it, the player will be told to press space. After, instructions will be told to the player. The player will need to click on birds that randomly appear on the tv screen before they disappear. If they click the bird in time, their score goes up by 1.
 * A digit with a shape is shown to the player after the player reaches a score of 10. The 3rd level will introduce an obstacle dodge task. In it, the player will need to press space to show instructions. The player will then need to use w to jump and s to crouch over obstacles.
 * Not getting hit by the obstacle increases the player’s score by 1.
 * Reaching a score of 10 will give the player another digit and shape. After the player finishes the 3rd level, a win screen is shown to the player.
 * 
 * PROGRAM DETAILS;
 * Examples of user input are in line 28 of the door class or line 47 of the task 2 class.
 * Line 28 of the door class receives in string input from the user. If that string input is equal to the key, the player advances a level.
 * Line 47 of the task 2 class receives a string input from the user. If that input is equal to the computer password, a shape and digit is shown to the user.
 * 
 * Examples of if statements are in line 86 of the cutscene task or in line 239 of the main class.
 * In line 77 of the cutscene task, Instructions, a white box with a black border, and a countdown timer will be shown if the number on the countdown is more than 3.
 * Line 239 of the main class sees if a win variable is true. If it is, a win screen is painted.
 * 
 * Random numbers are used in line 126 of the task 4 class and line 945 of the main class.
 * Line 126 of the task 4 class generates a random x position for the bird to be shown at.
 * Line 945 of the main class will generate a certain amount of random digit for the door code.
 * 
 * An example of a for loop is in line 32 of the task 1 class.
 * In it, the loop will run for the amount of handles there are. Each time the loop is run, a handle hitbox is made.
 * An example of a while loop is in line 123 of the background class.
 * In it, the while loop will continue until each task’s hitbox isn’t colliding with each other.
 * 
 * An example of a string class method is in line 50 of the task 2 class.
 * In it, the method checks if the user input is equal to the set password.
 * An example of a try catch statement is in line 130 of the main class. 
 * In it, music files are being made into objects. If there’s an error, an error message is shown.
 * 
 * One example of an array is in line 80 of the background class.
 * In it, an array of images is being made so an integer variable can easily access them.
 * Another example is in line 34 of task 1 class.
 * In it, an array of rectangle2d objects are being made. These objects are then used to see if the player clicks on them.
 * 
 * An example of a self made method is in line 953 of the main class.
 * This method changes the level of the game. If the lives is 0, the game ends. If the player has not been caught, the level increases.
 * If the level is 4 or more, a win variable is set to true, the player stops, all unnecessary timers stop, and the method ends. If not, the code is changed and all the constructors are reinitialized.
 * 
 * An example of a JOptionPane class is in line 57 of the task 2 class.
 * In it, a JOptionPane tells the user that they inputted the wrong password.
 * 
 * An example of animation in a JFrame is in line 252 of the background class.
 * In it, the y position of a background picture is being moved when an up variable is true. This variable is set when the w key is pressed.
 * An example of collision detection is in line 296 of the main class. In it, the player is caught, their movement is stopped, their lives are decreased by 1, and all unnecessary timers are stopped.
 */

//Imports packages
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.File;

import javax.sound.sampled.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class House_Escape extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener{

	//Creates variables
	public Cutscene Cutscene;
	public Background Background;
	public Task_0 Task_0;
	public Task_1 Task_1;
	public Task_2 Task_2;
	public Task_3 Task_3;
	public Task_4 Task_4;
	public Task_5 Task_5;
	public Door Door;
	public Enemy Enemy;
	public static Timer update, intro_timer, enemy_spawn, second_timer, second_timer_2, timer, move_animation, flip_timer, shot_timer, task_5_timer, poof;
	public Clip intro_music, bg_music, ghost_sounds, footsteps, scare;
	public Font f, font_big;
	public FontMetrics fm, fmb;
	public final int DOWN = 0, RIGHT = 1, UP = 2, LEFT = 3;
	public int count, key, password_num, clues, level, lives;
	public int [] clue, task, place;
	public int x_pos_player, y_pos_player, x_pos_enemy, y_pos_enemy;
	public double distance;
	public String hold;
	public String [] shape, password;
	public Rectangle2D player, task_0, task_2, task_3, task_4, task_5, door, enemy;
	public Rectangle2D [] task_1;
	public Ellipse2D player_radius;
	public boolean game_start, intro, stop, up, down, left, right, interact, caught, task_0_interact, task_2_interact, task_3_interact, task_4_interact, task_5_interact, win, poofBool;
	public boolean [] task_1_interact;

	//Initializes variables
	House_Escape()
	{
		setLayout(null);
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		setFocusable(true);
		requestFocus();

		//Creates timers
		update = new Timer(2, this);
		intro_timer = new Timer(1000, this);
		enemy_spawn = new Timer(10000, this);
		second_timer = new Timer(1000, this);
		second_timer_2 = new Timer(1000, this);
		timer = new Timer(16, this);
		move_animation = new Timer(250, this);
		flip_timer = new Timer(1000, this);
		shot_timer = new Timer(250, this);
		task_5_timer = new Timer(16, this);
		poof = new Timer(700, this);

		//Creates sound objects
		try
		{
			File soundFile1 = new File("intro_music.midi");
			AudioInputStream audioIn1 = AudioSystem.getAudioInputStream(soundFile1);
			intro_music = AudioSystem.getClip();
			intro_music.open(audioIn1);

			File soundFile2 = new File("horror.mid");
			AudioInputStream audioIn2 = AudioSystem.getAudioInputStream(soundFile2);
			bg_music = AudioSystem.getClip();
			bg_music.open(audioIn2);

			File soundFile3 = new File("footsteps.wav");
			AudioInputStream audioIn3 = AudioSystem.getAudioInputStream(soundFile3);
			footsteps = AudioSystem.getClip();
			footsteps.open(audioIn3);

			File soundFile4 = new File("ghost_sound.wav");
			AudioInputStream audioIn4 = AudioSystem.getAudioInputStream(soundFile4);
			ghost_sounds = AudioSystem.getClip();
			ghost_sounds.open(audioIn4);
		}
		catch(Exception e)
		{
			System.out.println("ERROR -- MUSIC");
		}

		//Creates fonts
		try 
		{
			f = Font.createFont(Font.TRUETYPE_FONT, new File
					("emulogic.ttf")).deriveFont(15f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File
					("emulogic.ttf")));

			fm = getFontMetrics(f);

			font_big = Font.createFont(Font.TRUETYPE_FONT, new File
					("emulogic.ttf")).deriveFont(30f);
			GraphicsEnvironment ge1 = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge1.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File
					("emulogic.ttf")));

			fmb = getFontMetrics(font_big);
		} 
		catch (Exception e) {}

		//Sets variables
		count = 40;
		lives = 4;
		distance = 1000;

		password = new String [] {"FOSTER", "POISON", "VESSEL", "PARADE", "EXCUSE", "PEPPER"};

		task_1 = new Rectangle2D.Double [3];
		task_1_interact = new boolean [3];

		level = 0;

		//Runs level change method
		level_change();

		//Creates all hitboxes
		for (int i = 0; i < task_1.length; i++)
		{
			task_1[i] = Background.task_1_hitbox(i);
		}
		task_0 = Background.task_0_hitbox();
		task_2 = Background.task_2_hitbox();
		task_3 = Background.task_3_hitbox();
		if (level >= 2)
		{
			task_4 = Background.task_4_hitbox();
		}
		if (level >= 3)
		{
			task_5 = Background.task_5_hitbox();
		}
		door = Background.door_hitbox();
		player = Background.player_hitbox();
		enemy = new Rectangle2D.Double(Background.getBackgroundX() + x_pos_enemy, Background.getBackgroundY() + y_pos_enemy, 50, 50);		

		//Sets stop to true
		stop = true;

		//Creates JPanel
		JFrame frame = new JFrame();

		frame.setContentPane(this);
		frame.setIconImage(Enemy.get_image().getImage());
		frame.setSize(1000, 700);
		frame.setTitle("House Escape");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		//Starts update timer
		update.start();
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;

		g2.setFont(f);

		//Draws win screen
		if (win)
		{
			Cutscene.draw_win(g2, f, fm, font_big, fmb);
		}
		else if (game_start == false)
		{
			//Starts intro music
			intro_music.start();
			intro_music.loop(Clip.LOOP_CONTINUOUSLY);

			//Draws title screen
			Cutscene.draw_intro(g2, f, fm, font_big, fmb);
		}
		else if (intro == true)
		{
			//Draws instructions
			Cutscene.draw_instructions(g2, f, fm, font_big, fmb);
		}
		else if (caught)
		{
			//Draws death screen
			Cutscene.draw_death(g2, f, fm, font_big, fmb, lives);
		}
		else
		{
			//Starts in game music
			bg_music.start();
			bg_music.loop(Clip.LOOP_CONTINUOUSLY);

			//Draws background, tasks, and enemies
			Background.drawBackground(g2);
			Background.drawTasks(g2);
			Enemy.draw(g2, Background.getBackgroundX(), Background.getBackgroundY(), Background.getBackgroundWidth(), Background.getBackgroundHeight(), Background.getPlayerX(), Background.getPlayerY());

			//Draws poof when enemy teleports
			if (poofBool)
			{
				Enemy.drawPoof(Background.getBackgroundX(), Background.getBackgroundY(), g2);
			}

			//Draws vision, player, and lives
			Background.drawVision(g2);
			Background.drawPlayer(g2);
			Cutscene.draw_lives(g2, f, fm, font_big, fmb, lives);

			//Draws the specific task based on which one is open
			if (task_0_interact)
			{
				Task_0.draw(g2, fm);
			}
			else if (task_1_interact[0])
			{
				Task_1.draw_drawer_1(g2);
			}
			else if (task_1_interact[1])
			{
				Task_1.draw_drawer_2(g2);
			}
			else if (task_1_interact[2])
			{
				Task_1.draw_drawer_3(g2);
			}
			else if (task_2_interact)
			{
				Task_2.draw(g2);
			}
			else if (task_3_interact)
			{
				Task_3.draw(g2);
			}
			else if (task_4_interact)
			{
				Task_4.draw(g2, fm);
			}
			else if (task_5_interact)
			{
				Task_5.draw(g2, fm);
			}
		}
	}

	public static void main(String[] args) {

		//Runs constructor
		new House_Escape();

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		//Timer only works if game has started
		if (game_start)
		{
			if (e.getSource() == timer)
			{
				//Only moves player and enemy if stop is false
				if (stop == false)
				{
					Background.move();
					player = Background.player_hitbox();

					Enemy.move(Background.getBackgroundX(), Background.getBackgroundY(), Background.getPlayerX(), Background.getPlayerY());
					enemy = Enemy.enemy_hitbox(Background.getBackgroundX(), Background.getBackgroundY(), Background.getBackgroundWidth(), Background.getBackgroundHeight());
				}

				//Creates radius around player
				player_radius = new Ellipse2D.Double(Background.getPlayerX() - 400, Background.getPlayerY() - 400, 800, 800);

				//Plays ghost sound if the enemy is close enough to the player and the player isn't caught or hasn't won yet
				if (player_radius.intersects(enemy) && caught == false && win == false)
				{
					ghost_sounds.start();
					ghost_sounds.loop(Clip.LOOP_CONTINUOUSLY);
				}
				else
				{
					ghost_sounds.stop();
				}

				//Stops all timers, subtracts a life, and sets caught to true if the player and the enemy tough
				if (enemy.intersects(player))
				{
					caught = true;

					stop();

					lives--;

					ghost_sounds.stop();

					enemy_spawn.stop();
					second_timer.stop();
					second_timer_2.stop();
					timer.stop();
					move_animation.stop();
					flip_timer.stop();
					shot_timer.stop();
					task_5_timer.stop();
				}

				//Plays footsteps if the player is moving
				if (up && down == false || down && up == false || left && right == false || right && left == false)
				{
					footsteps.start();
					footsteps.loop(Clip.LOOP_CONTINUOUSLY);
				}
				else
				{
					footsteps.stop();
				}

				//Creates all the necessary hitboxes
				task_0 = Background.task_0_hitbox();
				task_2 = Background.task_2_hitbox();
				task_3 = Background.task_3_hitbox();
				if (level >= 2)
				{
					task_4 = Background.task_4_hitbox();
				}
				if (level >= 3)
				{
					task_5 = Background.task_5_hitbox();
				}

				door = Background.door_hitbox();

				Task_3.key_hitbox();

				for (int i = 0; i < task_1.length; i++)
				{
					task_1[i] = Background.task_1_hitbox(i); 
				}

				//Sees if the player is interacting with a task. If they are, stop the player and the enemy and see which task they are interacting with. Set that tasks interact boolean to true
				if (interact)
				{
					if (player.intersects(task_0))
					{
						stop();
						stop = true;

						task_0_interact = true;

						enemy_spawn.stop();
					}
					else if (player.intersects(task_1[0]))
					{
						stop();
						stop = true;

						task_1_interact[0] = true;

						enemy_spawn.stop();
					}
					else if (player.intersects(task_1[1]))
					{
						stop();
						stop = true;

						task_1_interact[1] = true;

						enemy_spawn.stop();
					}
					else if (player.intersects(task_1[2]))
					{
						stop();
						stop = true;

						task_1_interact[2] = true;

						enemy_spawn.stop();
					}
					else if (player.intersects(task_2))
					{
						stop();
						stop = true;

						task_2_interact = true;

						enemy_spawn.stop();

						Task_2.task_interact();

						//Kicks player out of task interact JOptionPane and lets them and the enemy move again
						task_2_interact = false;

						enemy_spawn.start();

						stop = false;

					}
					else if (player.intersects(task_3))
					{
						stop();
						stop = true;

						task_3_interact = true;

						enemy_spawn.stop();
					}
					else if (level >= 2 && player.intersects(task_4))
					{
						stop();
						stop = true;

						task_4_interact = true;

						enemy_spawn.stop();
					}
					else if (level >= 3 && player.intersects(task_5))
					{
						stop();
						stop = true;

						task_5_interact = true;

						enemy_spawn.stop();
					}
					else if (player.intersects(door) && win == false)
					{
						stop();

						//IIf the player guesses the right code for the door, restart the enemy timer and change the level
						if (Door.interact())
						{
							enemy_spawn.restart();
							level_change();
						}
					}
				}

				//Sets interact to false so the user can't hold the interact key
				interact = false;
			}

			if (e.getSource() == intro_timer)
			{
				//Countsdown in the cutscene class
				count = Cutscene.countdown();

				//Starts game when the intro is finished
				if (count == 0)
				{
					intro = false;
					stop = false;
					intro_timer.stop();
					intro_music.stop();
					timer.start();
					move_animation.start();
					enemy_spawn.start();
				}
			}

			//Randomizes the enemy location and redraws and starts poof animation
			if (e.getSource() == enemy_spawn)
			{
				player_radius = new Ellipse2D.Double(Background.getPlayerX() - 150, Background.getPlayerY() - 150, 300, 300);
				poofBool = true;
				poof.start();
				Enemy.setPoof();
				Enemy.enemy_randomize(Background.getBackgroundX(), Background.getBackgroundY(), Background.getBackgroundWidth(), Background.getBackgroundHeight(), player_radius);
				poofBool = true;
				poof.start();
			}

			//Stops the poof animation from playing when the timer runs out
			if (e.getSource() == poof)
			{
				poof.stop();
				poofBool = false;
			}

			//Keeps a constant look going for the enemy and background classes so the walking and hovering pictures for the player and enemy constantly changes
			if (e.getSource() == move_animation)
			{
				Background.animation();
				Enemy.animation();
			}

			//Stops task 0 from showing a flipping book
			if (e.getSource() == flip_timer)
			{
				Task_0.flip_stop();
			}

			//Countsdown for task 4
			if (e.getSource() == second_timer)
			{
				Task_4.count();
			}

			//Randomizes bird location for task 4
			if (e.getSource() == shot_timer)
			{
				Task_4.bird_randomize();
			}

			//Countsdown for task 5
			if (e.getSource() == second_timer_2)
			{
				Task_5.count();
			}

			//Starts move timer for task 5
			if (e.getSource() == task_5_timer)
			{
				Task_5.task_timer();
			}
		}

		//Repaints
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e)
	{		
		//Sees if game has started when space is pressed
		if (game_start == false)
		{
			//Starts the game when space is pressed
			if (e.getKeyCode() == KeyEvent.VK_SPACE)
			{
				game_start = true;
				intro = true;
				intro_timer.start();
			}
		}
		else
		{
			//Sees if the player can move
			if (stop == false)
			{
				//Moves the player in the direction they pressed
				if (e.getKeyCode() == KeyEvent.VK_W)
				{
					Background.setUp(true);
					up = true;
				}
				if (e.getKeyCode() == KeyEvent.VK_S)
				{
					Background.setDown(true);
					down = true;
				}
				if (e.getKeyCode() == KeyEvent.VK_A)
				{
					Background.setLeft(true);
					left = true;
				}
				if (e.getKeyCode() == KeyEvent.VK_D)
				{
					Background.setRight(true);
					right = true;
				}
			}

			//Sees if the player has been caught
			if (caught == true)
			{
				//Resets the level when the player presses space
				if (e.getKeyCode() == KeyEvent.VK_SPACE)
				{
					stop = false;
					level_change();

					enemy_spawn.start();
					timer.start();
					move_animation.start();
				}
			}

			//Player interacts with an object when they press space
			if (e.getKeyCode() == KeyEvent.VK_SPACE)
			{
				if (interact == false)
				{
					interact = true;
				}
			}

			//Player exits out of all tasks if they presses escape
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
			{
				if (task_0_interact)
				{
					task_0_interact = false;
					stop = false;
				}
				if (task_1_interact[0])
				{
					task_1_interact[0] = false;
					stop = false;
				}
				if (task_1_interact[1])
				{
					task_1_interact[1] = false;
					stop = false;
				}
				if (task_1_interact[2])
				{
					task_1_interact[2] = false;
					stop = false;
				}
				if (task_2_interact)
				{
					task_2_interact = false;
					stop = false;
				}
				if (task_3_interact)
				{
					task_3_interact = false;
					stop = false;
				}
				if (task_4_interact)
				{
					task_4_interact = false;
					stop = false;
				}
				if (task_5_interact)
				{
					task_5_interact = false;
					stop = false;
				}
				//Restarts enemy spawn timer
				if (enemy_spawn.isRunning() == false)
				{
					enemy_spawn.start();
				}
			}

			//Runs page flip if task 0 is being interacted with
			if (task_0_interact)
			{
				Task_0.flip_page(e);
			}
			//Runs tsak 5 game utility if task 5 is being interacted with
			else if (task_5_interact)
			{
				Task_5.key_pressed(e);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		//Stops character if they release the key they were moving in
		if (e.getKeyCode() == KeyEvent.VK_W)
		{
			Background.setUp(false);
			up = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_S)
		{
			Background.setDown(false);
			down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_A)
		{
			Background.setLeft(false);
			left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_D)
		{
			Background.setRight(false);
			right = false;
		}
		//Stops the player from interacting when they release space
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			interact = false;
		}

		//Runs task 5 utility if task 5 is being interacted with
		if (task_5_interact)
		{
			Task_5.key_released(e);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e)
	{
		//Gets mouse x and y position
		int x = e.getX();
		int y = e.getY();

		//Passes in the positions of the mouse and runs the corresponding task utility
		if (task_1_interact[0])
		{
			Task_1.drawer_1(x, y);
		}
		else if (task_1_interact[1])
		{
			Task_1.drawer_2(x, y);
		}
		else if (task_1_interact[2])
		{
			Task_1.drawer_3(x, y);
		}
		else if (task_3_interact)
		{
			Task_3.mouse_pressed(x, y);
		}
		else if (task_4_interact)
		{
			Task_4.mouse_pressed(x, y);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		//Gets mouse x and y position
		int x = e.getX();
		int y = e.getY();

		//Runs task 3 utility if task 3 is being interacted with. Also sends over mouse position
		if (task_3_interact)
		{
			Task_3.mouse_dragged(x, y);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {}

	//Stops all player movement
	public void stop()
	{
		Background.setUp(false);
		Background.setDown(false);
		Background.setLeft(false);
		Background.setRight(false);
		up = false;
		down = false;
		left = false;
		right = false;
	}

	public void code_change()
	{
		//Initializes variables
		clues = level + 2;

		clue = new int [clues];
		task = new int [clues];
		place = new int [clues];
		shape = new String [clues];

		for (int i = 0; i < clues; i++)
		{
			task[i] = -1;
			place[i] = 0;
		}

		//Creates shape order for door code
		//Randomizes a number between 1 and the amount of clues. If that number isn't one of the numbers before, it gets accepted. If there's a duplicate, the loop repeats
		for (int i = 0; i < clues; i++)
		{
			int num = (int)(Math.random() * clues + 1);

			for (int j = 0; j < clues; j++)
			{
				if (num == place[j])
				{
					num = 0;

					break;
				}
			}

			place[i] = num;

			if (num == 0)
			{
				i--;
			}			
		}

		//Converts each place number into a shape string
		for (int i = 0; i < clues; i++)
		{
			if (place[i] == 1)
			{
				shape[i] = "Circle";
			}
			else if (place[i] == 2)
			{
				shape[i] = "Cross";
			}
			else if (place[i] == 3)
			{
				shape[i] = "Triangle";
			}
			else if (place[i] == 4)
			{
				shape[i] = "Square";
			}
			else if (place[i] == 5)
			{
				shape[i] = "Pentagon";
			}
			else if (place[i] == 6)
			{
				shape[i] = "Hexagon";
			}
			else if (place[i] == 7)
			{
				shape[i] = "Heptagon";
			}
			else if (place[i] == 8)
			{
				shape[i] = "Octagon";
			}
		}

		//Generates random numbers for each digit of the code
		for (int i = 0; i < clues; i++)
		{
			clue[i] = (int)(Math.random() * 10);
		}

		//Asigns digits for each task. If digits overlap, the loop repeats
		for (int i = 0; i < clues; i++)
		{
			int num = (int)(Math.random() * clues);

			for (int j = 0; j < clues; j++)
			{
				if (num == task[j])
				{
					num = -1;
					break;
				}
			}

			task[i] = num;

			if (num == -1)
			{
				i--;
			}
		}

		//Generates a single key int for the door
		key = 0;

		for (int i = 0; i < clues; i++)
		{
			key += clue[i] * Math.pow(10, clues - 1 - i);
		}

		//Generates a random index for the password array
		password_num = (int)(Math.random() * 6);
	}

	public void level_change()
	{
		//Closes game if lives is 0
		if (lives <= 0)
		{
			System.exit(0);
		}		
		//Advances level if player is not caught
		if (caught == false)
		{
			level++;
		}
		else
		{
			caught = false;
		}

		//Sets win to true if level is more than 3
		if (level >= 4)
		{
			win = true;
			stop = true;

			//Stops all sounds and timers and starts intro music
			footsteps.stop();
			ghost_sounds.stop();
			bg_music.stop();
			intro_music.start();

			intro_timer.stop();
			enemy_spawn.stop();
			second_timer.stop();
			second_timer_2.stop();
			move_animation.stop();
			flip_timer.stop();
			shot_timer.stop();
			task_5_timer.stop();

			//Ends method
			return;
		}

		//Runs code change method
		code_change();

		//Reinitializes all constructors
		Cutscene = new Cutscene(1000 - 12, 700 - 35);
		Background = new Background(1000, 700, level);
		Task_0 = new Task_0(1000, 700 , shape);
		Task_1 = new Task_1(1000 - 12, 700 - 35, shape[task[0]], clue[task[0]], password, password_num);
		Task_2 = new Task_2(1000, 700, shape[task[1]], clue[task[1]], password, password_num);
		Task_3 = new Task_3(1000, 700, shape[task[2]], clue[task[2]]);
		if (level >= 2)
		{
			Task_4 = new Task_4(1000, 700, shape[task[3]], clue[task[3]]);
		}
		if (level >= 3)
		{
			Task_5 = new Task_5(1000, 700, shape[task[4]], clue[task[4]]);
		}
		Door = new Door(clues, key);
		Enemy = new Enemy(level, Background.getBackgroundX(), Background.getBackgroundY());
	}
}
