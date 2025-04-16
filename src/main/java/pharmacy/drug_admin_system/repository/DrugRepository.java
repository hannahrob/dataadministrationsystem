package pharmacy.drug_admin_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pharmacy.drug_admin_system.entity.Drug;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Long> {

}
