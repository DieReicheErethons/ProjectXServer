
package com.dre.projectxserver.net;

import java.io.IOException;

import com.dre.projectxserver.net.packages.PlayerDisconnectPackage;
import com.dre.projectxserver.net.packages.PlayerLoginPackage;
import com.dre.projectxserver.net.packages.PlayerNewPackage;
import com.dre.projectxserver.net.packages.PlayerPositionPackage;
import com.dre.projectxserver.net.packages.PlayerVisiblePackage;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;
import com.esotericsoftware.kryonet.Server;

public class NetServer {
	public Server server;

	public static Kryo kryo;

	public NetServer (){
		server = new Server();

		// Register the classes that will be sent over the network.
		registerKryoClasses(server);

		// Add listener
		server.addListener(new NetListener());

		//Bind port
		try {
			server.bind(54555,54556);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Start server
		server.start();
	}

	//Kryo
	public static void registerKryoClasses (EndPoint endPoint) {
		kryo = endPoint.getKryo();

		//Initialize kryo classes
		kryo.register(PlayerLoginPackage.class);
		kryo.register(PlayerPositionPackage.class);
		kryo.register(PlayerVisiblePackage.class);
		kryo.register(PlayerNewPackage.class);
		kryo.register(PlayerDisconnectPackage.class);

		//TODO: Automatisieren
	}
}
