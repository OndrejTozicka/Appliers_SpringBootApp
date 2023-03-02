
package cz.appliersdatabase.appliersdatabase.data;

import java.util.*;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Tozicka Ondrej
 */
@Entity(name="applier")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplierEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    private String surname;

    @OneToMany(mappedBy="applier")
    private List<AppliersTechnologyEntity> technologyList = new ArrayList<>();

    
    
    
}
