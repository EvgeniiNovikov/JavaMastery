package cinema.servises;

import cinema.jpa.FilmRepo;
import cinema.jpa.models.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepo filmRepo;


    public List<Film> getAll() {
        return filmRepo.findAll();
    }

    public Film findById(Long id) {
        return filmRepo.findById(id).orElse(null);
    }

    public List<Film> findByDate(Date from, Date to) {
        return filmRepo.findByDate(from, to);
    }

    public List<Film> findByDirectorAndDate(Long id, Date from, Date to) {
        return filmRepo.findByDirectorAndDate(id, from, to);
    }
}
