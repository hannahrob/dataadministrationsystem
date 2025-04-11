package pharmacy.drug_admin_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends JpaRepository<pharmacy.drug_admin_system.entity.Drug, Long> {
}
