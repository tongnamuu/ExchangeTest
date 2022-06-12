package exchange.rate.exchangetest.domain.usecase.result;

import exchange.rate.exchangetest.domain.entity.Currency;
import exchange.rate.exchangetest.domain.entity.Remittance;
import exchange.rate.exchangetest.domain.entity.RemittanceStatus;
import java.time.ZonedDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RemittanceInfo {
    private int amount;
    private double rate;
    private Currency currency;
    private RemittanceStatus status;
    private ZonedDateTime createdAt;

    @Builder(access = AccessLevel.PRIVATE)
    private RemittanceInfo(int amount, double rate, Currency currency,
                          RemittanceStatus status, ZonedDateTime createdAt) {
        this.amount = amount;
        this.rate = rate;
        this.currency = currency;
        this.status = status;
        this.createdAt = createdAt;
    }

    public static RemittanceInfo from(Remittance remittance) {
        return RemittanceInfo.builder()
            .amount(remittance.getAmount())
            .rate(remittance.getRate())
            .currency(remittance.getChangeTo())
            .status(remittance.getStatus())
            .createdAt(remittance.getCreatedAt())
            .build();
    }
}
