package entity.people;

import entity.Age;

public class Passenger extends User {
    public Passenger(long id, String firstName, String lastName, Age age, int seatNumber) {
        super(id, firstName, lastName, age);
        this.seatNumber = seatNumber;
    }

    public Passenger(int seatNumber, User user) {
        super(user.getId(), user.getFirstName(), user.getLastName(), user.getAge());
        this.seatNumber = seatNumber;

    }

    private final int seatNumber;

    public int getSeatNumber() {
        return seatNumber;
    }
}
