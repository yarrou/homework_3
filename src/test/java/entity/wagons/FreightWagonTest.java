package entity.wagons;

import data.CargoTestSample;
import data.WagonTestSample;
import entity.Cargo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FreightWagonTest {
    private FreightWagon wagon;
    private Cargo cargo;
    private Set<Cargo> cargoSet;

    @BeforeEach
    void init() {
        wagon = WagonTestSample.getValidFrightWagon();
        cargo = CargoTestSample.getValidCargo();
        cargoSet = Set.of(CargoTestSample.getValidCargo(), CargoTestSample.getValidCargo());

    }


    @Test
    void workloadValue() {
        Set<Cargo> cargoSet = Set.of(CargoTestSample.getValidCargo(), CargoTestSample.getValidCargo(), CargoTestSample.getValidCargo());
        wagon.loadCargo(cargoSet);
        assertTrue(wagon.workloadValue() <= wagon.maxCarrying());
    }

    @Test
    void loadCargoOne() {
        assertTrue(wagon.loadCargo(cargo));
        assertEquals(wagon.workloadValue(), cargo.getWeight());
        assertTrue(wagon.transportedCargo().contains(cargo));
    }

    @Test
    void unloadCargoOne() {
        assertFalse(wagon.unloadCargo(cargo));
        wagon.loadCargo(cargo);
        assertTrue(wagon.unloadCargo(cargo));
        assertTrue(wagon.transportedCargo().isEmpty());
    }

    @Test
    void testLoadCargoSet() {
        assertEquals(wagon.loadCargo(cargoSet), cargoSet);
        assertEquals(wagon.transportedCargo(), cargoSet);
    }

    @Test
    void testUnloadCargoSet() {
        wagon.loadCargo(cargoSet);
        assertEquals(wagon.unloadCargo(cargoSet), cargoSet);
        assertTrue(wagon.transportedCargo().isEmpty());
    }

    @Test
    void transportedCargo() {
        assertTrue(wagon.transportedCargo().isEmpty());
        assertEquals(wagon.loadCargo(cargoSet), cargoSet);
    }
}