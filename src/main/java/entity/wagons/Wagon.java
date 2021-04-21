package entity.wagons;

import java.util.Objects;

public abstract class Wagon {
    public Wagon(long id) {
        this.id = id;
    }

    private final long id;

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wagon)) return false;
        if (!o.getClass().getSimpleName().equals(this.getClass().getSimpleName())) return false;
        Wagon wagon = (Wagon) o;
        return getId() == wagon.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "№" + id;
    }
}
