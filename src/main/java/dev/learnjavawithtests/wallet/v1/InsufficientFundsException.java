package dev.learnjavawithtests.wallet.v1;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException() {
        super("cannot withdraw more than the current balance");
    }
}

