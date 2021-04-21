package entity;

import entity.wagons.FreightWagon;
import entity.wagons.Locomotive;
import entity.wagons.PassengerWagon;
import entity.wagons.Wagon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;


public class Train {
    private static final Logger logger = LoggerFactory.getLogger(Train.class);
    private HashSet<Wagon> wagons;
    private final Wagon wagon;
    private Train nextWagon;
    private final long id;


    public long getId() {
        return id;
    }

    public Wagon getWagon() {
        return wagon;
    }


    public Train getNextWagon() {
        return nextWagon;
    }

    public Train(long id, Locomotive wagon) {
        this.wagon = wagon;
        this.id = id;
        nextWagon = null;
        this.wagons = new HashSet<Wagon>();
        wagons.add(wagon);
    }

    private Train(long id, Wagon wagon, HashSet<Wagon> wagons) {
        this.wagons = wagons;
        if (!this.wagons.add(wagon)) {
            RuntimeException e = new IllegalArgumentException("wagon " + wagon + " is already in the train");
            logger.error("it is impossible to add a wagon", e);
            throw e;
        }
        this.wagon = wagon;
        this.id = id;
        nextWagon = null;
    }


    public void addAtLast(PassengerWagon newWagon) {
        if (nextWagon == null) {
            nextWagon = new Train(getId(), newWagon, wagons);
        } else {
            nextWagon.addAtLast(newWagon);
        }
    }

    public void addAtLast(FreightWagon newWagon) {
        if (nextWagon == null) {
            nextWagon = new Train(getId(), newWagon, wagons);
        } else {
            nextWagon.addAtLast(newWagon);
        }
    }

    @Override
    public String toString() {
        StringBuilder trainToString = new StringBuilder("Train №" + id);
        wagonToString(trainToString);
        return trainToString.toString();
    }

    private void wagonToString(StringBuilder str) {
        str.append("-->" + wagon);
        if (nextWagon != null) {
            nextWagon.wagonToString(str);
        }
    }
}
