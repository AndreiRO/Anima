package ro.andreiro.anima.game;

import com.badlogic.gdx.Screen;


public class GameState implements Screen {

	protected boolean paused = false;
	protected GameStateManager manager;
	
	public GameState() {
		paused = false;
	}
	
	@Override
	public void render(float delta) {
		if(paused) return; 
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		paused = false;
	}

	@Override
	public void hide() {
		paused = true;
	}

	@Override
	public void pause() {
		paused = true;
	}

	@Override
	public void resume() {
		paused = false;
	}

	@Override
	public void dispose() {
		
	}

	public void init(GameStateManager m) {
		this.manager = m;
	}

}
