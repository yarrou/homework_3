package data;

import entity.Cargo;

import java.util.Random;

public class CargoTestSample {
    public static Cargo getValidCargo() {
        return new Cargo(new Random().nextLong(), "details", 30, 50000);
    }
}
