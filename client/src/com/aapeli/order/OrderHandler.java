package com.aapeli.order;


public interface OrderHandler {

    void orderCompleted();

    void orderCanceled(boolean var1);
}
