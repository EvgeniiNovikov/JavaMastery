package cinema.controllers;

import cinema.jpa.models.Director;
import cinema.jpa.models.Film;
import cinema.servises.DirectorService;
import cinema.servises.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FilmController {

    @Autowired
    private DirectorService directorService;

    @Autowired
    private FilmService filmService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(Model model) {
        model.addAttribute("director", directorService.getAll());
        return "start";
    }


    @RequestMapping(value = "/films/all", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Director> all = directorService.getAll();
        model.addAttribute("users", all);

        return "allFilms";
    }


    @RequestMapping(value = "/filmsById&Date", method = RequestMethod.GET)
    public String form_test() {
        return "form_test";
    }


    @RequestMapping(value = "/filmsByIdOrDate", method = RequestMethod.GET)
    public String getFilms() {
        return "forms";
    }


    @RequestMapping(value = "/filmsById/{id}", method = RequestMethod.GET)
    public String getDirector(Model model, @PathVariable @RequestParam("id") String id) {
        if (id == null || id.isEmpty()) {
            model.addAttribute("id", "ID can't be empty!");
        } else if (directorService.check(id)) {
            List<Director> dir = directorService.findById(Integer.parseInt(id));
            model.addAttribute("director", dir);
        } else {
            model.addAttribute("id", "Incorrect data");
        }

        return "forms";
    }


    @RequestMapping(value = "/filmsByDate/{date}", method = RequestMethod.GET)
    public String getFilmByDate(Model model, @PathVariable @RequestParam("date") String date) {
        if (date == null || date.isEmpty()) {
            model.addAttribute("info", "Incorrect data");
        } else {
            String result = filmService.parseStringDate(date);
            List<Film> films = filmService.findByDate(result);
            model.addAttribute("films", films);
            model.addAttribute("date", date);
        }

        return "forms";
    }


    @RequestMapping(value = "/filmsByIdAndDate/{id}{date}", method = RequestMethod.GET)
    public String findByDateAndId(@PathVariable @RequestParam("date") String date,
                                  @PathVariable @RequestParam("id") String id,
                                  Model model) {
        if (date == null || date.isEmpty() || id == null || id.isEmpty()) {
            model.addAttribute("info", "Field's can't be empty!");
        } else if (directorService.check(id)) {
            String result = filmService.parseStringDate(date);
            List<Film> films = filmService.findFilmsByIdAndDate(Integer.parseInt(id), result);
            model.addAttribute("films", films);
        } else {
           model.addAttribute("info", "Incorrect data");
        }

        return "form_test";
    }

}
