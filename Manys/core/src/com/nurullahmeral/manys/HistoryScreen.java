package com.nurullahmeral.manys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;


import java.util.ArrayList;

public class HistoryScreen implements Screen {

    CountMoneyGame game;
    HighScore highScore;
    GreatScreen greatScreen;
    SpriteBatch batch;
    BitmapFont font;
    TextureAtlas buttonatlas;
    private Stage stage;
    private TextButton buttonone,buttontwo,buttontree,buttontopla;
    private TextButton.TextButtonStyle buttononestyle,buttontwostyle,buttontreestyle,okbuttononestyle,okbuttontwostyle,okbuttontreestyle,
    buttontoplastyle;

    Texture img,img2;
    Skin buttonskin,classicgiftskin;
    int kisit = 0;
    private int buttonx =950;
    private int buttony = 135;
    private int historystate,histortystatetwo,historystatetree;



    public HistoryScreen(final CountMoneyGame game10,final HighScore highScore,final GreatScreen greatScreen){
        this.game = game10;
        this.greatScreen = greatScreen;
        this.highScore = highScore;
        img = game.getAssetManager().get("arkaplan.png");
        img2 = game.getAssetManager().get("reaccountscreen.png");

        batch = new SpriteBatch();
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
        font = game10.getAssetManager().get("myfont.fnt");
        buttonatlas = game.getAssetManager().get("ui.atlas",TextureAtlas.class);
        buttonskin = new Skin();
        buttonskin.addRegions(buttonatlas);

        buttononestyle = new TextButton.TextButtonStyle();
        okbuttononestyle = new TextButton.TextButtonStyle();
        buttontoplastyle = new TextButton.TextButtonStyle();




        buttononestyle.font = font;
        buttononestyle.up = buttonskin.getDrawable("rone");
        buttononestyle.down = buttonskin.getDrawable("rone");




        okbuttononestyle.font = font;
        okbuttononestyle.up = buttonskin.getDrawable("rtwo");
        okbuttononestyle.down = buttonskin.getDrawable("rtwo");

        buttontoplastyle.font = font;
        buttontoplastyle.up = buttonskin.getDrawable("victory");
        buttontoplastyle.down = buttonskin.getDrawable("victory");








        historystate = highScore.getGörevlerstate();
        histortystatetwo = highScore.getGörevlerstatetwo();
        historystatetree = highScore.getGörevlerstatetree();



        if (historystate == 0 || histortystatetwo ==0 || historystatetree == 0){
            if (historystate != 1 || histortystatetwo != 1 || historystatetree != 1){
                buttonone = new TextButton("Count 10\nmoney in\nClassic mode",buttononestyle);
                buttonone.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                buttonone.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*12/20);


                buttontwo = new TextButton("Reach 300 \ndollars in \n30 Seconds mode",buttononestyle);
                buttontwo.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                buttontwo.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*8/20);


                buttontree = new TextButton("Unlock \nMission 2",buttononestyle);
                buttontree.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                buttontree.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*4/20);

