package com.dre.projectxserver.net.packages;

import com.dre.projectxserver.contents.Player;
import com.esotericsoftware.kryonet.Connection;

public class PlayerLoginPackage extends NetPackage{
	public String name;
	public int id;

	@Override
	public void onRecieve(Connection connection) {
		Player player = new Player(this.name, connection);

		this.id = player.getId();

		for(Player oplayer : Player.players){
			oplayer.getConnection().sendTCP(this);
			if(oplayer != player){
				PlayerNewPackage playerNew = new PlayerNewPackage();
				playerNew.name = oplayer.getName();
				playerNew.id = oplayer.getId();
				player.getConnection().sendTCP(playerNew);
			}
		}
	}
}
