package entity.people;

import entity.Age;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrainDriver extends User {
    private static final Logger logger = LoggerFactory.getLogger(TrainDriver.class);
    private boolean license;

    public TrainDriver(long id, String firstName, String lastName, Age age) {
        super(id, firstName, lastName, age);
        validateAge(age);
        license = true;
    }

    public TrainDriver(User user) {
        super(user.getId(), user.getFirstName(), user.getLastName(), user.getAge());
        validateAge(getAge());
        license = true;
    }

    public void activateLicense() {
        license = true;
    }

    public void deactivateLicense() {
        license = false;
    }

    public boolean licenseStatus() {
        return license;
    }

    private void validateAge(Age age) {
        if (age.value() < 18) {
            RuntimeException e = new IllegalArgumentException("driver age is " + age.value());
            logger.error("driver's age must not be less than 18", e);
            throw e;
        }
    }

}
