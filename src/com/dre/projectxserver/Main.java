package com.dre.projectxserver;

import java.util.logging.Logger;

import com.dre.projectxserver.map.TileMap;
import com.dre.projectxserver.map.MapGenerator;
import com.dre.projectxserver.net.NetServer;

public class Main {
	public static Main m;

	//Net
	public NetServer netServer;

	//Map
	public TileMap map;
	public MapGenerator generator;

	//Logger
	public Logger logger = Logger.getLogger("projectx");

	//Other
	public boolean shutdown = false;

	public static void main(String[] args) {
		m = new Main();

		m.netServer = new NetServer();

		//Main loop
		//do{

		//}while(!m.shutdown);
	}
}
