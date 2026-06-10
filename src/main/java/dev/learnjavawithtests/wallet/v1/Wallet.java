package dev.learnjavawithtests.wallet.v1;

public final class Wallet {
    private Money balance = new Money(0);

    public Money balance() {
        return balance;
    }

    public void deposit(Money amount) {
        balance = balance.add(amount);
    }

    public void withdraw(Money amount) {
        if (balance.isLessThan(amount)) {
            throw new InsufficientFundsException();
        }
        balance = balance.subtract(amount);
    }
}

