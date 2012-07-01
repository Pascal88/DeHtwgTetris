package de.htwg.tetris.server;

import java.util.Random;

public class NewElement implements INewElement
{	
	private static final long serialVersionUID = 3236153996263949900L;
	public IElement[] element = new Element[7];
	public NewElement() {
		try {
			element[0] = new ElementL(); 
			element[1] = new ElementO(); 
			element[2] = new ElementN(); 
			element[3] = new ElementZ(); 
			element[4] = new ElementI(); 
			element[5] = new ElementJ(); 
			element[6] = new ElementT();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public IElement newEl()
	{
		Random rand = new Random();
		
		int el = rand.nextInt() % 7;
		
		try {
			return element[el];
		} catch (ArrayIndexOutOfBoundsException e) {
			return element[el * -1];
		}
	}
}
