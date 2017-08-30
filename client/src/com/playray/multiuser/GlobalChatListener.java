package com.playray.multiuser;

import com.playray.multiuser.ChatListener;

public interface GlobalChatListener extends ChatListener {

    void localUserSay(int var1, String var2);
}
