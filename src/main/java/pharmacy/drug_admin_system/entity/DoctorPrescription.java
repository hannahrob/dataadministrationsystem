package pharmacy.drug_admin_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DoctorPrescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorPrescriptionId;
    @Column(name = "Date Issued")
    private LocalDate dateIssued;
    @Column(name = "Status")
    private String status;
    @Column(name = "Dosage")
    private String dosage;
    @Column(name = "Frequency")
    private String frequency;
    @Column(name = "Duration")
    private String duration;
    @ManyToMany
    @JoinTable(
            name = "DoctorPrescription_Drug",
            joinColumns = @JoinColumn(name = "DoctorPrescription_id"),
            inverseJoinColumns = @JoinColumn(name = "drug_id")
    )
    private String drugs;
}