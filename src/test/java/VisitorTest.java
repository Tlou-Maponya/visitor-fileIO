import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class VisitorTest {
    Visitor alice = new Visitor("Alice", 26, "Well Done", "Vhambe Vhambelani");

    // Testing save function
    @Test
    void save() {
        try {
            alice.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Testing load function
    @Test
    void load() {
        try {
            alice.load("Alice");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}