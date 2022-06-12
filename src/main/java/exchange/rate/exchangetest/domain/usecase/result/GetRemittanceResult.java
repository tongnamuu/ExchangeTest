package exchange.rate.exchangetest.domain.usecase.result;

import exchange.rate.exchangetest.domain.entity.Remittance;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GetRemittanceResult {
    private final List<Remittance> remittances;

    @Builder
    private GetRemittanceResult(List<Remittance> remittances) {
        this.remittances = remittances;
    }
}
