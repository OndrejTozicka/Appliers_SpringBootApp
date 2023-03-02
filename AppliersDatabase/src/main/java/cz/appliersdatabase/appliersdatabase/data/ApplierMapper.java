
package cz.appliersdatabase.appliersdatabase.data;

import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author Tozicka Ondrej
 */
@Mapper(componentModel="spring")
public abstract class ApplierMapper {

    public abstract ApplierEntity toEntity(ApplierDTO source);
    public abstract ApplierDTO toDTO(ApplierEntity source);
    public abstract List<ApplierDTO> toApplierDTOList(List<ApplierEntity> source);
    public abstract List<ApplierEntity> toApplierEntityList(List<ApplierDTO> source);
}
