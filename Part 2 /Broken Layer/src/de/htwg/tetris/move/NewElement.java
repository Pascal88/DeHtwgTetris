package de.htwg.tetris.move;

import java.util.Random;

import de.htwg.tetris.model.Element;
import de.htwg.tetris.model.ElementI;
import de.htwg.tetris.model.ElementL;
import de.htwg.tetris.model.ElementN;
import de.htwg.tetris.model.ElementO;
import de.htwg.tetris.model.ElementZ;


public class NewElement 
{	
	public NewElement()
	{
		
	}
	public static Element newEl()
	{
		Element element;
		Random rand = new Random();
		
		int el = rand.nextInt() % 5;
		if (el < 0)
		{
			el = el *-1;
		}
		switch (el) 
		{
		case 0:
			element = new ElementL();
			break;
		case 1:
			element = new ElementO();
			break;
		case 2:
			element = new ElementN();
			break;
		case 3:
			element = new ElementZ();
			break;
		case 4:
			element = new ElementI();
			break;
		default:
			element = new ElementL();
			;
		}
		return element;
	}
}
