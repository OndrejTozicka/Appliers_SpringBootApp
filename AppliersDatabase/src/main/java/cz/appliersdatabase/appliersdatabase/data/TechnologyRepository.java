package cz.appliersdatabase.appliersdatabase.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tozicka Ondrej
 */
@Repository
public interface TechnologyRepository extends JpaRepository<TechnologyEntity,Long>{
    
}
