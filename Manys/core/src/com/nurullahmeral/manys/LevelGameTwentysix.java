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
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.util.ArrayList;
import java.util.Random;

public  class LevelGameTwentysix implements Screen {
    private SpriteBatch batch;
    private Stage stage;
    private Skin skin;
    private CountMoneyGame game3;
    Texture img;
    Texture deste,kazan;
    Texture bir, iki, bes, on, yirmi, elli, yuz;
    Sound ses,sesson;
    ParticleEffect effect;

    Texture loadingBar;
    Texture savebar;
    TextButton button1;
    TextButton button2;
    TextButton button3;
    int gamestate = 0;
    private float paraW, paraH;
    private float paraX, paraY;
    private float parax, paray;
    private float azaltX, azaltY;
    private float barX;
    private float bararttir;
    private ArrayList<Texture> list = new ArrayList<>();
    int time = 2;
    int listposition = 7;
    Random random;
    int deger;
    int a;
    int toplam;
    int bardenek;
    int parasayi = 1;
    private Label label,labelsayi;
    GameOverScreen gameOverScreen;
    GameOverMission gameOverMission;
    private Skin buttonskin;
    private TextureAtlas textureAtlas;
    private TextButton.TextButtonStyle buttononestyle;
    private TextButton buttonone;
    private BitmapFont font;
    private int buttonstate = 1;





