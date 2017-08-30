package adraw.game;

class GameDrawingData {

    private final GameDrawingWorker worker;
    private long timeCreated;
    private String data;
    private int dataLen;


    protected GameDrawingData(GameDrawingWorker worker, int data) {
        this(worker, String.valueOf((char) data));
    }

    protected GameDrawingData(GameDrawingWorker worker, String data) {
        this.worker = worker;
        this.timeCreated = System.currentTimeMillis();
        this.data = data;
        this.dataLen = data.length();
    }

    protected boolean shouldSend(long time, int delay) {
        return time > this.timeCreated + (long) delay;
    }

    protected int getDataLength() {
        return this.dataLen;
    }

    protected String getData() {
        return this.data;
    }
}
