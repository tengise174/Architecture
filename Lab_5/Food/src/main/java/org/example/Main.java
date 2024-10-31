package org.example;

public class Main {

    public interface CookF {
        String cookRule();
    }

    public static abstract class CookFood implements CookF {
        public abstract String getCook();

        public String startCooking() {
            return "Бэлдэцээ хийж эхэл.";
        }
    }

    public static class Tsuivan extends CookFood {
        @Override
        public String getCook() {
            return "10 минут ширүүн гал дээр 10 минут зөөлөн гал дээр жигнэнэ..";
        }

        @Override
        public String cookRule() {
            return "Дүрэм: Ус болон давс үргэлж шалга.";
        }
    }

    public static class Buuz extends CookFood {
        @Override
        public String getCook() {
            return "Ууранд 10-15 минут жигнэнэ";
        }

        @Override
        public String cookRule() {
            return "Дүрэм: Гурил зуззан эсэхийг байнга шалга.";
        }
    }

    public static void main(String[] args) {
        CookFood tsuivan = new Tsuivan();
        System.out.println(tsuivan.startCooking());
        System.out.println("Tsuivan zaavar: " + tsuivan.getCook());
        System.out.println("Tsuivan hiihde anhaarah: " + tsuivan.cookRule());

        CookFood buuz = new Buuz();
        System.out.println(buuz.startCooking());
        System.out.println("Buuz zaavar: " + buuz.getCook());
        System.out.println("Buuz hiihde anhaarah: " + buuz.cookRule());
    }
}
