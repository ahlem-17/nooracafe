package noora.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import noora.demo.Entity.Maker;
import noora.demo.Repository.MakerRepository;

@Service
public class MakerService {
    @Autowired MakerRepository makerRepository;
    
    public List<Maker> listAllMaker() {
        return makerRepository.findAll();
    }
    
    public void addMaker(Maker maker) {
        makerRepository.save(maker);
    }

    public void removeMakerById(Long id) {
        makerRepository.deleteById(id);
    }

    public Optional<Maker> getMakerById(Long id) {
        return makerRepository.findById(id);
    }
}
