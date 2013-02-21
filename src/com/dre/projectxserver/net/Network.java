package com.dre.projectxserver.net;

import com.dre.projectxserver.net.packages.PlayerDisconnectPackage;
import com.dre.projectxserver.net.packages.PlayerLoginPackage;
import com.dre.projectxserver.net.packages.PlayerNewPackage;
import com.dre.projectxserver.net.packages.PlayerPositionPackage;
import com.dre.projectxserver.net.packages.PlayerVisiblePackage;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

public class Network {

	public static Kryo kryo;

	public static void register (EndPoint endPoint) {
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
