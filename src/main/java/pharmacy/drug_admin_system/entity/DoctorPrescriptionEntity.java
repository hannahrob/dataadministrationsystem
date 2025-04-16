package pharmacy.drug_admin_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "Doctor_Prescription")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DoctorPrescriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Doctor_Prescription ID")
    private Long doctorPrescriptionId;

    @Column(name = "Patient_ID")
    private String patientId;

    @Column(name = "Date_Issued")
    private LocalDate dateIssued;

    @Column(name = "Status")
    private String status;

    @Column(name = "Prescription", columnDefinition = "TEXT")
    private String prescribedDrugs;

//    @ManyToMany
//    @JoinTable(
//            name = "DoctorPrescription_Drug",
//            joinColumns = @JoinColumn(name = "DoctorPrescription_id"),
//            inverseJoinColumns = @JoinColumn(name = "drug_id")
//    )
//    private Long drug_id;
}