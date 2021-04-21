package entity.wagons;

import data.UserTestSamples;
import entity.people.TrainDriver;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class LocomotiveTest {

    @Test
    void setDriver() {
        Locomotive locomotive = new Locomotive(new Random().nextLong());
        TrainDriver driver = UserTestSamples.getValidTrainDriver();
        driver.deactivateLicense();
        assertThrows(IllegalArgumentException.class, () -> locomotive.setDriver(driver));
    }
}