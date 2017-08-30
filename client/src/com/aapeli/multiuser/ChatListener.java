package com.aapeli.multiuser;


public interface ChatListener {

    void localUserSay(String var1);

    void localUserSayPrivately(String var1, String var2);

    void localUserAdminCommand(String var1, String var2);

    void localUserAdminCommand(String var1, String var2, String var3);
}
