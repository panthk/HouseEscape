//Imports variables
import java.awt.*;
import java.awt.geom.*;

import javax.swing.ImageIcon;

public class Cutscene {
	
	//Creates variables
	private ImageIcon image_pre, house, WASD, space, escape, mouse, keyboard, enemy_pic, door_pic, heart, death;
	private Image image_img;
	private int frame_width, frame_height, count;
	
	//Constructor that brings in frame width and height
	Cutscene(int Frame_width, int Frame_height)
	{
		//Initializes variables
		frame_width = Frame_width;
		frame_height = Frame_height;
		
		image_pre = new ImageIcon("house.png");
		image_img = image_pre.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
		house = new ImageIcon(image_img);
		
		WASD = new ImageIcon("WASD.png");
		space = new ImageIcon("space_bar.png");
		escape = new ImageIcon("escape.png");
		mouse = new ImageIcon("mouse.png");
		keyboard = new ImageIcon("keyboard.png");
		
		image_pre = new ImageIcon("enemy/right/1.png");
		image_img = image_pre.getImage().getScaledInstance(image_pre.getIconWidth() * 3, image_pre.getIconHeight() * 3, Image.SCALE_DEFAULT);
		enemy_pic = new ImageIcon(image_img);

		image_pre = new ImageIcon("door.png");
		image_img = image_pre.getImage().getScaledInstance(112, 150, Image.SCALE_DEFAULT);
		door_pic = new ImageIcon(image_img);
		
		heart = new ImageIcon("heart.png");
		
		image_pre = new ImageIcon("death screen.jpg");
		image_img = image_pre.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
		death = new ImageIcon(image_img);
		
		count = 40;
	}
	  
	//Draws intro. Brings in graphics2d object, 2 font object, and 2fontmetrics obejcts 
	public void draw_intro(Graphics2D g2, Font f, FontMetrics fm, Font font_big, FontMetrics fmb)
	{
		//Draws house image, title header, and instruction box
		g2.setFont(font_big);

		g2.drawImage(house.getImage(), 0, 0, null);

		g2.setStroke(new BasicStroke(7));
		g2.setColor(Color.black);
		g2.draw(new Rectangle2D.Double(frame_width / 2 - fmb.stringWidth("HOUSE ESCAPE") / 2 - 50, 50, fmb.stringWidth("HOUSE ESCAPE") + 100, fmb.getAscent() + 10));

		g2.setColor(Color.white);
		g2.fill(new Rectangle2D.Double(frame_width / 2 - fmb.stringWidth("HOUSE ESCAPE") / 2 - 50, 50, fmb.stringWidth("HOUSE ESCAPE") + 100, fmb.getAscent() + 10));

		g2.setColor(Color.black);
		g2.drawString("HOUSE ESCAPE", frame_width / 2 - fmb.stringWidth("HOUSE ESCAPE") / 2, fmb.getAscent() + 50);

		g2.setFont(f);

		g2.setColor(Color.black);
		g2.draw(new Rectangle2D.Double(frame_width / 2 - fm.stringWidth("PRESS SPACE TO START") / 2 - 50, frame_height - 100, fm.stringWidth("PRESS SPACE TO START") + 100, fm.getAscent() + 10));

		g2.setColor(Color.white);
		g2.fill(new Rectangle2D.Double(frame_width / 2 - fm.stringWidth("PRESS SPACE TO START") / 2 - 50, frame_height - 100, fm.stringWidth("PRESS SPACE TO START") + 100, fm.getAscent() + 10));

		g2.setColor(Color.black);
		g2.drawString("PRESS SPACE TO START", frame_width / 2 - fm.stringWidth("PRESS SPACE TO START") / 2, frame_height - 100 + fm.getAscent() + 2);
	}
	
