package com.mtopgul.exceptionsAndLocalization.loadingProperties;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author muhammed-topgul
 * @since 20/03/2024 11:59
 */
public class FormattingMessages {
    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Zoo", Locale.ENGLISH);
        String msg = resourceBundle.getString("helloByName");
        System.out.println(MessageFormat.format(msg, "Tammy", "Henry"));
    }
}
