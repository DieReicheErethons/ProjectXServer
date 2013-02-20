package com.dre.projectxserver.net.packages;

import com.esotericsoftware.kryonet.Connection;

public class PlayerNewPackage extends NetPackage{
	public String name;
	public int id;

	@Override
	public void onRecieve(Connection connection, Object object) {

	}
}
