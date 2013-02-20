
package com.dre.projectxserver.net;

import java.io.IOException;

import com.esotericsoftware.kryonet.Server;

public class NetServer {
	Server server;

	public NetServer (){
		server = new Server();

		// Register the classes that will be sent over the network.
		Network.register(server);

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
}
