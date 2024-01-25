package com.mtopgul.makingDecision.flowWithBraching;

/**
 * @author muhammed-topgul
 * @since 25/01/2024 08:35
 */
public class AddingOptionalLabel {
    public static void main(String[] args) {
        int frog = 15;
        BAD_IDEA:
        if (frog > 10)
            EVEN_WORSE_IDEA:{
                frog++;
            }
    }
}
