package entity.wagons;

import data.WagonTestSample;
import data.UserTestSamples;
import entity.people.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PassengerWagonTest {
    private Passenger passenger1;
    private Passenger passenger2;
    private PassengerWagon wagon;
    private Set<Passenger> passengersSet;

    @BeforeEach
    public void init() {
        passenger1 = UserTestSamples.getValidPassenger(1);
        passenger2 = UserTestSamples.getValidPassenger(2);
        wagon = WagonTestSample.getValidPassengerWagon();
        passengersSet = Set.of(passenger1, passenger2);
    }

    @Test
    void isOccupied() {
        assertFalse(wagon.isOccupied(1));
        wagon.placePassenger(passenger1);
        assertTrue(wagon.isOccupied(1));

    }

    @Test
    void placePassenger() {
        Passenger passenger = UserTestSamples.getValidPassenger(-1);
        assertFalse(wagon.placePassenger(passenger));
        assertTrue(wagon.placePassenger(passenger1));
        assertFalse(wagon.placePassenger(UserTestSamples.getValidPassenger(1)));

    }

    @Test
    void getPassengerFromSeat() {
        assertTrue(wagon.getPassengerFromSeat(1).isEmpty());
        wagon.placePassenger(passenger1);
        assertEquals(wagon.getPassengerFromSeat(1).get(), passenger1);

    }

    @Test
    void dropPassenger() {
        wagon.placePassenger(passenger1);
        assertTrue(wagon.dropPassenger(passenger1));
        assertFalse(wagon.dropPassenger(passenger2));
        assertTrue(wagon.getPassengerFromSeat(1).isEmpty());
    }

    @Test
    void passengersOnBoard() {
        assertEquals(wagon.passengersOnBoard().size(), 0);
    }

    @Test
    void placePassengers() {
        assertEquals(wagon.placePassengers(passengersSet), passengersSet);
        assertEquals(wagon.passengersOnBoard().size(), 2);
    }

    @Test
    void dropPassengers() {
        wagon.placePassengers(passengersSet);
        assertEquals(wagon.dropPassengers(passengersSet), passengersSet);
        assertTrue(wagon.passengersOnBoard().isEmpty());
    }
}