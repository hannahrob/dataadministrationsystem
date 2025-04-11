package pharmacy.drug_admin_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrugInventoryDto {
    private Long stockQuantity;
    private Integer reorderLevel;
    private String storageCondition;
    private LocalDateTime lastUpdated;
    private LocalDate expiryDate;
    private String batchNumber;
}
