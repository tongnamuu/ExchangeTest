package exchange.rate.exchangetest.domain.usecase;

import exchange.rate.exchangetest.domain.repository.RemittanceRepository;
import exchange.rate.exchangetest.domain.usecase.result.GetRemittanceResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetRemittanceList {
    private final RemittanceRepository repository;

    public GetRemittanceResult execute() {
        return GetRemittanceResult.builder().remittances(repository.findAll()).build();
    }
}