	//Draws instructions. Brings in graphics2d object, 2 font object, and 2fontmetrics obejcts
	public void draw_instructions(Graphics2D g2, Font f, FontMetrics fm, Font font_big, FontMetrics fmb)
	{
		//Draws background
		g2.setColor(new Color(47,79,79));
		g2.fill(new Rectangle2D.Double(0, 0, frame_width + 100, frame_height + 100));

		//Draws instructions header, instructions background, and countdown timer if countdown timer is more than 3
		if (count > 3)
		{
			g2.setStroke(new BasicStroke(7));
			g2.setFont(font_big);
			g2.setColor(Color.black);
			g2.draw(new Rectangle2D.Double(frame_width / 2 - fmb.stringWidth("INSTRUCTIONS") / 2 - 25, 50, fmb.stringWidth("INSTRUCTIONS") + 52, fmb.getAscent() + 10));
			g2.setColor(Color.white);
			g2.fill(new Rectangle2D.Double(frame_width / 2 - fmb.stringWidth("INSTRUCTIONS") / 2 - 25, 50, fmb.stringWidth("INSTRUCTIONS") + 52, fmb.getAscent() + 10));
			g2.setColor(Color.black);
			g2.drawString("INSTRUCTIONS", frame_width / 2 - fmb.stringWidth("INSTRUCTIONS") / 2, fmb.getAscent() + 50);
			
			g2.setColor(Color.black);
			g2.draw(new Rectangle2D.Double(50, 200, frame_width - 100, 450));
			g2.setColor(new Color(220, 220, 220));
			g2.fill(new Rectangle2D.Double(50, 200, frame_width - 100, 450));
			g2.setColor(Color.black);
			
			g2.setFont(f);
			g2.setColor(Color.white);
			g2.drawString("Game Start: " + count, 20, 20 + fm.getAscent());
		} 
		//Draws first set of story if timer is more than 30
		if (count > 30)
		{
			g2.setFont(f);
			g2.setColor(Color.black);
			g2.drawString("You've been knocked unconsious while walking at night", frame_width / 2 - fm.stringWidth("You've been knocked unconsious while walking at night") / 2, frame_height / 2 + fm.getAscent() / 2);
			g2.drawString("When you wake up, you're in an unfamiliar house", frame_width / 2 - fm.stringWidth("When you wake up, you're in an unfamiliar house") / 2, frame_height / 2 + fm.getAscent() + fm.getAscent());
			g2.drawString("You don't know where you are but you know one thing", frame_width / 2 - fm.stringWidth("You don't know where you are but you know one thing") / 2, frame_height - 212);
		}
		//Draws second set of instruction is timer is more than 26
		else if (count > 26)
		{
			g2.setFont(f);
			g2.setColor(Color.black);
			g2.drawString("You have to escape", frame_width / 2 - fm.stringWidth("You have to escape") / 2, frame_height / 2 + fm.getAscent() + fm.getAscent() + fm.getAscent());
		}
		//Draws first set of instructions if timer is more than 15
		else if (count > 15)
		{
			g2.setFont(f);
			g2.setColor(Color.black);
			g2.drawString("Press WASD to move", 150 + WASD.getIconWidth() / 2 - fm.stringWidth("Press WASD to move") / 2, frame_height / 2 + fm.getAscent() / 2 - 100);
			g2.drawImage(WASD.getImage(), 150, frame_height - WASD.getIconHeight() - 200 - 100, null);

			g2.drawString("Press SPACE to enter a task", frame_width - space.getIconWidth() - 100 - fm.stringWidth("Press WASD to move") / 2, frame_height / 2 + fm.getAscent() / 2 - 100);
			g2.drawString("and ESCAPE to exit a task", frame_width - space.getIconWidth() - 100 - fm.stringWidth("Press WASD to move") / 2 + 10, frame_height / 2 + fm.getAscent() + fm.getAscent() - 100);
			g2.drawImage(escape.getImage(), frame_width - space.getIconWidth() - 100 - escape.getIconWidth() - 20, frame_height - escape.getIconHeight() - 200 - 100, null);
			g2.drawImage(space.getImage(), frame_width - space.getIconWidth() - 100, frame_height - space.getIconHeight() - 200 - 100, null);

			g2.drawString("Use your mouse and keyboard", frame_width / 2 - fm.stringWidth("Use your mouse and keyboard") / 2, frame_height - 212);
			g2.drawString("while in a task to complete it", frame_width / 2 - fm.stringWidth("while in a task to complete it") / 2, frame_height - 212 + fm.getAscent() / 2 + fm.getAscent());
			g2.drawImage(keyboard.getImage(), frame_width / 2 - (mouse.getIconWidth() + keyboard.getIconWidth() + 50) / 2 + mouse.getIconWidth() + 50, frame_height - 200 + fm.getAscent() + fm.getAscent(), null);
			g2.drawImage(mouse.getImage(), frame_width / 2 - (mouse.getIconWidth() + keyboard.getIconWidth() + 50) / 2, frame_height - 200 + fm.getAscent() + fm.getAscent(), null);
		}
		//Draws second set of instructions if timer is more than 3
		else if (count > 3)
		{
			g2.setFont(f);
			g2.setColor(Color.black);

			g2.drawString("Don't get hit by the enemy", frame_width / 2 - fm.stringWidth("Don't get hit by the enemy") / 2, frame_height / 2 + fm.getAscent() / 2 - 100);
			g2.drawString("If you hear him, he's close", frame_width / 2 - fm.stringWidth("If you hear him, he's close") / 2, frame_height / 2 + fm.getAscent() + fm.getAscent() - 100);
			g2.drawImage(enemy_pic.getImage(), frame_width / 2 - enemy_pic.getIconWidth() / 2, frame_height - enemy_pic.getIconHeight() - 200 - 50, null);
			
			g2.drawString("Interact with tasks to find the code", frame_width / 2 - fm.stringWidth("Interact with tasks to find the code") / 2, frame_height - 212);
			g2.drawString("Find and unlock the door to escape the house", frame_width / 2 - fm.stringWidth("Find and unlock the door to escape the house") / 2, frame_height - 212 + fm.getAscent() / 2 + fm.getAscent());
			g2.drawImage(door_pic.getImage(), frame_width / 2 - door_pic.getIconWidth() / 2, frame_height - 200 + fm.getAscent() + fm.getAscent(), null);
		}
		//Draws countdown timer if timer is less than or equal to 3
		else
		{
			g2.setColor(Color.white);
			g2.setFont(font_big);
			g2.drawString(Integer.toString(count), frame_width / 2 - fm.stringWidth(Integer.toString(count)) / 2, frame_height / 2 + fmb.getAscent() / 2);
		}
	}
	
