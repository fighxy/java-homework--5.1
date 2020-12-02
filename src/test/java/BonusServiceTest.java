
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();


        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;


        long actual = service.calculate(amount, registered);


        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();


        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;


        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnRegisteredUnderLimit(){
        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;


        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);

    }

    @Test
    void shouldCalculateForUnRegisteredAndOverLimit() {
        BonusService service = new BonusService();


        long amount = 1_000_000_60;
        boolean registered = false;
        long expected = 500;


        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }


    @Test
    void shouldCalculatedForUnRegisteredAnd0() {
        BonusService service = new BonusService();

        long amount = 00000;
        boolean registered = false;
        long expected = 0;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculatedForRegisteredAnd0() {
        BonusService service = new BonusService();

        long amount = 00000;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
}
