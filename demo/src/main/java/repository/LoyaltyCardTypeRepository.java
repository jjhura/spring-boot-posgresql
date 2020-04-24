package repository;

import entity.LoyaltyCardType;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoyaltyCardTypeRepository extends CrudRepository<LoyaltyCardType, Long>, JpaSpecificationExecutor<LoyaltyCardType> {
    @Override
    List<LoyaltyCardType> findAll();
}
