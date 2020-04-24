package repository;

import entity.ConfigPoint;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConfigPointRepository extends CrudRepository<ConfigPoint, Long>, JpaSpecificationExecutor<ConfigPoint> {
    @Override
    List<ConfigPoint> findAll();
}
