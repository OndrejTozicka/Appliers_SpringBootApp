
package cz.appliersdatabase.appliersdatabase.data;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Tozicka Ondrej
 */
@Entity(name="applier_technology")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppliersTechnologyEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    @Column(nullable=false)
    private int skillLevel;
    
    @Column(nullable=false)
    private String note;
    
    @ManyToOne
    @JoinColumn(name="applier_id",referencedColumnName="id")
    private ApplierEntity applier;
    
    @ManyToOne
    @JoinColumn(name="technology_id",referencedColumnName="id")
    private TechnologyEntity technology;
    
}
