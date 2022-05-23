package noora.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import noora.demo.Entity.Departement;
import noora.demo.Repository.DepartementRepository;

@Service
public class DepartementService {
    
    @Autowired
     DepartementRepository departementRepository;

    public List<Departement> listAllDepartement() {
        return departementRepository.findAll();
    }
    public void addDepartement(Departement departement) {
        departementRepository.save(departement);
    }
    public void removeDepartemet(Long id) {
        departementRepository.deleteById(id);
    }
    public Optional<Departement> getDepartementById(Long id) {
        return departementRepository.findById(id);
    }
  
}
