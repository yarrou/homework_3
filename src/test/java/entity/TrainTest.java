package entity;

import data.WagonTestSample;
import entity.wagons.Locomotive;
import entity.wagons.PassengerWagon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainTest {

    @Test
    void getWagon() {
        Locomotive locomotive = WagonTestSample.getValidLocomotive();
        Train train = new Train(1, locomotive);

        assertEquals(locomotive, train.getWagon());
    }

    @Test
    void getNextWagon_addAtLast() {
        Locomotive locomotive = WagonTestSample.getValidLocomotive();
        PassengerWagon passengerWagon = WagonTestSample.getValidPassengerWagon();
        Train train = new Train(1, locomotive);
        train.addAtLast(passengerWagon);

        assertEquals(train.getNextWagon().getWagon(), passengerWagon);
        assertThrows(IllegalArgumentException.class, () -> train.addAtLast(passengerWagon));
    }

}