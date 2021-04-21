package data;

import entity.wagons.FreightWagon;
import entity.wagons.Locomotive;
import entity.wagons.PassengerWagon;

import java.util.Random;

public class WagonTestSample {
    public static PassengerWagon getValidPassengerWagon() {
        return new PassengerWagon(45, new Random().nextLong());
    }

    public static FreightWagon getValidFrightWagon() {
        return new FreightWagon(new Random().nextLong(), 68);
    }

    public static Locomotive getValidLocomotive() {
        return new Locomotive(new Random().nextLong(), UserTestSamples.getValidTrainDriver());
    }
}
