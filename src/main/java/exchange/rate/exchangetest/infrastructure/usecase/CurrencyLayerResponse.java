package exchange.rate.exchangetest.infrastructure.usecase;

import java.util.Map;
import lombok.ToString;

@ToString
public class CurrencyLayerResponse {
    boolean success;
    Map<String, Double> quotes;
}