                buttontopla = new TextButton("1000$",buttontoplastyle);
                buttontopla.setSize(0.5435f*Gdx.graphics.getWidth(),0.1f*Gdx.graphics.getWidth());
                buttontopla.setPosition(0.225f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*2/20);
            }


        }
        if (historystate == 1 || histortystatetwo ==1 || historystatetree == 1){
            if (historystate != 0 || histortystatetwo != 0 || historystatetree != 0){
                if (historystate != 2 || histortystatetwo != 2 || historystatetree != 2){
                    buttonone = new TextButton("Reach 200 \ndollars in \nClassic mode",buttononestyle);
                    buttonone.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttonone.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*12/20);

                    buttontwo = new TextButton("Count 10\nmoney in\n30 Seconds mode",buttononestyle);
                    buttontwo.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontwo.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*8/20);


                    buttontree = new TextButton("Reach 400 \ndollars in \nEasy mode",buttononestyle);
                    buttontree.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontree.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*4/20);

                    buttontopla = new TextButton("2000$",buttontoplastyle);
                    buttontopla.setSize(0.5435f*Gdx.graphics.getWidth(),0.1f*Gdx.graphics.getWidth());
                    buttontopla.setPosition(0.225f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*2/20);
                }

            }


        }
        if (historystate == 2 || histortystatetwo ==2 || historystatetree == 2){
            if (historystate != 1 || histortystatetwo != 1 || historystatetree != 1){
                if (historystate != 3 || histortystatetwo != 3 || historystatetree != 3){
                    buttonone = new TextButton("Count 15\nmoney in\nClassic mode",buttononestyle);
                    buttonone.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttonone.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*12/20);

                    buttontwo = new TextButton("Reach 350 \ndollars in \n30 Seconds mode",buttononestyle);
                    buttontwo.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontwo.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*8/20);


                    buttontree = new TextButton("Unlock \nMission 4",buttononestyle);
                    buttontree.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontree.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*4/20);

                    buttontopla = new TextButton("1 Turtle 1 Pause",buttontoplastyle);
                    buttontopla.setSize(0.5435f*Gdx.graphics.getWidth(),0.1f*Gdx.graphics.getWidth());
                    buttontopla.setPosition(0.225f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*2/20);
                }

            }


        }
        if (historystate == 3 || histortystatetwo ==3 || historystatetree == 3){
            if (historystate != 2 || histortystatetwo != 2 || historystatetree != 2){
                if (historystate != 4 || histortystatetwo != 4 || historystatetree != 4){
                    buttonone = new TextButton("Reach 400 \ndollars in \nClassic mode",buttononestyle);
                    buttonone.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttonone.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*12/20);

                    buttontwo = new TextButton("Count 12\nmoney in\n30 Seconds mode",buttononestyle);
                    buttontwo.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontwo.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*8/20);


                    buttontree = new TextButton("Reach 800 \ndollars in \nEasy mode",buttononestyle);
                    buttontree.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontree.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*4/20);

                    buttontopla = new TextButton("2500$",buttontoplastyle);
                    buttontopla.setSize(0.5435f*Gdx.graphics.getWidth(),0.1f*Gdx.graphics.getWidth());
                    buttontopla.setPosition(0.225f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*2/20);
                }

            }


        }
        if (historystate == 4 || histortystatetwo ==4 || historystatetree == 4){
            if (historystate != 3 || histortystatetwo != 3 || historystatetree != 3){
                if (historystate != 5 || histortystatetwo != 5 || historystatetree != 5){
                    buttonone = new TextButton("Count 20\nmoney in\nClassic mode",buttononestyle);
                    buttonone.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttonone.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*12/20);

                    buttontwo = new TextButton("Reach 400 \ndollars in \n30 Seconds mode",buttononestyle);
                    buttontwo.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontwo.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*8/20);


                    buttontree = new TextButton("Unlock \nMission 7",buttononestyle);
                    buttontree.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontree.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*4/20);


                    buttontopla = new TextButton("3000$",buttontoplastyle);
                    buttontopla.setSize(0.5435f*Gdx.graphics.getWidth(),0.1f*Gdx.graphics.getWidth());
                    buttontopla.setPosition(0.225f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*2/20);
                }

            }


        }
        if (historystate == 5 || histortystatetwo ==5 || historystatetree == 5){
            if (historystate != 4 || histortystatetwo != 4 || historystatetree != 4){
                if (historystate != 6 || histortystatetwo != 6 || historystatetree != 6){
                    buttonone = new TextButton("Reach 600 \ndollars in \nClassic mode",buttononestyle);
                    buttonone.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttonone.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*12/20);

                    buttontwo = new TextButton("Count 16\nmoney in\n30 Seconds mode",buttononestyle);
                    buttontwo.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontwo.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*8/20);


                    buttontree = new TextButton("Reach 1000 \ndollars in \nEasy mode",buttononestyle);
                    buttontree.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontree.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*4/20);


                    buttontopla = new TextButton("2 Turtle 2 Pause",buttontoplastyle);
                    buttontopla.setSize(0.5435f*Gdx.graphics.getWidth(),0.1f*Gdx.graphics.getWidth());
                    buttontopla.setPosition(0.225f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*2/20);
                }

            }


        }
        if (historystate == 6 || histortystatetwo ==6 || historystatetree == 6){
            if (historystate != 5 || histortystatetwo != 5 || historystatetree !=5){
                if (historystate != 7 || histortystatetwo != 7 || historystatetree != 7){
                    buttonone = new TextButton("Count 25\nmoney in\nClassic mode",buttononestyle);
                    buttonone.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttonone.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*12/20);

                    buttontwo = new TextButton("Reach 450 \ndollars in \n30 Seconds mode",buttononestyle);
                    buttontwo.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontwo.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*8/20);


                    buttontree = new TextButton("Unlock \nMission 10",buttononestyle);
                    buttontree.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontree.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*4/20);

                    buttontopla = new TextButton("3500$",buttontoplastyle);
                    buttontopla.setSize(0.5435f*Gdx.graphics.getWidth(),0.1f*Gdx.graphics.getWidth());
                    buttontopla.setPosition(0.225f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*2/20);
                }

            }


        }
        if (historystate == 7 || histortystatetwo ==7 || historystatetree == 7){
            if (historystate != 6 || histortystatetwo != 6 || historystatetree !=6){
                if (historystate != 8 || histortystatetwo != 8 || historystatetree != 8){
                    buttonone = new TextButton("Reach 800 \ndollars in \nClassic mode",buttononestyle);
                    buttonone.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttonone.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*12/20);

                    buttontwo = new TextButton("Count 18\nmoney in\n30 Seconds mode",buttononestyle);
                    buttontwo.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontwo.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*8/20);


                    buttontree = new TextButton("Reach 1200 \ndollars in \nEasy mode",buttononestyle);
                    buttontree.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontree.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*4/20);


                    buttontopla = new TextButton("4000$",buttontoplastyle);
                    buttontopla.setSize(0.5435f*Gdx.graphics.getWidth(),0.1f*Gdx.graphics.getWidth());
                    buttontopla.setPosition(0.225f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*2/20);
                }

            }

        }
        if (historystate == 8 || histortystatetwo ==8 || historystatetree == 8){
            if (historystate != 7 || histortystatetwo != 7 || historystatetree !=7){
                if (historystate != 9 || histortystatetwo != 9 || historystatetree != 9){
                    buttonone = new TextButton("Count 30\nmoney in\nClassic mode",buttononestyle);
                    buttonone.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttonone.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*12/20);

                    buttontwo = new TextButton("Reach 500 \ndollars in \n30 Seconds mode",buttononestyle);
                    buttontwo.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontwo.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*8/20);


                    buttontree = new TextButton("Unlock \nMission 14",buttononestyle);
                    buttontree.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontree.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*4/20);


                    buttontopla = new TextButton("4500$",buttontoplastyle);
                    buttontopla.setSize(0.5435f*Gdx.graphics.getWidth(),0.1f*Gdx.graphics.getWidth());
                    buttontopla.setPosition(0.225f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*2/20);
                }

            }

        }
        if (historystate == 9 || histortystatetwo ==9 || historystatetree == 9){
            if (historystate != 8 || histortystatetwo != 8 || historystatetree !=8){
                if (historystate != 10 || histortystatetwo != 10 || historystatetree != 10){
                    buttonone = new TextButton("Reach 1000 \ndollars in \nClassic mode",buttononestyle);
                    buttonone.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttonone.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*12/20);

                    buttontwo = new TextButton("Count 20\nmoney in\n30 Seconds mode",buttononestyle);
                    buttontwo.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontwo.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*8/20);


                    buttontree = new TextButton("Reach 1400 \ndollars in \nEasy mode",buttononestyle);
                    buttontree.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontree.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*4/20);

                    buttontopla = new TextButton("5000$",buttontoplastyle);
                    buttontopla.setSize(0.5435f*Gdx.graphics.getWidth(),0.1f*Gdx.graphics.getWidth());
                    buttontopla.setPosition(0.225f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*2/20);
                }

            }

        }
        if (historystate == 10 || histortystatetwo ==10 || historystatetree == 10){
            if (historystate != 9 || histortystatetwo != 9 || historystatetree !=9){
                if (historystate != 11 || histortystatetwo != 11 || historystatetree != 11){
                    buttonone = new TextButton("Count 35\nmoney in\nClassic mode",buttononestyle);
                    buttonone.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttonone.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*12/20);

                    buttontwo = new TextButton("Reach 550 \ndollars in \n30 Seconds mode",buttononestyle);
                    buttontwo.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontwo.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*8/20);


                    buttontree = new TextButton("Unlock \nMission 18",buttononestyle);
                    buttontree.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontree.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*4/20);

                    buttontopla = new TextButton("3 Turtle 3 Pause",buttontoplastyle);
                    buttontopla.setSize(0.5435f*Gdx.graphics.getWidth(),0.1f*Gdx.graphics.getWidth());
                    buttontopla.setPosition(0.225f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*2/20);
                }

            }

        }
        if (historystate == 11 || histortystatetwo ==11 || historystatetree == 11){
            if (historystate != 10 || histortystatetwo != 10 || historystatetree !=10){
                if (historystate != 12 || histortystatetwo != 12 || historystatetree != 12){
                    buttonone = new TextButton("Reach 1200 \ndollars in \nClassic mode",buttononestyle);
                    buttonone.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttonone.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*12/20);

                    buttontwo = new TextButton("Count 22\nmoney in\n30 Seconds mode",buttononestyle);
                    buttontwo.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontwo.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*8/20);


                    buttontree = new TextButton("Reach 1600 \ndollars in \nEasy mode",buttononestyle);
                    buttontree.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontree.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*4/20);

                    buttontopla = new TextButton("6000$",buttontoplastyle);
                    buttontopla.setSize(0.5435f*Gdx.graphics.getWidth(),0.1f*Gdx.graphics.getWidth());
                    buttontopla.setPosition(0.225f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*2/20);
                }

            }

        }
        if (historystate == 12 || histortystatetwo ==12 || historystatetree == 12){
            if (historystate != 11 || histortystatetwo != 11 || historystatetree !=11){
                if (historystate != 13 || histortystatetwo != 13 || historystatetree != 13){
                    buttonone = new TextButton("Count 40\nmoney in\nClassic mode",buttononestyle);
                    buttonone.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttonone.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*12/20);

                    buttontwo = new TextButton("Reach 600 \ndollars in \n30 Seconds mode",buttononestyle);
                    buttontwo.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontwo.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*8/20);


                    buttontree = new TextButton("Unlock \nMission 22",buttononestyle);
                    buttontree.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontree.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*4/20);

                    buttontopla = new TextButton("6500$",buttontoplastyle);
                    buttontopla.setSize(0.5435f*Gdx.graphics.getWidth(),0.1f*Gdx.graphics.getWidth());
                    buttontopla.setPosition(0.225f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*2/20);
                }

            }

        }
        if (historystate == 13 || histortystatetwo ==13 || historystatetree == 13){
            if (historystate != 12 || histortystatetwo != 12 || historystatetree !=12){
                if (historystate != 14 || histortystatetwo != 14 || historystatetree != 14){
                    buttonone = new TextButton("Reach 1400 \ndollars in \nClassic mode",buttononestyle);
                    buttonone.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttonone.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*12/20);

                    buttontwo = new TextButton("Count 24\nmoney in\n30 Seconds mode",buttononestyle);
                    buttontwo.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontwo.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*8/20);


                    buttontree = new TextButton("Reach 1800 \ndollars in \nEasy mode",buttononestyle);
                    buttontree.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontree.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*4/20);

                    buttontopla = new TextButton("7000$",buttontoplastyle);
                    buttontopla.setSize(0.5435f*Gdx.graphics.getWidth(),0.1f*Gdx.graphics.getWidth());
                    buttontopla.setPosition(0.225f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*2/20);
                }

            }

        }
        if (historystate == 14 || histortystatetwo ==14 || historystatetree == 14){
            if (historystate != 13 || histortystatetwo != 13 || historystatetree !=13){
                if (historystate != 15 || histortystatetwo != 15 || historystatetree != 15){
                    buttonone = new TextButton("Count 45\nmoney in\nClassic mode",buttononestyle);
                    buttonone.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttonone.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*12/20);

                    buttontwo = new TextButton("Reach 650 \ndollars in \n30 Seconds mode",buttononestyle);
                    buttontwo.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontwo.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*8/20);


                    buttontree = new TextButton("Unlock \nMission 26",buttononestyle);
                    buttontree.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontree.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*4/20);

                    buttontopla = new TextButton("7500$",buttontoplastyle);
                    buttontopla.setSize(0.5435f*Gdx.graphics.getWidth(),0.1f*Gdx.graphics.getWidth());
                    buttontopla.setPosition(0.225f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*2/20);
                }

            }

        }
        if (historystate == 15 || histortystatetwo ==15 || historystatetree == 15){
            if (historystate != 14 || histortystatetwo != 14 || historystatetree !=14){
                if (historystate != 16 || histortystatetwo != 16 || historystatetree != 16){
                    buttonone = new TextButton("Reach 1600 \ndollars in \nClassic mode",buttononestyle);
                    buttonone.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttonone.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*12/20);

                    buttontwo = new TextButton("Count 26\nmoney in\n30 Seconds mode",buttononestyle);
                    buttontwo.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontwo.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*8/20);


                    buttontree = new TextButton("Reach 2000 \ndollars in \nEasy mode",buttononestyle);
                    buttontree.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontree.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*4/20);

                    buttontopla = new TextButton("4 Turtle 4 Pause",buttontoplastyle);
                    buttontopla.setSize(0.5435f*Gdx.graphics.getWidth(),0.1f*Gdx.graphics.getWidth());
                    buttontopla.setPosition(0.225f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*2/20);
                }

            }

        }
        if (historystate == 16 || histortystatetwo ==16 || historystatetree == 16){
            if (historystate != 15 || histortystatetwo != 15 || historystatetree !=15){
                if (historystate != 17 || histortystatetwo != 17 || historystatetree != 17){
                    buttonone = new TextButton("Count 50\nmoney in\nClassic mode",buttononestyle);
                    buttonone.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttonone.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*12/20);

                    buttontwo = new TextButton("Reach 700 \ndollars in \n30 Seconds mode",buttononestyle);
                    buttontwo.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontwo.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*8/20);


                    buttontree = new TextButton("Unlock \nMission 31",buttononestyle);
                    buttontree.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontree.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*4/20);

                    buttontopla = new TextButton("9000$",buttontoplastyle);
                    buttontopla.setSize(0.5435f*Gdx.graphics.getWidth(),0.1f*Gdx.graphics.getWidth());
                    buttontopla.setPosition(0.225f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*2/20);
                }

            }

        }
        if (historystate == 17 || histortystatetwo ==17 || historystatetree == 17){
            if (historystate != 18 || histortystatetwo != 18 || historystatetree !=18){
                if (historystate != 16 || histortystatetwo != 16 || historystatetree != 16){
                    buttonone = new TextButton("Reach 1800 \ndollars in \nClassic mode",buttononestyle);
                    buttonone.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttonone.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*12/20);

                    buttontwo = new TextButton("Count 28\nmoney in\n30 Seconds mode",buttononestyle);
                    buttontwo.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontwo.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*8/20);


                    buttontree = new TextButton("Reach 2200 \ndollars in \nEasy mode",buttononestyle);
                    buttontree.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontree.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*4/20);

                    buttontopla = new TextButton("9500$",buttontoplastyle);
                    buttontopla.setSize(0.5435f*Gdx.graphics.getWidth(),0.1f*Gdx.graphics.getWidth());
                    buttontopla.setPosition(0.225f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*2/20);
                }

            }

        }
        if (historystate == 18 || histortystatetwo ==18 || historystatetree == 18){
            if (historystate != 17 || histortystatetwo != 17 || historystatetree !=17){
                if (historystate != 19 || histortystatetwo != 19 || historystatetree != 19){
                    buttonone = new TextButton("Count 55\nmoney in\nClassic mode",buttononestyle);
                    buttonone.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttonone.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*12/20);

                    buttontwo = new TextButton("Reach 800 \ndollars in \n30 Seconds mode",buttononestyle);
                    buttontwo.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontwo.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*8/20);


                    buttontree = new TextButton("Complete \nMission ",buttononestyle);
                    buttontree.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontree.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*4/20);

                    buttontopla = new TextButton("10000$",buttontoplastyle);
                    buttontopla.setSize(0.5435f*Gdx.graphics.getWidth(),0.1f*Gdx.graphics.getWidth());
                    buttontopla.setPosition(0.225f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*2/20);
                }

            }

        }
        if (historystate == 19 || histortystatetwo ==19 || historystatetree == 19){
            if (historystate != 18 || histortystatetwo != 18 || historystatetree !=18){
                if (historystate != 20 || histortystatetwo != 20 || historystatetree != 20){
                    buttonone = new TextButton("Reach 2000 \ndollars in \nClassic mode",buttononestyle);
                    buttonone.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttonone.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*12/20);

                    buttontwo = new TextButton("Count 30\nmoney in\n30 Seconds mode",buttononestyle);
                    buttontwo.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontwo.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*8/20);


                    buttontree = new TextButton("Reach 2400 \ndollars in \nEasy mode",buttononestyle);
                    buttontree.setSize(0.67f*Gdx.graphics.getWidth(),0.136f*Gdx.graphics.getWidth());
                    buttontree.setPosition(0.11f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*4/20);


                    buttontopla = new TextButton("20000$",buttontoplastyle);
                    buttontopla.setSize(0.5435f*Gdx.graphics.getWidth(),0.1f*Gdx.graphics.getWidth());
                    buttontopla.setPosition(0.225f*Gdx.graphics.getWidth(),Gdx.graphics.getHeight()*2/20);
                }

            }

        }

        if (historystate == 1 && histortystatetwo ==1 && historystatetree == 1){

        }
        if (historystate == 2 && histortystatetwo ==2 && historystatetree == 2){

        }
        if (historystate == 3 && histortystatetwo ==3 && historystatetree == 3){

        }
        if (historystate == 4 && histortystatetwo ==4 && historystatetree == 4){

        }
        if (historystate == 5 && histortystatetwo ==5 && historystatetree == 5){

        }
        if (historystate == 6 && histortystatetwo ==6 && historystatetree == 6){

        }
        if (historystate == 7 && histortystatetwo ==7 && historystatetree == 7){

        }
        if (historystate == 8 && histortystatetwo ==8 && historystatetree == 8){

        }
        if (historystate == 9 && histortystatetwo ==9 && historystatetree == 9){

        }
        if (historystate == 10 && histortystatetwo ==10 && historystatetree == 10){

        }
        if (historystate == 11 && histortystatetwo ==11 && historystatetree == 11){

        }
        if (historystate == 12 && histortystatetwo ==12 && historystatetree == 12){

        }
        if (historystate == 13 && histortystatetwo ==13 && historystatetree == 13){

        }
        if (historystate == 14 && histortystatetwo ==14 && historystatetree == 14){

        }
        if (historystate == 15 && histortystatetwo ==15 && historystatetree == 15){

        }
        if (historystate == 16 && histortystatetwo ==16 && historystatetree == 16){

        }
        if (historystate == 17 && histortystatetwo ==17 && historystatetree == 17){

        }
        if (historystate == 18 && histortystatetwo ==18 && historystatetree == 18){

        }
        if (historystate == 19 && histortystatetwo ==19 && historystatetree == 19){

        }
        if (historystate == 20 && histortystatetwo ==20 && historystatetree == 20){

        }
























      //  stage.setDebugAll(true);


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

        stage.addActor(buttonone);
        stage.addActor(buttontwo);
        stage.addActor(buttontree);
        stage.addActor(buttontopla);

        batch.draw(img, 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch.draw(img2, 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        historystate = highScore.getGörevlerstate();
        histortystatetwo = highScore.getGörevlerstatetwo();
        historystatetree = highScore.getGörevlerstatetree();



        if (historystate == 0 || histortystatetwo == 0 || historystatetree == 0){
            if (historystate == 1){
                buttonone.setStyle(okbuttononestyle);
            }
            if (histortystatetwo == 1){
                buttontwo.setStyle(okbuttononestyle);
            }

            if (historystatetree == 1){
                buttontree.setStyle(okbuttononestyle);
            }

        }
        if (historystate == 1 || histortystatetwo == 1 || historystatetree == 1){
            if (historystate == 2){
                buttonone.setStyle(okbuttononestyle);
            }
            if (histortystatetwo == 2){
                buttontwo.setStyle(okbuttononestyle);
            }

            if (historystatetree == 2){
                buttontree.setStyle(okbuttononestyle);
            }
        }


        if (historystate == 2 || histortystatetwo == 2 || historystatetree == 2){
            if (historystate == 3){
                buttonone.setStyle(okbuttononestyle);
            }
            if (histortystatetwo == 3){
                buttontwo.setStyle(okbuttononestyle);
            }

            if (historystatetree == 3){
                buttontree.setStyle(okbuttononestyle);
            }
        }

        if (historystate == 3 || histortystatetwo == 3 || historystatetree == 3){
            if (historystate == 4){
                buttonone.setStyle(okbuttononestyle);
            }
            if (histortystatetwo == 4){
                buttontwo.setStyle(okbuttononestyle);
            }

            if (historystatetree == 4){
                buttontree.setStyle(okbuttononestyle);
            }
        }

        if (historystate == 4 || histortystatetwo == 4 || historystatetree == 4){
            if (historystate == 5){
                buttonone.setStyle(okbuttononestyle);
            }
            if (histortystatetwo == 5){
                buttontwo.setStyle(okbuttononestyle);
            }

            if (historystatetree == 5){
                buttontree.setStyle(okbuttononestyle);
            }
        }

        if (historystate == 5 || histortystatetwo == 5 || historystatetree == 5){
            if (historystate == 6){
                buttonone.setStyle(okbuttononestyle);
            }
            if (histortystatetwo == 6){
                buttontwo.setStyle(okbuttononestyle);
            }

            if (historystatetree == 6){
                buttontree.setStyle(okbuttononestyle);
            }
        }

        if (historystate == 6 || histortystatetwo == 6 || historystatetree == 6){
            if (historystate == 7){
                buttonone.setStyle(okbuttononestyle);
            }
            if (histortystatetwo == 7){
                buttontwo.setStyle(okbuttononestyle);
            }

            if (historystatetree == 7){
                buttontree.setStyle(okbuttononestyle);
            }
        }

        if (historystate == 7 || histortystatetwo == 7 || historystatetree == 7){
            if (historystate == 8){
                buttonone.setStyle(okbuttononestyle);
            }
            if (histortystatetwo == 8){
                buttontwo.setStyle(okbuttononestyle);
            }

            if (historystatetree == 8){
                buttontree.setStyle(okbuttononestyle);
            }
        }

        if (historystate == 8 || histortystatetwo == 8 || historystatetree == 8){

            if (historystate == 9){
                buttonone.setStyle(okbuttononestyle);
            }
            if (histortystatetwo == 9){
                buttontwo.setStyle(okbuttononestyle);
            }

            if (historystatetree == 9){
                buttontree.setStyle(okbuttononestyle);
            }
        }
        if (historystate == 9 || histortystatetwo == 9 || historystatetree == 9){
            if (historystate == 10){
                buttonone.setStyle(okbuttononestyle);
            }
            if (histortystatetwo == 10){
                buttontwo.setStyle(okbuttononestyle);
            }

            if (historystatetree == 10){
                buttontree.setStyle(okbuttononestyle);
            }
        }
        if (historystate == 10 || histortystatetwo == 10 || historystatetree == 10){

            if (historystate == 11){
                buttonone.setStyle(okbuttononestyle);
            }
            if (histortystatetwo == 11){
                buttontwo.setStyle(okbuttononestyle);
            }

            if (historystatetree == 11){
                buttontree.setStyle(okbuttononestyle);
            }
        }
        if (historystate == 11 || histortystatetwo == 11 || historystatetree == 11){

            if (historystate == 12){
                buttonone.setStyle(okbuttononestyle);
            }
            if (histortystatetwo == 12){
                buttontwo.setStyle(okbuttononestyle);
            }

            if (historystatetree == 12){
                buttontree.setStyle(okbuttononestyle);
            }
        }
        if (historystate == 12 || histortystatetwo == 12 || historystatetree == 12){

            if (historystate == 13){
                buttonone.setStyle(okbuttononestyle);
            }
            if (histortystatetwo == 13){
                buttontwo.setStyle(okbuttononestyle);
            }

            if (historystatetree == 13){
                buttontree.setStyle(okbuttononestyle);
            }
        }
        if (historystate == 13 || histortystatetwo == 13 || historystatetree == 13){


            if (historystate == 14){
                buttonone.setStyle(okbuttononestyle);
            }
            if (histortystatetwo == 14){
                buttontwo.setStyle(okbuttononestyle);
            }

            if (historystatetree == 14){
                buttontree.setStyle(okbuttononestyle);
            }
        }
        if (historystate == 14 || histortystatetwo == 14 || historystatetree == 14){

            if (historystate == 15){
                buttonone.setStyle(okbuttononestyle);
            }
            if (histortystatetwo == 15){
                buttontwo.setStyle(okbuttononestyle);
            }

            if (historystatetree == 15){
                buttontree.setStyle(okbuttononestyle);
            }
        }
        if (historystate == 15 || histortystatetwo == 15 || historystatetree == 15){

            if (historystate == 16){
                buttonone.setStyle(okbuttononestyle);
            }
            if (histortystatetwo == 16){
                buttontwo.setStyle(okbuttononestyle);
            }

            if (historystatetree == 16){
                buttontree.setStyle(okbuttononestyle);
            }
        }
        if (historystate == 16 || histortystatetwo == 16 || historystatetree == 16){


            if (historystate == 17){
                buttonone.setStyle(okbuttononestyle);
            }
            if (histortystatetwo == 17){
                buttontwo.setStyle(okbuttononestyle);
            }

            if (historystatetree == 17){
                buttontree.setStyle(okbuttononestyle);
            }
        }

        if (historystate == 17 || histortystatetwo == 17 || historystatetree == 17){

            if (historystate == 18){
                buttonone.setStyle(okbuttononestyle);
            }
            if (histortystatetwo == 18){
                buttontwo.setStyle(okbuttononestyle);
            }

            if (historystatetree == 18){
                buttontree.setStyle(okbuttononestyle);
            }
        }
        if (historystate == 18 || histortystatetwo == 18 || historystatetree == 18){

            if (historystate == 19){
                buttonone.setStyle(okbuttononestyle);
            }
            if (histortystatetwo == 19){
                buttontwo.setStyle(okbuttononestyle);
            }

            if (historystatetree == 19){
                buttontree.setStyle(okbuttononestyle);
            }
        }
        if (historystate == 19 || histortystatetwo == 19 || historystatetree == 19){

            if (historystate == 20){
                buttonone.setStyle(okbuttononestyle);
            }
            if (histortystatetwo == 20){
                buttontwo.setStyle(okbuttononestyle);
            }

            if (historystatetree == 20){
                buttontree.setStyle(okbuttononestyle);
            }

        }



















        if (Gdx.input.isKeyPressed(Input.Keys.BACK)){
            game.setScreen(game.oneScreen);

        }



        batch.end();


        stage.act();
        stage.draw();

    }

    @Override
    public void resize(int width, int heigt) {



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
        batch.dispose();

    }
}
