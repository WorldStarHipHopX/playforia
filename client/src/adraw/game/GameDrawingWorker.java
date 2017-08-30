package adraw.game;

import com.aapeli.tools.Tools;

import java.util.Vector;

class GameDrawingWorker implements Runnable {

    private static final int[] delays = {3000, 2000};
    private GamePanel gamePanel;
    private int delay;
    private Vector<GameDrawingData> drawingData;
    private boolean running;


    protected GameDrawingWorker(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.delay = delays[gamePanel.method275() ? 1 : 0];//todo wut???
        this.drawingData = new Vector<GameDrawingData>();
        this.running = true;
    }

    public void run() {
        do {
            Tools.sleep(1000L);
            this.process();
        } while (this.running);

        this.drawingData = null;
        this.gamePanel = null;
    }

    protected synchronized void addString(String data) {
        if (this.running) {
            this.drawingData.addElement(new GameDrawingData(this, data));
        }
    }

    protected synchronized void addSeparator() {//todo find out wut it does
        if (this.running) {
            this.drawingData.addElement(new GameDrawingData(this, '$'));// 36
        }
    }

    protected synchronized void addInteger(int data) {//todo why '%'
        if (this.running) {
            this.drawingData.addElement(new GameDrawingData(this, '%' + data));// 37
        }
    }

    protected synchronized void addUndo() {
        if (this.running) {
            int numDataz = this.drawingData.size();
            if (numDataz > 0) {
                this.drawingData.removeElementAt(numDataz - 1);
            } else {
                this.drawingData.addElement(new GameDrawingData(this, '5'));// 53
            }
        }
    }

    protected synchronized void stop() {
        this.running = false;
    }

    private synchronized void process() {
        if (this.running) {
            int numDataz = this.drawingData.size();
            if (numDataz != 0) {
                long timeNow = System.currentTimeMillis();
                int lastDataIndex = -1;
                int totalDatazLength = 0;

                GameDrawingData lastData;
                for (int хузхузхуз = 0; хузхузхуз < numDataz; ++хузхузхуз) {
                    lastData = this.drawingData.elementAt(хузхузхуз);
                    if (lastData.shouldSend(timeNow, this.delay)) {
                        lastDataIndex = хузхузхуз;
                        totalDatazLength += lastData.getDataLength();
                    } else {
                        хузхузхуз = numDataz;
                    }
                }

                if (lastDataIndex != -1) {
                    StringBuffer sb = new StringBuffer(1 + lastDataIndex + 1 + totalDatazLength);
                    sb.append("d");

                    for (int var9 = 0; var9 <= lastDataIndex; ++var9) {
                        lastData = this.drawingData.elementAt(0);
                        sb.append('\t');
                        sb.append(lastData.getData());
                        this.drawingData.removeElementAt(0);
                    }

                    this.gamePanel.writeGameData(sb.toString());
                }
            }
        }
    }

}
