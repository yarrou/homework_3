package entity;


import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CargoTest {
    @Test
    void CargoNegativeParametersTest() {
        assertThrows(IllegalArgumentException.class, () -> new Cargo(2, "detals", -100, 300));
        assertThrows(IllegalArgumentException.class, () -> new Cargo(2, "detals", 100, -300));
    }

}