package com.playray.flashclient;

import com.playray.applet.AApplet;
import com.playray.flashclient.MessageIn;

public interface FlashGame {

    AApplet getAApplet();

    String getZoneName();

    void startUpResult(int var1);

    void userDataReady();

    void friendListReady();

    void actionCommandReceived(MessageIn var1);

    void notifyServerDisconnecting(int var1);

    void connectionError();
}
