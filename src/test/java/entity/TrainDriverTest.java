package entity;

import data.UserTestSamples;
import entity.people.TrainDriver;
import entity.people.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainDriverTest {
    @Test
    void createInvalidDriver() {
        User user = UserTestSamples.getValidChildren();
        assertThrows(IllegalArgumentException.class, () -> new TrainDriver(user));
    }

}