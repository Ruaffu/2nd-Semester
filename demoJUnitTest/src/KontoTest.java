import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KontoTest {

    Konto konto = new Konto("nik", 100);

    @org.junit.jupiter.api.Test
    void getNavn()
    {
        assertEquals("nik", konto.getNavn());
    }

    @org.junit.jupiter.api.Test
    void getSaldo()
    {
        assertEquals(100, konto.getSaldo());
    }

    @Test
    void testDeposit() {
        assertEquals(213, konto.deposit(113));
    }

    @Test
    void testForDepositNegNum() {
        assertEquals(100, konto.deposit(-1000));
    }

    @Test
    void testWithdraw() {
        assertEquals(100, konto.withdraw(500));
    }

    @Test
    void testWithdrawNegNum() {
        assertEquals(100, konto.withdraw(-100));
    }

    @Test
    void testWithdrawZero() {
        assertEquals(100, konto.withdraw(0));
    }


}