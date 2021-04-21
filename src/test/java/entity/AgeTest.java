package entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AgeTest {

    @Test
    void AgeTest() {
        assertThrows(IllegalArgumentException.class, () -> new Age(150));
        assertThrows(IllegalArgumentException.class, () -> new Age(-1));
        assertThrows(IllegalArgumentException.class, () -> new Age(LocalDate.of(3000, 1, 1)));
        assertThrows(IllegalArgumentException.class, () -> new Age(LocalDate.of(1890, 1, 1)));
    }
}