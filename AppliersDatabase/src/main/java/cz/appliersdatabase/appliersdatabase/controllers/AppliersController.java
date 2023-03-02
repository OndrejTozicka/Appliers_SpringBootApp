
package cz.appliersdatabase.appliersdatabase.controllers;

import cz.appliersdatabase.appliersdatabase.data.ApplierDTO;
import cz.appliersdatabase.appliersdatabase.data.AppliersTechnologyDTO;
import cz.appliersdatabase.appliersdatabase.services.ApplierService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tozicka Ondrej
 */

//Controler of /appliers APIs containing mapping of APIs
@RestController
@RequestMapping("/appliers")
public class AppliersController {
    
    @Autowired
    private ApplierService applierService;
    
   
    @PostMapping
    public ApplierDTO addAplier(@RequestBody ApplierDTO applierDTO){
        return applierService.addApplier(applierDTO);
    }
    
    @PutMapping("/{id}")
    public ApplierDTO updateApplier(@PathVariable Long id, @RequestBody ApplierDTO sendApplier) {
        return applierService.updateApplier(id, sendApplier);
    }
        
    @DeleteMapping("/{id}")
    public String deleteApplier(@PathVariable Long id){
        return applierService.deleteApplier(id);
    }
    
    @GetMapping("/{id}")
    public ApplierDTO getApplier(@PathVariable Long id) {
        return applierService.getApplier(id);
    }
    
    @GetMapping
    public List<ApplierDTO> getAllApplier() {
        return applierService.getAllAppliers();
    }
    
   
    @PostMapping("/{id}/technologies")
    public AppliersTechnologyDTO addTechnology(@PathVariable Long id, @RequestBody AppliersTechnologyDTO technology) {
        return applierService.addTechnologyRelation(id, technology);
    }
    
    
    @PutMapping("/id/technologies/{technologyId}")
    public AppliersTechnologyDTO updateTechnology(@PathVariable Long technologyId, @RequestBody AppliersTechnologyDTO appliersTechnologyDTO) {
        return applierService.updateTechnologyRelation(technologyId,appliersTechnologyDTO);
    }
    
    @GetMapping("/id/technologies/{technologyId}")
    public AppliersTechnologyDTO getApplierTechnology(@PathVariable Long technologyId) {
        return applierService.getApplierTechnology(technologyId);
    }
    
    @DeleteMapping("/id/technologies/{technologyId}")
    public String deleteApplierTechnology(@PathVariable Long technologyId) {
        return applierService.deleteApplierTechnology(technologyId);
    }
}

