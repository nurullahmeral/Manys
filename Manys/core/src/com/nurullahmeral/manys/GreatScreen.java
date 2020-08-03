package com.nurullahmeral.manys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
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
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GreatScreen implements Screen {
    CountMoneyGame game4;
    private SpriteBatch batch;
    private Texture great,arkaplan;
    private Stage stage;
    private Skin skin,buttonskin;
    private Label label;
    private TextButton yes,no;
    private TextButton.TextButtonStyle yesstyle,nostyle;
    private BitmapFont font;
    private TextureAtlas buttonatlas;

    int toplammanygreat,parasayigreat;
    int toplamGreat,easymodeGreat,timemodeGreat;
    int levelOneGreat,levelTwoGreat,levelTreeGreat,levelFourGreat,levelFiveGreat,levelSixGreat,levelSevenGreat
            ,levelEigthGreat,levelNineGreat,levelTenGreat,levelElevenGreat,levelTwelveGreat,levelThirteenGreat
            ,levelFourteenGreat,levelFiveteenGreat,levelSixteenGreat,levelSeventeenGreat,levelEigthteenGreat,levelNineteenGreat
            ,levelTwentyGreat,levelTwentyoneGreat,levelTwentytwoGreat,levelTwentytreeGreat,levelTwentyfourGreat,levelTwentyfiveGreat
            ,levelTwentysixGreat,levelTwentysevenGreat,levelTwentyeightGreat,levelTwentynineGreat,levelThirtyGreat,levelThirtyoneGreat
            ,levelThirtytwoGreat,levelThirtytreeGreat,levelThirtyfourGreat,levelThirtyfiveGreat,levelThirtysixGreat;
    MissionScreen missionScreen;
    HighScore highScore;
    OneScreen oneScreen;
    int kisit;
    int greatayir;
    int gameoverstate;
    int görevlerstate,görevlerstatetwo,görevlerstatetree;
    float buttonboy = 0.198f * Gdx.graphics.getWidth();

    public GreatScreen (final CountMoneyGame game4,final MissionScreen missionScreen,final HighScore highScore){
        this.game4 = game4;
        this.missionScreen = missionScreen;
        this.highScore = highScore;


        batch = new SpriteBatch();
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
        skin = game4.getAssetManager().get("glassy-ui.json");
        great = game4.getAssetManager().get("great.png");
        arkaplan = game4.getAssetManager().get("arkaplan.png");
        font = new BitmapFont();

        buttonatlas = game4.getAssetManager().get("ui.atlas",TextureAtlas.class);
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



        label = new Label("",skin,"font-big","black");
        label.setSize(600,100);
        label.setPosition(Gdx.graphics.getWidth()*5/12,Gdx.graphics.getHeight()*9/24);
        label.setText(String.valueOf(toplamGreat)+"$");
        görevlerstate = highScore.getGörevlerstate();
        görevlerstatetwo = highScore.getGörevlerstatetwo();
        görevlerstatetree = highScore.getGörevlerstatetree();


        stage.addActor(label);
        stage.addActor(yes);
        stage.addActor(no);
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
    public void show() {
        Gdx.input.setInputProcessor(stage);
        Gdx.input.setCatchBackKey(true);

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        if (Gdx.input.isKeyPressed(Input.Keys.BACK)){
            game4.setScreen(game4.oneScreen);

        }


        batch.draw(arkaplan, 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch.draw(great, 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        if (toplamGreat != 0){
            label.setText(toplamGreat+"$");
            if (parasayigreat>=10 && görevlerstate<1){
                highScore.setGörevlerstate(1);
            }
            if (toplamGreat>=200 && görevlerstate==1){
                highScore.setGörevlerstate(2);
            }
            if (parasayigreat>=15 && görevlerstate==2){
                highScore.setGörevlerstate(3);
            }
            if (toplamGreat>=400 && görevlerstate==3){
                highScore.setGörevlerstate(4);
            }
            if (parasayigreat>=20 && görevlerstate==4){
                highScore.setGörevlerstate(5);
            }
            if (toplamGreat>=600 && görevlerstate==5){
                highScore.setGörevlerstate(6);
            }
            if (parasayigreat>=25 && görevlerstate ==6){
                highScore.setGörevlerstate(7);
            }
            if (toplamGreat>=800 && görevlerstate==7){
                highScore.setGörevlerstate(8);
            }
            if (parasayigreat>=30 && görevlerstate==8){
                highScore.setGörevlerstate(9);
            }
            if (toplamGreat>=1000 && görevlerstate==9){
                highScore.setGörevlerstate(10);
            }
            if (parasayigreat>=35 && görevlerstate==10){
                highScore.setGörevlerstate(11);
            }
            if (toplamGreat>=1200 && görevlerstate==11){
                highScore.setGörevlerstate(12);
            }
            if (parasayigreat>=40 && görevlerstate==12){
                highScore.setGörevlerstate(13);
            }
            if (toplamGreat>=1400 && görevlerstate==13){
                highScore.setGörevlerstate(14);
            }
            if (parasayigreat>=45 && görevlerstate==14){
                highScore.setGörevlerstate(15);
            }
            if (toplamGreat>=1600 && görevlerstate==15){
                highScore.setGörevlerstate(16);
            }
            if (parasayigreat>=50 && görevlerstate==16){
                highScore.setGörevlerstate(17);
            }
            if (toplamGreat>=1800 && görevlerstate==17){
                highScore.setGörevlerstate(18);
            }
            if (parasayigreat>=55 && görevlerstate==18){
                highScore.setGörevlerstate(19);
            }
            if (toplamGreat>=2000 && görevlerstate==19){
                highScore.setGörevlerstate(20);
            }
            if (kisit < 2){
                highScore.setToplammany(highScore.getToplammany()+(2*toplamGreat));
                kisit = 2;
            }

            if (toplamGreat> highScore.getHigscoretoplam()){
                highScore.setHigscoretoplam(toplamGreat);

            }

        }
        if (easymodeGreat != 0){
            label.setText(easymodeGreat+"$");
            if (kisit<2){
                highScore.setToplammany(highScore.getToplammany()+easymodeGreat);
                kisit = 2;
            }
            if (easymodeGreat>=400 && görevlerstatetree==1 ){
                highScore.setGörevlerstatetree(2);
            }
            if (easymodeGreat>=800 && görevlerstatetree==3 ){
                highScore.setGörevlerstatetree(4);
            }
            if (easymodeGreat>=1000 && görevlerstatetree==5 ){
                highScore.setGörevlerstatetree(6);
            }
            if (easymodeGreat>=1200 && görevlerstatetree==7 ){
                highScore.setGörevlerstatetree(8);
            }
            if (easymodeGreat>=1400 && görevlerstatetree==9 ){
                highScore.setGörevlerstatetree(10);
            }
            if (easymodeGreat>=1600 && görevlerstatetree==11 ){
                highScore.setGörevlerstatetree(12);
            }
            if (easymodeGreat>=1800 && görevlerstatetree==13 ){
                highScore.setGörevlerstatetree(14);
            }
            if (easymodeGreat>=2000 && görevlerstatetree==15 ){
                highScore.setGörevlerstatetree(16);
            }
            if (easymodeGreat>=2200 && görevlerstatetree==17 ){
                highScore.setGörevlerstatetree(18);
            }
            if (easymodeGreat>=2400 && görevlerstatetree==19 ){
                highScore.setGörevlerstatetree(20);
            }

            if (easymodeGreat> highScore.getEasyhighscoretoplam()){
                highScore.setEasyhighscoretoplam(easymodeGreat);

            }

        }
        if (timemodeGreat != 0){
            label.setText(timemodeGreat+"$");

            if (timemodeGreat>=300 && görevlerstatetwo<1 ){
                highScore.setGörevlerstatetwo(1);
            }
            if (parasayigreat>=10 && görevlerstatetwo==1){
                highScore.setGörevlerstatetwo(2);
            }
            if (timemodeGreat>=350 && görevlerstatetwo==2 ){
                highScore.setGörevlerstatetwo(3);
            }
            if (parasayigreat>=12 && görevlerstatetwo==3){
                highScore.setGörevlerstatetwo(4);
            }
            if (timemodeGreat>=400 && görevlerstatetwo==4 ){
                highScore.setGörevlerstatetwo(5);
            }
            if (parasayigreat>=16 && görevlerstatetwo==5){
                highScore.setGörevlerstatetwo(6);
            }
            if (timemodeGreat>=450 && görevlerstatetwo==6 ){
                highScore.setGörevlerstatetwo(7);
            }
            if (parasayigreat>=18 && görevlerstatetwo==7){
                highScore.setGörevlerstatetwo(8);
            }
            if (timemodeGreat>=500 && görevlerstatetwo==8 ){
                highScore.setGörevlerstatetwo(9);
            }
            if (parasayigreat>=20 && görevlerstatetwo==9){
                highScore.setGörevlerstatetwo(10);
            }
            if (timemodeGreat>=550 && görevlerstatetwo==10 ){
                highScore.setGörevlerstatetwo(11);
            }
            if (parasayigreat>=22 && görevlerstatetwo==11){
                highScore.setGörevlerstatetwo(12);
            }
            if (timemodeGreat>=600 && görevlerstatetwo==12 ){
                highScore.setGörevlerstatetwo(13);
            }
            if (parasayigreat>=24 && görevlerstatetwo==13){
                highScore.setGörevlerstatetwo(14);
            }
            if (timemodeGreat>=650 && görevlerstatetwo==14 ){
                highScore.setGörevlerstatetwo(15);
            }
            if (parasayigreat>=26 && görevlerstatetwo==15){
                highScore.setGörevlerstatetwo(16);
            }
            if (timemodeGreat>=700 && görevlerstatetwo==16 ){
                highScore.setGörevlerstatetwo(17);
            }
            if (parasayigreat>=28 && görevlerstatetwo==17){
                highScore.setGörevlerstatetwo(18);
            }
            if (timemodeGreat>=800 && görevlerstatetwo==18 ){
                highScore.setGörevlerstatetwo(19);
            }
            if (parasayigreat>=30 && görevlerstatetwo==19){
                highScore.setGörevlerstatetwo(20);
            }


            if (timemodeGreat> highScore.getTimemodescoretoplam()){
                highScore.setTimemodescoretoplam(timemodeGreat);

            }

        }
        if (levelOneGreat != 0){
            if (görevlerstatetree<1){
                highScore.setGörevlerstatetree(1);
            }


            label.setText(levelOneGreat+"$");
            if (highScore.getMissionstatescore()<3){
                highScore.setMissionstatescore(2);

            }



        }
        if (levelTwoGreat != 0){

            label.setText(levelTwoGreat+"$");
            System.out.println(highScore.getMissionstatescore());
            if (highScore.getMissionstatescore()<3){
                highScore.setMissionstatescore(3);

            }



        }
        if (levelTreeGreat != 0){

            if (görevlerstatetree==2){
                highScore.setGörevlerstatetree(3);
            }

            label.setText(levelTreeGreat+"$");
            if (highScore.getMissionstatescore()<5){
                highScore.setMissionstatescore(4);
            }



        }
        if (levelFourGreat != 0){

            label.setText(levelFourGreat+"$");
            if (highScore.getMissionstatescore()<6){
                highScore.setMissionstatescore(5);
            }



        }
        if (levelFiveGreat != 0){

            label.setText(levelFiveGreat+"$");
            if (highScore.getMissionstatescore()<7){
                highScore.setMissionstatescore(6);
            }



        }
        if (levelSixGreat != 0){

            label.setText(levelSixGreat+"$");
            if (highScore.getMissionstatescore()<8){
                highScore.setMissionstatescore(7);
            }
            if (highScore.getGörevlerstatetree()==4){
                highScore.setGörevlerstatetree(5);
            }



        }
        if (levelSevenGreat != 0){


            label.setText(levelSevenGreat+"$");
            if (highScore.getMissionstatescore()<9){
                highScore.setMissionstatescore(8);
            }



        }
        if (levelEigthGreat != 0){

            label.setText(levelEigthGreat+"$");
            if (highScore.getMissionstatescore()<10){
                highScore.setMissionstatescore(9);
            }



        }
        if (levelNineGreat != 0){
            if (görevlerstatetree==6){
                highScore.setGörevlerstatetree(7);
            }

            label.setText(levelNineGreat+"$");
            if (highScore.getMissionstatescore()<11){
                highScore.setMissionstatescore(10);
            }



        }
        if (levelTenGreat != 0){

            label.setText(levelTenGreat+"$");
            if (highScore.getMissionstatescore()<12){
                highScore.setMissionstatescore(11);
            }



        }
        if (levelElevenGreat != 0){

            label.setText(levelElevenGreat+"$");
            if (highScore.getMissionstatescore()<13){
                highScore.setMissionstatescore(12);
            }



        }
        if (levelTwelveGreat != 0){

            label.setText(levelTwelveGreat+"$");
            if (highScore.getMissionstatescore()<14){
                highScore.setMissionstatescore(13);
            }



        }
        if (levelThirteenGreat != 0){
            if (görevlerstatetree==8){
                highScore.setGörevlerstatetree(9);
            }

            label.setText(levelThirteenGreat+"$");
            if (highScore.getMissionstatescore()<15){
                highScore.setMissionstatescore(14);
            }



        }
        if (levelFourteenGreat != 0){

            label.setText(levelFourteenGreat+"$");
            if (highScore.getMissionstatescore()<16){
                highScore.setMissionstatescore(15);
            }



        }
        if (levelFiveteenGreat != 0){

            label.setText(levelFiveteenGreat+"$");
            if (highScore.getMissionstatescore()<17){
                highScore.setMissionstatescore(16);
            }



        }
        if (levelSixteenGreat != 0){

            label.setText(levelSixteenGreat+"$");
            if (highScore.getMissionstatescore()<18){
                highScore.setMissionstatescore(17);
            }



        }
        if (levelSeventeenGreat != 0){
            if (görevlerstatetree==10){
                highScore.setGörevlerstatetree(11);
            }

            label.setText(levelSeventeenGreat+"$");
            if (highScore.getMissionstatescore()<19){
                highScore.setMissionstatescore(18);
            }



        }
        if (levelEigthteenGreat != 0){

            label.setText(levelEigthteenGreat+"$");
            if (highScore.getMissionstatescore()<20){
                highScore.setMissionstatescore(19);
            }



        }
        if (levelNineteenGreat != 0){

            label.setText(levelNineteenGreat+"$");
            if (highScore.getMissionstatescore()<21){
                highScore.setMissionstatescore(20);
            }



        }
        if (levelTwentyGreat != 0){

            label.setText(levelTwentyGreat+"$");
            if (highScore.getMissionstatescore()<22){
                highScore.setMissionstatescore(21);
            }



        }
        if (levelTwentyoneGreat != 0){
            if (görevlerstatetree==12){
                highScore.setGörevlerstatetree(13);
            }

            label.setText(levelTwentyoneGreat+"$");
            if (highScore.getMissionstatescore()<23){
                highScore.setMissionstatescore(22);
            }



        }
        if (levelTwentytwoGreat != 0){

            label.setText(levelTwentytwoGreat+"$");
            if (highScore.getMissionstatescore()<24){
                highScore.setMissionstatescore(23);
            }



        }
        if (levelTwentytreeGreat != 0){

            label.setText(levelTwentytreeGreat+"$");
            if (highScore.getMissionstatescore()<25){
                highScore.setMissionstatescore(24);
            }



        }
        if (levelTwentyfourGreat != 0){

            label.setText(levelTwentyfourGreat+"$");
            if (highScore.getMissionstatescore()<26){
                highScore.setMissionstatescore(25);
            }



        }
        if (levelTwentyfiveGreat != 0){
            if (görevlerstatetree==14){
                highScore.setGörevlerstatetree(15);
            }

            label.setText(levelTwentyfiveGreat+"$");
            if (highScore.getMissionstatescore()<27){
                highScore.setMissionstatescore(26);
            }



        }
        if (levelTwentysixGreat != 0){

            label.setText(levelTwentysixGreat+"$");
            if (highScore.getMissionstatescore()<28){
                highScore.setMissionstatescore(27);
            }



        }
        if (levelTwentysevenGreat != 0){

            label.setText(levelTwentysevenGreat+"$");
            if (highScore.getMissionstatescore()<29){
                highScore.setMissionstatescore(28);
            }



        }
        if (levelTwentyeightGreat != 0){

            label.setText(levelTwentyeightGreat+"$");
            if (highScore.getMissionstatescore()<30){
                highScore.setMissionstatescore(29);
            }



        }
        if (levelTwentynineGreat != 0){

            label.setText(levelTwentynineGreat+"$");
            if (highScore.getMissionstatescore()<31){
                highScore.setMissionstatescore(30);
            }



        }
        if (levelThirtyGreat != 0){
            if (görevlerstatetree==16){
                highScore.setGörevlerstatetree(17);
            }

            label.setText(levelThirtyGreat+"$");
            if (highScore.getMissionstatescore()<32){
                highScore.setMissionstatescore(31);
            }



        }
        if (levelThirtyoneGreat != 0){

            label.setText(levelThirtyoneGreat+"$");
            if (highScore.getMissionstatescore()<33){
                highScore.setMissionstatescore(32);
            }



        }
        if (levelThirtytwoGreat != 0){

            label.setText(levelThirtytwoGreat+"$");
            if (highScore.getMissionstatescore()<34){
                highScore.setMissionstatescore(33);
            }



        }
        if (levelThirtytreeGreat != 0){

            label.setText(levelThirtytreeGreat+"$");
            if (highScore.getMissionstatescore()<35){
                highScore.setMissionstatescore(34);
            }



        }
        if (levelThirtyfourGreat != 0){

            label.setText(levelThirtyfourGreat+"$");
            if (highScore.getMissionstatescore()<36){
                highScore.setMissionstatescore(35);
            }



        }
        if (levelThirtyfiveGreat != 0){

            label.setText(levelThirtyfiveGreat+"$");
            if (highScore.getMissionstatescore()<37){
                highScore.setMissionstatescore(36);
            }



        }
        if (levelThirtysixGreat != 0){
            if (görevlerstatetree==18){
                highScore.setGörevlerstatetree(19);
            }

            label.setText(levelThirtysixGreat+"$");
            if (highScore.getMissionstatescore()<38){
                highScore.setMissionstatescore(37);
            }



        }


        yes.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                if (gameoverstate == 1){
                    game4.setScreen(game4.manys);
                }
                if (gameoverstate == 2){
                    game4.setScreen(game4.easyModeScreen);
                }
                if (gameoverstate == 3){
                    game4.setScreen(game4.secondGameScreen);
                }
                if (gameoverstate == 4){
                    game4.setScreen(game4.levelGameİki);
                }
                if (gameoverstate == 5){
                    game4.setScreen(game4.levelGameTree);
                }
                if (gameoverstate == 6){
                    game4.setScreen(game4.levelGameFour);
                }
                if (gameoverstate == 7){
                    game4.setScreen(game4.levelGameFive);
                }
                if (gameoverstate == 8){
                    game4.setScreen(game4.levelGameSix);
                }
                if (gameoverstate == 9){
                    game4.setScreen(game4.levelGameSeven);
                }
                if (gameoverstate == 10){
                    game4.setScreen(game4.levelGameEight);
                }
                if (gameoverstate == 11){
                    game4.setScreen(game4.levelGameNine);
                }
                if (gameoverstate == 12){
                    game4.setScreen(game4.levelGameTen);
                }
                if (gameoverstate == 13){
                    game4.setScreen(game4.levelGameEleven);
                }
                if (gameoverstate == 14){
                    game4.setScreen(game4.levelGameTwelve);
                }
                if (gameoverstate == 15){
                    game4.setScreen(game4.levelGameThirteen);
                }
                if (gameoverstate == 16){
                    game4.setScreen(game4.levelGameFourteen);
                }
                if (gameoverstate == 17){
                    game4.setScreen(game4.levelGameFiveteen);
                }
                if (gameoverstate == 18){
                    game4.setScreen(game4.levelGameSixteen);
                }
                if (gameoverstate == 19){
                    game4.setScreen(game4.levelGameSeventeen);
                }
                if (gameoverstate == 20){
                    game4.setScreen(game4.levelGameEigthteen);
                }
                if (gameoverstate == 21){
                    game4.setScreen(game4.levelGameNineteen);
                }
                if (gameoverstate == 22){
                    game4.setScreen(game4.levelGameTwenty);
                }
                if (gameoverstate == 23){
                    game4.setScreen(game4.levelGameTwentyone);
                }
                if (gameoverstate == 24){
                    game4.setScreen(game4.levelGameTwentytwo);
                }
                if (gameoverstate == 25){
                    game4.setScreen(game4.levelGameTwentytree);
                }
                if (gameoverstate == 26){
                    game4.setScreen(game4.levelGameTwentyfour);
                }
                if (gameoverstate == 27){
                    game4.setScreen(game4.levelGameTwentyfive);
                }
                if (gameoverstate == 28){
                    game4.setScreen(game4.levelGameTwentysix);
                }
                if (gameoverstate == 29){
                    game4.setScreen(game4.levelGameTwentyseven);
                }
                if (gameoverstate == 30){
                    game4.setScreen(game4.levelGameTwentyeight);
                }
                if (gameoverstate == 31){
                    game4.setScreen(game4.levelGameTwentynine);
                }
                if (gameoverstate== 32){
                    game4.setScreen(game4.levelGameThirty);
                }
                if (gameoverstate == 33){
                    game4.setScreen(game4.levelGameThirtyone);
                }
                if (gameoverstate == 34){
                    game4.setScreen(game4.levelGameThirtytwo);
                }
                if (gameoverstate == 35){
                    game4.setScreen(game4.levelGameThirtytree);
                }
                if (gameoverstate == 36){
                    game4.setScreen(game4.levelGameThirtyfour);
                }
                if (gameoverstate == 37){
                    game4.setScreen(game4.levelGameThirtyfive);
                }
                if (gameoverstate == 38){
                    game4.setScreen(game4.levelGameThirtysix);
                }
                if (gameoverstate == 39){
                    game4.setScreen(game4.levelGameThirtysix);
                }
                toplamGreat =0;
                easymodeGreat = 0;
                timemodeGreat = 0;
                levelOneGreat =0;
                levelTwoGreat =0;
                levelTreeGreat =0;
                levelFourGreat =0;
                levelFiveGreat =0;
                levelSixGreat =0;
                levelSevenGreat = 0;
                levelEigthGreat=0;
                levelNineGreat = 0;
                levelTenGreat = 0;
                levelElevenGreat = 0;
                levelTwelveGreat = 0;
                levelThirteenGreat = 0;
                levelFourteenGreat = 0;
                levelFiveteenGreat =0;
                levelSixteenGreat = 0;
                levelSeventeenGreat = 0;
                levelEigthteenGreat = 0;
                levelNineteenGreat = 0;
                levelTwentyGreat = 0;
                levelTwentyoneGreat = 0;
                levelTwentytwoGreat = 0;
                levelTwentytreeGreat = 0;
                levelTwentyfourGreat = 0;
                levelTwentyfiveGreat = 0;
                levelTwentysixGreat = 0;
                levelTwentysevenGreat = 0;
                levelTwentyeightGreat = 0;
                levelTwentynineGreat = 0;
                levelThirtyGreat = 0;
                levelThirtyoneGreat = 0;
                levelThirtytwoGreat = 0;
                levelThirtytreeGreat = 0;
                levelThirtyfourGreat = 0;
                levelThirtyfiveGreat = 0;
                levelThirtysixGreat = 0;
                kisit = 0;


            }
        });

        no.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                if (getGameoverstate() <=3 ){
                    game4.setScreen(game4.oneScreen);
                }

                if (gameoverstate>3 && gameoverstate<=15 ){
                    game4.setScreen(game4.missionScreen);
                }
                if (gameoverstate>15 && gameoverstate <=27){
                    game4.setScreen(game4.missionScreenTwo);
                }
                if (gameoverstate>27){
                    game4.setScreen(game4.missionScreenTree);
                }
                label.setText("");
                toplamGreat =0;
                easymodeGreat = 0;
                timemodeGreat = 0;
                levelOneGreat =0;
                levelTwoGreat =0;
                levelTreeGreat =0;
                levelFourGreat =0;
                levelFiveGreat =0;
                levelSixGreat =0;
                levelSevenGreat = 0;
                levelEigthGreat=0;
                levelNineGreat = 0;
                levelTenGreat = 0;
                levelElevenGreat = 0;
                levelTwelveGreat = 0;
                levelThirteenGreat = 0;
                levelFourteenGreat = 0;
                levelFiveteenGreat =0;
                levelSixteenGreat = 0;
                levelSeventeenGreat = 0;
                levelEigthteenGreat = 0;
                levelNineteenGreat = 0;
                levelTwentyGreat = 0;
                levelTwentyoneGreat = 0;
                levelTwentytwoGreat = 0;
                levelTwentytreeGreat = 0;
                levelTwentyfourGreat = 0;
                levelTwentyfiveGreat = 0;
                levelTwentysixGreat = 0;
                levelTwentysevenGreat = 0;
                levelTwentyeightGreat = 0;
                levelTwentynineGreat = 0;
                levelThirtyGreat = 0;
                levelThirtyoneGreat = 0;
                levelThirtytwoGreat = 0;
                levelThirtytreeGreat = 0;
                levelThirtyfourGreat = 0;
                levelThirtyfiveGreat = 0;
                levelThirtysixGreat = 0;
                kisit = 0;
            }
        });



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

    public int getToplamGreat(){return toplamGreat;}

    public void setToplamGreat(int toplamGreat){
        this.toplamGreat = toplamGreat;
    }

    public int getEasymodeGreat() {
        return easymodeGreat;
    }

    public void setEasymodeGreat(int easymodeGreat) {
        this.easymodeGreat = easymodeGreat;
    }

    public int getTimemodeGreat() {
        return timemodeGreat;
    }

    public void setTimemodeGreat(int timemodeGreat) {
        this.timemodeGreat = timemodeGreat;
    }

    public int getLevelOneGreat(){return levelOneGreat;}

    public void setLevelOneGreat(int levelOneGreat){this.levelOneGreat = levelOneGreat;}

    public int getLevelTwoGreat() {
        return levelTwoGreat;
    }

    public void setLevelTwoGreat(int levelTwoGreat) {
        this.levelTwoGreat = levelTwoGreat;
    }

    public int getLevelTreeGreat() {
        return levelTreeGreat;
    }

    public void setLevelTreeGreat(int levelTreeGreat) {
        this.levelTreeGreat = levelTreeGreat;
    }

    public int getLevelFourGreat() {
        return levelFourGreat;
    }

    public void setLevelFourGreat(int levelFourGreat) {
        this.levelFourGreat = levelFourGreat;
    }

    public int getLevelFiveGreat() {
        return levelFiveGreat;
    }

    public void setLevelFiveGreat(int levelFiveGreat) {
        this.levelFiveGreat = levelFiveGreat;
    }

    public int getLevelSixGreat() {
        return levelSixGreat;
    }

    public void setLevelSixGreat(int levelSixGreat) {
        this.levelSixGreat = levelSixGreat;
    }

    public int getLevelSevenGreat() {
        return levelSevenGreat;
    }

    public void setLevelSevenGreat(int levelSevenGreat) {
        this.levelSevenGreat = levelSevenGreat;
    }

    public int getLevelEigthGreat() {
        return levelEigthGreat;
    }

    public void setLevelEigthGreat(int levelEigthGreat) {
        this.levelEigthGreat = levelEigthGreat;
    }

    public int getLevelNineGreat() {
        return levelNineGreat;
    }

    public void setLevelNineGreat(int levelNineGreat) {
        this.levelNineGreat = levelNineGreat;
    }

    public int getLevelTenGreat() {
        return levelTenGreat;
    }
    public void setLevelTenGreat(int levelTenGreat) {
        this.levelTenGreat = levelTenGreat;
    }

    public int getLevelElevenGreat() {
        return levelElevenGreat;
    }

    public void setLevelElevenGreat(int levelElevenGreat) {
        this.levelElevenGreat = levelElevenGreat;
    }

    public int getLevelTwelveGreat() {
        return levelTwelveGreat;
    }

    public void setLevelTwelveGreat(int levelTwelveGreat) {
        this.levelTwelveGreat = levelTwelveGreat;
    }

    public int getLevelThirteenGreat() {
        return levelThirteenGreat;
    }

    public void setLevelThirteenGreat(int levelThirteenGreat) {
        this.levelThirteenGreat = levelThirteenGreat;
    }

    public int getLevelFourteenGreat() {
        return levelFourteenGreat;
    }

    public void setLevelFourteenGreat(int levelFourteenGreat) {
        this.levelFourteenGreat = levelFourteenGreat;
    }

    public int getLevelFiveteenGreat() {
        return levelFiveteenGreat;
    }

    public void setLevelFiveteenGreat(int levelFiveteenGreat) {
        this.levelFiveteenGreat = levelFiveteenGreat;
    }

    public int getLevelSixteenGreat() {
        return levelSixteenGreat;
    }

    public void setLevelSixteenGreat(int levelSixteenGreat) {
        this.levelSixteenGreat = levelSixteenGreat;
    }

    public int getLevelSeventeenGreat() {
        return levelSeventeenGreat;
    }

    public void setLevelSeventeenGreat(int levelSeventeenGreat) {
        this.levelSeventeenGreat = levelSeventeenGreat;
    }

    public int getLevelEigthteenGreat() {
        return levelEigthteenGreat;
    }

    public void setLevelEigthteenGreat(int levelEigthteenGreat) {
        this.levelEigthteenGreat = levelEigthteenGreat;
    }

    public int getLevelNineteenGreat() {
        return levelNineteenGreat;
    }

    public void setLevelNineteenGreat(int levelNineteenGreat) {
        this.levelNineteenGreat = levelNineteenGreat;
    }

    public int getLevelTwentyGreat() {
        return levelTwentyGreat;
    }

    public void setLevelTwentyGreat(int levelTwentyGreat) {
        this.levelTwentyGreat = levelTwentyGreat;
    }

    public int getLevelTwentyoneGreat() {
        return levelTwentyoneGreat;
    }

    public void setLevelTwentyoneGreat(int levelTwentyoneGreat) {
        this.levelTwentyoneGreat = levelTwentyoneGreat;
    }

    public int getLevelTwentytwoGreat() {
        return levelTwentytwoGreat;
    }

    public void setLevelTwentytwoGreat(int levelTwentytwoGreat) {
        this.levelTwentytwoGreat = levelTwentytwoGreat;
    }

    public int getLevelTwentytreeGreat() {
        return levelTwentytreeGreat;
    }

    public void setLevelTwentytreeGreat(int levelTwentytreeGreat) {
        this.levelTwentytreeGreat = levelTwentytreeGreat;
    }

    public int getLevelTwentyfourGreat() {
        return levelTwentyfourGreat;
    }

    public void setLevelTwentyfourGreat(int levelTwentyfourGreat) {
        this.levelTwentyfourGreat = levelTwentyfourGreat;
    }

    public int getLevelTwentyfiveGreat() {
        return levelTwentyfiveGreat;
    }

    public void setLevelTwentyfiveGreat(int levelTwentyfiveGreat) {
        this.levelTwentyfiveGreat = levelTwentyfiveGreat;
    }
    public int getLevelTwentysixGreat() {
        return levelTwentysixGreat;
    }

    public void setLevelTwentysixGreat(int levelTwentysixGreat) {
        this.levelTwentysixGreat = levelTwentysixGreat;
    }

    public int getLevelTwentysevenGreat() {
        return levelTwentysevenGreat;
    }

    public void setLevelTwentysevenGreat(int levelTwentysevenGreat) {
        this.levelTwentysevenGreat = levelTwentysevenGreat;
    }
    public int getLevelTwentyeightGreat() {
        return levelTwentyeightGreat;
    }

    public void setLevelTwentyeightGreat(int levelTwentyeightGreat) {
        this.levelTwentyeightGreat = levelTwentyeightGreat;
    }

    public int getLevelTwentynineGreat() {
        return levelTwentynineGreat;
    }

    public void setLevelTwentynineGreat(int levelTwentynineGreat) {
        this.levelTwentynineGreat = levelTwentynineGreat;
    }

    public int getLevelThirtyGreat() {
        return levelThirtyGreat;
    }

    public void setLevelThirtyGreat(int levelThirtyGreat) {
        this.levelThirtyGreat = levelThirtyGreat;
    }

    public int getLevelThirtyoneGreat() {
        return levelThirtyoneGreat;
    }

    public void setLevelThirtyoneGreat(int levelThirtyoneGreat) {
        this.levelThirtyoneGreat = levelThirtyoneGreat;
    }

    public int getLevelThirtytwoGreat() {
        return levelThirtytwoGreat;
    }

    public void setLevelThirtytwoGreat(int levelThirtytwoGreat) {
        this.levelThirtytwoGreat = levelThirtytwoGreat;
    }

    public int getLevelThirtytreeGreat() {
        return levelThirtytreeGreat;
    }

    public void setLevelThirtytreeGreat(int levelThirtytreeGreat) {
        this.levelThirtytreeGreat = levelThirtytreeGreat;
    }

    public int getLevelThirtyfourGreat() {
        return levelThirtyfourGreat;
    }

    public void setLevelThirtyfourGreat(int levelThirtyfourGreat) {
        this.levelThirtyfourGreat = levelThirtyfourGreat;
    }

    public int getLevelThirtyfiveGreat() {
        return levelThirtyfiveGreat;
    }

    public void setLevelThirtyfiveGreat(int levelThirtyfiveGreat) {
        this.levelThirtyfiveGreat = levelThirtyfiveGreat;
    }

    public int getLevelThirtysixGreat() {
        return levelThirtysixGreat;
    }

    public void setLevelThirtysixGreat(int levelThirtysixGreat) {
        this.levelThirtysixGreat = levelThirtysixGreat;
    }

    public int getGreatayir() {
        return greatayir;
    }

    public void setGreatayir(int greatayir) {
        this.greatayir = greatayir;
    }

    public int getGameoverstate() {
        return gameoverstate;

    }

    public void setGameoverstate(int gameoverstate) {
        this.gameoverstate = gameoverstate;
    }

    public int getParasayigreat() {
        return parasayigreat;
    }

    public void setParasayigreat(int parasayigreat) {
        this.parasayigreat = parasayigreat;
    }
}

