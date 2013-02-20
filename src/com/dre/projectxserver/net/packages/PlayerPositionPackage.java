package com.dre.projectxserver.net.packages;

import com.dre.projectxserver.contents.Player;
import com.esotericsoftware.kryonet.Connection;

public class PlayerPositionPackage extends NetPackage{
	public int playerId;
	public float x, y;
	public float rotation;

	@Override
	public void onRecieve(Connection connection) {
		for(Player player : Player.players){
			if(player.getId() != this.playerId){
				player.getConnection().sendUDP(this);
			}
		}

		//TODO: Check Möglichkeit

		//TODO: Chunk basiertes Positions/Visible senden
	}
}
