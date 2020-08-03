package com.nurullahmeral.manys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateByAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.util.ArrayList;
import java.util.Random;

public  class BonusScreen implements Screen {
    private SpriteBatch batch;
    private Stage stage;
    private Skin skin,buttonskin;
    private TextureAtlas textureAtlas;
    private TextButton.TextButtonStyle button1style,button2style,button3style,button4style,buttontoplastyle;
    private BitmapFont font;

    private CountMoneyGame game2;
    Texture img,img2;


    Texture loadingBar,loadingbar2,loadingbar3,loadingbar4;
    Texture savebar,savebar2,savebar3,savebar4;
    TextButton button1;
    TextButton button2;
    TextButton button3,button4,buttontopla;
    int gamestate = 0;
    private float barX,barx2,barx3,barx4;
    private float bararttir;
    private ArrayList<Texture> list = new ArrayList<>();
    int time = 2;
    int listposition = 7;
    Random random;
    int deger;
    int a;
    int toplam;
    int kisit,kisittoplam;
    private Label label;
    GameOverScreen gameOverScreen;
    HighScore highScore;
    long starttime,starttimetwo,starttimetree,starttimefour;
    int buttonboy = 144;






    public BonusScreen(final CountMoneyGame game2,final HighScore highScore) {
        this.game2 = game2;
        this.highScore = highScore;



        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));

        batch = new SpriteBatch();

        img = game2.getAssetManager().get("arkaplan.png",Texture.class);
        img2 = game2.getAssetManager().get("bonustext.png");

        skin = game2.getAssetManager().get("glassy-ui.json",Skin.class);

        font = game2.getAssetManager().get("myfont.fnt");

        textureAtlas = game2.getAssetManager().get("ui.atlas",TextureAtlas.class);
        buttonskin = new Skin();
        buttonskin.addRegions(textureAtlas);

        button1style = new TextButton.TextButtonStyle();
        button2style = new TextButton.TextButtonStyle();
        button3style = new TextButton.TextButtonStyle();
        button4style = new TextButton.TextButtonStyle();
        buttontoplastyle = new TextButton.TextButtonStyle();



        button1style.font = font;
        button1style.up = buttonskin.getDrawable("bin");
        button1style.down = buttonskin.getDrawable("bin");


        button2style.font = font;
        button2style.up = buttonskin.getDrawable("slowly");
        button2style.down = buttonskin.getDrawable("slowly");


        button3style.font = font;
        button3style.up = buttonskin.getDrawable("stop");
        button3style.down = buttonskin.getDrawable("stop");


        button4style.font = font;
        button4style.up = buttonskin.getDrawable("ikibin");
        button4style.down = buttonskin.getDrawable("ikibin");

        buttontoplastyle.font = font;
        buttontoplastyle.up = buttonskin.getDrawable("victory");
        buttontoplastyle.down = buttonskin.getDrawable("victory");


        button1 = new TextButton("",button1style);
        button1.setSize(2*0.11852f*Gdx.graphics.getWidth(),2*0.0787f*Gdx.graphics.getWidth());
        button1.setPosition(Gdx.graphics.getWidth()*560/800,Gdx.graphics.getHeight()*204/300);

        button2 = new TextButton("",button2style);
        button2.setSize(0.1602f*Gdx.graphics.getWidth(),0.1602f*Gdx.graphics.getWidth());
        button2.setPosition(Gdx.graphics.getWidth()*6/8,Gdx.graphics.getHeight()*152/300);


        button3 = new TextButton("",button3style);
        button3.setSize(0.1602f*Gdx.graphics.getWidth(),0.1602f*Gdx.graphics.getWidth());
        button3.setPosition(Gdx.graphics.getWidth()*6/8,Gdx.graphics.getHeight()*102/300);


        button4 = new TextButton("",button4style);
        button4.setSize(2*0.11852f*Gdx.graphics.getWidth(),2*0.0787f*Gdx.graphics.getWidth());
        button4.setPosition(Gdx.graphics.getWidth()*57/80,Gdx.graphics.getHeight()*54/300);

        buttontopla = new TextButton("Watch video to get a surpise",buttontoplastyle);
        buttontopla.setSize(0.7f*Gdx.graphics.getWidth(),0.1f*Gdx.graphics.getWidth());
        buttontopla.setPosition(0.150f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*1/20);

        stage.addActor(button1);
        stage.addActor(button2);
        stage.addActor(button3);
        stage.addActor(button4);
        stage.addActor(buttontopla);

        loadingBar = game2.getAssetManager().get("bararkaplan.png",Texture.class);
        savebar = game2.getAssetManager().get("baric.png",Texture.class);

        loadingbar2 = game2.getAssetManager().get("bararkaplan.png",Texture.class);
        savebar2 = game2.getAssetManager().get("baric.png",Texture.class);

        loadingbar3 = game2.getAssetManager().get("bararkaplan.png",Texture.class);
        savebar3 = game2.getAssetManager().get("baric.png",Texture.class);

        loadingbar4 = game2.getAssetManager().get("bararkaplan.png",Texture.class);
        savebar4 = game2.getAssetManager().get("baric.png",Texture.class);


        //rot = 0;
        //  rott =0 ;
        bararttir = 0;

        if ((int) kisit < 2){
            barX = Gdx.graphics.getWidth()*0.625f;
            barx2 = Gdx.graphics.getWidth()*0.625f;
            barx3 = Gdx.graphics.getWidth()*0.625f;
            barx4 = Gdx.graphics.getWidth()*0.625f;

            kisit = 2;
        }








    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        Gdx.input.setCatchBackKey(true);

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        batch.begin();
        batch.draw(img, 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch.draw(img2, 0, Gdx.graphics.getHeight()*16/20,Gdx.graphics.getWidth(),0.2445f*Gdx.graphics.getWidth());

        if (highScore.getIlkgames()<3){
            starttime =  TimeUtils.millis();
            highScore.setStatedurationone((int) starttime);

            highScore.setIlkgames(3);
        }

        starttime = highScore.getStatedurationone();
        starttimetwo = highScore.getStatedurationtwo();
        starttimetree = highScore.getStatedurationtree();
        starttimefour = highScore.getStatedurationfour();
        //  batch.draw(kazan, 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());


        batch.draw(savebar,Gdx.graphics.getWidth()/15,Gdx.graphics.getHeight()*21/30,barX,Gdx.graphics.getHeight()/27);
        batch.draw(loadingBar,Gdx.graphics.getWidth()/15,Gdx.graphics.getHeight()*21/30,Gdx.graphics.getWidth()*5/8,Gdx.graphics.getHeight()/27);

        batch.draw(savebar2,Gdx.graphics.getWidth()/15,Gdx.graphics.getHeight()*16/30,barx2,Gdx.graphics.getHeight()/27);
        batch.draw(loadingbar2,Gdx.graphics.getWidth()/15,Gdx.graphics.getHeight()*16/30,Gdx.graphics.getWidth()*5/8,Gdx.graphics.getHeight()/27);

        batch.draw(savebar3,Gdx.graphics.getWidth()/15,Gdx.graphics.getHeight()*11/30,barx3,Gdx.graphics.getHeight()/27);
        batch.draw(loadingbar3,Gdx.graphics.getWidth()/15,Gdx.graphics.getHeight()*11/30,Gdx.graphics.getWidth()*5/8,Gdx.graphics.getHeight()/27);

        batch.draw(savebar4,Gdx.graphics.getWidth()/15,Gdx.graphics.getHeight()*6/30,barx4,Gdx.graphics.getHeight()/27);
        batch.draw(loadingbar4,Gdx.graphics.getWidth()/15,Gdx.graphics.getHeight()*6/30,Gdx.graphics.getWidth()*5/8,Gdx.graphics.getHeight()/27);




        if (Gdx.input.isKeyPressed(Input.Keys.BACK)){

            game2.setScreen(game2.oneScreen);


        }



        if (barX <= Gdx.graphics.getWidth()*0.625f) {

            if (barX>= Gdx.graphics.getWidth()*0.620f){
                barX = Gdx.graphics.getWidth()*0.625f;
            }else{
                barX = (int) TimeUtils.timeSinceMillis(starttime)/10000;
            }



        }

        if (barx2 <= Gdx.graphics.getWidth()*0.625f) {

            if (barx2>= Gdx.graphics.getWidth()*0.620f){
                barx2 = Gdx.graphics.getWidth()*0.625f;
            }else {
                barx2 = (int) TimeUtils.timeSinceMillis(starttimetwo) / 60000;
            }





        }

        if (barx3 <= Gdx.graphics.getWidth()*0.625f) {

            if (barx3>= Gdx.graphics.getWidth()*0.620f){
                barx3 = Gdx.graphics.getWidth()*0.625f;
            }else{
                barx3 = (int) TimeUtils.timeSinceMillis(starttimetree)/120000;
            }



        }

        if (barx4 <= Gdx.graphics.getWidth()*0.625f) {

            if (barx4>= Gdx.graphics.getWidth()*0.620f){
                barx4 = Gdx.graphics.getWidth()*0.625f;
            }else{
                barx4 = (int) TimeUtils.timeSinceMillis(starttimefour)/240000;
            }



        }


        if (barX >= Gdx.graphics.getWidth()*0.625f ){
            button1.addCaptureListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent changeEvent, Actor actor) {

                    if (barX >= Gdx.graphics.getWidth()*0.625f ){
                        highScore.setStatedurationone((int)TimeUtils.millis());
                        barX = 0;
                    }else {
                        System.out.println("Daha zamanı değil" );
                    }

                }
            });
        }

        if (barx2 >= Gdx.graphics.getWidth()*0.625f ){

            button2.addCaptureListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent changeEvent, Actor actor) {

                    if (barx2 >= Gdx.graphics.getWidth()*0.625f ){
                        highScore.setStatedurationtwo((int) TimeUtils.millis());
                        barx2 = 0;
                    }else{
                        System.out.println("daha zamanı değil");
                    }


                }
            });
        }

        if (barx3 >= Gdx.graphics.getWidth()*0.625f ){
            button3.addCaptureListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent changeEvent, Actor actor) {
                    if (barx3 >= Gdx.graphics.getWidth()*0.625f ){
                        highScore.setStatedurationtree((int) TimeUtils.millis());
                        barx3 = 0;

                    }else{
                        System.out.println("daha zamanı değil");
                    }

                }
            });
        }

        if (barx4 >= Gdx.graphics.getWidth()*0.625f ){
            button4.addCaptureListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent changeEvent, Actor actor) {
                    if (barx4 >= Gdx.graphics.getWidth()*0.625f ){
                        highScore.setStatedurationofour((int) TimeUtils.millis());
                        barx4 = 0;
                    }else{
                        System.out.println("Daha zamanı değil");
                    }


                }
            });
        }

        System.out.println(barX);


        batch.draw(savebar,Gdx.graphics.getWidth()/15,Gdx.graphics.getHeight()*21/30,barX,Gdx.graphics.getHeight()/27);
        batch.draw(savebar2,Gdx.graphics.getWidth()/15,Gdx.graphics.getHeight()*16/30,barx2,Gdx.graphics.getHeight()/27);
        batch.draw(savebar3,Gdx.graphics.getWidth()/15,Gdx.graphics.getHeight()*11/30,barx3,Gdx.graphics.getHeight()/27);
        batch.draw(savebar4,Gdx.graphics.getWidth()/15,Gdx.graphics.getHeight()*6/30,barx4,Gdx.graphics.getHeight()/27);




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

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);

    }

    @Override
    public void dispose() {
        stage.dispose();



    }
}

