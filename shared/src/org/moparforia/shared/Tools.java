package org.moparforia.shared;

import com.mongodb.BasicDBList;

import java.util.Iterator;
import java.util.List;

public class Tools {

    private static String toString(Object o) {
        if (o instanceof Boolean)
            return (Boolean) o ? "t" : "f";
        return o.toString();
    }

    public static String izer(String splitter, Object... args) {
        String s = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Object[]) {
                Object[] arr = (Object[]) args[i];
                for (int j = 0; j < arr.length; j++) {
                    s += toString(arr[j]) + ((j == args.length - 1) ? "" : splitter);
                }
            } else {
                s += toString(args[i]) + ((i == args.length - 1) ? "" : splitter);
            }
        }
        return s;
    }

    public static String tabularize(Object... args) {// lololol
        return izer("\t", args);

    }

    public static String triangelize(Object... args) {// hhhehehe
        return izer("^", args);
    }

    public static String commaize(Object... args) {// hhhehehe
        return izer(",", args);
    }

    public static int[] toIntArray(BasicDBList list)  {
        int[] ret = new int[list.size()];
        int i = 0;
        for (Object e : list)
            ret[i++] = (Integer) e;
        return ret;
    }
}