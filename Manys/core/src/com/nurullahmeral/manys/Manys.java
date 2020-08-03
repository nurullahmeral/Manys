package com.nurullahmeral.manys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.Animation;
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
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.util.ArrayList;
import java.util.Random;

public abstract class  Manys implements Screen, InputProcessor {

    private CountMoneyGame game;
    private SpriteBatch batch;
    private Stage stage;
    private Skin skin;
    Texture img;
    Texture deste,kazan;
    Texture bir;
    Texture iki, bes, on, yirmi, elli, yuz;
    Texture slow,stop;
    Sound ses,sesson,ozellikclick;
    Music music;
    int parasayi = 1;


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
    private Label label,labelslow,labelstop;
    String toplamm;
    GameOverScreen gameOverScreen;
    HighScore highScore;
    int kisit,degiskenkisit,parasayikisit;
    int kisittoplam;
    int touchdownstate =0;
    Procesador procesador;
    int degisken= 0;
    int degiskensay = 11;
    float barspeed = 0.3f;






    public Manys(CountMoneyGame game,GameOverScreen gameOverScreen,final HighScore highScore) {
        this.gameOverScreen = gameOverScreen;
        this.highScore = highScore;



        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));

        this.game = game;
        batch = new SpriteBatch();

        img = game.getAssetManager().get("kazannarkaplan.png",Texture.class);
        deste = game.getAssetManager().get("deste.png",Texture.class);
        bir = game.getAssetManager().get("bir.png",Texture.class);
        iki = game.getAssetManager().get("iki.png",Texture.class);
        bes = game.getAssetManager().get("bes.png",Texture.class);
        on = game.getAssetManager().get("on.png",Texture.class);
        yirmi = game.getAssetManager().get("yirmi.png",Texture.class);
        elli = game.getAssetManager().get("elli.png",Texture.class);
        yuz = game.getAssetManager().get("yuz.png",Texture.class);
        slow = game.getAssetManager().get("slowly.png",Texture.class);
        stop = game.getAssetManager().get("stop.png",Texture.class);
        skin = game.getAssetManager().get("glassy-ui.json",Skin.class);
        ses = game.getAssetManager().get("ses.mp3",Sound.class);
        sesson = game.getAssetManager().get("sessonn.mp3",Sound.class);
        ozellikclick = game.getAssetManager().get("ozellikclick.mp3",Sound.class);

        effect = game.getEffect();




        label = new Label("2x Kazanc",skin,"font-big","white");
        label.setSize(600,100);
        label.setPosition(Gdx.graphics.getWidth()*10/15,Gdx.graphics.getHeight()*25/30+150);


        labelslow = new Label("",skin,"font-big","white");
        labelslow.setSize(100,50);
        labelslow.setPosition(Gdx.graphics.getWidth()*9/10-50,Gdx.graphics.getHeight()*31/40+150);


        labelstop = new Label("",skin,"font-big","white");
        labelstop.setSize(100,50);
        labelstop.setPosition(Gdx.graphics.getWidth()*9/10-50,Gdx.graphics.getHeight()*28/40+100);

        toplamm = new String();








        loadingBar = game.getAssetManager().get("bararkaplan.png",Texture.class);
        savebar = game.getAssetManager().get("baric.png",Texture.class);
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


        button1 = new TextButton("",skin,"default");
        button1.setSize(100,100);
        button1.setPosition(Gdx.graphics.getWidth()*9/10,Gdx.graphics.getHeight()*31/40);
        button2 = new TextButton("",skin,"default");
        button2.setSize(100,100);
        button2.setPosition(Gdx.graphics.getWidth()*9/10,Gdx.graphics.getHeight()*14/20);











     //   stage.addActor(label);
        stage.addActor(labelslow);
        stage.addActor(labelstop);








        paraW = Gdx.graphics.getWidth();
        paraH = Gdx.graphics.getHeight();
        paraX = 0;
        paraY = 0;
        parax = 0;


    }

    public Manys(CountMoneyGame game) {
    }

    @Override
    public void show() {
      //  Gdx.input.setInputProcessor(stage);
        Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchBackKey(true);


    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        effect.update(Gdx.graphics.getDeltaTime());












        batch.begin();

        batch.draw(img, 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
       // batch.draw(kazan, 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch.draw(deste,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch.draw(savebar,Gdx.graphics.getWidth()/15,Gdx.graphics.getHeight()*9/10,barX,Gdx.graphics.getHeight()/27);
        batch.draw(loadingBar,Gdx.graphics.getWidth()/15,Gdx.graphics.getHeight()*9/10,Gdx.graphics.getWidth()*7/8,Gdx.graphics.getHeight()/27);
        batch.draw(slow,Gdx.graphics.getWidth()*42/50,Gdx.graphics.getHeight()*32/40,150,150);
        batch.draw(stop,Gdx.graphics.getWidth()*42/50,Gdx.graphics.getHeight()*28/40,150,150);

       // System.out.println("zamanolcer;"+ System.currentTimeMillis()/1000);


        labelslow.setText(String.valueOf(highScore.getSlowlyduration()));
        labelstop.setText(String.valueOf(highScore.getStopduration()));

        if (gamestate != 1){
            if (Gdx.input.isKeyPressed(Input.Keys.BACK)){
                game.setScreen(game.oneScreen);

            }
        }




        if (gamestate == 1) {



            if (Gdx.input.isKeyPressed(Input.Keys.BACK)){
                gamestate = 3;

            }

            if (degisken == 2 && degiskensay<=5){

                if (barX <= Gdx.graphics.getWidth()*113/128) {
                    bararttir = 5;
                    barX += bararttir;

                }
                if (barX > Gdx.graphics.getWidth()*113/128) {
                    sesson.play(gameOverScreen.getSoundvolume());


                    gamestate = 2;
                }
            }

            if (degisken ==3 && degiskensay<= 5){

                if (barX <= Gdx.graphics.getWidth()*113/128) {
                    bararttir = 0;
                    barX += bararttir;

                }
                if (barX > Gdx.graphics.getWidth()*113/128) {
                    sesson.play(gameOverScreen.getSoundvolume());


                    gamestate = 2;
                }

            }

            if (degisken == 0 || degiskensay > 5){

                if (barX <= Gdx.graphics.getWidth()*113/128) {


                    if (parasayi<= 4){
                        bararttir =7;
                    }
                    if (parasayi>4 && parasayi<= 9){
                        bararttir = 8;
                    }
                    if (parasayi>9 && parasayi<= 14){
                        bararttir = 9;
                    }
                    if (parasayi>14 && parasayi<=19){
                        bararttir = 10;
                    }
                    if (parasayi>19 && parasayi<= 29){
                        bararttir = 12;
                    }
                    if (parasayi>29 && parasayi<= 39){
                        bararttir = 13;
                    }
                    if (parasayi>39 && parasayi <= 49){
                        bararttir = 14;
                    }
                    if (parasayi>49){
                        bararttir =15;
                    }



                    barX += bararttir;

                }
                if (barX >Gdx.graphics.getWidth()*113/128) {
                    sesson.play(gameOverScreen.getSoundvolume());


                    gamestate = 2;
                }

            }



            //paraX += azaltX;
            paraX -= azaltX;
            //rot -= rott;







            //float deltatime = Gdx.graphics.getDeltaTime();
            //time -= deltatime;
            //System.out.println("time: " + time);
            if (paraX <= (-100*10) ) {
                a = random.nextInt(listposition);
                kisittoplam = 0;
                degiskenkisit =0;
                parasayikisit = 0;


            }

            if (paraX <= (-100*5)) {
                touchdownstate = 0;
            }

            if (paraX <= -100*10) {
                azaltX = 0;
                //rott = 0;
                paraX = 0;
                paraY = 0;
                //a = random.nextInt(listposition);

            }



           if (paraX == 0){

               if (kisittoplam == 0){
                   if (a == 0) {
                       toplam = toplam +1;
                       kisittoplam = 2;
                       //time = 5;


                   }

                   if (a == 1) {
                       toplam = toplam +2;
                       kisittoplam = 2;
                       //time = 5;


                   }
                   if (a == 2) {
                       toplam = toplam +5;
                       kisittoplam = 2;
                       //time = 3;


                   }
                   if (a == 3) {
                       toplam = toplam +10;
                       kisittoplam = 2;
                       //time = 5;


                   }
                   if (a == 4) {
                       toplam = toplam +20;
                       kisittoplam = 2;
                       //time = 5;


                   }
                   if (a == 5) {
                       toplam = toplam +50;
                       kisittoplam = 2;
                       //time = 5;


                   }
                   if (a == 6) {
                       toplam = toplam +100;
                       kisittoplam = 2;
                       //time = 5;

                       ;

                   }
               }

           }





            if (touchdownstate ==2) {

                if (parasayikisit<2){
                    parasayi += 1;
                    parasayikisit = 2;
                }



                if (degiskenkisit <2){
                    degiskensay += 1;
                    degiskenkisit =2;
                }



                effect.reset();
                if (kisit<2){
                    highScore.setToplammany(highScore.getToplammany()-500);
                    kisit = 2;
                }
               // toplamm.valueOf(toplam);








                //menuBackground.rotateBy(10f);
                //menuBackground.addAction(Actions.scaleTo(0,1, 1f));
                //menuBackground2.addAction(Actions.delay(1f), Actions.scaleTo(1,1, 1f));
                // menuBackground.addAction(Actions.scaleTo(0,0,0.05f));

                barX = Gdx.graphics.getWidth()/30;
                azaltX = 100;
                //rott = 5;
                gamestate =1;
                //for (int i = 0; i<listposition; i++) {
                System.out.println("yazı" + a);
                System.out.println("deger" + list.get(a));




                System.out.println("Toplam:" + toplam);



            } else if (gamestate == 0) {
                if (touchdownstate == 2) {
                    gamestate = 1;
                }
            } else if (gamestate == 2) {
                gameOverScreen.setToplamgameover(gameOverScreen.getToplamgameover()+toplam);
                gameOverScreen.setParasayi(parasayi);
                System.out.println("nurullah");
                Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1f);
                Gdx.gl.glClearColor(GL20.GL_COLOR_BUFFER_BIT,GL20.GL_COLOR_BUFFER_BIT,GL20.GL_COLOR_BUFFER_BIT,GL20.GL_COLOR_BUFFER_BIT);
                toplam = 0;
                kisit = 0;
                kisittoplam = 0;
                touchdownstate = 0;
                barspeed = 0;
                parasayi = 1;
                parasayikisit = 0;


                game.setScreen(game.gameOverScreen);

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


                if (touchdownstate == 2) {
                    gamestate = 1;
                }

                barX = Gdx.graphics.getWidth()/30;

            }else if (gamestate == 3){

                Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1f);
                Gdx.gl.glClearColor(GL20.GL_COLOR_BUFFER_BIT,GL20.GL_COLOR_BUFFER_BIT,GL20.GL_COLOR_BUFFER_BIT,GL20.GL_COLOR_BUFFER_BIT);

                game.setScreen(game.oneScreen);

                kisit = 0;
                kisittoplam = 0;
                barspeed = 0;
                parasayi = 1;
                parasayikisit = 0;

                if (touchdownstate == 2) {
                    gamestate = 1;
                }

                toplam = 0;
                barX = Gdx.graphics.getWidth()/30;
                touchdownstate = 0;
            }



          //  batch.draw(list.get(a),0,0,paraW,paraH);
            batch.draw(list.get(a),paraX,paraY,paraW,paraH);
            batch.draw(savebar,Gdx.graphics.getWidth()/15,Gdx.graphics.getHeight()*9/10,barX,Gdx.graphics.getHeight()/27);
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












        else{
            if (Gdx.input.justTouched()) {
                gamestate = 1;
                touchdownstate = 0;
                barspeed = 0;

            }

        }






        batch.end();

        stage.act();
        stage.draw();



    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        if (screenY >= Gdx.graphics.getHeight()*46/100 || screenX<= Gdx.graphics.getWidth()*3/5){
            ses.play(gameOverScreen.getSoundvolume());

            touchdownstate = 2;
        }

        if (screenX >= Gdx.graphics.getWidth()*42/50 && screenX <= (Gdx.graphics.getWidth()*42/50+150) &&
                screenY <= Gdx.graphics.getHeight()*8/40 && screenY >= ((Gdx.graphics.getHeight()*8/40)-150)){

            ozellikclick.play(gameOverScreen.getSoundvolume());
            degisken = 2;
            degiskensay = 0;
            highScore.setSlowlyduration(highScore.getSlowlyduration()-1);
        }

        if (screenX >= Gdx.graphics.getWidth()*42/50 && screenX <= (Gdx.graphics.getWidth()*42/50+150) &&
                screenY <= Gdx.graphics.getHeight()*12/40 && screenY >= (Gdx.graphics.getHeight()*12/40-150)){
            degisken = 3;
            ozellikclick.play(gameOverScreen.getSoundvolume());
            degiskensay = 0;

            highScore.setStopduration(highScore.getStopduration()-1);
        }






        System.out.println("touchdown deneme"+"screenx"+screenX+"screeny"+screenY);
        return false;
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
