package ua.kpi.tef.controller;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class StringBundleProcessor {
    //Resource bundle installation
    private static final String MESSAGE_RESOURCE_BUNDLE = "messages";
    private static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGE_RESOURCE_BUNDLE,
                    new Locale("en"));

    static public String concatenateStringsUsingBundle(ArrayList<String> messages) {
        StringBuilder result = new StringBuilder("");
        for (String item : messages) {
            result = result.append(bundle.getString(item));
        }
        return result.toString();
    }

    static public String concatenateStrings(String... messages) {
        StringBuilder result = new StringBuilder("");
        for (String item : messages) {
            result = result.append(bundle.getString(item));
        }
        return result.toString();
    }

    static public String getBundleString(String bundleKey) {
        return bundle.getString(bundleKey);
    }
}
