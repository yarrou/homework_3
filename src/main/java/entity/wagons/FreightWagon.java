package entity.wagons;

import entity.Cargo;

import java.util.HashSet;
import java.util.Set;

public class FreightWagon extends Wagon {
    private final int maxCarrying;
    private final HashSet<Cargo> cargoOnBoard;

    public FreightWagon(long id, int maxCarrying) {
        super(id);
        this.maxCarrying = maxCarrying;
        this.cargoOnBoard = new HashSet<Cargo>();
    }

    public int maxCarrying() {
        return maxCarrying;
    }

    public int workloadValue() {
        int workLoad = 0;
        if (!cargoOnBoard.isEmpty()) {
            for (Cargo cargo : cargoOnBoard) {
                workLoad += cargo.getWeight();
            }
        }
        return workLoad;
    }

    public boolean loadCargo(Cargo cargo) {
        return workloadValue() + cargo.getWeight() <= maxCarrying ? cargoOnBoard.add(cargo) : false;
    }

    public boolean unloadCargo(Cargo cargo) {
        return cargoOnBoard.remove(cargo);
    }

    public Set<Cargo> loadCargo(Set<Cargo> cargo) {
        HashSet<Cargo> loadedCargo = new HashSet<>();
        for (Cargo cargoOne : cargo) {
            if (loadCargo(cargoOne)) loadedCargo.add(cargoOne);
        }
        return loadedCargo;
    }

    public Set<Cargo> unloadCargo(Set<Cargo> cargo) {
        HashSet<Cargo> unloadedCargo = new HashSet<>();
        for (Cargo cargoOne : cargo) {
            if (unloadCargo(cargoOne)) unloadedCargo.add(cargoOne);
        }
        return unloadedCargo;
    }

    public Set<Cargo> transportedCargo() {
        return Set.copyOf(cargoOnBoard);
    }

}
