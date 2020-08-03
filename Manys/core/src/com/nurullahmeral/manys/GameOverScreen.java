package com.nurullahmeral.manys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameOverScreen implements Screen {

    private Stage stage;
    private SpriteBatch batch;
    private Skin skin2,skin;
    private float buttonx,buttony;
    private float buttonboy;
    private float azalt;
    private Texture gameover,para,howmuch;
    private TextField textField;
    private Image image,image2;
    private BitmapFont font;
    private TextureAtlas levelatlas;
    private TextButton.TextButtonStyle style1,style2,style3,style4,style5,style6,style7,style8,style9,style0,styledel,styleok;
    private TextButton zero;
    private TextButton bir;
    private TextButton iki;
    private TextButton uc;
    private TextButton dort;
    private TextButton bes;
    private TextButton alti;
    private TextButton yedi;
    private TextButton sekiz;
    private TextButton dokuz;
    private Label label;
    Sound greatses,gameoverses;
    private TextureRegion region,region2;
    int toplamgameover = 0;
    int easytoplam = 0;
    int timemodetoplam = 0;
    int levelbirtoplam = 0;
    int levelikitoplam = 0;
    int leveltreetoplam = 0;
    int levelfourtoplam = 0;
    int levelfivetoplam = 0;
    int levelsixtoplam = 0;
    int levelseventoplam = 0;
    int leveleigthtoplam = 0;
    int levelninetoplam = 0;
    int leveltentoplam = 0;
    int leveleleventoplam = 0;
    int leveltwelvetoplam =0;
    int levelthirteentoplam =0;
    int levelfourteentoplam = 0;
    int levelfiveteentoplam = 0;
    int levelsixteentoplam = 0;
    int levelseventeentoplam = 0;
    int leveleigthteentoplam = 0;
    int levelnineteentoplam = 0;
    int leveltwentytoplam = 0;
    int leveltwentyonetoplam = 0;
    int leveltwentytwotoplam = 0;
    int leveltwentytreetoplam = 0;
    int leveltwentyfourtoplam = 0;
    int leveltwentyfivetoplam = 0;
    int leveltwentysixtoplam = 0;
    int leveltwentyseventoplam = 0;
    int leveltwentyeigthtoplam = 0;
    int leveltwentyninetoplam = 0;
    int levelthirtytoplam = 0;
    int levelthirtyonetoplam = 0;
    int levelthirtytwotoplam = 0;
    int levelthirtytreetoplam = 0;
    int levelthirtyfourtoplam = 0;
    int levelthirtyfivetoplam = 0;
    int levelthirtysixtoplam = 0;
    int soundvolume = 1;
    int parasayi;



    CountMoneyGame game6;
    GameOverOne gameOverOne;
    GreatScreen greatScreen;
    Texture img;


    //private Image gameover;
    private TextButton retry;
    private TextButton del;

    public GameOverScreen(final CountMoneyGame game6,final GameOverOne gameOverOne,final GreatScreen greatScreen) {
        this.gameOverOne = gameOverOne;
        this.greatScreen = greatScreen;
        this.game6 = game6;


        batch = new SpriteBatch();
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
        skin2 = skin = game6.getAssetManager().get("glassy-ui.json");
        buttonboy = Gdx.graphics.getWidth()*17/108;
        buttonx = Gdx.graphics.getWidth()*25/108;
        buttony = Gdx.graphics.getWidth()*43/54;
        azalt = Gdx.graphics.getHeight()/100;

        gameover= game6.getAssetManager().get("arkaplan.png",Texture.class);
        img = game6.getAssetManager().get("howmuch.png",Texture.class);
        greatses = game6.getAssetManager().get("welldone.mp3");
        gameoverses = game6.getAssetManager().get("gameover.mp3");
       // para = new Texture(Gdx.files.internal("para.png"));

        region = new TextureRegion(gameover,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
       // region2 = new TextureRegion(para,Gdx.graphics.getWidth()/10,Gdx.graphics.getHeight()/10,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());


        image = new Image(region);

        font = new BitmapFont();
        levelatlas = game6.getAssetManager().get("ui.atlas",TextureAtlas.class);
        skin = new Skin();

        skin.addRegions(levelatlas);

        style1 = new TextButton.TextButtonStyle();
        style2 = new TextButton.TextButtonStyle();
        style3 = new TextButton.TextButtonStyle();
        style4 = new TextButton.TextButtonStyle();
        style5 = new TextButton.TextButtonStyle();
        style6 = new TextButton.TextButtonStyle();
        style7 = new TextButton.TextButtonStyle();
        style8 = new TextButton.TextButtonStyle();
        style9 = new TextButton.TextButtonStyle();
        style0 = new TextButton.TextButtonStyle();
        styleok = new TextButton.TextButtonStyle();
        styledel = new TextButton.TextButtonStyle();


        style0.font = font;
        style0.up = skin.getDrawable("howzero");
        style0.down = skin.getDrawable("howzero");


        styleok.font = font;
        styleok.up = skin.getDrawable("howok");
        styleok.down = skin.getDrawable("howok");


        styledel.font = font;
        styledel.up = skin.getDrawable("howdel");
        styledel.down = skin.getDrawable("howdel");


        style1.font = font;
        style1.up = skin.getDrawable("howone");
        style1.down = skin.getDrawable("howone");


        style2.font = font;
        style2.up = skin.getDrawable("howtwo");
        style2.down = skin.getDrawable("howtwo");

        style3.font = font;
        style3.up = skin.getDrawable("howtree");
        style3.down = skin.getDrawable("howtree");

        style4.font = font;
        style4.up = skin.getDrawable("howfour");
        style4.down = skin.getDrawable("howfour");

        style5.font = font;
        style5.up = skin.getDrawable("howfive");
        style5.down = skin.getDrawable("howfive");

        style6.font = font;
        style6.up = skin.getDrawable("howsix");
        style6.down = skin.getDrawable("howsix");

        style7.font = font;
        style7.up = skin.getDrawable("howseven");
        style7.down = skin.getDrawable("howseven");

        style8.font = font;
        style8.up = skin.getDrawable("howeigth");
        style8.down = skin.getDrawable("howeigth");

        style9.font = font;
        style9.up = skin.getDrawable("hownine");
        style9.down = skin.getDrawable("hownine");

        //image2 = new Image(region2);
        //image.setPosition(0,0);
        //image.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());


        retry = new TextButton("",styleok);
        retry.setSize(buttonboy,buttonboy);
        retry.setPosition(Gdx.graphics.getWidth()*7/12,Gdx.graphics.getHeight()*4/7);
        label = new Label("",skin2,"font-big","black");
        label.setSize(600,100);
        label.setPosition(buttonx,Gdx.graphics.getHeight()*5/7);
        zero = new TextButton("",style0);
        zero.setSize(buttonboy,buttonboy);
        zero.setPosition(buttonx+azalt+buttonboy,(buttony-azalt*3)-(buttonboy*3));
        bir = new TextButton("",style1);
        bir.setSize(buttonboy,buttonboy);
        bir.setPosition(buttonx,buttony);
        iki = new TextButton("",style2);
        iki.setSize(buttonboy,buttonboy);
        iki.setPosition((buttonx+azalt+buttonboy),buttony);
        uc = new TextButton("",style3);
        uc.setSize(buttonboy,buttonboy);
        uc.setPosition(buttonx+2*buttonboy+2*azalt,buttony);
        dort = new TextButton("",style4);
        dort.setSize(buttonboy,buttonboy);
        dort.setPosition(buttonx,buttony-azalt-buttonboy);
        bes = new TextButton("",style5);
        bes.setSize(buttonboy,buttonboy);
        bes.setPosition((buttonx+azalt+buttonboy),buttony-azalt-buttonboy);
        alti = new TextButton("",style6);
        alti.setSize(buttonboy,buttonboy);
        alti.setPosition(buttonx+2*buttonboy+2*azalt,buttony-azalt-buttonboy);
        yedi = new TextButton("",style7);
        yedi.setSize(buttonboy,buttonboy);
        yedi.setPosition(buttonx,buttony-azalt*2-buttonboy*2);
        sekiz = new TextButton("",style8);
        sekiz.setSize(buttonboy,buttonboy);
        sekiz.setPosition((buttonx+azalt+buttonboy),buttony-azalt*2-buttonboy*2);
        dokuz = new TextButton("",style9);
        dokuz.setSize(buttonboy,buttonboy);
        dokuz.setPosition(buttonx+2*buttonboy+2*azalt,buttony-azalt*2-buttonboy*2);
        del = new TextButton("",styledel);
        del.setSize(buttonboy,buttonboy);
        del.setPosition(buttonx,(buttony-azalt*3)-(buttonboy*3));


        zero.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {






                label.setText(label.getText()+"0");


            }
        });
        bir.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                label.setText(label.getText()+"1");
                //  for (TextureRegion textureRegion:anim.getKeyFrames()) {
                //   if(textureRegion.isFlipX()) textureRegion.flip(true,false);
                //   }
            }
        });

        iki.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                label.setText(label.getText()+"2");
            }
        });

        uc.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                label.setText(label.getText()+"3");
            }
        });

        dort.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                label.setText(label.getText()+"4");
            }
        });

        bes.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                label.setText(label.getText()+"5");
            }
        });

        alti.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                label.setText(label.getText()+"6");
            }
        });

        yedi.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                label.setText(label.getText()+"7");
            }
        });

        sekiz.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                label.setText(label.getText()+"8");
            }
        });

        dokuz.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                label.setText(label.getText()+"9");
            }
        });
        del.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                label.setText("");

            }
        });

        retry.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                if (toplamgameover == 0 && easytoplam == 0 && timemodetoplam == 0 && levelbirtoplam == 0 && levelikitoplam == 0 &&
                        leveltreetoplam == 0 && levelfourtoplam == 0 && levelfivetoplam == 0 && levelsixtoplam == 0 && levelseventoplam == 0 &&
                leveleigthtoplam == 0 && levelninetoplam == 0 && leveltentoplam == 0 && leveleleventoplam == 0 && leveltwelvetoplam == 0 &&
                levelthirteentoplam == 0 && levelfourteentoplam == 0 && levelfiveteentoplam == 0){

                    game6.setScreen(game6.gameOverOne);
                    gameOverOne.setToplamgameoverone(0);

                }

                if (toplamgameover != 0 ){

                    if (label.getText().toString().equals(String.valueOf(toplamgameover))){

                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(1);
                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setToplamGreat(toplamgameover);
                        greatScreen.setParasayigreat(parasayi);

                    } else{
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(1);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");
                        gameOverOne.setToplamgameoverone(toplamgameover);


                    }
                }

                if (easytoplam != 0) {

                    if (label.getText().toString().equals(String.valueOf(easytoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(2);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setEasymodeGreat(easytoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(2);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");
                        System.out.println("denek" + gameOverOne.getToplamgameoverone());
                        System.out.println("toplamgameover" + toplamgameover);
                        gameOverOne.setToplamgameoverone(easytoplam);
                    }
                }

                if (timemodetoplam != 0) {

                    if (label.getText().toString().equals(String.valueOf(timemodetoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(3);
                        greatScreen.setParasayigreat(parasayi);
                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setTimemodeGreat(timemodetoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(3);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(timemodetoplam);
                    }
                }

                if (levelbirtoplam != 0) {

                    if (label.getText().toString().equals(String.valueOf(levelbirtoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(4);
                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelOneGreat(levelbirtoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(4);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(levelbirtoplam);
                    }
                }

                if (levelikitoplam != 0) {

                    if (label.getText().toString().equals(String.valueOf(levelikitoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(5);
                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelTwoGreat(levelikitoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(5);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(levelikitoplam);
                    }
                }

                if (leveltreetoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(leveltreetoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(6);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelTreeGreat(leveltreetoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(6);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(leveltreetoplam);
                    }
                }
                if (levelfourtoplam!= 0) {
                    if (label.getText().toString().equals(String.valueOf(levelfourtoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(7);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelFourGreat(levelfourtoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(7);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(levelfourtoplam);
                    }
                }
                if (levelfivetoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(levelfivetoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(8);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelFiveGreat(levelfivetoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(8);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(levelfivetoplam);
                    }
                }

                if (levelsixtoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(levelsixtoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(9);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelSixGreat(levelsixtoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(9);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(levelsixtoplam);
                    }
                }

                if (levelseventoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(levelseventoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(10);;

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelSevenGreat(levelseventoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(10);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(levelseventoplam);
                    }
                }
                if (leveleigthtoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(leveleigthtoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(11);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelEigthGreat(leveleigthtoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(11);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(leveleigthtoplam);
                    }

                }
                if (levelninetoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(levelninetoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(12);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelNineGreat(levelninetoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(12);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(levelninetoplam);
                    }

                }
                if (leveltentoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(leveltentoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(13);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelTenGreat(leveltentoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(13);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(leveltentoplam);
                    }

                }
                if (leveleleventoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(leveleleventoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(14);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelElevenGreat(leveleleventoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(14);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(leveleleventoplam);
                    }

                }
                if (leveltwelvetoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(leveltwelvetoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(15);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelTwelveGreat(leveltwelvetoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(15);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(leveltwelvetoplam);
                    }

                }
                if (levelthirteentoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(levelthirteentoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(16);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelThirteenGreat(levelthirteentoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(16);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(levelthirteentoplam);
                    }

                }
                if (levelfourteentoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(levelfourteentoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(17);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelFourteenGreat(levelfourteentoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(17);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(levelfourteentoplam);
                    }

                }
                if (levelfiveteentoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(levelfiveteentoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(18);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelFiveteenGreat(levelfiveteentoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(18);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(levelfiveteentoplam);
                    }

                }

                if (levelsixteentoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(levelsixteentoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(19);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelSixteenGreat(levelsixteentoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(19);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(levelsixteentoplam);
                    }

                }
                if (levelseventeentoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(levelseventeentoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(20);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelSeventeenGreat(levelseventeentoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(20);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(levelseventeentoplam);
                    }

                }
                if (leveleigthteentoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(leveleigthteentoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(21);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelEigthteenGreat(leveleigthteentoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(21);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(leveleigthteentoplam);
                    }

                }
                if (levelnineteentoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(levelnineteentoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(22);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelNineteenGreat(levelnineteentoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(22);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(levelnineteentoplam);
                    }

                }
                if (leveltwentytoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(leveltwentytoplam))) {
                        greatses.play(getSoundvolume());
                        ;
                        greatScreen.setGameoverstate(23);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelTwentyGreat(leveltwentytoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(23);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(leveltwentytoplam);
                    }

                }
                if (leveltwentyonetoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(leveltwentyonetoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(24);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelTwentyoneGreat(leveltwentyonetoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(24);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(leveltwentyonetoplam);
                    }

                }
                if (leveltwentytwotoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(leveltwentytwotoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(25);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelTwentytwoGreat(leveltwentytwotoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(25);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(leveltwentytwotoplam);
                    }

                }
                if (leveltwentytreetoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(leveltwentytreetoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(26);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelTwentytreeGreat(leveltwentytreetoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(26);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(leveltwentytreetoplam);
                    }

                }
                if (leveltwentyfourtoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(leveltwentyfourtoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(27);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelTwentyfourGreat(leveltwentyfourtoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(27);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(leveltwentyfourtoplam);
                    }

                }
                if (leveltwentyfivetoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(leveltwentyfivetoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(28);;

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelTwentyfiveGreat(leveltwentyfivetoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(28);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(leveltwentyfivetoplam);
                    }

                }
                if (leveltwentysixtoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(leveltwentysixtoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(29);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelTwentysixGreat(leveltwentysixtoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(29);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(leveltwentysixtoplam);
                    }

                }
                if (leveltwentyseventoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(leveltwentyseventoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(30);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelTwentysevenGreat(leveltwentyseventoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(30);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(leveltwentyseventoplam);
                    }

                }
                if (leveltwentyeigthtoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(leveltwentyeigthtoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(31);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelTwentyeightGreat(leveltwentyeigthtoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(31);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(leveltwentyeigthtoplam);
                    }

                }
                if (leveltwentyninetoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(leveltwentyninetoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(32);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelTwentynineGreat(leveltwentyninetoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(32);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(leveltwentyninetoplam);
                    }

                }
                if (levelthirtytoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(levelthirtytoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(33);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelThirtyGreat(levelthirtytoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(33);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(levelthirtytoplam);
                    }

                }

                if (levelthirtyonetoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(levelthirtyonetoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(34);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelThirtyoneGreat(levelthirtyonetoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(34);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(levelthirtyonetoplam);
                    }

                }
                if (levelthirtytwotoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(levelthirtytwotoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(35);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelThirtytwoGreat(levelthirtytwotoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(35);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(levelthirtytwotoplam);
                    }

                }
                if (levelthirtytreetoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(levelthirtytreetoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(36);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelThirtytreeGreat(levelthirtytreetoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(36);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(levelthirtytreetoplam);
                    }

                }
                if (levelthirtyfourtoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(levelthirtyfourtoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(37);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelThirtyfourGreat(levelthirtyfourtoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(37);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(levelthirtyfourtoplam);
                    }

                }
                if (levelthirtyfivetoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(levelthirtyfivetoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(38);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelThirtyfiveGreat(levelthirtyfivetoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(38);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(levelthirtyfivetoplam);
                    }

                }
                if (levelthirtysixtoplam != 0) {
                    if (label.getText().toString().equals(String.valueOf(levelthirtysixtoplam))) {
                        greatses.play(getSoundvolume());
                        greatScreen.setGameoverstate(39);

                        game6.setScreen(game6.greatScreen);
                        label.setText("");
                        greatScreen.setLevelThirtysixGreat(levelthirtysixtoplam);
                    } else {
                        gameoverses.play(getSoundvolume());
                        gameOverOne.setGameoverstate(39);
                        game6.setScreen(game6.gameOverOne);
                        label.setText("");

                        gameOverOne.setToplamgameoverone(levelthirtysixtoplam);
                    }

                }



                toplamgameover = 0;
                easytoplam = 0;
                timemodetoplam = 0;
                levelbirtoplam = 0;
                levelikitoplam = 0;
                leveltreetoplam =0;
                levelfourtoplam = 0;
                levelfivetoplam = 0;
                levelsixtoplam = 0;
                levelseventoplam = 0;
                levelninetoplam = 0;
                leveltentoplam = 0;
                leveleleventoplam = 0;
                leveltwelvetoplam = 0;
                levelthirteentoplam = 0;
                levelfourteentoplam = 0;
                levelfiveteentoplam = 0;
                levelsixtoplam = 0;
                levelseventoplam = 0;
                leveleigthtoplam = 0;
                levelninetoplam = 0;
                leveltentoplam = 0;
                leveleleventoplam = 0;
                leveltwelvetoplam =0;
                levelthirteentoplam =0;
                levelfourteentoplam = 0;
                levelfiveteentoplam = 0;
                levelsixteentoplam = 0;
                levelseventeentoplam = 0;
                leveleigthteentoplam = 0;
                levelnineteentoplam = 0;
                leveltwentytoplam = 0;
                leveltwentyonetoplam = 0;
                leveltwentytwotoplam = 0;
                leveltwentytreetoplam = 0;
                leveltwentyfourtoplam = 0;
                leveltwentyfivetoplam = 0;
                leveltwentysixtoplam = 0;
                leveltwentyseventoplam = 0;
                leveltwentyeigthtoplam = 0;
                leveltwentyninetoplam = 0;
                levelthirtytoplam = 0;
                levelthirtyonetoplam = 0;
                levelthirtytwotoplam = 0;
                levelthirtytreetoplam = 0;
                levelthirtyfourtoplam = 0;
                levelthirtyfivetoplam = 0;
                levelthirtysixtoplam = 0;



            }
        });

        retry.setSize(buttonboy,buttonboy);
        retry.setPosition(buttonx+2*buttonboy+2*azalt,(buttony-azalt*3)-(buttonboy*3));

        textField = new TextField("",skin2,"default");
        textField.setPosition(buttonx,Gdx.graphics.getHeight()/2-buttonboy);
        textField.setSize(Gdx.graphics.getWidth()/3+azalt,Gdx.graphics.getHeight()/20);


       // stage.addActor(image);
       // stage.addActor(image2);
        stage.addActor(retry);
        stage.addActor(del);
        //stage.addActor(textField);
        stage.addActor(zero);
        stage.addActor(bir);
        stage.addActor(iki);
        stage.addActor(uc);
        stage.addActor(dort);
        stage.addActor(bes);
        stage.addActor(alti);
        stage.addActor(yedi);
        stage.addActor(sekiz);
        stage.addActor(dokuz);
        stage.addActor(label);




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
        greatses.dispose();
        gameoverses.dispose();
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        parasayi = getParasayi();

        batch.draw(gameover, 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        batch.draw(img, 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        if (Gdx.input.isKeyPressed(Input.Keys.BACK)){
            game6.setScreen(game6.oneScreen);
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

    public int getToplamgameover(){
        return toplamgameover;
    }

    public void setToplamgameover(int toplamgameover){
        this.toplamgameover = toplamgameover;
    }

    public int getEasytoplam() {
        return easytoplam;
    }

    public void setEasytoplam(int easytoplam) {
        this.easytoplam = easytoplam;
    }

    public int getTimemodetoplam() {
        return timemodetoplam;
    }

    public void setTimemodetoplam(int timemodetoplam) {
        this.timemodetoplam = timemodetoplam;
    }

    public int getLevelbirtoplam(){
        return levelbirtoplam;
    }
    public void setLevelbirtoplam(int levelbirtoplam){
        this.levelbirtoplam = levelbirtoplam;
    }
    public int getLevelikitoplam(){return levelikitoplam;}
    public void setLevelikitoplam(int levelikitoplam){this.levelikitoplam = levelikitoplam;}

    public int getLeveltreetoplam(){return leveltreetoplam;}
    public void setLeveltreetoplam(int leveltreetoplam){this.leveltreetoplam = leveltreetoplam;}

    public int getLevelfourtoplam(){return levelfourtoplam;}
    public void setLevelfourtoplam(int levelfourtoplam){this.levelfourtoplam = levelfourtoplam;}

    public int getLevelfivetoplam(){return levelfivetoplam;}
    public void setLevelfivetoplam(int levelfivetoplam){this.levelfivetoplam = levelfivetoplam;}

    public int getLevelsixtoplam(){return levelsixtoplam;}
    public void setLevelsixtoplam(int levelsixtoplam){this.levelsixtoplam = levelsixtoplam;}

    public int getLevelseventoplam(){return levelseventoplam;}
    public void setLevelseventoplam(int levelseventoplam){this.levelseventoplam = levelseventoplam;}

    public int getLeveleigthtoplam(){return leveleigthtoplam;}
    public void setLeveleigthtoplam(int leveleigthtoplam) {
        this.leveleigthtoplam = leveleigthtoplam;
    }

    public int getLevelninetoplam() {
        return levelninetoplam;
    }

    public void setLevelninetoplam(int levelninetoplam) {
        this.levelninetoplam = levelninetoplam;
    }

    public int getLeveltentoplam() {
        return leveltentoplam;
    }

    public void setLeveltentoplam(int leveltentoplam) {
        this.leveltentoplam = leveltentoplam;
    }

    public int getLeveleleventoplam() {
        return leveleleventoplam;
    }

    public void setLeveleleventoplam(int leveleleventoplam) {
        this.leveleleventoplam = leveleleventoplam;
    }

    public int getLeveltwelvetoplam() {
        return leveltwelvetoplam;
    }

    public void setLeveltwelvetoplam(int leveltwelvetoplam) {
        this.leveltwelvetoplam = leveltwelvetoplam;
    }

    public int getLevelthirteentoplam() {
        return levelthirteentoplam;
    }

    public void setLevelthirteentoplam(int levelthirteentoplam) {
        this.levelthirteentoplam = levelthirteentoplam;
    }

    public int getLevelfourteentoplam() {
        return levelfourteentoplam;
    }

    public void setLevelfourteentoplam(int levelfourteentoplam) {
        this.levelfourteentoplam = levelfourteentoplam;
    }

    public int getLevelfiveteentoplam() {
        return levelfiveteentoplam;
    }

    public void setLevelfiveteentoplam(int levelfiveteentoplam) {
        this.levelfiveteentoplam = levelfiveteentoplam;
    }

    public int getLevelsixteentoplam() {
        return levelsixteentoplam;
    }

    public void setLevelsixteentoplam(int levelsixteentoplam) {
        this.levelsixteentoplam = levelsixteentoplam;
    }

    public int getLevelseventeentoplam() {
        return levelseventeentoplam;
    }

    public void setLevelseventeentoplam(int levelseventeentoplam) {
        this.levelseventeentoplam = levelseventeentoplam;
    }

    public int getLeveleigthteentoplam() {
        return leveleigthteentoplam;
    }

    public void setLeveleigthteentoplam(int leveleigthteentoplam) {
        this.leveleigthteentoplam = leveleigthteentoplam;
    }

    public int getLevelnineteentoplam() {
        return levelnineteentoplam;
    }

    public void setLevelnineteentoplam(int levelnineteentoplam) {
        this.levelnineteentoplam = levelnineteentoplam;
    }

    public int getLeveltwentytoplam() {
        return leveltwentytoplam;
    }

    public void setLeveltwentytoplam(int leveltwentytoplam) {
        this.leveltwentytoplam = leveltwentytoplam;
    }

    public int getLeveltwentyonetoplam() {
        return leveltwentyonetoplam;
    }

    public void setLeveltwentyonetoplam(int leveltwentyonetoplam) {
        this.leveltwentyonetoplam = leveltwentyonetoplam;
    }

    public int getLeveltwentytwotoplam() {
        return leveltwentytwotoplam;
    }

    public void setLeveltwentytwotoplam(int leveltwentytwotoplam) {
        this.leveltwentytwotoplam = leveltwentytwotoplam;
    }

    public int getLeveltwentytreetoplam() {
        return leveltwentytreetoplam;
    }

    public void setLeveltwentytreetoplam(int leveltwentytreetoplam) {
        this.leveltwentytreetoplam = leveltwentytreetoplam;
    }

    public int getLeveltwentyfourtoplam() {
        return leveltwentyfourtoplam;
    }

    public void setLeveltwentyfourtoplam(int leveltwentyfourtoplam) {
        this.leveltwentyfourtoplam = leveltwentyfourtoplam;
    }

    public int getLeveltwentyfivetoplam() {
        return leveltwentyfivetoplam;
    }

    public void setLeveltwentyfivetoplam(int leveltwentyfivetoplam) {
        this.leveltwentyfivetoplam = leveltwentyfivetoplam;
    }

    public int getLeveltwentysixtoplam() {
        return leveltwentysixtoplam;
    }

    public void setLeveltwentysixtoplam(int leveltwentysixtoplam) {
        this.leveltwentysixtoplam = leveltwentysixtoplam;
    }

    public int getLeveltwentyseventoplam() {
        return leveltwentyseventoplam;
    }

    public void setLeveltwentyseventoplam(int leveltwentyseventoplam) {
        this.leveltwentyseventoplam = leveltwentyseventoplam;
    }

    public int getLeveltwentyeigthtoplam() {
        return leveltwentyeigthtoplam;
    }

    public void setLeveltwentyeigthtoplam(int leveltwentyeigthtoplam) {
        this.leveltwentyeigthtoplam = leveltwentyeigthtoplam;
    }

    public int getLeveltwentyninetoplam() {
        return leveltwentyninetoplam;
    }

    public void setLeveltwentyninetoplam(int leveltwentyninetoplam) {
        this.leveltwentyninetoplam = leveltwentyninetoplam;
    }

    public int getLevelthirtytoplam() {
        return levelthirtytoplam;
    }

    public void setLevelthirtytoplam(int levelthirtytoplam) {
        this.levelthirtytoplam = levelthirtytoplam;
    }

    public int getLevelthirtyonetoplam() {
        return levelthirtyonetoplam;
    }

    public void setLevelthirtyonetoplam(int levelthirtyonetoplam) {
        this.levelthirtyonetoplam = levelthirtyonetoplam;
    }

    public int getLevelthirtytwotoplam() {
        return levelthirtytwotoplam;
    }

    public void setLevelthirtytwotoplam(int levelthirtytwotoplam) {
        this.levelthirtytwotoplam = levelthirtytwotoplam;
    }

    public int getLevelthirtytreetoplam() {
        return levelthirtytreetoplam;
    }

    public void setLevelthirtytreetoplam(int levelthirtytreetoplam) {
        this.levelthirtytreetoplam = levelthirtytreetoplam;
    }

    public int getLevelthirtyfourtoplam() {
        return levelthirtyfourtoplam;
    }

    public void setLevelthirtyfourtoplam(int levelthirtyfourtoplam) {
        this.levelthirtyfourtoplam = levelthirtyfourtoplam;
    }

    public int getLevelthirtyfivetoplam() {
        return levelthirtyfivetoplam;
    }

    public void setLevelthirtyfivetoplam(int levelthirtyfivetoplam) {
        this.levelthirtyfivetoplam = levelthirtyfivetoplam;
    }

    public int getLevelthirtysixtoplam() {
        return levelthirtysixtoplam;
    }

    public void setLevelthirtysixtoplam(int levelthirtysixtoplam) {
        this.levelthirtysixtoplam = levelthirtysixtoplam;
    }

    public int getSoundvolume() {
        return soundvolume;
    }

    public void setSoundvolume(int soundvolume) {
        this.soundvolume = soundvolume;
    }

    public int getParasayi() {
        return parasayi;
    }

    public void setParasayi(int parasayi) {
        this.parasayi = parasayi;
    }
}


