package repository;

import entity.ConfigPoint;
import entity.LoyaltyCard;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoyaltyCardRepository extends CrudRepository<LoyaltyCard, Long>, JpaSpecificationExecutor<LoyaltyCard> {
    @Override
    List<LoyaltyCard> findAll();
}
