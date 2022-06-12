package exchange.rate.exchangetest.domain.usecase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import exchange.rate.exchangetest.domain.entity.Currency;
import exchange.rate.exchangetest.domain.repository.RemittanceRepository;
import exchange.rate.exchangetest.domain.usecase.result.RemittanceInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CreateRemittanceTest {

    @Autowired
    private RemittanceRepository repository;

    private GetCurrencyRate getCurrencyRate = mock(GetCurrencyRate.class);

    private CreateRemittance createRemittance;

    @BeforeEach
    void setup() {
        createRemittance = new CreateRemittance(repository, getCurrencyRate);
    }

    @Test
    @DisplayName("create success")
    public void test01() {
        int amount = 10;
        Currency currency = Currency.KRW;
        given(getCurrencyRate.execute(currency)).willReturn(1300.10);

        RemittanceInfo result = createRemittance.execute(
            amount, currency
        );

        assertThat(result.getAmount()).isEqualTo(amount);
        assertThat(result.getCurrency()).isEqualTo(currency);
    }

    @Test
    @DisplayName("create fail with invalid amount")
    public void test02() {
        int amount = -10;
        Currency currency = Currency.KRW;
        given(getCurrencyRate.execute(currency)).willReturn(1300.10);

        assertThrows(IllegalArgumentException.class, () -> createRemittance.execute(
            amount, currency
        ));
    }

}