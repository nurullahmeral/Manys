package com.nurullahmeral.manys;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.TimeUtils;

import java.awt.Image;

import static com.badlogic.gdx.Gdx.app;


public class CountMoneyGame extends Game {
    public PlayServices playServices;
    AssetManager assetManager;
    HistoryScreen historyScreen;
    GameOverScreen gameOverScreen;
    OneScreen oneScreen;
    Manys manys;
    SecondGameScreen secondGameScreen;
    EasyModeScreen easyModeScreen;
    GameOverOne gameOverOne;
    GameOverMission gameOverMission;
    GreatScreen greatScreen;
    MissionScreen missionScreen;
    MissionScreenTwo missionScreenTwo;
    MissionScreenTree missionScreenTree;
    ShopScreen shopScreen;
    LevelGameBir levelGameBir;
    LevelGameİki levelGameİki;
    LevelGameTree levelGameTree;
    LevelGameFour levelGameFour;
    LevelGameFive levelGameFive;
    LevelGameSix levelGameSix;
    LevelGameSeven levelGameSeven;
    LevelGameEight levelGameEight;
    LevelGameNine levelGameNine;
    LevelGameTen levelGameTen;
    LevelGameEleven levelGameEleven;
    LevelGameTwelve levelGameTwelve;
    LevelGameThirteen levelGameThirteen;
    LevelGameFourteen levelGameFourteen;
    LevelGameFiveteen levelGameFiveteen;
    LevelGameSixteen levelGameSixteen;
    LevelGameSeventeen levelGameSeventeen;
    LevelGameEigthteen levelGameEigthteen;
    LevelGameNineteen levelGameNineteen;
    LevelGameTwenty levelGameTwenty;
    LevelGameTwentyone levelGameTwentyone;
    LevelGameTwentytwo levelGameTwentytwo;
    LevelGameTwentytree levelGameTwentytree;
    LevelGameTwentyfour levelGameTwentyfour;
    LevelGameTwentyfive levelGameTwentyfive;
    LevelGameTwentysix levelGameTwentysix;
    LevelGameTwentyseven levelGameTwentyseven;
    LevelGameTwentyeight levelGameTwentyeight;
    LevelGameTwentynine levelGameTwentynine;
    LevelGameThirty levelGameThirty;
    LevelGameThirtyone levelGameThirtyone;
    LevelGameThirtytwo levelGameThirtytwo;
    LevelGameThirtytree levelGameThirtytree;
    LevelGameThirtyfour levelGameThirtyfour;
    LevelGameThirtyfive levelGameThirtyfive;
    LevelGameThirtysix levelGameThirtysix;
    SingInScreen singInScreen;


    HighScore highScore;
    LoadingScreen loadingScreen;
    ParticleEffect effect;
    Music music2;
    DialogTutarial dialogTutarial;
    Preferences preferences;
    BonusScreen bonusScreen;
    SettingScreen settingScreen;
    float volume = 0.5f;



    public AssetManager getAssetManager() {
        return assetManager;

    }

    public ParticleEffect getEffect() {
        return effect;

    }
    public CountMoneyGame(PlayServices playServices){
       this.playServices = playServices;
    }


    @Override
    public void create() {


        preferences = Gdx.app.getPreferences("Manys");

        assetManager = new AssetManager();
        assetManager.load("glassy-ui.json", Skin.class);
        assetManager.load("ses.mp3", Sound.class);
        assetManager.load("sessonn.mp3",Sound.class);
        assetManager.load("click.mp3",Sound.class);
        assetManager.load("ozellikclick.mp3",Sound.class);
        assetManager.load("welldone.mp3",Sound.class);
        assetManager.load("gameover.mp3",Sound.class);
        assetManager.load("kazannarkaplan.png",Texture.class);
        assetManager.load("deste.png",Texture.class);
        assetManager.load("bir.png", Texture.class);
        assetManager.load("iki.png", Texture.class);
        assetManager.load("bes.png", Texture.class);
        assetManager.load("on.png", Texture.class);
        assetManager.load("yirmi.png", Texture.class);
        assetManager.load("elli.png", Texture.class);
        assetManager.load("yuz.png", Texture.class);
        assetManager.load("bararkaplan.png",Texture.class);
        assetManager.load("baric.png",Texture.class);
        assetManager.load("slowly.png",Texture.class);
        assetManager.load("stop.png",Texture.class);
        assetManager.load("arkaplan.png",Texture.class);
        assetManager.load("howmuch.png",Texture.class);
        assetManager.load("reaccountscreen.png",Texture.class);
        assetManager.load("ui.atlas", TextureAtlas.class);
        assetManager.load("gameover.png",Texture.class);
        assetManager.load("great.png",Texture.class);
        assetManager.load("highscore.png",Texture.class);
        assetManager.load("levelarkaplanone.png",Texture.class);
        assetManager.load("levelarkaplantwo.png",Texture.class);
        assetManager.load("levelarkaplantree.png",Texture.class);
        assetManager.load("levelselect.png",Texture.class);
        assetManager.load("logo.png",Texture.class);
        assetManager.load("anaekranpara.png",Texture.class);
        assetManager.load("shop.png",Texture.class);
        assetManager.load("settings.png",Texture.class);
        assetManager.load("yesno.png",Texture.class);
        assetManager.load("youlosemission.png",Texture.class);
        assetManager.load("bonustext.png",Texture.class);
        assetManager.load("myfont.fnt", BitmapFont.class);





        assetManager.finishLoading();

        loadingScreen = new LoadingScreen(this);
        setScreen(loadingScreen);








    }

