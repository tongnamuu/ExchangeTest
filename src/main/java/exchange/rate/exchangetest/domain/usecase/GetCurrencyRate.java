package exchange.rate.exchangetest.domain.usecase;

import exchange.rate.exchangetest.domain.entity.Currency;

public interface GetCurrencyRate {
    double execute(Currency currency);
}
