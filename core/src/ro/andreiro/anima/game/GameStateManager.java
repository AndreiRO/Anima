package ro.andreiro.anima.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;

import ro.andreiro.anima.AnimaGame;;

public class GameStateManager {
	private GameState[] states;
	private AnimaGame game;
	private State currentState;
	Pixmap pm;
	
	public GameStateManager(AnimaGame g) {
		states = new GameState[State.values().length];
		this.game = g;
		
		currentState = State.MAIN_MENU;
		states[0] = new MainMenuState();
		states[1] = new PlayState();
	}

	public void start() {
		states[0].init(this);
		states[1].init(this);
		pm = new Pixmap(Gdx.files.internal("ui/mouse.png"));
        int xHotSpot = 0;
        int yHotSpot = 0;
        Gdx.input.setCursorImage(pm, xHotSpot, yHotSpot);
        pm.dispose();
		game.setScreen(states[0]);
		
	}
	
	public void setState(State newState) {
		if(currentState == newState) {
			return ;
		}
		
		
		switch(newState) {
			case MAIN_MENU:
				game.setScreen(states[0]);
				break;
			case PLAY:
				game.setScreen(states[1]);
				System.out.println("changed to play");
				break;
			case OPTIONS_MENU:
				System.out.println("changed to options");
				break;
			case CREDITS:
				System.out.println("changed to credits");
				break;
		}
	}

	
}
