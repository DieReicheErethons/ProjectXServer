package com.dre.projectxserver.net;

import com.dre.projectxserver.net.packages.NetPackage;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class NetListener extends Listener{
	@Override
	public void received(Connection connection, Object object){
		for(NetPackage netPackage : Network.netPackages){
			if(object.getClass() == netPackage.getClass()){
				netPackage.onRecieve(connection, object);
			}
		}
	}
}
