package exchange.rate.exchangetest.domain.usecase;

import exchange.rate.exchangetest.domain.entity.Currency;
import exchange.rate.exchangetest.domain.entity.Remittance;
import exchange.rate.exchangetest.domain.entity.RemittanceStatus;
import exchange.rate.exchangetest.domain.repository.RemittanceRepository;
import exchange.rate.exchangetest.domain.usecase.result.RemittanceInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateRemittance {
    private final RemittanceRepository repository;
    private final GetCurrencyRate getCurrencyRate;

    public RemittanceInfo execute(
        int amount,
        Currency currency
    ) {
        double rate = getCurrencyRate.execute(currency);
        Remittance remittance = Remittance.builder()
            .amount(amount)
            .changeTo(currency)
            .rate(rate)
            .status(RemittanceStatus.ACCEPT)
            .build();
        repository.create(remittance);
        return RemittanceInfo.from(remittance);
    }
}
