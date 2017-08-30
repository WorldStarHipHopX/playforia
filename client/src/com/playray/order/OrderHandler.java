package com.playray.order;


public interface OrderHandler {

    void orderCompleted();

    void orderCanceled(boolean var1);
}
