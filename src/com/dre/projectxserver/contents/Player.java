package com.dre.projectxserver.contents;

import java.util.HashSet;
import java.util.Set;

import com.dre.projectxserver.Config;
import com.esotericsoftware.kryonet.Connection;

public class Player {
	public static Set<Player> players = new HashSet<Player>();
	public static int idCount = 0;

	private Connection connection;
	private int id;
	private String name;
	private int x, y;

	private Set<Player> visiblePlayers = new HashSet<Player>();

	public Player(String name, Connection connection){
		players.add(this);

		this.name = name;
		this.connection = connection;
		this.id = idCount;

		idCount++;
	}

	public int getDistance(Player oplayer){
		if(oplayer != null){
			double oppositeCathetusLenght = (oplayer.x - this.x);
		    double cathetusLenght = (oplayer.y - this.y);

		    double oppositeCathetusSquare = Math.pow(oppositeCathetusLenght, 2);
		    double cathetusSquare = Math.pow(cathetusLenght, 2);

		    return (int) (Math.abs(Math.sqrt(oppositeCathetusSquare + cathetusSquare)));
		}

		return 0;
	}


	//Static methods
	public static void update(){
		for(Player player : players){

			//Distance updates
			for(Player oplayer : players){
				if(player != oplayer){
					if(player.visiblePlayers.contains(oplayer)){
						if(player.getDistance(oplayer) > Config.viewDistance ){
							player.visiblePlayers.remove(oplayer);
						}
					} else {
						if(player.getDistance(oplayer) < Config.viewDistance ){
							player.visiblePlayers.add(oplayer);
						}
					}
				}
			}
		}
	}

	public static Set<Player> get(){
		return players;
	}

	//Getter and Setters
	public Connection getConnection() {
		return this.connection;
	}

	public int getId() {
		return this.id;
	}

	public String getName(){
		return this.name;
	}
}
