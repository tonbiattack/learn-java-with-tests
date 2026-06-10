package dev.learnjavawithtests.wallet.v1;

public record Money(int amount) {
    public Money add(Money other) {
        return new Money(amount + other.amount);
    }

    public Money subtract(Money other) {
        return new Money(amount - other.amount);
    }

    public boolean isLessThan(Money other) {
        return amount < other.amount;
    }
}

