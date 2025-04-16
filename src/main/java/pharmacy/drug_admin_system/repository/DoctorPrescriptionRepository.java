package pharmacy.drug_admin_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pharmacy.drug_admin_system.entity.DoctorPrescriptionEntity;

import java.util.Optional;

public interface DoctorPrescriptionRepository extends JpaRepository<DoctorPrescriptionEntity, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM doctor_prescription WHERE patient_id = :patientId")
    Optional<DoctorPrescriptionEntity> findByPatientId(@Param("patientId") String patientId);


}
