package com.dre.projectxserver.net.packages;

import com.esotericsoftware.kryonet.Connection;

public abstract class NetPackage {

	//Abstracts
	public abstract void onRecieve(Connection connection, Object object);
}
