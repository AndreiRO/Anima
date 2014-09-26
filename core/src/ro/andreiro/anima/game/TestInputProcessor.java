package ro.andreiro.anima.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

public class TestInputProcessor implements InputProcessor {

	OrthographicCamera c;
	private int unit = 10;
	
	public TestInputProcessor(OrthographicCamera c) {
		this.c = c;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		System.out.println("key down");
		if(Input.Keys.A == keycode) {
			c.translate(new Vector2(-5, 0));
		} else if(Input.Keys.D == keycode) {
			c.translate(new Vector2(5, 0));
		} else if(Input.Keys.W == keycode) {
			c.translate(new Vector2(0, 5));
		} else if(Input.Keys.S == keycode) {
			c.translate(new Vector2(0, -5));
		}
		
		c.update();
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		System.out.println("key up");
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		if('a' == character) {
			c.translate(new Vector2(-unit, 0));
		} else if('d' == character) {
			c.translate(new Vector2(unit, 0));
		} else if('w' == character) {
			c.translate(new Vector2(0, unit));
		} else if('s' == character) {
			c.translate(new Vector2(0, -unit));
		}
		
		c.update();
		System.out.println("key typed");
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		System.out.println("touch down");
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		System.out.println("touch up");
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		System.out.println("touch draged");
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		System.out.println("mouse moved");
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		System.out.println("scrolled");
		return false;
	}

}
