package ro.andreiro.anima;

import ro.andreiro.anima.game.GameStateManager;


import com.badlogic.gdx.Game;


public class AnimaGame extends Game {

	private GameStateManager manager;
	
	@Override
	public void create () {
		manager = new GameStateManager(this);
		manager.start();
	}
}
