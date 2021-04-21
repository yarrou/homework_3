package entity.wagons;

import entity.people.TrainDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Locomotive extends Wagon {
    private static final Logger logger = LoggerFactory.getLogger(Locomotive.class);
    private TrainDriver driver;

    public Locomotive(long id, TrainDriver driver) {
        super(id);
        setDriver(driver);
    }
    public Locomotive(long id){
        super(id);
    }

    public TrainDriver getDriver() {
        return driver;
    }

    public void setDriver(TrainDriver driver) {
        if (driver.licenseStatus()) {
            this.driver = driver;
        } else {
            RuntimeException e = new IllegalArgumentException("driver license is false");
            logger.error("not found license",e);
            throw e;
        }
    }

}
