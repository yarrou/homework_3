package entity.wagons;

import entity.people.Passenger;

import java.util.*;

public class PassengerWagon extends Wagon {


    private final int countSeats;
    private final HashMap<Integer, Passenger> seats;

    public PassengerWagon(int countSeats, long id) {
        super(id);
        this.countSeats = countSeats;
        HashMap<Integer, Passenger> seatsForPassenger = new HashMap<>();
        for (int seat = 1; seat <= countSeats; seat++) {
            seatsForPassenger.put(seat, null);
        }
        this.seats = seatsForPassenger;
    }

    public int getCountSeats() {
        return countSeats;
    }

    //проверяем свободно ли место
    public boolean isOccupied(int seat) {
        return seats.get(seat) != null ? true : false;
    }

    //получаем пассажира по номеру сиденья
    public Optional<Passenger> getPassengerFromSeat(int numberSeat) {
        return isOccupied(numberSeat) ? Optional.of(seats.get(numberSeat)) : Optional.empty();
    }

    //получаем сет размещенных пассажиров
    public Set<Passenger> passengersOnBoard() {
        Set<Passenger> passengers = new HashSet<>(seats.values());
        passengers.remove(null);
        return passengers;
    }

    //размещаем пассажира
    public boolean placePassenger(Passenger passenger) {
        return seats.replace(passenger.getSeatNumber(), null, passenger);
    }

    //высаживаем пассажира
    public boolean dropPassenger(Passenger passenger) {
        return seats.replace(passenger.getSeatNumber(), passenger, null);
    }

    //размещаем пассажиров
    public Set<Passenger> placePassengers(Set<Passenger> passengers) {
        Set<Passenger> placedPassengers = new HashSet<>();
        for (Passenger passenger : passengers) {
            if (placePassenger(passenger)) placedPassengers.add(passenger);
        }
        return placedPassengers;
    }

    //высаживаем пассажиров
    public Set<Passenger> dropPassengers(Set<Passenger> passengers) {
        Set<Passenger> droppedPassengers = new HashSet<>();
        for (Passenger passenger : passengers) {
            if (dropPassenger(passenger)) droppedPassengers.add(passenger);
        }
        return droppedPassengers;
    }


}
