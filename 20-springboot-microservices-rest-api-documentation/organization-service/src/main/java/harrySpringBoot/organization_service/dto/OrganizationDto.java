package harrySpringBoot.organization_service.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
    description = "OrganizationDTO Model Information"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {

    private Long id;

    @Schema(description = "Organization Name")
    private String organizationName;
    
    @Schema(description = "Organization Description")
    private String organizationDescription;
    
    @Schema(description = "Organization Code")
    private String organizationCode;

    private LocalDateTime createdDate;
}