    public void FinishLoading(){


        effect = new ParticleEffect();
        effect.load(Gdx.files.internal("son.p"), Gdx.files.internal(""));
        effect.getEmitters().first().setPosition(Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() *6/ 7);
        effect.start();




        singInScreen = new SingInScreen(this);
        highScore = new HighScore(this);

        bonusScreen = new BonusScreen(this,highScore);

        missionScreen = new MissionScreen(this,highScore);
        missionScreenTwo = new MissionScreenTwo(this,highScore);
        missionScreenTree = new MissionScreenTree(this,highScore);
        greatScreen = new GreatScreen(this,missionScreen,highScore);
        oneScreen = new OneScreen(this,highScore,gameOverMission);
        historyScreen = new HistoryScreen(this,highScore,greatScreen);
        gameOverOne = new GameOverOne(this);
        gameOverScreen = new GameOverScreen(this,gameOverOne,greatScreen);
        gameOverMission = new GameOverMission(this);
        settingScreen = new SettingScreen(this,highScore,gameOverMission,gameOverScreen);

        dialogTutarial = new DialogTutarial(this);

        manys = new Manys(this,gameOverScreen,highScore) {
            @Override
            public boolean keyDown(int keycode) {
                return false;
            }

            @Override
            public boolean keyUp(int keycode) {
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                return false;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }

            @Override
            public boolean scrolled(int amount) {
                return false;
            }
        };
        secondGameScreen = new SecondGameScreen(this,gameOverScreen,highScore);
        easyModeScreen = new EasyModeScreen(this,gameOverScreen,highScore){
            @Override
            public boolean keyDown(int keycode) {
                return false;
            }

            @Override
            public boolean keyUp(int keycode) {
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                return false;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }

            @Override
            public boolean scrolled(int amount) {
                return false;
            }
        };
        shopScreen = new ShopScreen(this,highScore);


        levelGameBir = new LevelGameBir(this,gameOverScreen,missionScreen,gameOverMission);
        levelGameİki = new LevelGameİki(this,gameOverScreen,gameOverMission);
        levelGameTree = new LevelGameTree(this,gameOverScreen,gameOverMission);
        levelGameFour = new LevelGameFour(this,gameOverScreen);
        levelGameFive = new LevelGameFive(this,gameOverScreen);
        levelGameSix = new LevelGameSix(this,gameOverScreen);
        levelGameSeven = new LevelGameSeven(this,gameOverScreen,gameOverMission);
        levelGameEight = new LevelGameEight(this,gameOverScreen,gameOverMission);
        levelGameNine = new LevelGameNine(this,gameOverScreen,gameOverMission);
        levelGameTen = new LevelGameTen(this,gameOverScreen);
        levelGameEleven = new LevelGameEleven(this,gameOverScreen);
        levelGameTwelve = new LevelGameTwelve(this,gameOverScreen);
        levelGameThirteen = new LevelGameThirteen(this,gameOverScreen,gameOverMission);
        levelGameFourteen = new LevelGameFourteen(this,gameOverScreen,gameOverMission);
        levelGameFiveteen = new LevelGameFiveteen(this,gameOverScreen,gameOverMission);
        levelGameSixteen = new LevelGameSixteen(this,gameOverScreen);
        levelGameSeventeen = new LevelGameSeventeen(this,gameOverScreen);
        levelGameEigthteen = new LevelGameEigthteen(this,gameOverScreen);
        levelGameNineteen = new LevelGameNineteen(this,gameOverScreen,gameOverMission);
        levelGameTwenty = new LevelGameTwenty(this,gameOverScreen,gameOverMission);
        levelGameTwentyone = new LevelGameTwentyone(this,gameOverScreen,gameOverMission);
        levelGameTwentytwo = new LevelGameTwentytwo(this,gameOverScreen);
        levelGameTwentytree = new LevelGameTwentytree(this,gameOverScreen);
        levelGameTwentyfour = new LevelGameTwentyfour(this,gameOverScreen);
        levelGameTwentyfive = new LevelGameTwentyfive(this,gameOverScreen,gameOverMission);
        levelGameTwentysix = new LevelGameTwentysix(this,gameOverScreen,gameOverMission);
        levelGameTwentyseven = new LevelGameTwentyseven(this,gameOverScreen,gameOverMission);
        levelGameTwentyeight = new LevelGameTwentyeight(this,gameOverScreen);
        levelGameTwentynine = new LevelGameTwentynine(this,gameOverScreen);
        levelGameThirty = new LevelGameThirty(this,gameOverScreen);
        levelGameThirtyone = new LevelGameThirtyone(this,gameOverScreen,gameOverMission);
        levelGameThirtytwo = new LevelGameThirtytwo(this,gameOverScreen,gameOverMission);
        levelGameThirtytree = new LevelGameThirtytree(this,gameOverScreen,gameOverMission);
        levelGameThirtyfour = new LevelGameThirtyfour(this,gameOverScreen);
        levelGameThirtyfive = new LevelGameThirtyfive(this,gameOverScreen);
        levelGameThirtysix = new LevelGameThirtysix(this,gameOverScreen);


        setScreen(oneScreen);
    }

}
