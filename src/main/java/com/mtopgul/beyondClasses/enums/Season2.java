package com.mtopgul.beyondClasses.enums;

/**
 * @author muhammed-topgul
 * @since 15/02/2024 09:37
 */
public enum Season2 implements Weather {
    WINTER {
        @Override
        public int getAverageTemperature() {
            return -12;
        }

        @Override
        public String getHours() {
            return "10am-3pm";
        }

        @Override
        public String getDetails() {
            return "This is cold season";
        }
    },
    SPRING {
        @Override
        public int getAverageTemperature() {
            return 10;
        }

        @Override
        public String getHours() {
            return "9am-5pm";
        }

        @Override
        public String getDetails() {
            return "This is rainy day!";
        }
    },
    SUMMER {
        @Override
        public int getAverageTemperature() {
            return 35;
        }

        @Override
        public String getHours() {
            return "9am-7pm";
        }
    },
    FALL {
        @Override
        public int getAverageTemperature() {
            return 7;
        }

        @Override
        public String getHours() {
            return "9am-5pm";
        }
    };

    public abstract String getHours();

    public String getDetails() {
        return "Details about season";
    }

    public static void main(String[] args) {
        Season2 spring = Season2.SPRING;
        System.out.println(spring.getDetails());
        System.out.println(spring.getHours());
        System.out.println(spring.getAverageTemperature());
    }
}
