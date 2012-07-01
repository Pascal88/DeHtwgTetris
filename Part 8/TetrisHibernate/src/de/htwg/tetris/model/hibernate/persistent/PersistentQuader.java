package de.htwg.tetris.model.hibernate.persistent;

import java.io.Serializable;

import javax.persistence.*;

import de.htwg.tetris.model.IQuader;
import de.htwg.tetris.model.IQuader.states;
import de.htwg.tetris.model.ITetrisColor;
import de.htwg.tetris.model.TetrisColor;

@Entity
@Table(name="Quader")
public class PersistentQuader implements Serializable {

	private static final long serialVersionUID = 5614961658602383753L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="state")
	private states state = states.FREE;
	@Column(name="color")
	private ITetrisColor color = new TetrisColor(90, 90, 180);
	@Column(name="x")
	private int x = 0;
	@Column(name="y")
	private int y = 0;
	@ManyToOne
	@JoinColumn(name="SaveGameId")
	private PersistentSaveGame saveGame;
	
	public PersistentQuader() {}
	
	public PersistentQuader(IQuader quader, PersistentSaveGame saveGame) {
		this.state = quader.getState();
		this.color = quader.getColor();
		this.x = quader.getX();
		this.y = quader.getY();
		this.saveGame = saveGame;
	}
	
	public PersistentQuader(states state, ITetrisColor color, int x, int y, PersistentSaveGame saveGame) {
		this.state = state;
		this.color = color;
		this.x = x;
		this.y = y;
		this.saveGame = saveGame;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public states getState() {
		return state;
	}
	public void setState(states state) {
		this.state = state;
	}
	public ITetrisColor getColor() {
		return color;
	}
	public void setColor(ITetrisColor color) {
		this.color = color;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public PersistentSaveGame getSaveGame() {
		return saveGame;
	}
	public void setSaveGame(PersistentSaveGame saveGame) {
		this.saveGame = saveGame;
	}
}
