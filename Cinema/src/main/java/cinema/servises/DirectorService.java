package cinema.servises;

import cinema.jpa.DirectorRepo;
import cinema.jpa.models.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepo directorRepo;

    public List<Director> getAll() {
        return directorRepo.findAll();
    }

    public List<Director> findById(Integer id) {
        return directorRepo.findDirectorById(id);
    }

    public boolean check(String data) {
        try {
            Integer.parseInt(data);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
