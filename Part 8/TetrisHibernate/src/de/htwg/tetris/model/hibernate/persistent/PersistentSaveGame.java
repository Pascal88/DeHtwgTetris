package de.htwg.tetris.model.hibernate.persistent;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="SaveGame")
public class PersistentSaveGame implements Serializable {
	private static final long serialVersionUID = 6111102081011752483L;
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	@Column(name="name")
	private String name = null;
	@OneToMany(mappedBy="saveGame")
	@Column(name="Quader")
	private List<PersistentQuader> Quader = null;
	@Column(name="highscore")
	private int highscore = 0;

	public PersistentSaveGame() {	}
	
	public PersistentSaveGame(String s, List<PersistentQuader> game, int score) {
		this.name = s;
		this.Quader = game;
		this.highscore = score;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<PersistentQuader> getGame() {
		return Quader;
	}

	public void setGame(List<PersistentQuader> game) {
		this.Quader = game;
	}

	public int getHighscore() {
		return highscore;
	}

	public void setHighscore(int highscore) {
		this.highscore = highscore;
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}
}
