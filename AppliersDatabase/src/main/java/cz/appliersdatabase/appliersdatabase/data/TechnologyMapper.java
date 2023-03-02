package cz.appliersdatabase.appliersdatabase.data;

import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author Tozicka Ondrej
 */
@Mapper(componentModel="spring")
public abstract class TechnologyMapper {

    public abstract TechnologyEntity toEntity(TechnologyDTO source);
    public abstract TechnologyDTO toDTO(TechnologyEntity source);
    public abstract List<TechnologyDTO> toTechnologyDTOList(List<TechnologyEntity> source);
    public abstract List<TechnologyEntity> toTechnologyEntityList(List<TechnologyDTO> source);
}
