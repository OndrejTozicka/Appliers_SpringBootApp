
package cz.appliersdatabase.appliersdatabase.services;

import cz.appliersdatabase.appliersdatabase.data.ApplierDTO;
import cz.appliersdatabase.appliersdatabase.data.ApplierEntity;
import cz.appliersdatabase.appliersdatabase.data.ApplierMapper;
import cz.appliersdatabase.appliersdatabase.data.ApplierRepository;
import cz.appliersdatabase.appliersdatabase.data.AppliersTechnologyDTO;
import cz.appliersdatabase.appliersdatabase.data.AppliersTechnologyEntity;
import cz.appliersdatabase.appliersdatabase.data.AppliersTechnologyMapper;
import cz.appliersdatabase.appliersdatabase.data.AppliersTechnologyRepository;
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
public class ApplierService{
    
    @Autowired
    private ApplierRepository applierRepository;
    
    @Autowired
    private TechnologyRepository technologyRepository;
    
    @Autowired
    private ApplierMapper applierMapper;
    
    @Autowired
    private AppliersTechnologyMapper applierTechnologyMapper;
    
    @Autowired
    private AppliersTechnologyRepository appliersTechnologyRepository;
    
    @Autowired
    private TechnologyMapper technologyMapper;
    

    
    public ApplierDTO addApplier(@RequestBody ApplierDTO applierDTO){
        ApplierEntity entity = applierMapper.toEntity(applierDTO);
        ApplierEntity savedEntity = applierRepository.save(entity);
        return applierMapper.toDTO(savedEntity);
    }
    
    public ApplierDTO updateApplier(@PathVariable Long id, @RequestBody ApplierDTO sendApplier) {
        
        ApplierEntity applier = applierRepository.findById(id).orElse(null);
        if (applier != null){
            applier.setName(sendApplier.getName());
            applier.setSurname(sendApplier.getSurname());
            applier.setTechnologyList(applierTechnologyMapper.toApplierTechnologyEntityList(sendApplier.getTechnologyList()));
            return applierMapper.toDTO(applierRepository.save(applier));
        }
        return null;
    }
    
    public String deleteApplier(@PathVariable Long id){
        ApplierEntity applierToDelete = applierRepository.findById(id).orElseThrow();
        try{
            applierRepository.delete(applierToDelete);
        }
        catch (Exception e){
            return "Something went wrong";
        }
        return "OK";
    }
    
    public ApplierDTO getApplier(@PathVariable Long id) {
        ApplierEntity applierEntity = applierRepository.findById(id).orElseThrow();
        ApplierDTO applier = applierMapper.toDTO(applierEntity);
        return applier;
    }
    
    public List<ApplierDTO> getAllAppliers(){
        List<ApplierEntity> appliersEntityList = applierRepository.findAll();
        List<ApplierDTO> appliersDTOList = new ArrayList<>();
        for (ApplierEntity entity:appliersEntityList){
            appliersDTOList.add(applierMapper.toDTO(entity));
        }
        return appliersDTOList;
    }
    
    public AppliersTechnologyDTO addTechnologyRelation(@PathVariable Long id, @RequestBody AppliersTechnologyDTO technology) {
        ApplierEntity applier = applierRepository.findById(id).orElseThrow();
        AppliersTechnologyEntity newTechnology = applierTechnologyMapper.toEntity(technology);
        TechnologyEntity tech = technologyRepository.findById(newTechnology.getTechnology().getId()).orElseThrow();
        newTechnology.setApplier(applier);
        newTechnology.setTechnology(tech);
        return applierTechnologyMapper.toDTO(appliersTechnologyRepository.save(newTechnology));
    }
    

    public AppliersTechnologyDTO updateTechnologyRelation(@PathVariable Long id, @RequestBody AppliersTechnologyDTO technology) {
        AppliersTechnologyEntity applierTechnologyEntity = appliersTechnologyRepository.findById(technology.getId()).orElse(null);
        if(applierTechnologyEntity != null){
            applierTechnologyEntity.setNote(technology.getNote());
            applierTechnologyEntity.setSkillLevel(technology.getSkillLevel());
            return applierTechnologyMapper.toDTO(appliersTechnologyRepository.save(applierTechnologyEntity));
        }
        return null;
    } 
    
    public AppliersTechnologyDTO getApplierTechnology(@PathVariable Long id) {
        AppliersTechnologyEntity applierTechnologyEntity = appliersTechnologyRepository.findById(id).orElseThrow();
        
        return applierTechnologyMapper.toDTO(applierTechnologyEntity);
    }
    
    public String deleteApplierTechnology(@PathVariable Long id) {
        AppliersTechnologyEntity applierTechnologyEntity = appliersTechnologyRepository.findById(id).orElseThrow();
        try{
            appliersTechnologyRepository.delete(applierTechnologyEntity);
        }
        catch (Exception e){
            return "Something went wrong";
        }
        return "OK";
       
    }
}

