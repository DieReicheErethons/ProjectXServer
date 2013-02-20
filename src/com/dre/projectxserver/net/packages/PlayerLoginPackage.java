package com.dre.projectxserver.net.packages;

import java.util.logging.Level;

import com.dre.projectxserver.Main;
import com.dre.projectxserver.contents.Player;
import com.esotericsoftware.kryonet.Connection;

public class PlayerLoginPackage extends NetPackage{
	public String name;
	public int id;

	@Override
	public void onRecieve(Connection connection, Object object) {
		if(object instanceof PlayerLoginPackage){
			Main.m.logger.log(Level.INFO, "TEST2");

			PlayerLoginPackage loginPackage = (PlayerLoginPackage) object;

			Player player = new Player(loginPackage.name, connection);

			loginPackage.id = player.getId();

			for(Player oplayer : Player.players){
				oplayer.getConnection().sendTCP(loginPackage);
				if(oplayer != player){
					PlayerNewPackage playerNew = new PlayerNewPackage();
					playerNew.name = oplayer.getName();
					playerNew.id = oplayer.getId();
					player.getConnection().sendTCP(playerNew);
				}
			}
		}
	}
}
