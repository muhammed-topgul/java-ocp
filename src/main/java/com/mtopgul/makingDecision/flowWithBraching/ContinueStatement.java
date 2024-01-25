package com.mtopgul.makingDecision.flowWithBraching;

/**
 * @author muhammed-topgul
 * @since 25/01/2024 08:43
 */
public class ContinueStatement {
    public static void main(String[] args) {
        CLEANING:
        for (char stables = 'a'; stables <= 'd'; stables++) {
            for (int leopard = 1; leopard < 4; leopard++) {
                if (stables == 'b' || leopard == 2) {
                    continue CLEANING;
                }
                System.out.println("Cleaning: " + stables + "," + leopard);
            }
        }
    }
}
