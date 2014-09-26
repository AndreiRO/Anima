package ro.andreiro.anima.game.world;

import com.badlogic.gdx.math.Vector3;

public class GameObject {

	protected float x;
	protected float y;
	protected float z;
	
	protected float dx;
	protected float dy;
	
	public static final String TAG = "Default object";
	
	public GameObject() {
		dx = dy = 0f;
	}

	public String toString() {
		return "GameObject:" + TAG+ " x:" + x + " y:" + y+ " z:" + z;
	}
	
	public void setCoordinates(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void setCoordinates(Vector3 pos) {
		this.x = pos.x;
		this.y = pos.y;
		this.z = pos.z;
	}
	
	public Vector3 getCoordinates() {
		return new Vector3(x,y,z);
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getZ() {
		return z;
	}
}
