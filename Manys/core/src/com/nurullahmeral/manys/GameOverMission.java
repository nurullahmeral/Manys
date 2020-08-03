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
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameOverMission implements Screen {
    CountMoneyGame game5;
    private SpriteBatch batch;
    private Texture gameoverone,img;
    private Stage stage;
    private Skin skin,buttonskin;
    private Label label;
    private TextButton yes,no;
    private TextButton.TextButtonStyle yesstyle,nostyle;
    private BitmapFont font;
    private TextureAtlas buttonatlas;
    private int toplamgameoverone;

    int gameoverstate;
    float buttonboy = 0.198f * Gdx.graphics.getWidth();




    public GameOverMission(final CountMoneyGame game5){
        this.game5 = game5;
        batch = new SpriteBatch();
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
        skin = game5.getAssetManager().get("glassy-ui.json");
        gameoverone = game5.getAssetManager().get("arkaplan.png");
        img = game5.getAssetManager().get("youlosemission.png");
        font = new BitmapFont();

        buttonatlas = game5.getAssetManager().get("ui.atlas",TextureAtlas.class);
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


        stage.addActor(yes);
        stage.addActor(no);



       // stage.addActor(label);
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
    }

    @Override
    public void render(float delta) {


        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();





        batch.draw(gameoverone, 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch.draw(img, 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        if (Gdx.input.isKeyPressed(Input.Keys.BACK)){
            game5.setScreen(game5.missionScreen);
        }

        yes.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {

                if (gameoverstate == 4){
                    game5.setScreen(game5.levelGameBir);
                }
                if (gameoverstate == 5){
                    game5.setScreen(game5.levelGameİki);
                }
                if (gameoverstate == 6){
                    game5.setScreen(game5.levelGameTree);
                }
                if (gameoverstate == 7){
                    game5.setScreen(game5.levelGameFour);
                }
                if (gameoverstate == 8){
                    game5.setScreen(game5.levelGameFive);
                }
                if (gameoverstate == 9){
                    game5.setScreen(game5.levelGameSix);
                }
                if (gameoverstate == 10){
                    game5.setScreen(game5.levelGameSeven);
                }
                if (gameoverstate == 11){
                    game5.setScreen(game5.levelGameEight);
                }
                if (gameoverstate == 12){
                    game5.setScreen(game5.levelGameNine);
                }
                if (gameoverstate == 13){
                    game5.setScreen(game5.levelGameTen);
                }
                if (gameoverstate == 14){
                    game5.setScreen(game5.levelGameEleven);
                }
                if (gameoverstate == 15){
                    game5.setScreen(game5.levelGameTwelve);
                }
                if (gameoverstate == 16){
                    game5.setScreen(game5.levelGameThirteen);
                }
                if (gameoverstate == 17){
                    game5.setScreen(game5.levelGameFourteen);
                }
                if (gameoverstate == 18){
                    game5.setScreen(game5.levelGameFiveteen);
                }
                if (gameoverstate == 19){
                    game5.setScreen(game5.levelGameSixteen);
                }
                if (gameoverstate == 20){
                    game5.setScreen(game5.levelGameSeventeen);
                }
                if (gameoverstate == 21){
                    game5.setScreen(game5.levelGameEigthteen);
                }
                if (gameoverstate == 22){
                    game5.setScreen(game5.levelGameNineteen);
                }
                if (gameoverstate == 23){
                    game5.setScreen(game5.levelGameTwenty);
                }
                if (gameoverstate == 24){
                    game5.setScreen(game5.levelGameTwentyone);
                }
                if (gameoverstate == 25){
                    game5.setScreen(game5.levelGameTwentytwo);
                }
                if (gameoverstate == 26){
                    game5.setScreen(game5.levelGameTwentytree);
                }
                if (gameoverstate == 27){
                    game5.setScreen(game5.levelGameTwentyfour);
                }
                if (gameoverstate == 28){
                    game5.setScreen(game5.levelGameTwentyfive);
                }
                if (gameoverstate == 29){
                    game5.setScreen(game5.levelGameTwentysix);
                }
                if (gameoverstate == 30){
                    game5.setScreen(game5.levelGameTwentyseven);
                }
                if (gameoverstate == 31){
                    game5.setScreen(game5.levelGameTwentyeight);
                }
                if (gameoverstate== 32){
                    game5.setScreen(game5.levelGameTwentynine);
                }
                if (gameoverstate == 33){
                    game5.setScreen(game5.levelGameThirty);
                }
                if (gameoverstate == 34){
                    game5.setScreen(game5.levelGameThirtyone);
                }
                if (gameoverstate == 35){
                    game5.setScreen(game5.levelGameThirtytwo);
                }
                if (gameoverstate == 36){
                    game5.setScreen(game5.levelGameThirtytree);
                }
                if (gameoverstate == 37){
                    game5.setScreen(game5.levelGameThirtyfour);
                }
                if (gameoverstate == 38){
                    game5.setScreen(game5.levelGameThirtyfive);
                }
                if (gameoverstate == 39){
                    game5.setScreen(game5.levelGameThirtysix);
                }


            }
        });

        no.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                if (getGameoverstate() <=3 ){
                    game5.setScreen(game5.oneScreen);
                }

                if (gameoverstate>3 && gameoverstate<=15 ){
                    game5.setScreen(game5.missionScreen);
                }
                if (gameoverstate>15 && gameoverstate <=27){
                    game5.setScreen(game5.missionScreenTwo);
                }
                if (gameoverstate>27){
                    game5.setScreen(game5.missionScreenTree);
                }

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

    public int getToplamgameoverone(){
        return toplamgameoverone;
    }

    public void setToplamgameoverone(int toplamgameoverone){
        this.toplamgameoverone = toplamgameoverone;
    }

    public int getGameoverstate() {
        return gameoverstate;

    }

    public void setGameoverstate(int gameoverstate) {
        this.gameoverstate = gameoverstate;
    }

}
