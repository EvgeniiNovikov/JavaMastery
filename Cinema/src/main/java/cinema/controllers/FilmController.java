package cinema.controllers;

import cinema.models.Director;
import cinema.models.Film;
import cinema.servises.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FilmController {

    @Autowired
    private DataService dataService;

    @GetMapping("/")
    public String start(Model model) {
        model.addAttribute("director", dataService.getAll());
        return "start";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        List<Director> all = dataService.getAll();
        model.addAttribute("users", all);

        return "allFilms";
    }

    @GetMapping("/form_test")
    public String form_test() {
        return "form_test";
    }

    @GetMapping("/forms")
    public String getFilms() {
        return "forms";
    }

    @PostMapping("/filmsById")
    public String getDirector(Model model, @RequestParam("id") String id) {
        if (id == null || id.isEmpty()) {
            model.addAttribute("id", "ID can't be empty!");
        } else if (dataService.check(id)) {
            List<Director> dir = dataService.findById(Integer.parseInt(id));
            model.addAttribute("director", dir);
        } else {
            model.addAttribute("id", "Incorrect data");
        }

        return "forms";
    }

    @PostMapping("/filmsByDate")
    public String getFilmByDate(Model model, @RequestParam("date") String date) {
        if (date == null || date.isEmpty()) {
            model.addAttribute("info", "Date can't be empty!");
        } else if(dataService.check(date)) {
            List<Film> films = dataService.findByDate(date);
            model.addAttribute("films", films);
            model.addAttribute("date", date);
        } else {
            model.addAttribute("info", "Incorrect data");
        }

        return "forms";
    }

    @PostMapping("/filmsByIdAndDate")
    public String findByDateAndId(@RequestParam("date") String date, @RequestParam("id") String id, Model model) {
        if (date == null || date.isEmpty() || id == null || id.isEmpty()) {
            model.addAttribute("info", "Field's can't be empty!");
        } else if (dataService.check(id) && dataService.check(date)) {
            List<Film> films = dataService.findFilmsByIdAndDate(Integer.parseInt(id), date);
            model.addAttribute("films", films);
        } else {
           model.addAttribute("info", "Incorrect data");
        }

        return "form_test";
    }

}
