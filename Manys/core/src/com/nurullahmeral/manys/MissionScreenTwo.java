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
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class MissionScreenTwo implements Screen {
    CountMoneyGame game6;
    private SpriteBatch batch;
    private Stage stage;
    private Skin skin;
    BitmapFont font;
    Sound click;
    private TextureAtlas levelatlas;
    private TextButton.TextButtonStyle level1style,level2style,level3style,level4style,level5style,level6style,level7style,level8style,
            level9style,level11style,level10style,level12style,level13style,level14style,level15style,level16style,levelkilitstyle;
    private TextButton level1, level2, level3, level4, level5, level6, level7, level8, level9, level10, level11, level12, level13, level14, level15,level16;
    Texture img, kilit,levelselected,arkaplan;
    TextButton button1;
    int missionstate;
    int x = Gdx.graphics.getWidth() * 4 / 75;
    HighScore highScore;
    int backsayi;
    int toplamback;
    int levelx = Gdx.graphics.getWidth();
    int levely = Gdx.graphics.getHeight();
    int a = Gdx.graphics.getWidth()*2/45;
    int buttonboy = Gdx.graphics.getWidth()/6;





    public MissionScreenTwo(final CountMoneyGame game6, final HighScore highScore) {

        this.game6 = game6;
        this.highScore = highScore;


        batch = new SpriteBatch();
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        arkaplan = game6.getAssetManager().get("arkaplan.png");
        img = game6.getAssetManager().get("levelarkaplantwo.png");
        levelselected = game6.getAssetManager().get("levelselect.png");


        click = game6.getAssetManager().get("click.mp3",Sound.class);


        font = new BitmapFont();
        levelatlas = game6.getAssetManager().get("ui.atlas",TextureAtlas.class);
        skin = new Skin();

        skin.addRegions(levelatlas);

        levelkilitstyle = new TextButton.TextButtonStyle();
        level1style = new TextButton.TextButtonStyle();
        level2style = new TextButton.TextButtonStyle();
        level3style = new TextButton.TextButtonStyle();
        level4style = new TextButton.TextButtonStyle();
        level5style = new TextButton.TextButtonStyle();
        level6style = new TextButton.TextButtonStyle();
        level7style = new TextButton.TextButtonStyle();
        level8style = new TextButton.TextButtonStyle();
        level9style = new TextButton.TextButtonStyle();
        level10style = new TextButton.TextButtonStyle();
        level11style = new TextButton.TextButtonStyle();
        level12style = new TextButton.TextButtonStyle();
        level13style = new TextButton.TextButtonStyle();
        level14style = new TextButton.TextButtonStyle();
        level15style = new TextButton.TextButtonStyle();
        level16style = new TextButton.TextButtonStyle();

        levelkilitstyle.font = font;
        levelkilitstyle.up = skin.getDrawable("levelkilit");
        levelkilitstyle.down = skin.getDrawable("levelkilit");


        level1style.font = font;
        level1style.up = skin.getDrawable("levelone");
        level1style.down = skin.getDrawable("levelone");


        level2style.font = font;
        level2style.up = skin.getDrawable("leveltwo");
        level2style.down = skin.getDrawable("leveltwo");

        level3style.font = font;
        level3style.up = skin.getDrawable("leveltree");
        level3style.down = skin.getDrawable("leveltree");

        level4style.font = font;
        level4style.up = skin.getDrawable("levelfour");
        level4style.down = skin.getDrawable("levelfour");

        level5style.font = font;
        level5style.up = skin.getDrawable("levelfive");
        level5style.down = skin.getDrawable("levelfive");

        level6style.font = font;
        level6style.up = skin.getDrawable("levelsix");
        level6style.down = skin.getDrawable("levelsix");

        level7style.font = font;
        level7style.up = skin.getDrawable("levelseven");
        level7style.down = skin.getDrawable("levelseven");

        level8style.font = font;
        level8style.up = skin.getDrawable("leveleigth");
        level8style.down = skin.getDrawable("leveleigth");

        level9style.font = font;
        level9style.up = skin.getDrawable("levelnine");
        level9style.down = skin.getDrawable("levelnine");

        level10style.font = font;
        level10style.up = skin.getDrawable("levelten");
        level10style.down = skin.getDrawable("levelten");

        level11style.font = font;
        level11style.up = skin.getDrawable("leveleleven");
        level11style.down = skin.getDrawable("leveleleven");

        level12style.font = font;
        level12style.up = skin.getDrawable("leveltwelve");
        level12style.down = skin.getDrawable("leveltwelve");



        level14style.font = font;
        level14style.up = skin.getDrawable("levelnextright");
        level14style.down = skin.getDrawable("levelnextright");

        level15style.font = font;
        level15style.up = skin.getDrawable("levelnextleft");
        level15style.down = skin.getDrawable("levelnextleft");



        level1 = new TextButton("", levelkilitstyle);
        level1.setSize(buttonboy, buttonboy);
        level1.setPosition(Gdx.graphics.getWidth()*2/9, levely*71/96-(levely*7/64)-2*a);

        level2 = new TextButton("", levelkilitstyle);
        level2.setSize(buttonboy, buttonboy);
        level2.setPosition(Gdx.graphics.getWidth()*23/54 , levely*71/96-(levely*7/64)-2*a);

        level3 = new TextButton("", levelkilitstyle);
        level3.setSize(buttonboy, buttonboy);
        level3.setPosition(Gdx.graphics.getWidth()*17/27, levely*71/96-(levely*7/64)-2*a);

        level4 = new TextButton("", levelkilitstyle);
        level4.setSize(buttonboy, buttonboy);
        level4.setPosition(Gdx.graphics.getWidth()*2/9, levely*71/96-2*(levely*7/64)-2.5f*a);

        level5 = new TextButton("", levelkilitstyle);
        level5.setSize(buttonboy, buttonboy);
        level5.setPosition(Gdx.graphics.getWidth()*23/54, levely*71/96-2*(levely*7/64)-2.5f*a);

        level6 = new TextButton("", levelkilitstyle);
        level6.setSize(buttonboy, buttonboy);
        level6.setPosition(Gdx.graphics.getWidth()*17/27, levely*71/96-2*(levely*7/64)-2.5f*a);

        level7 = new TextButton("", levelkilitstyle);
        level7.setSize(buttonboy, buttonboy);
        level7.setPosition(Gdx.graphics.getWidth()*2/9, levely*71/96-3*(levely*7/64)-3*a);

        level8 = new TextButton("", levelkilitstyle);
        level8.setSize(buttonboy, buttonboy);
        level8.setPosition(Gdx.graphics.getWidth()*23/54, levely*71/96-3*(levely*7/64)-3*a);

        level9 = new TextButton("", levelkilitstyle);
        level9.setSize(buttonboy, buttonboy);
        level9.setPosition(Gdx.graphics.getWidth()*17/27, levely*71/96-3*(levely*7/64)-3*a);

        level10 = new TextButton("", levelkilitstyle);
        level10.setSize(buttonboy, buttonboy);
        level10.setPosition(Gdx.graphics.getWidth()*2/9 , levely*71/96-4*(levely*7/64)-3.5f*a);

        level11 = new TextButton("", levelkilitstyle);
        level11.setSize(buttonboy, buttonboy);
        level11.setPosition(Gdx.graphics.getWidth()*23/54, levely*71/96-4*(levely*7/64)-3.5f*a);

        level12 = new TextButton("", levelkilitstyle);
        level12.setSize(buttonboy, buttonboy);
        level12.setPosition(Gdx.graphics.getWidth()*17/27, levely*71/96-4*(levely*7/64)-3.5f*a);



        level14 = new TextButton("", level15style);
        level14.setSize(Gdx.graphics.getWidth()*4/27, Gdx.graphics.getWidth()*4/27);
        level14.setPosition(3*a+levelx*7/36, levely*71/96-4*(levely*7/64)-8*a);

        level15 = new TextButton("", level14style);
        level15.setSize(Gdx.graphics.getWidth()*4/27, Gdx.graphics.getWidth()*4/27);
        level15.setPosition(3.3f*a+2*(levelx*7/36), levely*71/96-4*(levely*7/64)-8*a);



        level1.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                click.play();
            }
        });


        level2.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                click.play();
            }
        });


        level3.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                click.play();
            }
        });


        level4.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                click.play();
            }
        });


        level5.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                click.play();
            }
        });


        level6.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                click.play();
            }
        });


        level7.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                click.play();
            }
        });


        level8.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                click.play();
            }
        });


        level9.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                click.play();
            }
        });


        level10.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                click.play();
            }
        });


        level11.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                click.play();
            }
        });


        level12.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                click.play();
            }
        });




        level14.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                click.play();
                game6.setScreen(game6.missionScreen);
            }
        });


        level15.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                click.play();
                game6.setScreen(game6.missionScreenTree);
            }
        });





        stage.addActor(level1);
        stage.addActor(level2);
        stage.addActor(level3);
        stage.addActor(level4);
        stage.addActor(level5);
        stage.addActor(level6);
        stage.addActor(level7);
        stage.addActor(level8);
        stage.addActor(level9);
        stage.addActor(level10);
        stage.addActor(level11);
        stage.addActor(level12);

        stage.addActor(level14);
        stage.addActor(level15);

        //   stage.addActor(button1);


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
        batch.draw(arkaplan, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(img, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());


        batch.draw(levelselected, 0, Gdx.graphics.getHeight()*8/10, Gdx.graphics.getWidth(), 180);

        missionstate = highScore.getMissionstatescore();





        if (Gdx.input.isKeyJustPressed(Input.Keys.BACK)) {
            backsayi = 0;

            game6.setScreen(game6.oneScreen);
        }









        if (missionstate>= 13){
            level1.setStyle(level1style);
            level1.addCaptureListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {

                    game6.setScreen(game6.levelGameBir);
                    toplamback =0;
                }
            });

        }


        if (missionstate >= 14) {
            level2.setStyle(level2style);
            level2.addCaptureListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {

                    game6.setScreen(game6.levelGameİki);
                }
            });
        }

        if (missionstate >= 15) {
            level3.setStyle(level3style);
            level3.addCaptureListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {

                    game6.setScreen(game6.levelGameTree);
                }
            });
        }

        if (missionstate >= 16) {
            level4.setStyle(level4style);
            level4.addCaptureListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {

                    game6.setScreen(game6.levelGameFour);
                }
            });
        }

        if (missionstate >= 17) {
            level5.setStyle(level5style);
            level5.addCaptureListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {

                    game6.setScreen(game6.levelGameFive);
                }
            });
        }

        if (missionstate >= 18) {
            level6.setStyle(level6style);
            level6.addCaptureListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {

                    game6.setScreen(game6.levelGameSix);
                }
            });
        }

        if (missionstate >= 19) {
            level7.setStyle(level7style);
            level7.addCaptureListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {

                    game6.setScreen(game6.levelGameSeven);
                }
            });
        }

        if (missionstate >= 20) {
            level8.setStyle(level8style);
            level8.addCaptureListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {

                    game6.setScreen(game6.levelGameEight);
                }
            });
        }

        if (missionstate >= 21) {
            level9.setStyle(level9style);
            level9.addCaptureListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {

                    game6.setScreen(game6.levelGameNine);
                }
            });
        }

        if (missionstate >= 22) {
            level10.setStyle(level10style);
            level10.addCaptureListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {

                    game6.setScreen(game6.levelGameTen);
                }
            });
        }

        if (missionstate >= 23) {
            level11.setStyle(level11style);
            level11.addCaptureListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {

                    game6.setScreen(game6.levelGameEleven);
                }
            });
        }

        if (missionstate >= 24) {
            level12.setStyle(level12style);
            level12.addCaptureListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {

                    game6.setScreen(game6.levelGameTwelve);
                }
            });
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
        Gdx.input.setInputProcessor(null);

    }

    @Override
    public void dispose() {
        stage.dispose();

    }

    public int getBacksayi() {
        return backsayi;
    }

    public void setBacksayi(int backsayi) {
        this.backsayi = backsayi;
    }

    // public int getMissionstate() {
    // return missionstate;
    // }

}