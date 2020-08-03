package com.nurullahmeral.manys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class HighScore implements Screen {
    CountMoneyGame game5;
    private SpriteBatch batch;
    private Texture gameoverone,arkaplan;
    private Stage stage;
    private Skin skin;
    private BitmapFont font;
    private Label label,label2,label3;
    private int higscoretoplam;
    private int easyhighscoretoplam;
    private int timemodescoretoplam;
    long statedurationone,statedurationtwo,statedurationtree,statedurationfour;
    int missionstatescore;
    private int toplammany;
    private int ilkgames;
    private int stopduration,slowlyduration;
    private int görevlerstate,görevlerstatetwo,görevlerstatetree;

    Preferences preferences;




    public HighScore(final CountMoneyGame game5){
        this.game5 = game5;
        batch = new SpriteBatch();
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
        skin = game5.getAssetManager().get("glassy-ui.json");
        gameoverone = game5.getAssetManager().get("highscore.png");
        arkaplan = game5.getAssetManager().get("arkaplan.png");
        font = game5.getAssetManager().get("myfont.fnt");






        if (!game5.preferences.contains("HighScore")){
            game5.preferences.putInteger("Highscore",0);
        }
        if (!game5.preferences.contains("EasyHighScore")){
            game5.preferences.putInteger("EasyHighScore",0);
        }

        if (!game5.preferences.contains("TimeModeScore")){
            game5.preferences.putInteger("TimeModeScore",0);
        }

        if (!game5.preferences.contains("MissionStateScore")){
            game5.preferences.putInteger("MissionStateScore",0);
        }

        if (!game5.preferences.contains("ToplamMany")){


            game5.preferences.putInteger("ToplamMany",0);

        }

        if (!game5.preferences.contains("StopDuration")){


            game5.preferences.putInteger("StopDuration",0);

        }

        if (!game5.preferences.contains("SlowlyDuration")){


            game5.preferences.putInteger("SlowlyDuration",0);

        }



        if (!game5.preferences.contains("IlkGames")){


            game5.preferences.putInteger("IlkGames",0);

        }
        if (!game5.preferences.contains("StateDurationOne")){


            game5.preferences.putInteger("StateDurationOne",0);

        }
        if (!game5.preferences.contains("StateDurationTwo")){


            game5.preferences.putInteger("StateDurationTwo",0);

        }
        if (!game5.preferences.contains("StateDurationTree")){


            game5.preferences.putInteger("StateDurationTree",0);

        }
        if (!game5.preferences.contains("StateDurationFour")){


            game5.preferences.putInteger("StateDurationFour",0);

        }
        if (!game5.preferences.contains("GörevlerState")){


            game5.preferences.putInteger("GörevlerState",0);

        }
        if (!game5.preferences.contains("GörevlerStateTwo")){


            game5.preferences.putInteger("GörevlerStateTwo",0);

        }
        if (!game5.preferences.contains("GörevlerStateTree")){


            game5.preferences.putInteger("GörevlerStateTree",0);

        }


        label = new Label("",skin,"font-big","black");
        label.setSize(600,100);
        label.setPosition(Gdx.graphics.getWidth()*11/24,Gdx.graphics.getHeight()*145/280);

        label2 = new Label("",skin,"font-big","black");
        label2.setSize(600,100);
        label2.setPosition(Gdx.graphics.getWidth()*9/24,Gdx.graphics.getHeight()*55/140);

        label3 = new Label("",skin,"font-big","black");
        label3.setSize(600,100);
        label3.setPosition(Gdx.graphics.getWidth()*25/48,Gdx.graphics.getHeight()*39/140);

        label.setText(String.valueOf(higscoretoplam)+"$");
        label2.setText(String.valueOf(easyhighscoretoplam)+"$");
        label3.setText(String.valueOf(timemodescoretoplam)+"$");


        stage.addActor(label);
        stage.addActor(label2);
        stage.addActor(label3);
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

        batch.draw(arkaplan, 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        batch.draw(gameoverone, 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        label.setText(String.valueOf(higscoretoplam)+"$");
        label2.setText(String.valueOf(easyhighscoretoplam)+"$");
        label3.setText(String.valueOf(timemodescoretoplam)+"$");



        higscoretoplam = getHigscoretoplam();
        easyhighscoretoplam = getEasyhighscoretoplam();
        timemodescoretoplam = getTimemodescoretoplam();
        missionstatescore = getMissionstatescore();
        toplammany = getToplammany();
        ilkgames = getIlkgames();
        stopduration = getStopduration();
        slowlyduration = getSlowlyduration();



        if (Gdx.input.isKeyPressed(Input.Keys.BACK)){
            game5.setScreen(game5.oneScreen);
        }

        if (Gdx.input.justTouched()) {
            //label.setText(String.valueOf(toplamgameoverone)+"$$$");
            game5.setScreen(game5.oneScreen);
            // label.setText("");
            // toplamgameoverone = 0;
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
    public int getGörevlerstatetwo(){return game5.preferences.getInteger("GörevlerStateTwo");}
    public void setGörevlerstatetwo(int görevlerstatetwo){
        game5.preferences.putInteger("GörevlerStateTwo",görevlerstatetwo);
        game5.preferences.flush();
    }
    public int getGörevlerstatetree(){return game5.preferences.getInteger("GörevlerStateTree");}
    public void setGörevlerstatetree(int görevlerstatetree){
        game5.preferences.putInteger("GörevlerStateTree",görevlerstatetree);
        game5.preferences.flush();
    }

    public int getGörevlerstate(){return game5.preferences.getInteger("GörevlerState");}
    public void setGörevlerstate(int görevlerstate){
        game5.preferences.putInteger("GörevlerState",görevlerstate);
        game5.preferences.flush();
    }
    public int getStatedurationtwo(){return game5.preferences.getInteger("StateDurationTwo");}
    public void setStatedurationtwo(int statedurationtwo){
        game5.preferences.putInteger("StateDurationTwo",statedurationtwo);
        game5.preferences.flush();
    }
    public int getStatedurationone(){return game5.preferences.getInteger("StateDurationOne");}
    public void setStatedurationone(int statedurationone){
        game5.preferences.putInteger("StateDurationOne",statedurationone);
        game5.preferences.flush();
    }
    public int getStatedurationtree(){return game5.preferences.getInteger("StateDurationTree");}
    public void setStatedurationtree(int statedurationtree){
        game5.preferences.putInteger("StateDurationOTree",statedurationtree);
        game5.preferences.flush();
    }

    public int getStatedurationfour(){return game5.preferences.getInteger("StateDurationFour");}
    public void setStatedurationofour(int statedurationfour){
        game5.preferences.putInteger("StateDurationFour",statedurationfour);
        game5.preferences.flush();
    }

    public int getSlowlyduration() {
        return game5.preferences.getInteger("SlowlyDuration");
    }

    public void setSlowlyduration(int slowlyduration) {
        game5.preferences.putInteger("SlowlyDuration",slowlyduration);
        game5.preferences.flush();
    }

    public int getStopduration() {
        return game5.preferences.getInteger("StopDuration");
    }

    public void setStopduration(int stopduration) {
        game5.preferences.putInteger("StopDuration",stopduration);
        game5.preferences.flush();
    }

    public int getHigscoretoplam() {
        return game5.preferences.getInteger("HighScore");
    }

    public void setHigscoretoplam(int higscoretoplam) {
        game5.preferences.putInteger("HighScore",higscoretoplam);
        game5.preferences.flush();

    }

    public int getEasyhighscoretoplam() {
        return game5.preferences.getInteger("EasyHighScore");
    }

    public void setEasyhighscoretoplam(int easyhighscoretoplam) {
        game5.preferences.putInteger("EasyHighScore",easyhighscoretoplam);
        game5.preferences.flush();
    }

    public int getTimemodescoretoplam() {
        return game5.preferences.getInteger("TimeModeScore");
    }

    public void setTimemodescoretoplam(int timemodescoretoplam) {
        game5.preferences.putInteger("TimeModeScore",timemodescoretoplam);
        game5.preferences.flush();
    }

    public int getMissionstatescore() {
        return game5.preferences.getInteger("MissionStateScore");
    }

    public void setMissionstatescore(int missionstatescore) {
        game5.preferences.putInteger("MissionStateScore",missionstatescore);
        game5.preferences.flush();
    }

    public int getToplammany() {

        return game5.preferences.getInteger("ToplamMany");
    }

    public void setToplammany(int toplammany) {
        game5.preferences.putInteger("ToplamMany",toplammany);
        game5.preferences.flush();
    }

    public int getIlkgames() {
        return game5.preferences.getInteger("IlkGames");
    }

    public void setIlkgames(int ilkgames) {
        game5.preferences.putInteger("IlkGames",ilkgames);
        game5.preferences.flush();
    }

}
