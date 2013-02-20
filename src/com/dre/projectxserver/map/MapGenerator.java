package com.dre.projectxserver.map;

import java.util.Random;

public class MapGenerator {

	public Noise noise;
	public int width, height;

	public int minValue, maxValue;

	public MapGenerator(Random rand, float roughness, int width, int height, int minValue, int maxValue){
		this.noise = new Noise(rand, roughness, width, height);
		noise.initialise();
	}

	public int[][] getArray(){
		float[][] floatArray = this.noise.toFloat();

		int[][] intArray = new int[this.width][this.height];

		//Convert Array
		for(int x = 0; x < this.width; x++){
			for(int y = 0; y < this.height; y++){
				float divisor = 1 / (maxValue-minValue);
				int value = (int) Math.ceil(floatArray[x][y] / divisor);
				intArray[x][y] = value;
			}
		}


		return intArray;
	}
}
