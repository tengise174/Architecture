package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static class Car {
        private String name;
        private Person owner;

        public Car(String name, Person owner) {
            this.name = name;
            this.owner = owner;
            owner.addCar(this);
        }

        public String getName() {
            return name;
        }
    }

    public static class Person {
        private String name;
        private List<Car> cars;

        public Person(String name) {
            this.name = name;
            this.cars = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void addCar(Car car) {
            cars.add(car);
        }

        public void printCars() {
            System.out.println(this.name);
            for (Car car : cars) {
                System.out.println("- " + car.getName());
            }
        }
    }

    public static void main(String[] args) {

        Person Bat = new Person("Bat");
        Person Bold = new Person("Bold");

        Car car1 = new Car("Camry", Bat);
        Car car2 = new Car("Honda", Bold);
        Car car3 = new Car("Ford", Bat);

        Bat.printCars();
        Bold.printCars();
    }
}