package de.htwg.tetris.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class NewElementServer {

	public static void main(String[] args) {
		try {
			System.setProperty("java.rmi.server.codebase", "http://localhost/server.jar");
			Registry reg = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
			
			INewElement stub = (INewElement) UnicastRemoteObject.exportObject(new NewElement(),0);
			
			reg.rebind("newelement", stub);
			
			while(true){}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 	
	}

}
