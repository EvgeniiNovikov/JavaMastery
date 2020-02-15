package cinema.servises;

import cinema.dao.DirectorRepo;
import cinema.dao.FilmRepo;
import cinema.models.Director;
import cinema.models.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    @Autowired
    private DirectorRepo directorRepo;

    @Autowired
    private FilmRepo filmRepo;


    public List<Film> findByDate(String date) {
        return filmRepo.findByDate(date);
    }

    public List<Film> findFilmsByIdAndDate(Integer id, String date) {
        return filmRepo.findByIdAndDate(id, date);
    }

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
