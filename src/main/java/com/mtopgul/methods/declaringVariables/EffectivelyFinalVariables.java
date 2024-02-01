package com.mtopgul.methods.declaringVariables;

/**
 * @author muhammed-topgul
 * @since 01/02/2024 15:49
 */
public class EffectivelyFinalVariables {
    public String zooFriends() {
        String name = "Harry the Hippo"; // Effectively Final
        var size = 10;
        boolean wet;                     // Effectively Final
        if (size > 100)
            size++;
        name.substring(0);
        wet = true;
        return name;
    }
}
