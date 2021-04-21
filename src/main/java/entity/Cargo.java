package entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class Cargo {
    private static final Logger logger = LoggerFactory.getLogger(Cargo.class);
    private final long id;
    private final String name;
    private final int weight;
    private final int cost;
    private final boolean fragile;

    public Cargo(long id, String name, int weight, int cost, boolean fragile) {
        if (weight <= 0) {
            RuntimeException e = new IllegalArgumentException("weight = " + weight);
            logger.error("weight cannot be zero or negative");
            throw e;
        }
        if (cost <= 0) {
            RuntimeException e = new IllegalArgumentException("cost = " + cost);
            logger.error("cost cannot be zero or negative");
            throw e;
        }
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.fragile = fragile;
    }

    public Cargo(long id, String name, int weight, int cost) {
        this(id, name, weight, cost, false);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }

    public boolean isFragile() {
        return fragile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cargo)) return false;
        Cargo cargo = (Cargo) o;
        return getId() == cargo.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
