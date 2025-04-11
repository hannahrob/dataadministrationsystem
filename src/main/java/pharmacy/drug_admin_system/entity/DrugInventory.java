package pharmacy.drug_admin_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrugInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drugInventoryId;
    private Long stockQuantity;
    private Integer reorderLevel;
    private String storageCondition;
    private LocalDateTime lastUpdated;
    private LocalDate expiryDate;
    private String batchNumber;


}
