package com.nurullahmeral.manys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
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
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class OneScreen implements Screen {
    private SpriteBatch batch;
    private Stage stage;
    private Skin skin,buttonskin;
    private TextButton denemebutton,musicbuttonn,easybutton,timebutton,missionbutton,shopbutton,scorebutton,buttonone,buttontwo,
    buttontree,buttonfour,buttonfive,parabar,slowbar,stopbar,levelbar,kalp;
    private TextButton.TextButtonStyle textButtonStyle,musicstyle,easystyle,timestyle,missionstyle,shopstyle,scorestyle,buttononestyle,
    buttontwostyle,buttontreestyle,buttonfourstyle,buttonfivestyle,parabarstyle,slowbarstyle,stopbarstyle,levelbarstyle,levelbaronestyle,
    levelbartwostyle,levelbartreestyle,kalpstyle,kalpstyleone;
    BitmapFont font;
    private TextureAtlas buttonatlas;
    private TextButton play,second,score,emek,easymode,musicbutton;
    CountMoneyGame game;
    HighScore highScore;
    Label label;
    String stringmany;
    int kisit;
    int buttonx = 532;
    int buttony = 115;
    int buttonboy = 144;
    int buttonkisit;
    float buttonarttir = 0.0602f*Gdx.graphics.getWidth();
    GameOverMission gameOverMission;
    int batcdeneme;
    long started,started2;
    private int historystate,histortystatetwo,historystatetree;
    int barseviye;
    int bonusstate;




    Texture img,playkapla,kapla,logo,paraonescreen;
    public OneScreen(final CountMoneyGame game,final HighScore highScore,final GameOverMission gameOverMission) {
        this.game = game;
        this.highScore = highScore;



        batch = new SpriteBatch();
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
        img = game.getAssetManager().get("arkaplan.png");
        logo = game.getAssetManager().get("logo.png");
        paraonescreen = game.getAssetManager().get("anaekranpara.png");

        skin = game.getAssetManager().get("glassy-ui.json");

        font = game.getAssetManager().get("myfont.fnt");

        started = TimeUtils.millis();





        buttonatlas = game.getAssetManager().get("ui.atlas",TextureAtlas.class);
        buttonskin = new Skin();
        buttonskin.addRegions(buttonatlas);
        textButtonStyle = new TextButton.TextButtonStyle();
        easystyle = new TextButton.TextButtonStyle();
        timestyle = new TextButton.TextButtonStyle();
        missionstyle = new TextButton.TextButtonStyle();

        buttononestyle = new TextButton.TextButtonStyle();
        buttontwostyle = new TextButton.TextButtonStyle();
        buttontreestyle = new TextButton.TextButtonStyle();
        buttonfourstyle = new TextButton.TextButtonStyle();
        buttonfivestyle = new TextButton.TextButtonStyle();
        parabarstyle = new TextButton.TextButtonStyle();
        levelbarstyle = new TextButton.TextButtonStyle();
        levelbaronestyle = new TextButton.TextButtonStyle();
        levelbartwostyle = new TextButton.TextButtonStyle();
        levelbartreestyle = new TextButton.TextButtonStyle();
        stopbarstyle = new TextButton.TextButtonStyle();
        slowbarstyle = new TextButton.TextButtonStyle();
        kalpstyle = new TextButton.TextButtonStyle();
        kalpstyleone = new TextButton.TextButtonStyle();

        parabarstyle.font = font;
        parabarstyle.up = buttonskin.getDrawable("manybar");
        parabarstyle.down = buttonskin.getDrawable("manybar");

        levelbarstyle.font = font;
        levelbarstyle.up = buttonskin.getDrawable("levelbar");
        levelbarstyle.down = buttonskin.getDrawable("levelbar");

        levelbaronestyle.font = font;
        levelbaronestyle.up = buttonskin.getDrawable("levelbarone");
        levelbaronestyle.down = buttonskin.getDrawable("levelbarone");

        levelbartwostyle.font = font;
        levelbartwostyle.up = buttonskin.getDrawable("levelbartwo");
        levelbartwostyle.down = buttonskin.getDrawable("levelbartwo");

        levelbartreestyle.font = font;
        levelbartreestyle.up = buttonskin.getDrawable("levelbartree");
        levelbartreestyle.down = buttonskin.getDrawable("levelbartree");

        slowbarstyle.font = font;
        slowbarstyle.up = buttonskin.getDrawable("slowbar");
        slowbarstyle.down = buttonskin.getDrawable("slowbar");

        stopbarstyle.font = font;
        stopbarstyle.up = buttonskin.getDrawable("stopbar");
        stopbarstyle.down = buttonskin.getDrawable("stopbar");

        kalpstyle.font = font;
        kalpstyle.up = buttonskin.getDrawable("kalp");
        kalpstyle.down = buttonskin.getDrawable("kalp");

        kalpstyleone.font = font;
        kalpstyleone.up = buttonskin.getDrawable("kalpone");
        kalpstyleone.down = buttonskin.getDrawable("kalpone");





        buttononestyle.font = font;
        buttononestyle.up = buttonskin.getDrawable("buttonone");
        buttononestyle.down = buttonskin.getDrawable("buttononeclick");


        buttontwostyle.font = font;
        buttontwostyle.up = buttonskin.getDrawable("buttontwo");
        buttontwostyle.down = buttonskin.getDrawable("buttontwoclick");


        buttontreestyle.font = font;
        buttontreestyle.up = buttonskin.getDrawable("buttontree");
        buttontreestyle.down = buttonskin.getDrawable("buttontreeclick");


        buttonfourstyle.font = font;
        buttonfourstyle.up = buttonskin.getDrawable("buttonfour");
        buttonfourstyle.down = buttonskin.getDrawable("buttonfourclick");


        buttonfivestyle.font = font;
        buttonfivestyle.up = buttonskin.getDrawable("buttonfive");
        buttonfivestyle.down = buttonskin.getDrawable("buttonfiveclick");

        easystyle.font = font;
        easystyle.up = buttonskin.getDrawable("easy");
        easystyle.down = buttonskin.getDrawable("clickgider");

        timestyle.font = font;
        timestyle.up = buttonskin.getDrawable("twentyseconds");
        timestyle.down = buttonskin.getDrawable("secondsclick");

        missionstyle.font = font;
        missionstyle.up = buttonskin.getDrawable("missions");
        missionstyle.down = buttonskin.getDrawable("missionsclick");




        textButtonStyle.font = font;
        textButtonStyle.up = buttonskin.getDrawable("classic");
        textButtonStyle.down = buttonskin.getDrawable("clickgider");
       // textButtonStyle.checked = buttonskin.getDrawable("mission");

        kalp = new TextButton("",kalpstyle);
        kalp.setSize(0.07685f*Gdx.graphics.getWidth(),0.07315f*Gdx.graphics.getWidth());
        kalp.setPosition(Gdx.graphics.getWidth()*54/60,Gdx.graphics.getHeight()*1680/2000);



        levelbar = new TextButton("",levelbarstyle);
        levelbar.setSize(0.342f*Gdx.graphics.getWidth(),0.0981f*Gdx.graphics.getWidth());
        levelbar.setPosition(Gdx.graphics.getWidth()*1/60,Gdx.graphics.getHeight()*1809/2000);
        levelbar.getLabel().setAlignment(Align.left);

        parabar = new TextButton("",parabarstyle);
        parabar.setSize(0.2713f*Gdx.graphics.getWidth(),0.0537f*Gdx.graphics.getWidth());
        parabar.setPosition(Gdx.graphics.getWidth()*14/20,Gdx.graphics.getHeight()*182/200);
        parabar.getLabel().setFontScale(0.6f,0.6f);
        parabar.getLabel().setAlignment(Align.left);
      //  parabar.getLabel().setColor(Color.BLACK);
        stopbar = new TextButton("",stopbarstyle);
        stopbar.setSize(0.112f*Gdx.graphics.getWidth(),0.0574f*Gdx.graphics.getWidth());
        stopbar.setPosition(Gdx.graphics.getWidth()*11/20,Gdx.graphics.getHeight()*727/800);
        stopbar.getLabel().setFontScale(0.6f,0.6f);
        stopbar.getLabel().setAlignment(Align.left);
        slowbar = new TextButton("",slowbarstyle);
        slowbar.setSize(0.112f*Gdx.graphics.getWidth(),0.0574f*Gdx.graphics.getWidth());
        slowbar.setPosition(Gdx.graphics.getWidth()*8/20,Gdx.graphics.getHeight()*727/800);
        slowbar.getLabel().setFontScale(0.6f,0.6f);
        slowbar.getLabel().setAlignment(Align.left);;




        denemebutton = new TextButton("",textButtonStyle);
        denemebutton.setSize(buttonx,buttony);
        denemebutton.setPosition(Gdx.graphics.getWidth()*11/24,Gdx.graphics.getHeight()*99/200);

        easybutton = new TextButton("",easystyle);
        easybutton.setSize(buttonx,buttony);
        easybutton.setPosition(Gdx.graphics.getWidth()*11/24,Gdx.graphics.getHeight()*76/200);

        timebutton = new TextButton("",timestyle);
        timebutton.setSize(buttonx,buttony);
        timebutton.setPosition(Gdx.graphics.getWidth()*11/24,Gdx.graphics.getHeight()*53/200);

        missionbutton = new TextButton("",missionstyle);
        missionbutton.setSize(buttonx,buttony);
        missionbutton.setPosition(Gdx.graphics.getWidth()*11/24,Gdx.graphics.getHeight()*30/200);

        buttonone = new TextButton("",buttononestyle);
        buttonone.setSize(buttonboy,buttonboy);
        buttonone.setPosition(50,Gdx.graphics.getHeight()/25);

        buttontwo = new TextButton("",buttontwostyle);
        buttontwo.setSize(buttonboy,buttonboy);
        buttontwo.setPosition(50+(buttonboy+buttonarttir),Gdx.graphics.getHeight()/25);


        buttontree = new TextButton("",buttontreestyle);
        buttontree.setSize(buttonboy,buttonboy);
        buttontree.setPosition(50+2*(buttonboy+buttonarttir),Gdx.graphics.getHeight()/25);


        buttonfour = new TextButton("",buttonfourstyle);
        buttonfour.setSize(buttonboy,buttonboy);
        buttonfour.setPosition(50+3*(buttonboy+buttonarttir),Gdx.graphics.getHeight()/25);


        buttonfive = new TextButton("",buttonfivestyle);
        buttonfive.setSize(buttonboy,buttonboy);
        buttonfive.setPosition(50+4*(buttonboy+buttonarttir),Gdx.graphics.getHeight()/25);





        label = new Label("",skin,"font-big","white");
        label.setSize(600,100);
        label.setPosition(50,Gdx.graphics.getHeight()*37/40);








     //   musicbuttonn.addCaptureListener(new ChangeListener() {
     //       @Override
     //       public void changed(ChangeEvent event, Actor actor) {

      //          if (gameOverMission.getMusic2().getVolume()>0f){
      //              gameOverMission.setMusic23();
     //           }else {
      //              gameOverMission.setMusic2();
    //            }
    //        }
   //     });





        kalp.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                game.setScreen(game.bonusScreen);
            }
        });







        buttonone.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.highScore);
            }
        });



        buttontwo.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.historyScreen);
            }
        });

        buttontree.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                game.setScreen(game.shopScreen);
            }
        });

        buttonfive.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                game.setScreen(game.dialogTutarial);
            }
        });



        missionbutton.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.missionScreen);
            }
        });

        buttonfour.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                game.setScreen(game.settingScreen);
            }
        });


        timebutton.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.secondGameScreen);


            }
        });

        levelbar.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {

                game.setScreen(game.historyScreen);

                if (bonusstate == 1){

                }

                if (bonusstate == 2){

                }
                if (bonusstate == 3){

                }
                if (bonusstate == 4){

                }
                if (bonusstate == 5){

                }
                if (bonusstate == 6){

                }
                if (bonusstate == 7){

                }
                if (bonusstate ==8){

                }
                if (bonusstate ==9){

                }
                if (bonusstate ==10){

                }
                if (bonusstate ==11){

                }
                if (bonusstate ==12){

                }
                if (bonusstate ==13){

                }
                if (bonusstate ==14){

                }
                if (bonusstate ==15){

                }
                if (bonusstate ==16){

                }
                if (bonusstate ==17){

                }
                if (bonusstate ==18){

                }

            }
        });














        stage.addActor(denemebutton);
        stage.addActor(easybutton);
        stage.addActor(timebutton);
        stage.addActor(missionbutton);
        stage.addActor(buttonone);
        stage.addActor(buttontwo);
        stage.addActor(buttontree);
        stage.addActor(buttonfour);
        stage.addActor(buttonfive);
       // stage.addActor(label);
        stage.addActor(levelbar);
        stage.addActor(parabar);
        stage.addActor(stopbar);
        stage.addActor(slowbar);
        stage.addActor(kalp);


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

        batch.draw(paraonescreen, 0, Gdx.graphics.getHeight()*29/200,Gdx.graphics.getWidth()*56/135,0.420f*Gdx.graphics.getHeight());
        batch.draw(logo, 0, Gdx.graphics.getHeight()*27/40,Gdx.graphics.getWidth(),300);
      //  batch.draw(kapla, Gdx.graphics.getWidth()*14/15,Gdx.graphics.getHeight()*502/1000,Gdx.graphics.getWidth()*7/100,Gdx.graphics.getHeight()/25);
    //    batch.draw(playkapla, Gdx.graphics.getWidth()*8/15,Gdx.graphics.getHeight()*20/40,Gdx.graphics.getWidth()*5/45,Gdx.graphics.getHeight()/35);
    //    batch.draw(playkapla, Gdx.graphics.getWidth()*8/15,Gdx.graphics.getHeight()*16/40,Gdx.graphics.getWidth()*5/45,Gdx.graphics.getHeight()/35);
    //    batch.draw(playkapla, Gdx.graphics.getWidth()*8/15,Gdx.graphics.getHeight()*12/40,Gdx.graphics.getWidth()*5/45,Gdx.graphics.getHeight()/35);

        historystate = highScore.getGörevlerstate();
        histortystatetwo = highScore.getGörevlerstatetwo();
        historystatetree = highScore.getGörevlerstatetree();




        //
        if (historystate == 0 && histortystatetwo == 0 && historystatetree == 0){
            levelbar.setStyle(levelbarstyle);
            levelbar.setText("  1");
        }
        if (historystate == 1 && histortystatetwo == 0 && historystatetree == 0){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  1");
        }
        if (historystate == 0 && histortystatetwo == 1 && historystatetree == 0){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  1");
        }
        if (historystate == 0 && histortystatetwo == 0 && historystatetree == 1){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  1");
        }
        if (historystate == 1 && histortystatetwo == 1 && historystatetree == 0){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  1");
        }
        if (historystate == 1 && histortystatetwo == 0 && historystatetree == 1){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  1");
        }
        if (historystate == 0 && histortystatetwo == 1 && historystatetree == 1){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  1");
        }
        if (historystate == 1 && histortystatetwo == 1 && historystatetree == 1){
            levelbar.setStyle(levelbartreestyle);
            bonusstate = 1;

            levelbar.setText("  1");


        }

        //

        if (historystate == 1 && histortystatetwo == 1 && historystatetree == 1){
            levelbar.setStyle(levelbarstyle);
            levelbar.setText("  2");

        }

        if (historystate == 2 && histortystatetwo == 1 && historystatetree == 1){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  2");
        }
        if (historystate == 1 && histortystatetwo == 2 && historystatetree == 1){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  2");
        }
        if (historystate == 1 && histortystatetwo == 1 && historystatetree == 2){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  2");
        }
        if (historystate == 2 && histortystatetwo == 2 && historystatetree == 1){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  2");
        }
        if (historystate == 2 && histortystatetwo == 1 && historystatetree == 2){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  2");
        }
        if (historystate == 1 && histortystatetwo == 2 && historystatetree == 2){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  2");
        }
        if (historystate == 2 && histortystatetwo == 2 && historystatetree == 2){
            levelbar.setStyle(levelbartreestyle);
            levelbar.setText("  2");
            bonusstate =2;
        }
        //

        if (historystate == 2 && histortystatetwo == 2 && historystatetree == 2){
            levelbar.setStyle(levelbarstyle);
            levelbar.setText("  3");

        }

        if (historystate == 3 && histortystatetwo == 2 && historystatetree == 2){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  3");
        }
        if (historystate == 2 && histortystatetwo == 3 && historystatetree == 2){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  3");
        }
        if (historystate == 2 && histortystatetwo == 2 && historystatetree == 3){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  3");
        }
        if (historystate == 3 && histortystatetwo == 3 && historystatetree == 2){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  3");
        }
        if (historystate == 3 && histortystatetwo == 2 && historystatetree == 3){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  3");
        }
        if (historystate == 2 && histortystatetwo == 3 && historystatetree == 3){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  3");
        }
        if (historystate == 3 && histortystatetwo == 3 && historystatetree == 3){
            levelbar.setStyle(levelbartreestyle);
            levelbar.setText("  3");
        }
        //
        if (historystate == 3 && histortystatetwo == 3 && historystatetree == 3){
            levelbar.setStyle(levelbarstyle);
            levelbar.setText("  4");
        }
        if (historystate == 4 && histortystatetwo == 3 && historystatetree == 3){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  4");
        }
        if (historystate == 3 && histortystatetwo == 4 && historystatetree == 3){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  4");
        }
        if (historystate == 3 && histortystatetwo ==3 && historystatetree == 4){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  4");
        }
        if (historystate == 4 && histortystatetwo == 4 && historystatetree == 3){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  4");
        }
        if (historystate == 4 && histortystatetwo == 3 && historystatetree == 4){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  4");
        }
        if (historystate == 3 && histortystatetwo == 4 && historystatetree == 4){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  4");
        }
        if (historystate == 4 && histortystatetwo == 4 && historystatetree == 4){
            levelbar.setStyle(levelbartreestyle);
            levelbar.setText("  4");
        }
        //
        if (historystate == 4 && histortystatetwo == 4 && historystatetree == 4){
            levelbar.setStyle(levelbarstyle);
            levelbar.setText("  5");
        }
        if (historystate == 5 && histortystatetwo == 4 && historystatetree == 4){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  5");
        }
        if (historystate == 4 && histortystatetwo == 5 && historystatetree == 4){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  5");
        }
        if (historystate == 4 && histortystatetwo ==4 && historystatetree == 5){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  5");
        }
        if (historystate == 5 && histortystatetwo == 5 && historystatetree == 4){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  5");
        }
        if (historystate == 5 && histortystatetwo == 4 && historystatetree == 5){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  5");
        }
        if (historystate == 4 && histortystatetwo == 5 && historystatetree == 5){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  5");
        }
        if (historystate == 5 && histortystatetwo == 5 && historystatetree == 5){
            levelbar.setStyle(levelbartreestyle);
            levelbar.setText("  5");
        }
        //
        if (historystate == 5 && histortystatetwo == 5 && historystatetree == 5){
            levelbar.setStyle(levelbarstyle);
            levelbar.setText("  6");
        }
        if (historystate == 6 && histortystatetwo == 5 && historystatetree == 5){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  6");
        }
        if (historystate == 5 && histortystatetwo == 6 && historystatetree == 5){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  6");
        }
        if (historystate == 5 && histortystatetwo ==5 && historystatetree == 6){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  6");
        }
        if (historystate == 6 && histortystatetwo == 6 && historystatetree == 5){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  6");
        }
        if (historystate == 6 && histortystatetwo == 5 && historystatetree == 6){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  6");
        }
        if (historystate == 5 && histortystatetwo == 6 && historystatetree == 6){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  6");
        }
        if (historystate ==6 && histortystatetwo == 6 && historystatetree == 6){
            levelbar.setStyle(levelbartreestyle);
            levelbar.setText("  6");
        }
        //
        if (historystate == 6 && histortystatetwo == 6 && historystatetree == 6){
            levelbar.setStyle(levelbarstyle);
            levelbar.setText("  7");
        }
        if (historystate == 7 && histortystatetwo == 6 && historystatetree == 6){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  7");
        }
        if (historystate == 6 && histortystatetwo == 7 && historystatetree == 6){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  7");
        }
        if (historystate == 6 && histortystatetwo ==6 && historystatetree == 7){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  7");
        }
        if (historystate == 7 && histortystatetwo == 7 && historystatetree == 6){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  7");
        }
        if (historystate == 7 && histortystatetwo == 6 && historystatetree == 7){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  7");
        }
        if (historystate == 6 && histortystatetwo == 7 && historystatetree == 7){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  7");
        }
        if (historystate ==7 && histortystatetwo == 7 && historystatetree == 7){
            levelbar.setStyle(levelbartreestyle);
            levelbar.setText("  7");
        }
        //
        if (historystate == 7 && histortystatetwo == 7 && historystatetree == 7){
            levelbar.setStyle(levelbarstyle);
            levelbar.setText("  8");
        }
        if (historystate == 8 && histortystatetwo == 7 && historystatetree == 7){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  8");
        }
        if (historystate == 7 && histortystatetwo == 8 && historystatetree == 7){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  8");
        }
        if (historystate == 7 && histortystatetwo ==7 && historystatetree == 8){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  8");
        }
        if (historystate == 8 && histortystatetwo == 8 && historystatetree == 7){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  8");
        }
        if (historystate == 8 && histortystatetwo == 7 && historystatetree == 8){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  8");
        }
        if (historystate == 7 && histortystatetwo == 8 && historystatetree == 8){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  8");
        }
        if (historystate ==8 && histortystatetwo == 8 && historystatetree == 8){
            levelbar.setStyle(levelbartreestyle);
            levelbar.setText("  8");
        }
        //
        if (historystate == 8 && histortystatetwo == 8 && historystatetree == 8){
            levelbar.setStyle(levelbarstyle);
            levelbar.setText("  9");
        }
        if (historystate == 9 && histortystatetwo == 8 && historystatetree == 8){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  9");
        }
        if (historystate == 8 && histortystatetwo == 9 && historystatetree == 8){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  9");
        }
        if (historystate == 8 && histortystatetwo ==8 && historystatetree == 9){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  9");
        }
        if (historystate == 9 && histortystatetwo == 9 && historystatetree == 8){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  9");
        }
        if (historystate == 9 && histortystatetwo == 8 && historystatetree == 9){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  9");
        }
        if (historystate == 8 && histortystatetwo == 9 && historystatetree == 9){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText("  9");
        }
        if (historystate ==9 && histortystatetwo == 9 && historystatetree == 9){
            levelbar.setStyle(levelbartreestyle);
            levelbar.setText("  9");
        }
        //
        if (historystate == 9 && histortystatetwo == 9 && historystatetree == 9){
            levelbar.setStyle(levelbarstyle);
            levelbar.setText(" 10");
        }
        if (historystate == 10 && histortystatetwo == 9 && historystatetree == 9){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 10");
        }
        if (historystate == 9 && histortystatetwo == 10 && historystatetree == 9){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 10");
        }
        if (historystate == 9 && histortystatetwo ==9 && historystatetree == 10){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 10");
        }
        if (historystate == 10 && histortystatetwo == 10 && historystatetree == 9){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 10");
        }
        if (historystate == 10 && histortystatetwo == 9 && historystatetree == 10){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 10");
        }
        if (historystate == 9 && histortystatetwo == 10 && historystatetree == 10){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 10");
        }
        if (historystate ==10 && histortystatetwo == 10 && historystatetree == 10){
            levelbar.setStyle(levelbartreestyle);
            levelbar.setText(" 10");
        }
        //
        if (historystate == 10 && histortystatetwo == 10 && historystatetree == 10){
            levelbar.setStyle(levelbarstyle);
            levelbar.setText(" 11");
        }
        if (historystate == 11 && histortystatetwo == 10 && historystatetree == 10){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 11");
        }
        if (historystate == 10 && histortystatetwo == 11 && historystatetree == 10){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 11");
        }
        if (historystate == 10 && histortystatetwo ==10 && historystatetree == 11){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 11");
        }
        if (historystate == 11 && histortystatetwo == 11 && historystatetree == 10){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 11");
        }
        if (historystate == 11 && histortystatetwo == 10 && historystatetree == 11){
            levelbar.setStyle(levelbartwostyle);
        }
        if (historystate == 10 && histortystatetwo == 11 && historystatetree == 11){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 11");
        }
        if (historystate ==11 && histortystatetwo == 11 && historystatetree == 11){
            levelbar.setStyle(levelbartreestyle);
            levelbar.setText(" 11");
        }
        //
        if (historystate == 11 && histortystatetwo == 11 && historystatetree == 11){
            levelbar.setStyle(levelbarstyle);
            levelbar.setText(" 12");
        }
        if (historystate == 12 && histortystatetwo == 11 && historystatetree == 11){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 12");
        }
        if (historystate == 11 && histortystatetwo == 12 && historystatetree == 11){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 12");
        }
        if (historystate == 11 && histortystatetwo ==11 && historystatetree == 12){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 12");
        }
        if (historystate == 12 && histortystatetwo == 12 && historystatetree == 11){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 12");
        }
        if (historystate == 12 && histortystatetwo == 11 && historystatetree == 12){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 12");
        }
        if (historystate == 11 && histortystatetwo == 12 && historystatetree == 12){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 12");
        }
        if (historystate ==12 && histortystatetwo == 12 && historystatetree == 12){
            levelbar.setStyle(levelbartreestyle);
            levelbar.setText(" 12");
        }
        //
        if (historystate == 12 && histortystatetwo == 12 && historystatetree == 12){
            levelbar.setStyle(levelbarstyle);
            levelbar.setText(" 13");
        }
        if (historystate == 13 && histortystatetwo == 12 && historystatetree == 12){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 13");
        }
        if (historystate == 12 && histortystatetwo == 13 && historystatetree == 12){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 13");
        }
        if (historystate == 12 && histortystatetwo ==12 && historystatetree == 13){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 13");
        }
        if (historystate == 13 && histortystatetwo == 13 && historystatetree == 12){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 13");
        }
        if (historystate == 13 && histortystatetwo == 12 && historystatetree == 13){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 13");
        }
        if (historystate == 12 && histortystatetwo == 13 && historystatetree == 13){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 13");
        }
        if (historystate ==13 && histortystatetwo == 13 && historystatetree == 13){
            levelbar.setStyle(levelbartreestyle);
            levelbar.setText(" 13");
        }
        //
        if (historystate == 13 && histortystatetwo == 13 && historystatetree == 13){
            levelbar.setStyle(levelbarstyle);
            levelbar.setText(" 14");
        }
        if (historystate == 14 && histortystatetwo == 13 && historystatetree == 13){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 14");
        }
        if (historystate == 13 && histortystatetwo == 14 && historystatetree == 13){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 14");
        }
        if (historystate == 13 && histortystatetwo ==13 && historystatetree == 14){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 14");
        }
        if (historystate == 14 && histortystatetwo == 14 && historystatetree == 13){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 14");
        }
        if (historystate == 14 && histortystatetwo == 13 && historystatetree == 14){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 14");
        }
        if (historystate == 13 && histortystatetwo == 14 && historystatetree == 14){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 14");
        }
        if (historystate ==14 && histortystatetwo == 14 && historystatetree == 14){
            levelbar.setStyle(levelbartreestyle);
            levelbar.setText(" 14");
        }
        //
        if (historystate == 14 && histortystatetwo == 14 && historystatetree == 14){
            levelbar.setStyle(levelbarstyle);
            levelbar.setText(" 15");
        }
        if (historystate == 15 && histortystatetwo == 14 && historystatetree == 14){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText("  15");
        }
        if (historystate == 14 && histortystatetwo == 15 && historystatetree == 14){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 15");
        }
        if (historystate == 14 && histortystatetwo ==14 && historystatetree == 15){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 15");
        }
        if (historystate == 15 && histortystatetwo == 15 && historystatetree == 14){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 15");
        }
        if (historystate == 15 && histortystatetwo == 14 && historystatetree == 15){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 15");
        }
        if (historystate == 14 && histortystatetwo == 15 && historystatetree == 15){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 15");
        }
        if (historystate ==15 && histortystatetwo == 15 && historystatetree == 15){
            levelbar.setStyle(levelbartreestyle);
            levelbar.setText(" 15");
        }
        //
        if (historystate == 15 && histortystatetwo == 15 && historystatetree == 15){
            levelbar.setStyle(levelbarstyle);
            levelbar.setText(" 16");
        }
        if (historystate == 16 && histortystatetwo == 15 && historystatetree == 15){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 16");
        }
        if (historystate == 15 && histortystatetwo == 16 && historystatetree == 15){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 16");
        }
        if (historystate == 15 && histortystatetwo ==15 && historystatetree == 16){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 16");
        }
        if (historystate == 16 && histortystatetwo == 16 && historystatetree == 15){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 16");
        }
        if (historystate == 16 && histortystatetwo == 15 && historystatetree == 16){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 16");
        }
        if (historystate == 15 && histortystatetwo == 16 && historystatetree == 16){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 16");
        }
        if (historystate ==16 && histortystatetwo == 16 && historystatetree == 16){
            levelbar.setStyle(levelbartreestyle);
            levelbar.setText(" 16");
        }
        //
        if (historystate == 16 && histortystatetwo == 16 && historystatetree == 16){
            levelbar.setStyle(levelbarstyle);
            levelbar.setText(" 17");
        }
        if (historystate == 17 && histortystatetwo == 16 && historystatetree == 16){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 17");
        }
        if (historystate == 16 && histortystatetwo == 17 && historystatetree == 16){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 17");
        }
        if (historystate == 16 && histortystatetwo ==16 && historystatetree == 17){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 17");
        }
        if (historystate == 17 && histortystatetwo == 17 && historystatetree == 16){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 17");
        }
        if (historystate == 17 && histortystatetwo == 16 && historystatetree == 17){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 17");
        }
        if (historystate == 16 && histortystatetwo == 17 && historystatetree == 17){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 17");
        }
        if (historystate ==17 && histortystatetwo == 17 && historystatetree == 17){
            levelbar.setStyle(levelbartreestyle);
            levelbar.setText(" 17");
        }
        //
        if (historystate == 17 && histortystatetwo == 17 && historystatetree == 17){
            levelbar.setStyle(levelbarstyle);
            levelbar.setText(" 18");
        }
        if (historystate == 18 && histortystatetwo == 17 && historystatetree == 17){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 18");
        }
        if (historystate == 17 && histortystatetwo == 18 && historystatetree == 17){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 18");
        }
        if (historystate == 17 && histortystatetwo ==17 && historystatetree == 18){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 18");
        }
        if (historystate == 18 && histortystatetwo == 18 && historystatetree == 17){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 18");
        }
        if (historystate == 18 && histortystatetwo == 17 && historystatetree == 18){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 18");
        }
        if (historystate == 17 && histortystatetwo == 18 && historystatetree == 18){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 18");
        }
        if (historystate ==18 && histortystatetwo == 18 && historystatetree == 18){
            levelbar.setStyle(levelbartreestyle);
            levelbar.setText(" 18");
        }
        //
        if (historystate == 18 && histortystatetwo == 18 && historystatetree == 18){
            levelbar.setStyle(levelbarstyle);
            levelbar.setText(" 19");
        }
        if (historystate == 19 && histortystatetwo == 18 && historystatetree == 18){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 19");
        }
        if (historystate == 18 && histortystatetwo == 19 && historystatetree == 18){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 19");
        }
        if (historystate == 18 && histortystatetwo ==18 && historystatetree == 19){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 19");
        }
        if (historystate == 19 && histortystatetwo == 19 && historystatetree == 18){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 19");
        }
        if (historystate == 19 && histortystatetwo == 18 && historystatetree == 19){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 19");
        }
        if (historystate == 18 && histortystatetwo == 19 && historystatetree == 19){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 19");
        }
        if (historystate ==19 && histortystatetwo == 19 && historystatetree == 19){
            levelbar.setStyle(levelbartreestyle);
            levelbar.setText(" 19");
        }
        //
        if (historystate == 19 && histortystatetwo == 19 && historystatetree == 19){
            levelbar.setStyle(levelbarstyle);
            levelbar.setText(" 20");
        }
        if (historystate == 20 && histortystatetwo == 19 && historystatetree == 19){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 20");
        }
        if (historystate == 19 && histortystatetwo == 20 && historystatetree == 19){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 20");
        }
        if (historystate == 19 && histortystatetwo ==19 && historystatetree == 20){
            levelbar.setStyle(levelbaronestyle);
            levelbar.setText(" 20");
        }
        if (historystate == 20 && histortystatetwo == 20 && historystatetree == 19){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 20");
        }
        if (historystate == 20 && histortystatetwo == 19 && historystatetree == 20){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 20");
        }
        if (historystate == 19 && histortystatetwo == 20 && historystatetree == 20){
            levelbar.setStyle(levelbartwostyle);
            levelbar.setText(" 20");
        }
        if (historystate ==20 && histortystatetwo == 20 && historystatetree == 20){
            levelbar.setStyle(levelbartreestyle);
            levelbar.setText(" 20");
        }

        if (highScore.getIlkgames()<2){
            highScore.setToplammany(2000);
            highScore.setSlowlyduration(10);
            highScore.setStopduration(10);
            highScore.setIlkgames(2);
        }
        if ((float) TimeUtils.timeSinceMillis(started)/1000 > 1f){

            batcdeneme =2;


        }


        if (batcdeneme == 2){
            kalp.setStyle(kalpstyleone);
            if ((float) TimeUtils.timeSinceMillis(started2)/1000 > 1.5f){
                batcdeneme = 3;
                kalp.setStyle(kalpstyle);
                started = TimeUtils.millis();
                started2 = TimeUtils.millis();
            }

        }






        if (highScore.getToplammany()> -6000){

        }

        stringmany = String.valueOf(highScore.getToplammany())+"$";
      //  label.setText(stringmany);
        parabar.setText("  "+stringmany);
        stopbar.setText(" "+String.valueOf(highScore.getStopduration()));
        slowbar.setText(" "+String.valueOf(highScore.getSlowlyduration()));





        if (highScore.getToplammany()>= -11315500){



            denemebutton.addCaptureListener(new ChangeListener() {


                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    if (highScore.getToplammany()>= -15165500){
                        game.setScreen(game.manys);
                       ;
                    }else {

                    }




                }
            });

        }
        if (highScore.getToplammany()>= -1565500){


            easybutton.addCaptureListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    game.setScreen(game.easyModeScreen);






                }
            });

        }



        if (Gdx.input.justTouched()) {
            kisit = 0;
        }


        if (Gdx.input.isKeyPressed(Input.Keys.BACK)){
          //  game.setScreen(game.oneScreen);

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

    public TextButton getLevelbar() {
        return levelbar;
    }

    public void setLevelbar(TextButton.TextButtonStyle style) {
        levelbar.setStyle(style);
    }
}
