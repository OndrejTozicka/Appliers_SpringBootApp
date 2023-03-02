
package cz.appliersdatabase.appliersdatabase.data;

import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author Tozicka Ondrej
 */

@Mapper(componentModel="spring")
public abstract class AppliersTechnologyMapper {

    public abstract AppliersTechnologyEntity toEntity(AppliersTechnologyDTO source);
    public abstract AppliersTechnologyDTO toDTO(AppliersTechnologyEntity source);
    public abstract List<AppliersTechnologyDTO> toApplierTechnologyDTOList(List<AppliersTechnologyEntity> source);
    public abstract List<AppliersTechnologyEntity> toApplierTechnologyEntityList(List<AppliersTechnologyDTO> source);
    
}
