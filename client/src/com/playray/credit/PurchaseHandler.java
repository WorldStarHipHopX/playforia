package com.playray.credit;

import com.playray.credit.Product;

public interface PurchaseHandler {

    int refreshCredits();

    int userBuyProduct(Product var1, Object var2);

    void userCanceled();
}
