package com.mtopgul.makingDecision.applyingSwitch.switchExpression;

/**
 * @author muhammed-topgul
 * @since 24/01/2024 10:09
 */
public class CaseBlock {
    public static void main(String[] args) {
        int fish = 5;
        int length = 12;
        var name = switch (fish) {
            case 1 -> "Goldfish";
            case 2 -> {
                yield "Trout";
            }
            case 3 -> {
                if (length > 10)
                    yield "Blobfish";
                else
                    yield "Green";
            }
            default -> "Swordfish";
        };
        System.out.println(name);
    }
}
