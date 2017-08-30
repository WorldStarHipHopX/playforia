package com.playray.connection;


public interface ConnListener {

    void dataReceived(String var1);

    void connectionLost(int var1);

    void notifyConnectionDown();

    void notifyConnectionUp();
}
