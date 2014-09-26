package ro.andreiro.anima.game;

import ro.andreiro.anima.game.world.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class PlayState extends GameState {

	private SpriteBatch batch;
	private OrthographicCamera camera;
	private BitmapFont font;
	private TextureAtlas atlas;
	private World world;
	
	
	public PlayState() {
		super();

		batch = new SpriteBatch();
		
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
	    camera.update();

	    atlas = new TextureAtlas(Gdx.files.internal("images/map.pack"));
	    Resources.set("map", atlas);
	    world = new World(128, 128);
	}
	
	@Override
	public void init(GameStateManager m) {
		super.init(m);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);	
		batch.setProjectionMatrix(camera.combined);
	
		batch.begin();
		world.render(batch, 0, 0);
		batch.end();	
	}
	
	@Override
	public void resize(int w, int h) {
		super.resize(w, h);
		camera.viewportWidth = w;
		camera.viewportHeight = h;
		camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0);
		camera.update();
	}
	
	@Override
	public void show() {
		super.show();
		font = (BitmapFont)Resources.get("font");
		Gdx.input.setInputProcessor(new TestInputProcessor(camera));
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
	}
	
	@Override
	public void dispose() {
		atlas.dispose();
	}


}
