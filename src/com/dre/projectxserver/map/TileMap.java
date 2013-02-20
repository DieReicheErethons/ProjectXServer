package com.dre.projectxserver.map;

public class TileMap {
	public int[][] tileSet;

	public TileMap(MapGenerator generator){
		tileSet = generator.getArray();
	}
}
