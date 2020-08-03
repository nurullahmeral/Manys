package com.nurullahmeral.manys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class SettingScreen implements Screen {
    private SpriteBatch batch;
    private Stage stage;
    private Skin skin,buttonskin;
    private TextButton bildirimbutton,musicbuttonn,soundbutton,vibrationbutton;
    private TextButton.TextButtonStyle bildirimStyle;
    BitmapFont font;
    private TextureAtlas buttonatlas;
    CountMoneyGame game;
    HighScore highScore;
    Label label;
    String stringmany;
    int kisit;
    Music music2;
    int buttonx = Gdx.graphics.getWidth()*23/108;
    int buttony = Gdx.graphics.getWidth()*2/47;

    GameOverMission gameOverMission;
    GameOverScreen gameOverScreen;

    Texture img,logo,paraonescreen;
    public SettingScreen(final CountMoneyGame game,final HighScore highScore,final GameOverMission gameOverMission,final GameOverScreen gameOverScreen) {
        this.game = game;
        this.highScore = highScore;
        this.gameOverScreen = gameOverScreen;
        this.gameOverMission = gameOverMission;



        batch = new SpriteBatch();
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
        img = game.getAssetManager().get("arkaplan.png");
        logo = game.getAssetManager().get("settings.png");

        skin = game.getAssetManager().get("glassy-ui.json");

        font = new BitmapFont();

        music2 = Gdx.audio.newMusic(Gdx.files.internal("song.mp3"));
        music2.setLooping(true);
        music2.setVolume(1f);
        music2.play();








        buttonatlas = game.getAssetManager().get("ui.atlas",TextureAtlas.class);
        buttonskin = new Skin();
        buttonskin.addRegions(buttonatlas);
        bildirimStyle = new TextButton.TextButtonStyle();




        bildirimStyle.font = font;
        bildirimStyle.up = buttonskin.getDrawable("settingson");
        bildirimStyle.checked = buttonskin.getDrawable("settingsof");


        // textButtonStyle.checked = buttonskin.getDrawable("mission");
        bildirimbutton = new TextButton("",bildirimStyle);
        bildirimbutton.setSize(buttonx,buttony);
        bildirimbutton.setPosition(Gdx.graphics.getWidth()*14/24,Gdx.graphics.getHeight()*72/200);

        musicbuttonn = new TextButton("",bildirimStyle);
        musicbuttonn.setSize(buttonx,buttony);
        musicbuttonn.setPosition(Gdx.graphics.getWidth()*14/24,Gdx.graphics.getHeight()*112/200);

        soundbutton = new TextButton("",bildirimStyle);
        soundbutton.setSize(buttonx,buttony);
        soundbutton.setPosition(Gdx.graphics.getWidth()*14/24,Gdx.graphics.getHeight()*92/200);

        musicbuttonn.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {




                if (music2.getVolume()>0f){

                    music2.setVolume(0f);

                }else{

                    music2.setVolume(1f);


                }

            }
        });



        soundbutton.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                if (gameOverScreen.getSoundvolume()> 0){
                    gameOverScreen.setSoundvolume(0);
                }else {
                    gameOverScreen.setSoundvolume(1);
                }
            }
        });




























        stage.addActor(musicbuttonn);

        stage.addActor(bildirimbutton);
        stage.addActor(soundbutton);


    }




    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public void dispose() {
        stage.dispose();
        batch.dispose();

    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
     //   batch.draw(logo, 0, Gdx.graphics.getHeight()*27/40,Gdx.graphics.getWidth(),300);
        batch.draw(logo, 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());










        if (Gdx.input.isKeyPressed(Input.Keys.BACK)){
              game.setScreen(game.oneScreen);

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
