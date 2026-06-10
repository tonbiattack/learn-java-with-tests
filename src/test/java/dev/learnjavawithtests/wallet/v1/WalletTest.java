package dev.learnjavawithtests.wallet.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WalletTest {

    @Test
    void depositsMoney() {
        Wallet wallet = new Wallet();

        wallet.deposit(new Money(10));

        assertEquals(new Money(10), wallet.balance());
    }

    @Test
    void withdrawsMoney() {
        Wallet wallet = new Wallet();
        wallet.deposit(new Money(20));

        wallet.withdraw(new Money(5));

        assertEquals(new Money(15), wallet.balance());
    }

    @Test
    void rejectsOverdrafts() {
        Wallet wallet = new Wallet();
        wallet.deposit(new Money(10));

        assertThrows(InsufficientFundsException.class, () -> wallet.withdraw(new Money(20)));
        assertEquals(new Money(10), wallet.balance());
    }
}