    public LevelGameTwentysix(CountMoneyGame game3,GameOverScreen gameOverScreen,GameOverMission gameOverMission) {
        this.gameOverScreen = gameOverScreen;
        this.game3 = game3;
        this.gameOverMission = gameOverMission;

        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
        batch = new SpriteBatch();

        img = game3.getAssetManager().get("kazannarkaplan.png",Texture.class);
        deste = game3.getAssetManager().get("deste.png",Texture.class);
        bir = game3.getAssetManager().get("bir.png",Texture.class);
        iki = game3.getAssetManager().get("iki.png",Texture.class);
        bes = game3.getAssetManager().get("bes.png",Texture.class);
        on = game3.getAssetManager().get("on.png",Texture.class);
        yirmi = game3.getAssetManager().get("yirmi.png",Texture.class);
        elli = game3.getAssetManager().get("elli.png",Texture.class);
        yuz = game3.getAssetManager().get("yuz.png",Texture.class);
        skin = game3.getAssetManager().get("glassy-ui.json",Skin.class);
        ses = game3.getAssetManager().get("ses.mp3",Sound.class);
        sesson = game3.getAssetManager().get("sessonn.mp3",Sound.class);
        effect = game3.getEffect();


        font = game3.getAssetManager().get("myfont.fnt");
        textureAtlas = game3.getAssetManager().get("ui.atlas",TextureAtlas.class);
        buttonskin = new Skin();
        buttonskin.addRegions(textureAtlas);

        buttononestyle = new TextButton.TextButtonStyle();

        buttononestyle.font = font;
        buttononestyle.up = buttonskin.getDrawable("bilgibox");
        buttononestyle.down = buttonskin.getDrawable("bilgibox");


        buttonone = new TextButton("Count 20 money",buttononestyle);
        buttonone.setSize(0.7917f*Gdx.graphics.getWidth(),0.538f*Gdx.graphics.getWidth());
        buttonone.setPosition(0.105f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*6/20);

        if (buttonstate == 1){


            buttonone.addCaptureListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent changeEvent, Actor actor) {
                    buttonone.remove();
                    buttonstate = 2;

                }
            });

        }





        labelsayi = new Label("",skin,"font-big","white");
        labelsayi.setSize(600,100);
        labelsayi.setPosition(50,0);







        loadingBar = game3.getAssetManager().get("bararkaplan.png",Texture.class);
        savebar = game3.getAssetManager().get("baric.png",Texture.class);
        azaltX = 0;
        barX = Gdx.graphics.getWidth()/30;
        random = new Random();
        list.add(bir);
        list.add(iki);
        list.add(bes);
        list.add(on);
        list.add(yirmi);
        list.add(elli);
        list.add(yuz);
        deger = 0;
        toplam = 0;
        time = 5000;
        //rot = 0;
        //  rott =0 ;
        bararttir = 0;
        stage.addActor(labelsayi);
        stage.addActor(buttonone);







        paraW = Gdx.graphics.getWidth();
        paraH = Gdx.graphics.getHeight();
        paraX = 0;
        paraY = 0;
        parax = 0;


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

        effect.update(Gdx.graphics.getDeltaTime());


        batch.begin();
        batch.draw(img, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //  batch.draw(kazan, 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        batch.draw(deste, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(savebar, Gdx.graphics.getWidth() / 15, Gdx.graphics.getHeight() * 9 / 10, barX, Gdx.graphics.getHeight() / 27);
        batch.draw(loadingBar, Gdx.graphics.getWidth() / 15, Gdx.graphics.getHeight() * 9 / 10, Gdx.graphics.getWidth() * 7 / 8, Gdx.graphics.getHeight() / 27);


        if (gamestate != 1){
            if (Gdx.input.isKeyPressed(Input.Keys.BACK)){
                game3.setScreen(game3.missionScreen);
                // missionScreen.setBacksayi(2);



            }
        }

        if (buttonstate == 2){
            labelsayi.setText(String.valueOf(parasayi));

            if (gamestate == 1) {

                if (Gdx.input.isKeyPressed(Input.Keys.BACK)){
                    gamestate = 3;

                }




                if (barX <= Gdx.graphics.getWidth() * 113f / 128f) {
                    if (parasayi<21){

                        bararttir = 9;

                        barX += bararttir;

                    }else {
                        bararttir = 1;
                        barX += bararttir;
                    }


                }
                if (barX > Gdx.graphics.getWidth() * 113f / 128f) {
                    sesson.play(gameOverScreen.getSoundvolume());
                    gamestate = 5;

                    System.out.println("ç");
                }
                if (parasayi == 21) {
                    gamestate = 2;


                }

                //paraX += azaltX;
                paraX -= azaltX;
                //rot -= rott;


                //float deltatime = Gdx.graphics.getDeltaTime();
                //time -= deltatime;
                //System.out.println("time: " + time);
                if (paraX <= (-100 * 10)) {


                    a = random.nextInt(listposition);


                }


                if (paraX <= -100 * 10) {
                    azaltX = 0;
                    //rott = 0;
                    paraX = 0;
                    paraY = 0;
                    //a = random.nextInt(listposition);

                }


                if (Gdx.input.justTouched()) {
                    ses.play(gameOverScreen.getSoundvolume());
                    effect.reset();
                    parasayi += 1;



                    //menuBackground.rotateBy(10f);
                    //menuBackground.addAction(Actions.scaleTo(0,1, 1f));
                    //menuBackground2.addAction(Actions.delay(1f), Actions.scaleTo(1,1, 1f));
                    // menuBackground.addAction(Actions.scaleTo(0,0,0.05f));

                    barX = Gdx.graphics.getWidth() / 30;

                    azaltX = 100;



                    //rott = 5;
                    gamestate = 1;
                    //for (int i = 0; i<listposition; i++) {
                    System.out.println("yazı" + a);
                    System.out.println("deger" + list.get(a));

                    if (a == 0) {
                        toplam = toplam + 1;
                        //time = 5;


                    }

                    if (a == 1) {
                        toplam = toplam + 2;
                        //time = 5;


                    }
                    if (a == 2) {
                        toplam = toplam + 5;
                        //time = 3;


                    }
                    if (a == 3) {
                        toplam = toplam + 10;
                        //time = 5;


                    }
                    if (a == 4) {
                        toplam = toplam + 20;
                        //time = 5;


                    }
                    if (a == 5) {
                        toplam = toplam + 50;
                        //time = 5;


                    }
                    if (a == 6) {
                        toplam = toplam + 100;
                        //time = 5;

                        ;

                    }


                    System.out.println("Toplam:" + toplam);


                } else if (gamestate == 0) {
                    if (Gdx.input.justTouched()) {
                        gamestate = 1;
                    }
                } else if (gamestate == 2) {


                    gameOverScreen.setLeveltwentysixtoplam(gameOverScreen.getLeveltwentysixtoplam() + toplam);
                    parasayi = 1;
                    toplam = 0;
                    azaltX = 0;
                    paraX = 0;
                    System.out.println("nurullah");
                    Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1f);
                    Gdx.gl.glClearColor(GL20.GL_COLOR_BUFFER_BIT, GL20.GL_COLOR_BUFFER_BIT, GL20.GL_COLOR_BUFFER_BIT, GL20.GL_COLOR_BUFFER_BIT);


                    game3.setScreen(game3.gameOverScreen);
                    //   stage.addAction(Actions.sequence(Actions.delay(1.5f),Actions.run(new Runnable() {
                    //      @Override
                    //      public void run() {
                    //          game.setScreen(game.gameOverScreen);
                    //       }
                    //     })));


                    System.out.println("nurullah");
                    //if (Login()){
                    //game.setScreen(new LoginScreen(game));
                    //dispose();


                    //}


                    if (Gdx.input.justTouched()) {
                        gamestate = 1;
                    }

                    a = random.nextInt(listposition);

                    barX = Gdx.graphics.getWidth() / 30;

                } else if (gamestate == 5) {

                    System.out.println("gamestate5");

                    //  gameOverScreen.setToplamgameover(gameOverScreen.getToplamgameover()+toplam);
                    parasayi = 1;
                    bardenek = 5;
                    azaltX = 0;
                    paraX = 0;
                    System.out.println("nurullah");
                    Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1f);
                    Gdx.gl.glClearColor(GL20.GL_COLOR_BUFFER_BIT, GL20.GL_COLOR_BUFFER_BIT, GL20.GL_COLOR_BUFFER_BIT, GL20.GL_COLOR_BUFFER_BIT);

                    gameOverMission.setGameoverstate(29);
                    game3.setScreen(game3.gameOverMission);
                    //   stage.addAction(Actions.sequence(Actions.delay(1.5f),Actions.run(new Runnable() {
                    //      @Override
                    //      public void run() {
                    //          game.setScreen(game.gameOverScreen);
                    //       }
                    //     })));


                    System.out.println("nurullah");
                    //if (Login()){
                    //game.setScreen(new LoginScreen(game));
                    //dispose();


                    //}


                    if (Gdx.input.justTouched()) {
                        gamestate = 1;
                    }
                    toplam = 0;
                    barX = Gdx.graphics.getWidth() / 30;
                    a = random.nextInt(listposition);

                }else if (gamestate == 3){

                    Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1f);
                    Gdx.gl.glClearColor(GL20.GL_COLOR_BUFFER_BIT,GL20.GL_COLOR_BUFFER_BIT,GL20.GL_COLOR_BUFFER_BIT,GL20.GL_COLOR_BUFFER_BIT);

                    game3.setScreen(game3.missionScreen);

                    parasayi = 1;
                    bardenek = 5;

                    if (Gdx.input.justTouched()) {
                        gamestate = 1;
                    }

                    toplam = 0;
                    barX = Gdx.graphics.getWidth()/30;
                    azaltX = 0;
                    paraX = 0;
                    a = random.nextInt(listposition);
                }





                //  batch.draw(list.get(a),0,0,paraW,paraH);
                batch.draw(list.get(a), paraX, paraY, paraW, paraH);
                batch.draw(savebar, Gdx.graphics.getWidth() / 15, Gdx.graphics.getHeight() * 9 / 10, barX, Gdx.graphics.getHeight() / 27);
                effect.draw(batch);
                //  batch.draw(region, paraX, paraY, 100, 100, paraW, paraH,1f, 1f,rot);


                //batch.draw(bir,paraX,paraY,paraW,paraH);


                //}
                //if (p.touchDragged(Gdx.graphics.getWidth()-50,Gdx.graphics.getHeight()-50,1)) {
                //paraX = paraX - azaltX;


                //batch.draw(bir,paraX,paraY,paraW,paraH);


                //};


            }
            //if (gamestate == 3) {

            //batch.draw(list.get(a),paraX,paraY,paraW,paraH);
            //gamestate = 1;

            //}


            else {
                if (Gdx.input.justTouched()) {
                    gamestate = 1;

                }

            }
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

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
        ses.dispose();
        sesson.dispose();
        effect.dispose();


    }
}


