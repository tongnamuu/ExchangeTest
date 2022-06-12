package exchange.rate.exchangetest.domain.validator;

public class Validator {
    public static int validateAmount(int amount) {
        if(amount < 0 || amount > 10000) {
            throw new IllegalArgumentException();
        }
        return amount;
    }
}
