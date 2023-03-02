
package cz.appliersdatabase.appliersdatabase.services;


import cz.appliersdatabase.appliersdatabase.data.AppliersTechnologyMapper;
import cz.appliersdatabase.appliersdatabase.data.TechnologyDTO;
import cz.appliersdatabase.appliersdatabase.data.TechnologyEntity;
import cz.appliersdatabase.appliersdatabase.data.TechnologyMapper;
import cz.appliersdatabase.appliersdatabase.data.TechnologyRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Tozicka Ondrej
 */

@Service
public class TechnologyService {
    
    @Autowired
    private TechnologyRepository technologyRepository;
    
    @Autowired
    private TechnologyMapper technologyMapper;
    
    @Autowired
    private AppliersTechnologyMapper appliersTechnologyMapper;
    
    
    public TechnologyDTO addTechnology(TechnologyDTO technologyDTO){
        TechnologyEntity entity = technologyMapper.toEntity(technologyDTO);
        TechnologyEntity savedEntity = technologyRepository.save(entity);
        return technologyMapper.toDTO(savedEntity);
    }
    
    public TechnologyDTO updateTechnology(@PathVariable Long id, @RequestBody TechnologyDTO sendTechnology) {
        
        TechnologyEntity technology = technologyRepository.findById(id).orElse(null);
        if (technology != null){
        technology.setName(sendTechnology.getName());
        //technology.setAppliers(appliersTechnologyMapper.toApplierTechnologyEntityList(sendTechnology.getAppliers()));
        technology.setDescription(sendTechnology.getDescription());
        technologyRepository.save(technology);
        return technologyMapper.toDTO(technology);
        }
        return null;
       }
       
    public String deleteTechnology(@PathVariable Long id){
        TechnologyEntity technologyToDelete = technologyRepository.findById(id).orElseThrow();
        try{
            technologyRepository.delete(technologyToDelete);
        }
        catch (Exception e){
            return "Something went wrong";
        }
        return "OK";
        }
       
    public TechnologyDTO getTechnology(@PathVariable Long id) {
        TechnologyEntity technologyEntity = technologyRepository.findById(id).orElseThrow();
        TechnologyDTO technology = technologyMapper.toDTO(technologyEntity);
        return technology;
    }
    
    public List<TechnologyDTO> getAllTechnology(){
        List<TechnologyEntity> technologyEntityList = technologyRepository.findAll();
        List<TechnologyDTO> technologyDTOList = new ArrayList<>();
        for (TechnologyEntity entity:technologyEntityList){
            technologyDTOList.add(technologyMapper.toDTO(entity));
        }
        
        return technologyDTOList;
    }
}
