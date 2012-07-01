package de.htwg.tetris.model.db;

import com.google.inject.AbstractModule;

import de.htwg.tetris.DI.*;

public class DbModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IDataBase.class).annotatedWith(Db4o.class).to(de.htwg.tetris.model.db.db4o.DataBase.class);
		bind(IDataBase.class).annotatedWith(Hibernate.class).to(de.htwg.tetris.model.db.hibernate.DataBase.class);
	}

}
