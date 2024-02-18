package com.mtopgul.beyondClasses.nestedClasses.anonymousClass;

/**
 * @author muhammed-topgul
 * @since 19/02/2024 00:00
 */
public class ZooGiftShop {
    abstract class SaleTodayOnly {
        abstract int dollarsOff();

        String detail() {
            return "Java 17 OCP";
        }
    }

    public int admission(int basePrice) {
        // Anonim sınıflar aynı anda sadece tek bir sınıf veya interface implement edebilirler
        SaleTodayOnly saleTodayOnly = new SaleTodayOnly() {
            @Override
            int dollarsOff() {
                return 0;
            }

            @Override
            String detail() {
                return super.detail();
            }
        };
        // System.out.println(saleTodayOnly.detail());
        return basePrice - saleTodayOnly.dollarsOff();
    }
}
