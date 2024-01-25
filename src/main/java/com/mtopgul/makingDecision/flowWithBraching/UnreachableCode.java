package com.mtopgul.makingDecision.flowWithBraching;

/**
 * @author muhammed-topgul
 * @since 25/01/2024 08:45
 */
public class UnreachableCode {
    public static void main(String[] args) {
        int checkDate = 0;
        while(checkDate<10) {
            checkDate++;
            if(checkDate>100) {
                break;
                // checkDate++; // DOES NOT COMPILE
            }
        }
    }
}