	//Draws lives. Brings in graphics2d object, 2 font object, and 2fontmetrics obejcts
	public void draw_lives(Graphics2D g2, Font f, FontMetrics fm, Font font_big, FontMetrics fmb, int lives)
	{
		//Draws lives box based on how many lives there are
		g2.setStroke(new BasicStroke(7));
		g2.setColor(Color.black);
		g2.draw(new Rectangle2D.Double(50 - 5, 50 - 5, fm.stringWidth("Lives:") + 5 + (heart.getIconWidth() + 5) * (lives) + 7, fm.getAscent() + 15));
		g2.setColor(Color.white);
		g2.fill(new Rectangle2D.Double(50 - 5, 50 - 5, fm.stringWidth("Lives:") + 5 + (heart.getIconWidth() + 5) * (lives) + 7, fm.getAscent() + 15));
		g2.setColor(Color.black);
		g2.drawString("Lives: " + lives, 50, 50 + fm.getAscent());
	
		//Draws amount of lives
		for (int i = 0; i < lives; i++)
		{
			g2.drawImage(heart.getImage(), 50 + fm.stringWidth("Lives:") + 5 + (heart.getIconWidth() + 5) * i, 50, null);
		}
	}
	
	//Draws death screen. Brings in graphics2d object, 2 font object, 2fontmetrics obejcts, and int variable
	public void draw_death(Graphics2D g2, Font f, FontMetrics fm, Font font_big, FontMetrics fmb, int lives)
	{
		//Creates string varibles
		String string1 = "PRESS SPACE TO RESTART";
		String string2 = "PRESS SPACE TO QUIT";
		
		//Draws death image
		g2.drawImage(death.getImage(), 0, 0, null);

		//Draws text boxes
		g2.setStroke(new BasicStroke(7));
		g2.setColor(Color.black);
		g2.draw(new Rectangle2D.Double(frame_width / 2 - fm.stringWidth("You have " + lives + " live(s) left") / 2 - 50, frame_height - 150, fm.stringWidth("You have " + lives + " live(s) left") + 100, fm.getAscent() + 10));

		g2.setColor(Color.white);
		g2.fill(new Rectangle2D.Double(frame_width / 2 - fm.stringWidth("You have " + lives + " live(s) left") / 2 - 50, frame_height - 150, fm.stringWidth("You have " + lives + " live(s) left") + 100, fm.getAscent() + 10));

		g2.setColor(Color.black);
		g2.drawString("You have " + lives + " live(s) left", frame_width / 2 - fm.stringWidth("You have " + lives + " live(s) left") / 2, frame_height - 150 + fm.getAscent() + 2);

		//Draws text boxes based on how many lives the player has
		if (lives > 0)
		{
			g2.setStroke(new BasicStroke(7));
			g2.setColor(Color.black);
			g2.draw(new Rectangle2D.Double(frame_width / 2 - fm.stringWidth(string1) / 2 - 50, frame_height - 100, fm.stringWidth(string1) + 100, fm.getAscent() + 10));

			g2.setColor(Color.white);
			g2.fill(new Rectangle2D.Double(frame_width / 2 - fm.stringWidth(string1) / 2 - 50, frame_height - 100, fm.stringWidth(string1) + 100, fm.getAscent() + 10));

			g2.setColor(Color.black);
			g2.drawString("PRESS SPACE TO RESTART", frame_width / 2 - fm.stringWidth(string1) / 2, frame_height - 100 + fm.getAscent() + 2);
		}
		else
		{
			g2.setStroke(new BasicStroke(7));
			g2.setColor(Color.black);
			g2.draw(new Rectangle2D.Double(frame_width / 2 - fm.stringWidth(string2) / 2 - 50, frame_height - 100, fm.stringWidth(string2) + 100, fm.getAscent() + 10));

			g2.setColor(Color.white);
			g2.fill(new Rectangle2D.Double(frame_width / 2 - fm.stringWidth(string2) / 2 - 50, frame_height - 100, fm.stringWidth(string2) + 100, fm.getAscent() + 10));

			g2.setColor(Color.black);
			g2.drawString(string2, frame_width / 2 - fm.stringWidth(string2) / 2, frame_height - 100 + fm.getAscent() + 2);
		}
	}
	
