package agolf.game;

import agolf.GameApplet;
import agolf.GameContainer;
import com.aapeli.client.StringDraw;
import com.aapeli.colorgui.ColorButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GameTrackInfoPanel extends Panel implements ActionListener {

    private static final Font fontDialog12 = new Font("Dialog", 0, 12);
    private static final Font fontDialog14 = new Font("Dialog", 0, 14);
    private static final Font fontSerif16 = new Font("Serif", 0, 16);
    private static final Font fontDialog11 = new Font("Dialog", 0, 11);
    private static final Color[] voteColours = new Color[]{
            new Color(192, 0, 0), new Color(255, 0, 0), new Color(255, 64, 0),
            new Color(255, 128, 0), new Color(255, 192, 0), new Color(255, 255, 0),
            new Color(192, 255, 0), new Color(128, 255, 0), new Color(64, 255, 0),
            new Color(0, 255, 0), new Color(64, 255, 64)
    };

    private GameContainer gameContainer;
    private int width;
    private int height;
    private boolean showLongAvgResult;
    private int numTracks;
    private int currentTrack;
    private String trackAuthor;
    private String trackName;
    private String firstBestPlayerName;
    private String firstBestPlayerDate;
    private String lastBestPlayerName;
    private String lastBestPlayerDate;
    private int resultBestNumStrokes;
    private int trackTotalRatings;
    private int trackRating;
    private double resultBestPercent;
    private double resultAverage;
    private double trackAverageRating;
    private ColorButton buttonNoVote;
    private ColorButton[] buttonsVote;
    private ColorButton buttonReject;
    private ColorButton buttonAccept;
    private ColorButton buttonR;
    private ConfirmButton buttonBack;
    private boolean hasNotRatedTrack;
    private boolean trackPending;
    private boolean aBoolean436;
    private boolean aBoolean437;
    private Image image;
    private Graphics graphics;
    private boolean created;


    protected GameTrackInfoPanel(GameContainer gameContainer, int width, int height, boolean var4) {
        this.gameContainer = gameContainer;
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        this.showLongAvgResult = var4;
        this.created = this.hasNotRatedTrack = this.trackPending = this.aBoolean436 = this.aBoolean437 = false;
        this.numTracks = -1;
        this.resetCurrentTrack();
    }

    public void addNotify() {
        super.addNotify();
        if (!this.created) {
            this.created = true;
            this.create();
        }

        this.repaint();
    }

    public void paint(Graphics g) {
        this.update(g);
    }

    public void update(Graphics g) {
        if (this.image == null) {
            this.image = this.createImage(this.width, this.height);
            this.graphics = this.image.getGraphics();
        }

        this.graphics.setColor(GameApplet.colourGameBackground);
        this.graphics.fillRect(0, 0, this.width, this.height);
        if (this.numTracks > -1) {
            this.graphics.setFont(fontDialog12);
            this.graphics.setColor(GameApplet.colourTextDarkGreen);
            int xMod = this.showLongAvgResult ? 20 : 0;
            if (this.currentTrack == -1) {
                StringDraw.drawString(this.graphics, this.gameContainer.textManager.getGame("GameTrackInfo_NumberOfTracks", this.numTracks), this.width / 4 - xMod, 15, 0);
            } else {
                StringDraw.drawString(this.graphics, this.gameContainer.textManager.getGame("GameTrackInfo_CurrentTrack", this.currentTrack + 1, this.numTracks), this.width / 4 - xMod, 15, 0);
                this.graphics.setColor(GameApplet.colourTextBlack);

                Font font;
                for (font = fontSerif16; this.getFontMetrics(font).stringWidth(this.trackName) / 2 > this.width / 4 - xMod; font = new Font(font.getName(), font.getStyle(), font.getSize() - 1)) {
                    ;
                }

                this.graphics.setFont(font);
                StringDraw.drawString(this.graphics, this.trackName, this.width / 4 - xMod, 35, 0);
                this.graphics.setFont(fontDialog14);
                this.graphics.setColor(GameApplet.colourTextDarkGreen);
                StringDraw.drawString(this.graphics, this.trackAuthor, this.width / 4 - xMod, 55, 0);
                String keySuffix = this.showLongAvgResult ? "L" : "S";
                this.graphics.setFont(fontDialog12);
                this.graphics.setColor(GameApplet.colourTextBlack);
                if (this.resultAverage > 0.0D) {
                    StringDraw.drawString(this.graphics, this.gameContainer.textManager.getGame("GameTrackInfo_AverageResult" + keySuffix, this.gameContainer.textManager.getNumber(this.resultAverage, 1)), this.width * 3 / 4 - xMod, this.lastBestPlayerName == null ? 15 : 12, 0);
                }

                String resultBestText;
                if (this.resultBestNumStrokes > 0) {
                    resultBestText = this.gameContainer.textManager.getGame("GameTrackInfo_BestResult" + keySuffix, this.resultBestNumStrokes);
                    String resultText = resultBestText + " ";
                    if (this.resultBestPercent > 0.0D) {
                        byte roundingPrecision = 0;
                        if (this.resultBestPercent < 10.0D && this.resultBestPercent >= 1.0D) {
                            roundingPrecision = 1;
                        }

                        if (this.resultBestPercent < 1.0D && this.resultBestPercent >= 0.1D) {
                            roundingPrecision = 2;
                        }

                        if (this.resultBestPercent < 0.1D) {
                            roundingPrecision = 3;
                        }

                        resultText = resultText + this.gameContainer.textManager.getGame("GameTrackInfo_BestResultPercent" + keySuffix, this.gameContainer.textManager.getNumber(this.resultBestPercent, roundingPrecision));
                    } else {
                        resultText = resultText + this.gameContainer.textManager.getGame("GameTrackInfo_BestResultUnique" + keySuffix);
                    }

                    this.graphics.setColor(GameApplet.colourTextDarkGreen);
                    int textWidth = StringDraw.drawString(this.graphics, resultText, this.width * 3 / 4 - xMod, this.lastBestPlayerName == null ? 35 : 29, 0);
                    this.graphics.setColor(GameApplet.colourTextBlack);
                    this.graphics.drawString(resultBestText, this.width * 3 / 4 - xMod - textWidth / 2, this.lastBestPlayerName == null ? 35 : 29);
                    this.graphics.setClip(0, 0, this.width, this.height);
                    this.graphics.setFont(fontDialog11);
                    this.graphics.setColor(GameApplet.colourTextDarkGreen);
                    resultBestText = this.firstBestPlayerName != null ? this.gameContainer.textManager.getGame("GameTrackInfo_BestResultFirstBy" + keySuffix, this.firstBestPlayerName, this.firstBestPlayerDate) : this.gameContainer.textManager.getGame("GameTrackInfo_BestResultFirstByUnknown" + keySuffix);
                    StringDraw.drawString(this.graphics, resultBestText, this.width * 3 / 4 - xMod, this.lastBestPlayerName == null ? 55 : 45, 2);
                    if (this.lastBestPlayerName != null) {
                        StringDraw.drawString(this.graphics, this.gameContainer.textManager.getGame("GameTrackInfo_BestResultLastBy" + keySuffix, this.lastBestPlayerName, this.lastBestPlayerDate), this.width * 3 / 4 - xMod, 60, 2);
                    }

                    this.graphics.setColor(GameApplet.colourTextBlack);
                }

                if (this.hasNotRatedTrack) {
                    this.graphics.drawString(this.gameContainer.textManager.getGame("GameTrackInfo_GiveRating"), 10, this.height - 4);
                }

                if (!this.hasNotRatedTrack && !this.trackPending && this.trackAverageRating >= 0.0D) {
                    this.graphics.setFont(fontDialog12);
                    StringDraw.drawString(this.graphics, this.gameContainer.textManager.getGame("GameTrackInfo_Rating", this.gameContainer.textManager.getNumber(this.trackAverageRating, 1)), this.width / 4 - xMod, this.height - 4, 0);
                }

                if (this.trackPending) {
                    this.graphics.drawString("Pending:", 10, this.height - 4);
                }
            }
        }

        g.drawImage(this.image, 0, 0, this);
    }

    public void actionPerformed(ActionEvent evt) {
        Object evtSource = evt.getSource();
        if (evtSource == this.buttonNoVote) {
            this.method388(false);
            this.repaint();
        } else {
            for (int i = 0; i <= 10; ++i) {
                if (evtSource == this.buttonsVote[i]) {
                    this.gameContainer.gamePanel.rateTrack(this.currentTrack, i);
                    ++this.trackTotalRatings;
                    this.trackRating += i;
                    this.trackAverageRating = (double) this.trackRating / (double) this.trackTotalRatings;
                    this.method388(false);
                    this.repaint();
                    return;
                }
            }

            if(evtSource == buttonReject || evtSource == buttonAccept) {
                this.gameContainer.gamePanel.respondNewGame(this.currentTrack, evtSource == this.buttonAccept);
                this.toggleAcceptRejectButtons(false);
                this.repaint();
            }
            else if (evtSource == this.buttonBack) {
                this.gameContainer.gamePanel.method345(this.currentTrack);
                this.method390(false);
                this.repaint();
            } else {
                if (evtSource == this.buttonR) {
                    this.gameContainer.gamePanel.method336();
                }

            }
        }
    }

    protected void resetCurrentTrack() {
        this.currentTrack = -1;
    }

    protected void setNumTracks(int numTracks) {
        this.numTracks = numTracks;
        this.repaint();
    }

    protected void parseTrackInfoStats(String trackAuthor, String trackName, int[] parStats, int[] someRatingStats, String firstBest, String lastBest, boolean trackTestMode1, boolean trackTestMode2, boolean var9) {
        ++this.currentTrack;
        this.trackAuthor = trackAuthor;
        this.trackName = trackName;
        this.resultBestNumStrokes = -1;
        this.resultAverage = this.trackAverageRating = -1.0D;
        String[] firstBestPlayer = this.parseBestPlayerInformation(firstBest);
        String[] lastBestPlayer = this.parseBestPlayerInformation(lastBest);
        this.firstBestPlayerName = firstBestPlayer[0];
        this.firstBestPlayerDate = firstBestPlayer[1];
        this.lastBestPlayerName = lastBestPlayer[0];
        this.lastBestPlayerDate = lastBestPlayer[1];

        if (parStats != null) {
            this.resultBestNumStrokes = parStats[2];
            if (parStats[3] > 1) { // If number of people to get the best score is more than 1 (not unique)
                this.resultBestPercent = 100.0D * (double) parStats[3] / (double) parStats[0];
            } else {
                this.resultBestPercent = 0.0D;
            }

            this.resultAverage = (double) parStats[1] / (double) parStats[0]; // Number completed?!?!
        }

        this.trackTotalRatings = this.trackRating = 0;
        if (someRatingStats != null) {
            for (int var12 = 1; var12 <= 9; ++var12) {
                this.trackTotalRatings += someRatingStats[var12];
                this.trackRating += var12 * someRatingStats[var12];
            }

            if (this.trackTotalRatings < 10) {
                this.trackTotalRatings += someRatingStats[0];
                this.trackTotalRatings += someRatingStats[10];
                this.trackRating += 10 * someRatingStats[10];
            }

            this.trackAverageRating = (double) this.trackRating / (double) this.trackTotalRatings; // i think its average rating
        }

        if (!this.gameContainer.synchronizedTrackTestMode.get()) {   // Toggles some buttons??!
            this.method388(true);
        } else {
            this.toggleAcceptRejectButtons(trackTestMode1);
            this.method390(trackTestMode2);
            this.method391(var9);
        }

        this.repaint();
    }

    protected void method384() {
        if (this.aBoolean437) {
            this.method391(false);
        }

    }

    protected int method385() {
        return (int) (this.resultAverage + 0.99D);
    }

    private void create() {
        this.setLayout((LayoutManager) null);
        this.buttonNoVote = new ColorButton("-");
        this.buttonNoVote.setBounds(this.width - 264, this.height - 15, 22, 15);
        this.buttonNoVote.addActionListener(this);
        this.buttonsVote = new ColorButton[11];

        for (int i = 0; i <= 10; ++i) {
            this.buttonsVote[i] = new ColorButton(String.valueOf(i));
            this.buttonsVote[i].setBounds(this.width - 264 + 22 * (i + 1), this.height - 15, 22, 15);
            this.buttonsVote[i].setBackground(voteColours[i]);
            this.buttonsVote[i].addActionListener(this);
        }

        this.buttonReject = new ColorButton("Reject");
        this.buttonReject.setBounds(this.width - 10 - 80 - 10 - 80, this.height - 15, 70, 15);
        this.buttonReject.setBackground(GameApplet.colourButtonRed);
        this.buttonReject.addActionListener(this);
        this.buttonAccept = new ColorButton("Accept");
        this.buttonAccept.setBounds(this.width - 10 - 80 - 10, this.height - 15, 70, 15);
        this.buttonAccept.setBackground(GameApplet.colourButtonGreen);
        this.buttonAccept.addActionListener(this);
        this.buttonBack = new ConfirmButton("Back to private", "Sure?");
        this.buttonBack.setBounds(this.width - 10 - 130, this.height - 15, 95, 15);
        this.buttonBack.setBackground(GameApplet.colourButtonRed);
        this.buttonBack.setActionListener(this);
        this.buttonR = new ColorButton("R");
        this.buttonR.setBounds(this.width - 10 - 20 - 5, this.height - 15, 25, 15);
        this.buttonR.setBackground(GameApplet.colourButtonGreen);
        this.buttonR.addActionListener(this);
    }

    private String[] parseBestPlayerInformation(String var1) {
        String[] var2 = new String[]{null, null};
        if (var1 != null) {
            int var3 = var1.indexOf(44);
            var2[0] = var1.substring(0, var3);
            var2[1] = var1.substring(var3 + 1);
            var3 = var2[1].indexOf(44);
            if (var3 > 0) {
                var2[1] = var2[1].substring(0, var3);
            }

            long var4 = Long.parseLong(var2[1]);
            var2[1] = this.gameContainer.textManager.getDateWithTodayYesterday(var4);
        }

        return var2;
    }

    private void method388(boolean var1) {
        if (var1 != this.hasNotRatedTrack) {
            this.hasNotRatedTrack = var1;
            this.setVisible(false);
            if (var1) {
                this.add(this.buttonNoVote);

                for (int var2 = 0; var2 <= 10; ++var2) {
                    this.add(this.buttonsVote[var2]);
                }
            } else {
                this.removeAll();
            }

            this.setVisible(true);
        }
    }

    private void toggleAcceptRejectButtons(boolean var1) {
        if (!this.gameContainer.safeMode) {
            if (var1 != this.trackPending) {
                this.trackPending = var1;
                this.setVisible(false);
                if (var1) {
                    this.add(this.buttonReject);
                    this.add(this.buttonAccept);
                } else {
                    this.remove(this.buttonReject);
                    this.remove(this.buttonAccept);
                }

                this.setVisible(true);
            }
        }
    }

    private void method390(boolean var1) {
        if (!this.gameContainer.safeMode) {
            if (var1 != this.aBoolean436) {
                this.aBoolean436 = var1;
                this.setVisible(false);
                if (var1) {
                    this.add(this.buttonBack);
                } else {
                    this.remove(this.buttonBack);
                }

                this.setVisible(true);
            }
        }
    }

    private void method391(boolean var1) {
        if (var1 != this.aBoolean437) {
            this.aBoolean437 = var1;
            this.setVisible(false);
            if (var1) {
                this.add(this.buttonR);
            } else {
                this.remove(this.buttonR);
            }

            this.setVisible(true);
        }
    }
}
