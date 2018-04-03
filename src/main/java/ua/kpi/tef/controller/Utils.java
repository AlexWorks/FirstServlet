package ua.kpi.tef.controller;

import java.util.regex.Pattern;

public class Utils {
    public boolean checkStringValueWithRegexp(String string, String regexp) {
        return Pattern.compile(regexp).matcher(string).matches();
    }
}
