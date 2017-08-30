package com.aapeli.singleclient;

import java.util.Hashtable;

class HashtableContainer {

    private Hashtable hashTable = new Hashtable();


    protected boolean contains(String key, String value) {
        if (value == null) {
            return false;
        } else {
            String valueExisting = this.get(key);
            if (valueExisting != null && valueExisting.equals(value)) {
                return false;
            } else {
                this.hashTable.put(key.toLowerCase(), value);
                return true;
            }
        }
    }

    protected String get(String key) {
        return (String) ((String) this.hashTable.get(key.toLowerCase()));
    }
}
