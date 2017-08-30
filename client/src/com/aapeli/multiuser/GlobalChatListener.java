package com.aapeli.multiuser;

import com.aapeli.multiuser.ChatListener;

public interface GlobalChatListener extends ChatListener {

    void localUserSay(int var1, String var2);
}
