package ro.andreiro.anima.game.world;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator.RequestorType;
import java.util.Scanner;

import javax.xml.ws.soap.AddressingFeature.Responses;

import ro.andreiro.anima.game.Resources;
import ro.andreiro.anima.game.Constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class World {
	
	private int map[][];
	private float size;
	
	public World(int w, int h) {
		map = new int[w][h];
		
		try {
			loadMap(w, h);
		} catch (IOException e) {
		}
	}
	
	
	private void loadMap(int w, int h) throws IOException {
		/*FileHandle handle = Gdx.files.internal("map.txt");
		
		Scanner scanner = new Scanner(handle.read());
		for(int i = 0; i < w; ++ i) {
			for(int j = 0; j < h; ++ j) {				
				map[i][j] = scanner.nextInt();
			}
		}
		
		scanner.close();
		*/
		int prefs[] = {10, 10, 40, 10, 10, 10};
		WorldGenerator generator = new WorldGenerator(128, 128, prefs);
		map = generator.generateMap();
	}
	
	public void render(SpriteBatch sb, int x, int y) {
		float width  = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();
		
		
		
		int toDrawX = Constants.TO_DRAW;
		int toDrawY = Constants.TO_DRAW;
		
		if(toDrawX > getWidth()) toDrawX = getWidth();
		if(toDrawY > getHeight()) toDrawY = getHeight();
		
		float sizeX = width / toDrawX;
		float sizeY = height / toDrawY;
		
		sizeX = sizeX > sizeY ? sizeX : sizeY;
		sizeY = sizeY > sizeX ? sizeY : sizeX;
		
		size = sizeX;
		
		float mapX = 0f;
		float mapY = height;
		
		mapY -= sizeY;
		
		for(int i = 0; i < toDrawX; ++ i) {
			for(int j = 0; j < toDrawY; ++ j) {
				sb.draw(Resources.getRegion(map[i][j]), mapX, mapY, sizeX, sizeY);
				mapX += sizeX;
			}
			mapY -= sizeY;
			mapX = 0f;
		}
	}
	
	public int getWidth() {
		return map.length;
	}
	
	public int getHeight() {
		if(map != null) return map[0].length;
		
		return 0;
	}
	
	public BlockType getBlockType(float x, float y) {
		int blockNumberX = MathUtils.floor(x/size);
		int blockNumberY = MathUtils.floor(y/size);
		
		return BlockType.getBlockType(map[blockNumberX][blockNumberY]);		
	}
}
