package pharmacy.drug_admin_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pharmacy.drug_admin_system.entity.DrugEffects;

public interface DrugEffectsRepository extends JpaRepository<DrugEffects, Long> {
}
