package com.dre.projectxserver.net.packages;

import com.esotericsoftware.kryonet.Connection;

public class PlayerDisconnectPackage extends NetPackage{
	public int playerId;

	@Override
	public void onRecieve(Connection connection) {

	}
}
