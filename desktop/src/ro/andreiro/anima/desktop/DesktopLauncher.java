package ro.andreiro.anima.desktop;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.Dimension;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import ro.andreiro.anima.AnimaGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
	    cfg.width = 1024;
	    cfg.height = 768;
	    
	    
		new LwjglApplication(new AnimaGame(), cfg);
	}
}
