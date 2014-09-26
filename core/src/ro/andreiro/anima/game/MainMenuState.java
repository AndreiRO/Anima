package ro.andreiro.anima.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainMenuState extends GameState {

	private BitmapFont font;
	private Stage stage;
	private Skin skin;
	private Label label;
	private TextButton play;
	private TextButton options;
	private TextButton credits;
	private TextButton quit;
	private Table table;
	private TextureAtlas atlas;

	
	public MainMenuState() {
		super();
	}
	
	@Override
	public void init(GameStateManager m) {
		super.init(m);
		initializeFont();
		initializeUI();
		
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act(delta);
		stage.draw();
		
	}
	
	private void initializeUI() {
		atlas = new TextureAtlas(Gdx.files.internal("ui/ui.pack"));
		skin = new Skin(atlas);
		stage = new Stage();
		table = new Table();
		
		final TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.getDrawable("button-up");
		textButtonStyle.down = skin.getDrawable("button-down");
		textButtonStyle.pressedOffsetX = 2;
		textButtonStyle.pressedOffsetX = -2;
		textButtonStyle.font = font;
		textButtonStyle.fontColor = Color.RED;

		play = new TextButton("Play", textButtonStyle);
		play.addListener(new ClickListener() {
			@Override
			public void clicked (InputEvent event, float x, float y) {
				changeTo(State.PLAY);
			}
		});
		
		options = new TextButton("Options", textButtonStyle);
		options.addListener(new ClickListener() {
			@Override
			public void clicked (InputEvent event, float x, float y) {
				System.out.println("Options");
			}
			
		});
		
		credits = new TextButton("Credits", textButtonStyle);
		credits.addListener(new ClickListener() {
			@Override
			public void clicked (InputEvent event, float x, float y) {
				System.out.println("Credits");
			}
			
		});

		quit = new TextButton("Quit", textButtonStyle);
		quit.addListener(new ClickListener() {
			@Override
			public void clicked (InputEvent event, float x, float y) {
				Gdx.app.exit();
			}
			
		});
	
		
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = font;
		labelStyle.fontColor = Color.RED;
		
		label = new Label("Anima v1.0", labelStyle);
		
		table.setFillParent(true);
		
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		table.add(label).padBottom(60).row();
		table.add(play).padBottom(20).row();
		table.add(options).padBottom(20).row();
		table.add(credits).padBottom(20).row();
		table.add(quit).padBottom(20).row();
		
		stage.addActor(table);
		
		Gdx.input.setInputProcessor(stage);
		
	}
	
	private void changeTo(State state) {
		super.paused = true;
		super.manager.setState(state);
	}
	
	private void initializeFont() {
		font = new BitmapFont(Gdx.files.internal("fonts/font.fnt"));
		font.setColor(Color.YELLOW);
		Resources.set("font", font);
	}
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
	}
	
	@Override
	public void resize(int width, int height) {
	    stage.getViewport().update(width, height, true);
	}
	
	@Override
	public void dispose() {
		atlas.dispose();
		font.dispose();
		stage.dispose();
		skin.dispose();
	}
	
}
