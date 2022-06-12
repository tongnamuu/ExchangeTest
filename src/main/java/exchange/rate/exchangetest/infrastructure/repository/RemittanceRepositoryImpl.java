package exchange.rate.exchangetest.infrastructure.repository;

import exchange.rate.exchangetest.domain.entity.Remittance;
import exchange.rate.exchangetest.domain.repository.RemittanceRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
class RemittanceRepositoryImpl implements RemittanceRepository {
    private final RemittanceJpaRepository remittanceJpaRepository;

    @Override
    public List<Remittance> findAll() {
        return remittanceJpaRepository.findAll();
    }

    @Override
    public Remittance create(Remittance remittance) {
        return remittanceJpaRepository.save(remittance);
    }
}
