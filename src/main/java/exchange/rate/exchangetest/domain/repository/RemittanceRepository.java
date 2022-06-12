package exchange.rate.exchangetest.domain.repository;

import exchange.rate.exchangetest.domain.entity.Remittance;
import java.util.List;

public interface RemittanceRepository {
    List<Remittance> findAll();
    Remittance create(Remittance remittance);
}
