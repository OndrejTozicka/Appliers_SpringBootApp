
package cz.appliersdatabase.appliersdatabase.data;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 *
 * @author Tozicka Ondrej
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApplierDTO {
    
    private Long id;
    
    private String name;

    private String surname;
    
    
    private List<AppliersTechnologyDTO> technologyList;
    
    
}
