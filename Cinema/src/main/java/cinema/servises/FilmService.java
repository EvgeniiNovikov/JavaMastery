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

//    public List<Film> findByDate(String date) {
//        return filmRepo.findByDate(parseDate(date));
//    }
//
//    public List<Film> findFilmsByIdAndDate(Integer id, String date) {
//        return filmRepo.findByIdAndDate(id, parseDate(date));
//    }

//    public String parseStringDate(String s) {
//        return s.replaceAll("-", "");
//    }


//    public Date parseDate(String date) {
//        DateFormat dateFormat;
//        Date result = null;
//        try {
//            dateFormat = new SimpleDateFormat("yyyyMMdd");
//            result = dateFormat.parse(date);
//        } catch (ParseException e) {
//        }
//        return result;
//    }


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
