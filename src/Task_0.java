//Imports packages
import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Task_0 {

	//Creates variables
	private ImageIcon image_pre, book, page_instructions, book_gif;
	private Image image_img;
	private int frame_width, frame_height, flip, page, page_num;
	private String [] shape;

	//Constructor that brings in frame width, frame height, and code order
	Task_0(int Frame_width, int Frame_height, String [] Shape)
	{
		//Initializes variables
		frame_width = Frame_width;
		frame_height = Frame_height;

		image_pre = new ImageIcon("book_pic.jpg");
		image_img = image_pre.getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT);
		book = new ImageIcon(image_img);

		image_pre = new ImageIcon("book_gif.gif");
		image_img = image_pre.getImage().getScaledInstance(960, 650, Image.SCALE_DEFAULT);
		book_gif = new ImageIcon(image_img);
		
		page_instructions = new ImageIcon("pageinstructions.png");
		
		page = 1;
		page_num = (int)(Math.random() * 9 + 2);
		
		shape = Shape;
	}

	//Paints task. Brings in graphics2d object and font metrics object
	public void draw(Graphics2D g2, FontMetrics fm)
	{
		//Draws book flip gif if flip is 1
		if (flip == 1)
		{
			g2.drawImage(book.getImage(), frame_width / 2 - book.getIconWidth() / 2, frame_height / 2 - book.getIconHeight() / 2, null);
			g2.drawImage(book_gif.getImage(), frame_width / 2 - book_gif.getIconWidth() / 2, frame_height / 2 - book_gif.getIconHeight() / 2, null);
		}
		//Draws reversed book flip gif if flip is 2
		else if (flip == 2)
		{
			g2.drawImage(book.getImage(), frame_width / 2 - book.getIconWidth() / 2, frame_height / 2 - book.getIconHeight() / 2, null);
			g2.rotate(3.14, frame_width / 2, frame_height / 2);
			g2.drawImage(book_gif.getImage(), frame_width / 2 - book_gif.getIconWidth() / 2, frame_height / 2 - book_gif.getIconHeight() / 2, null);
			g2.rotate(-3.14, frame_width / 2, frame_height / 2);
		}
		//Draws book
		else
		{
			g2.drawImage(book.getImage(), frame_width / 2 - book.getIconWidth() / 2, frame_height / 2 - book.getIconHeight() / 2, null);

			g2.setColor(Color.black);
			g2.drawString(Integer.toString(page * 2 - 1), frame_width / 2 - book.getIconWidth() / 2 + 40, frame_height / 2 - book.getIconHeight() / 2 + book.getIconHeight() - 40);
			g2.drawString(Integer.toString(page * 2), frame_width / 2 - book.getIconWidth() / 2 + book.getIconWidth() - 70, frame_height / 2 - book.getIconHeight() / 2 + book.getIconHeight() - 40);

			//Draws instructions if page is 1
			if (page == 1)
			{
				g2.drawImage(page_instructions.getImage(), frame_width / 2 - book.getIconWidth() / 2 + 100, frame_height / 2 - book.getIconHeight() / 2 + 50, null);
			}
			//Draws code order if page is the random page number
			else if (page == page_num)
			{
				for (int i = 0; i < shape.length; i++)
				{
					g2.drawString(shape[i], frame_width / 2 - book.getIconWidth() / 2 + book.getIconWidth() - 270, frame_height / 2 - book.getIconHeight() / 2 + 100 + (fm.getAscent() + 30) * i);
				}
			}
		}
	}
	
	//Stops flip timer
	public void flip_stop()
	{
		flip = 0;
		
		House_Escape.flip_timer.stop();
	}
	
	//Flips page depending on key pressed and what page the book is on
	public void flip_page(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_D)
		{
			if (page < 10 && flip == 0)
			{
				flip = 1;

				page++;

				House_Escape.flip_timer.start();
			}
		}
		else if (e.getKeyCode() == KeyEvent.VK_A)
		{
			if (page > 1 && flip == 0)
			{
				flip = 2;

				page--;

				House_Escape.flip_timer.start();
			}
		}
	}
}
