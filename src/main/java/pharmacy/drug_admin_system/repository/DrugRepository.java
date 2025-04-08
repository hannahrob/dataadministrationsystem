package pharmacy.drug_admin_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pharmacy.drug_admin_system.entity.DrugEntity;

@Repository
public interface DrugRepository extends JpaRepository<DrugEntity, Long> {
}
