package data;

import entity.people.Passenger;
import entity.people.TrainDriver;
import entity.people.User;

import java.util.Random;

public class UserTestSamples {
    public static User getValidAdult() {
        return new User(new Random().nextLong(), "Vasya", "Pupkin", AgeTestSample.getValidAgeForAdult());
    }

    public static User getValidChildren() {
        return new User(new Random().nextLong(), "Vovachka", "Pupochkin", AgeTestSample.getValidAgeForChildren());
    }

    public static Passenger getValidPassenger(int seat) {
        return new Passenger(seat, getValidAdult());
    }

    public static TrainDriver getValidTrainDriver() {
        return new TrainDriver(getValidAdult());
    }

}
