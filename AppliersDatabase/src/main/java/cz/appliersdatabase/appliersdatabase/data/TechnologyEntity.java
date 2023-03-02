
package cz.appliersdatabase.appliersdatabase.data;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Tozicka Ondrej
 */

@Entity(name="technology")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyEntity {
      
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    @Column(nullable=false)
    private String name;
    
    @Column(nullable=false)
    private String description;
    
    @Column(nullable=false)
    @OneToMany(mappedBy="technology")
    private List<AppliersTechnologyEntity> appliers = new ArrayList<>() ;
    
    
}
