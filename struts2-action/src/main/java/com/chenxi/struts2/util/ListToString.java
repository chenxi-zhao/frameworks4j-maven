package com.chenxi.struts2.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListToString {
    public static String List2Str(List<String> list) {
        String str = "";

        if (list == null) {
            return str;
        } else {
            Iterator<String> i = list.iterator();
            while (i.hasNext()) {
                String si = (String) i.next();
                str += "," + si;
            }
        }

        return str;
    }

    public static List<String> Str2List(String str) {
        List<String> list = new ArrayList<String>();

        if (str == null) {
            return list;
        } else {
            String[] strArr = str.split(",");

            for (int i = 0; i < strArr.length; i++) {
                if (!("".equals(strArr[i])) && strArr[i] != null)
                    list.add(strArr[i]);
            }
        }
        return list;
    }
}
