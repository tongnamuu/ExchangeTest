package exchange.rate.exchangetest.infrastructure.repository;

import exchange.rate.exchangetest.domain.entity.Remittance;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

interface RemittanceJpaRepository extends JpaRepository<Remittance, Long> {
    List<Remittance> findAll();
}
