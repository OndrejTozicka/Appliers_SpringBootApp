
package cz.appliersdatabase.appliersdatabase.controllers;

import cz.appliersdatabase.appliersdatabase.data.TechnologyDTO;
import cz.appliersdatabase.appliersdatabase.services.TechnologyService;
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
@RestController
@RequestMapping("/technologies")
public class TechnologyController {
    
    @Autowired
    private TechnologyService technologyService;
    
    
    @GetMapping("/{id}")
    public TechnologyDTO getTechnology(@PathVariable Long id){
        return technologyService.getTechnology(id);
    }
    
   
    @GetMapping
    public List<TechnologyDTO> getAllTechnology(){
        return technologyService.getAllTechnology();
    }

    @PostMapping
    public TechnologyDTO addTechnology(@RequestBody TechnologyDTO technologyDTO){
        return technologyService.addTechnology(technologyDTO);
    }
    
    @PutMapping("/{id}")
    public TechnologyDTO updateTechnology(@PathVariable Long id,@RequestBody TechnologyDTO sendTechnology){
        return technologyService.updateTechnology(id, sendTechnology);
    }

    @DeleteMapping("/{id}")
    public String deleteTechnology(@PathVariable Long id){
        return technologyService.deleteTechnology(id);
    }
}
