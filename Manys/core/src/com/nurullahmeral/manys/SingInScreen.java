package com.nurullahmeral.manys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class SingInScreen implements Screen {
    CountMoneyGame game5;
    private SpriteBatch batch;
    private Texture gameoverone,img;
    private Stage stage;
    private Skin skin,buttonskin;
    private Label label;
    private TextButton yes,no;
    private TextButton.TextButtonStyle yesstyle,nostyle;
    private BitmapFont font;
    private TextureAtlas buttonatlas;
    private int toplamgameoverone;
    Music music2;
    int gameoverstate;
    float buttonboy = 0.198f * Gdx.graphics.getWidth();
    private TextField usernameTextField,paswordTextField;









    public SingInScreen(final CountMoneyGame game5){
        this.game5 = game5;

        batch = new SpriteBatch();
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
        skin = game5.getAssetManager().get("glassy-ui.json");
        gameoverone = game5.getAssetManager().get("arkaplan.png");
        img = game5.getAssetManager().get("youlosemission.png");
        font = new BitmapFont();

        usernameTextField = new TextField("",skin);
        usernameTextField.setPosition(Gdx.graphics.getWidth()*1/10,Gdx.graphics.getHeight()*5/10);
        usernameTextField.setSize(Gdx.graphics.getWidth()*8/10, 100);

        paswordTextField = new TextField("",skin);
        paswordTextField.setPosition(Gdx.graphics.getWidth()*1/10,Gdx.graphics.getHeight()*4/10);
        paswordTextField.setSize(Gdx.graphics.getWidth()*8/10, 100);

        stage.addActor(usernameTextField);
        stage.addActor(paswordTextField);

        buttonatlas = game5.getAssetManager().get("ui.atlas",TextureAtlas.class);
        buttonskin = new Skin();
        buttonskin.addRegions(buttonatlas);
        yesstyle = new TextButton.TextButtonStyle();
        nostyle = new TextButton.TextButtonStyle();

        yesstyle.font = font;
        yesstyle.up = buttonskin.getDrawable("retryscore");
        yesstyle.down = buttonskin.getDrawable("retryscore");


        nostyle.font = font;
        nostyle.up = buttonskin.getDrawable("closescore");
        nostyle.down = buttonskin.getDrawable("closescore");


        yes = new TextButton("",yesstyle);
        yes.setSize(buttonboy,buttonboy);
        yes.setPosition(Gdx.graphics.getWidth()*5/20,Gdx.graphics.getHeight()*6/50);

        no = new TextButton("",nostyle);
        no.setSize(buttonboy,buttonboy);
        no.setPosition(Gdx.graphics.getWidth()*11/20,Gdx.graphics.getHeight()*6/50);


        stage.addActor(yes);
        stage.addActor(no);


        yes.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {

              // game5.playServices.onSignInButtonClicked();

            }
        });

        no.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
               // game5.playServices.onSignOutButtonClicked();

            }
        });



        // stage.addActor(label);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        Gdx.input.setCatchBackKey(true);

    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        stage.dispose();
        batch.dispose();
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();







        batch.draw(gameoverone, 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());


        if (Gdx.input.isKeyPressed(Input.Keys.BACK)){
           // game5.setScreen(game5.missionScreen);
        }





        batch.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }



}
