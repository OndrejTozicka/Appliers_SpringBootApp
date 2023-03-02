
package cz.appliersdatabase.appliersdatabase.data;

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
public class AppliersTechnologyDTO {

    private int skillLevel;
    

    private String note;
    
    private Long id;
    
    private ApplierDTO applier;
    
    private TechnologyDTO technology;
}
