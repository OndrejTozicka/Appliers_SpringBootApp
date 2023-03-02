package cz.appliersdatabase.appliersdatabase.data;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Tozicka Ondrej
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TechnologyDTO {
    
    private Long id;
    
    private String name;
    
    private String description;
    
    private List<AppliersTechnologyDTO> appliers;
}
