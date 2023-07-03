//Imports Packages
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Enemy {
	
	//Creates variables
	private int xPos, yPos, dir, speed, animation, xPoof, yPoof;
	private final int RIGHT = 1, LEFT = 3;
	private ImageIcon[] enemyRight, enemyLeft, enemyStill;
	private ImageIcon preImage, poof;
	private Image imageImg;
	private Rectangle2D enemy;
	
	Background background;
	
	//Constructor that takes in level, xPosition of the Background, and yPosition of the background
	public Enemy(int level, int xPosBackground, int yPosBackground)
	{	
		background = new Background((1000 - 12), (700 - 35), level);
		
		enemyRight = new ImageIcon[4];
		enemyLeft = new ImageIcon[4];
		enemyStill = new ImageIcon[4];
		
		for (int i = 0; i < enemyRight.length; i++)
		{
			// Renders in images into arrays
			preImage = new ImageIcon("enemy/right/" + (i + 1) + ".png");
			imageImg = preImage.getImage().getScaledInstance(preImage.getIconWidth()*2, preImage.getIconHeight()*2, Image.SCALE_DEFAULT);
			enemyRight[i] = new ImageIcon(imageImg);
			
			preImage = new ImageIcon("enemy/left/" + (i + 1) + ".png");
			imageImg = preImage.getImage().getScaledInstance(preImage.getIconWidth()*2, preImage.getIconHeight()*2, Image.SCALE_DEFAULT);
			enemyLeft[i] = new ImageIcon(imageImg);
		}
		
		// Renders in animation
		preImage = new ImageIcon("enemy/poof.gif");
		imageImg = preImage.getImage().getScaledInstance(preImage.getIconWidth()/2, (int) (preImage.getIconHeight()/1.5), Image.SCALE_DEFAULT);
		poof = new ImageIcon(imageImg);
		
		xPos = -300000;
		yPos = -300000;
		
		enemy =  new Rectangle2D.Double(xPosBackground + xPos, yPosBackground + yPos, 50, 50);
		
		dir = -1;
		
		animation = 3;
		speed = 2;
	}
	
	// Draws the enemy using Graphics2D class
	public void draw(Graphics2D g2, int xPosBackground, int yPosBackground, int BackgroundWidth, int BackgroundHeight, int xPosPlayer, int yPosPlayer)
	{
		g2.drawImage(setImage(xPosBackground, yPosBackground, xPosPlayer, yPosPlayer).getImage(), xPosBackground + xPos, yPosBackground + yPos, null);
	}
	
	// Returns xPosition of enemy
	public int getX()
	{
		return xPos;
	}
	
	// Returns yPosition of enemy
	public int getY()
	{
		return yPos;
	}
	
	// Randomizes location of enemy using parameters such as backgroundWitdth and backgroundHeight
	public void enemy_randomize(int xPosBackground, int yPosBackground, int BackgroundWidth, int BackgroundHeight, Ellipse2D player_radius)
	{
		while (true)
		{
			xPos = (int)(Math.random() * (BackgroundWidth - 50));
			yPos = (int)(Math.random() * (BackgroundHeight - 50));
			
			if (player_radius.intersects(enemy))
			{
				continue;
			}

			break;
		}
	}
	
	// Using xPosition of the player, enemy will set what direction to retrieve picture from
	private void setPictureDirection(int xPosBackground, int yPosBackground, int xPosPlayer, int yPosPlayer)
	{
		if (xPos + xPosBackground > xPosPlayer)
		{			
			dir = LEFT;
		}
		
		else if (xPos + xPosBackground <= xPosPlayer)
		{			
			dir = RIGHT;
		}
	}
	
	// Creates the enemy hitbox
	public Rectangle2D enemy_hitbox(int xPosBackground, int yPosBackground, int BackgroundWidth, int BackgroundHeight)
	{
		enemy = new Rectangle2D.Double(xPos + xPosBackground, yPos + yPosBackground, 88, 84);
		return enemy;
	}
	
	// Method used to move the enemy and follow the player
	public void move(int xPosBackground, int yPosBackground, int xPosPlayer, int yPosPlayer)
	{
		if (xPosBackground + xPos < xPosPlayer)
		{
			xPos += speed;
		}
		if (xPosBackground + xPos > xPosPlayer)
		{
			xPos -= speed;
		}
		if (yPosBackground + yPos < yPosPlayer)
		{
			yPos += speed;
		}
		if (yPosBackground + yPos > yPosPlayer)
		{
			yPos -= speed;
		}
	}
	
	// Using xPosition of the player, enemy will decide between using array that points left or right
	private ImageIcon setImage(int xPosBackground, int yPosBackground, int xPosPlayer, int yPosPlayer)
	{
		setPictureDirection(xPosBackground, yPosBackground, xPosPlayer, yPosPlayer);
		
		ImageIcon picture = null;
		
		if (dir == LEFT)
		{			
			picture = enemyLeft[animation];
		}
		
		else if (dir == RIGHT)
		{			
			picture = enemyRight[animation];
		}
		
		else
		{		
			picture = enemyStill[animation];
		}
		
		return picture;
	}
	
	// Return ImageIcon of the current enemy sprite
	public ImageIcon get_image()
	{
		return enemyRight[2];
	}
	
	// switch between sprites giving illusion that it is animated
	public void animation()
	{
		animation++;

		if (animation > 3)
		{
			animation = 0;
		}		
	}
	
	// sets the x and y position of the poof
	public void setPoof()
	{
		xPoof = xPos;
		yPoof = yPos;
	}
	
	// draws poof at specified points
	public void drawPoof(int xPosBackground, int yPosBackground, Graphics2D g2)
	{
		g2.drawImage(poof.getImage(), xPosBackground + xPos, yPosBackground + yPos-20, null);
		g2.drawImage(poof.getImage(), xPosBackground + xPoof, yPosBackground + yPoof-20, null);
	}
}