package com.aapeli.credit;

import com.aapeli.credit.Product;

public interface PurchaseHandler {

    int refreshCredits();

    int userBuyProduct(Product var1, Object var2);

    void userCanceled();
}
