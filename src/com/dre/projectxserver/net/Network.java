package com.dre.projectxserver.net;

import java.util.concurrent.CopyOnWriteArrayList;

import com.dre.projectxserver.net.packages.PlayerLoginPackage;
import com.dre.projectxserver.net.packages.PlayerNewPackage;
import com.dre.projectxserver.net.packages.PlayerPositionPackage;
import com.dre.projectxserver.net.packages.PlayerVisiblePackage;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

public class Network {
	public static CopyOnWriteArrayList<Class<?>> netPackages = new CopyOnWriteArrayList<Class<?>>();

	public static Kryo kryo;

	//Packages
	public static PlayerLoginPackage playerLogin = new PlayerLoginPackage();
	public static PlayerPositionPackage playerPosition = new PlayerPositionPackage();
	public static PlayerVisiblePackage playerVisible = new PlayerVisiblePackage();
	public static PlayerNewPackage playerNew = new PlayerNewPackage();

	public static void register (EndPoint endPoint) {
		kryo = endPoint.getKryo();

		//Initialize packages
		netPackages.add(PlayerLoginPackage.class);
		netPackages.add(PlayerPositionPackage.class);
		netPackages.add(PlayerVisiblePackage.class);
		netPackages.add(PlayerNewPackage.class);

		//Initialize kryo classes
		kryo.register(PlayerLoginPackage.class);
		kryo.register(PlayerPositionPackage.class);
		kryo.register(PlayerVisiblePackage.class);
		kryo.register(PlayerNewPackage.class);

		//TODO: Automatisieren
	}
}
