package ro.andreiro.anima.game;

import java.util.HashMap;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ro.andreiro.anima.game.world.BlockType;

public class Resources {
	private static HashMap<String, Object> hash;
	
	static {
		hash = new HashMap<>();
	}
	
	public static void set(String key, Object value) {
		hash.put(key, value);
	}
	
	public static Object get(String key) {
		return hash.get(key);
	}
	
	public static void remove(String key) {
		hash.remove(key);
	}
	
	public static TextureRegion getRegion(int i) {
		/**
		 * 0 - grass
		 * 1 - soil
		 * 2 - water
		 * 3 - green veg
		 * 4 - orange veg
		 * 5 - green tree
		 * 6 - orange tree
		 * 7 - big green tree
		 * 8 - big orange tree
		 * */
		TextureAtlas atlas = (TextureAtlas)hash.get("map");
		switch(i) {
			case 0:
				return atlas.findRegion("grass");
			case 1:
				return atlas.findRegion("soil");
			case 2:
				return atlas.findRegion("water");
			case 3:
				return atlas.findRegion("green-vegetation");
			case 4:
				return atlas.findRegion("orange-vegetation");
			case 5:
				return atlas.findRegion("green-tree");
			case 6:
				return atlas.findRegion("orange-tree");
			case 7:
				return atlas.findRegion("big-green-tree");
			case 8:
				return atlas.findRegion("big-orange-tree");
			default:
				return atlas.findRegion("soil");
		}
	}
	
	
}
