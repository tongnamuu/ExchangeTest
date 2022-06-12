package exchange.rate.exchangetest.domain.entity;

import static exchange.rate.exchangetest.domain.validator.Validator.validateAmount;

import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Remittance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "remittance_id")
    private Long id;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "rate", nullable = false)
    private Double rate;

    @Column(name = "ChangeTo", nullable = false)
    private Currency changeTo;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false)
    private RemittanceStatus status;

    @Column(name = "created_at", nullable = false)
    private ZonedDateTime createdAt;

    @Builder
    private Remittance(Integer amount, Double rate, Currency changeTo,
                      RemittanceStatus status) {
        this.amount = validateAmount(amount);
        this.rate = rate;
        this.changeTo = changeTo;
        this.status = status;
        this.createdAt = ZonedDateTime.now();
    }
}
