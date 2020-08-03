package com.nurullahmeral.manys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.awt.SplashScreen;

import static com.badlogic.gdx.Gdx.app;

public  class LoadingScreen implements Screen {

    private Stage stage;
    private Skin skin;
    private Label label;
    SpriteBatch batch;
    Texture img,img2;
    CountMoneyGame game;
    long starttime;

    public LoadingScreen(CountMoneyGame game) {



        this.game = game;
        starttime = TimeUtils.millis();
        batch = new SpriteBatch();
        img = new Texture("arkaplan.png");
        img2 = new Texture("logo.png");


        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
        skin = new Skin(Gdx.files.internal("glassy-ui.json"));



        label = new Label("Loading...",skin,"font-big","white");
        label.setSize(600,100);
        label.setPosition(Gdx.graphics.getWidth()*4/12,Gdx.graphics.getHeight()*3/7);


        stage.addActor(label);


    }



    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);


    }


    @Override
    public void render(float d) {


        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
      //  batch.draw(img, 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch.draw(img2, 0, Gdx.graphics.getHeight()*27/40,Gdx.graphics.getWidth(),300);


        if (game.getAssetManager().update() && TimeUtils.timeSinceMillis(starttime)>10000) {

            game.FinishLoading();

        }else{

            label.setText("Loading... ");
        }

        batch.end();

        stage.act();
        stage.draw();



    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }


    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }


}
