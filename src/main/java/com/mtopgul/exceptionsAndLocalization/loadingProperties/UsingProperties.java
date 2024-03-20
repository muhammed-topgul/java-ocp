package com.mtopgul.exceptionsAndLocalization.loadingProperties;

import java.util.Properties;

/**
 * @author muhammed-topgul
 * @since 20/03/2024 12:02
 */
public class UsingProperties {
    public static void main(String[] args) {
        var props = new Properties();
        props.setProperty("name", "Our zoo");
        props.setProperty("open", "10am");

        System.out.println(props.getProperty("camel"));                          // null
        System.out.println(props.getProperty("camel", "Bob")); // Bob

        System.out.println(props.get("camel")); // null
        System.out.println(props.get("open"));  // 10am
        // props.get("open", "The zoo will be open soon"); // DOES NOT COMPILE
    }
}
