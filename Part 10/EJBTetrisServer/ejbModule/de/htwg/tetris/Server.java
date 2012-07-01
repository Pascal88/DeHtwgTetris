package de.htwg.tetris;

import javax.ejb.Stateless;

import de.htwg.tetris.model.IElement;
import de.htwg.tetris.model.INewElement;
import de.htwg.tetris.model.NewElement;

/**
 * Session Bean implementation class Server
 */
@Stateless(mappedName="tetrisServer")
public class Server implements ServerRemote, ServerLocal {

    /**
     * Default constructor. 
     */
    public Server() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public IElement newElement() {
		INewElement newEle = new NewElement();
		return newEle.newEl();
	}

}
