package com.nurullahmeral.manys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class ShopScreen implements Screen {
    private SpriteBatch batch;
    private Stage stage;
    private Skin skin,buttonskin;
    private TextButton usdone,usdtwo,usdtree,usdfour,boxone,boxtwo,boxtree,stop,slowly;
    private TextButton.TextButtonStyle usdonestyle,usdtwostyle,usdtreestyle,usdfourstyle,boxonestyle,boxtwostyle,boxtreestyle,stopstyle,slowlystyle;
    BitmapFont font;
    private TextureAtlas buttonatlas;
    private TextButton play,second,score,emek,easymode,musicbutton;
    Sound click;
    CountMoneyGame game;
    HighScore highScore;
    Label label;
    String stringmany;
    int kisit;
    int x = Gdx.graphics.getWidth();
    int y = Gdx.graphics.getHeight();
    private float buttonx=0.1889f * Gdx.graphics.getWidth();
    private  float buttony=0.3565f * Gdx.graphics.getWidth();



    Texture img,playkapla,kapla,logo,paraonescreen;
    public ShopScreen(final CountMoneyGame game,final HighScore highScore) {
        this.game = game;
        this.highScore = highScore;



        batch = new SpriteBatch();
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
        img = game.getAssetManager().get("arkaplan.png");
        logo = game.getAssetManager().get("shop.png");

        click = game.getAssetManager().get("click.mp3",Sound.class);



        skin = game.getAssetManager().get("glassy-ui.json");

        font = new BitmapFont();





        buttonatlas = game.getAssetManager().get("ui.atlas",TextureAtlas.class);
        buttonskin = new Skin();
        buttonskin.addRegions(buttonatlas);
        usdonestyle = new TextButton.TextButtonStyle();
        usdtreestyle = new TextButton.TextButtonStyle();
        usdtwostyle= new TextButton.TextButtonStyle();
        usdfourstyle = new TextButton.TextButtonStyle();
        boxonestyle = new TextButton.TextButtonStyle();
        boxtwostyle = new TextButton.TextButtonStyle();
        boxtreestyle = new TextButton.TextButtonStyle();
        stopstyle = new TextButton.TextButtonStyle();
        slowlystyle = new TextButton.TextButtonStyle();


        usdonestyle.font = font;
        usdonestyle.up = buttonskin.getDrawable("shopone");
        usdonestyle.down = buttonskin.getDrawable("shopone");

        usdtwostyle.font = font;
        usdtwostyle.up = buttonskin.getDrawable("shoptwo");
        usdtwostyle.down = buttonskin.getDrawable("shoptwo");

        usdtreestyle.font = font;
        usdtreestyle.up = buttonskin.getDrawable("shoptree");
        usdtreestyle.down = buttonskin.getDrawable("shoptree");

        usdfourstyle.font = font;
        usdfourstyle.up = buttonskin.getDrawable("shopfour");
        usdfourstyle.down = buttonskin.getDrawable("shopfour");

        boxonestyle.font = font;
        boxonestyle.up = buttonskin.getDrawable("shopfive");
        boxonestyle.down = buttonskin.getDrawable("shopfive");

        boxtwostyle.font = font;
        boxtwostyle.up = buttonskin.getDrawable("shopsix");
        boxtwostyle.down = buttonskin.getDrawable("shopsix");

        boxtreestyle.font = font;
        boxtreestyle.up = buttonskin.getDrawable("levelnextright");
        boxtreestyle.down = buttonskin.getDrawable("levelnextright");

        stopstyle.font = font;
        stopstyle.up = buttonskin.getDrawable("levelnextleft");
        stopstyle.down = buttonskin.getDrawable("levelnextleft");

        // textButtonStyle.checked = buttonskin.getDrawable("mission");
        usdone = new TextButton("",usdonestyle);
        usdone.setSize(buttonx,buttony);
        usdone.setPosition(x*17/105,y*490/1000);

        usdtwo = new TextButton("",usdtwostyle);
        usdtwo.setSize(buttonx,buttony);
        usdtwo.setPosition(x*42/105,y*490/1000);

        usdtree = new TextButton("",usdtreestyle);
        usdtree.setSize(buttonx,buttony);
        usdtree.setPosition(x*67/105,y*490/1000);

        usdfour = new TextButton("",usdfourstyle);
        usdfour.setSize(buttonx,buttony);
        usdfour.setPosition(x*17/105,y*200/1000);

        boxone = new TextButton("",boxonestyle);
        boxone.setSize(buttonx,buttony);
        boxone.setPosition(x*42/105,Gdx.graphics.getHeight()*200/1000);

        boxtwo = new TextButton("",boxtwostyle);
        boxtwo.setSize(buttonx,buttony);
        boxtwo.setPosition(x*67/105,Gdx.graphics.getHeight()*200/1000);


        boxtree = new TextButton("",boxtreestyle);
        boxtree.setSize(Gdx.graphics.getWidth()*163/1080,Gdx.graphics.getWidth()*3/20);
        boxtree.setPosition(x*70/135,Gdx.graphics.getHeight()*1/12);

        stop = new TextButton("",stopstyle);
        stop.setSize(Gdx.graphics.getWidth()*163/1080,Gdx.graphics.getWidth()*3/20);
        stop.setPosition(x*45/135,Gdx.graphics.getHeight()*1/12);






        label = new Label("",skin,"font-big","white");
        label.setSize(600,100);
        label.setPosition(50,Gdx.graphics.getHeight()*1/40);

        usdone.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                click.play();

            }
        });


        usdtwo.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                click.play();

            }
        });

        usdtree.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                click.play();

            }
        });

        usdfour.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                click.play();

            }
        });

        boxone.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                click.play();

            }
        });

        boxtwo.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                click.play();

            }
        });

        boxtree.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                click.play();

            }
        });


        stop.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                click.play();

            }
        });














        stage.addActor(usdone);
        stage.addActor(usdtwo);
        stage.addActor(usdtree);
        stage.addActor(usdfour);
        stage.addActor(boxone);
        stage.addActor(boxtwo);
        stage.addActor(boxtree);
        stage.addActor(stop);



        //   stage.addActor(play);
        //    stage.addActor(easymode);
        //   stage.addActor(second);
        //    stage.addActor(score);
        //   stage.addActor(emek);
        //   stage.addActor(label);
        // stage.addActor(musicbutton);
    }




    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public void dispose() {
        stage.dispose();

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
        batch.draw(logo, 0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        //  batch.draw(kapla, Gdx.graphics.getWidth()*14/15,Gdx.graphics.getHeight()*502/1000,Gdx.graphics.getWidth()*7/100,Gdx.graphics.getHeight()/25);
        //    batch.draw(playkapla, Gdx.graphics.getWidth()*8/15,Gdx.graphics.getHeight()*20/40,Gdx.graphics.getWidth()*5/45,Gdx.graphics.getHeight()/35);
        //    batch.draw(playkapla, Gdx.graphics.getWidth()*8/15,Gdx.graphics.getHeight()*16/40,Gdx.graphics.getWidth()*5/45,Gdx.graphics.getHeight()/35);
        //    batch.draw(playkapla, Gdx.graphics.getWidth()*8/15,Gdx.graphics.getHeight()*12/40,Gdx.graphics.getWidth()*5/45,Gdx.graphics.getHeight()/35);

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