	//Draws win screen. Brings in graphics2d object, 2 font object, and 2fontmetrics obejcts
	public void draw_win(Graphics2D g2, Font f, FontMetrics fm, Font font_big, FontMetrics fmb)
	{
		//Draws house image
		g2.drawImage(house.getImage(), 0, 0, null);
		
		//Draws text boxes
		g2.setFont(font_big);
		
		g2.setStroke(new BasicStroke(7));
		g2.setColor(Color.black);
		g2.draw(new Rectangle2D.Double(frame_width / 2 - fmb.stringWidth("CONGRATULATIONS!") / 2 - 50, 50, fmb.stringWidth("CONGRATULATIONS!") + 100, fmb.getAscent() + 10));

		g2.setColor(Color.white);
		g2.fill(new Rectangle2D.Double(frame_width / 2 - fmb.stringWidth("CONGRATULATIONS!") / 2 - 50, 50, fmb.stringWidth("CONGRATULATIONS!") + 100, fmb.getAscent() + 10));

		g2.setColor(Color.black);
		g2.drawString("CONGRATULATIONS!", frame_width / 2 - fmb.stringWidth("CONGRATULATIONS!") / 2, fmb.getAscent() + 50);

		g2.setColor(Color.black);
		g2.draw(new Rectangle2D.Double(frame_width / 2 - fmb.stringWidth("YOU ESCAPED THE HOUSE") / 2 - 50, frame_height - 100, fmb.stringWidth("YOU ESCAPED THE HOUSE") + 100, fmb.getAscent() + 10));

		g2.setColor(Color.white);
		g2.fill(new Rectangle2D.Double(frame_width / 2 - fmb.stringWidth("YOU ESCAPED THE HOUSE") / 2 - 50, frame_height - 100, fmb.stringWidth("YOU ESCAPED THE HOUSE") + 100, fmb.getAscent() + 10));

		g2.setColor(Color.black);
		g2.drawString("YOU ESCAPED THE HOUSE", frame_width / 2 - fmb.stringWidth("YOU ESCAPED THE HOUSE") / 2, frame_height - 100 + fmb.getAscent() + 2);
	}
	
	//Countsdown when timer restarts
	public int countdown()
	{
		count--;
		return count;
	}
}
