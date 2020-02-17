package cinema.controllers;

import cinema.jpa.models.Director;
import cinema.servises.DirectorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Objects;

@Slf4j
@Controller
@RequestMapping("/directors")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @RequestMapping(method = RequestMethod.GET)
    public String getDirectors(Model model) {
        List<Director> directors = directorService.getAll();
        model.addAttribute("directors", directors);
        return "start";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getDirector(@PathVariable Long id, Model model) {
        Director director = directorService.findById(id);
        if (Objects.isNull(director)) {
            log.error("Director not found. ID: {}", id);
//            throw new IllegalArgumentException("Director with received ID not found");
        }
        model.addAttribute("director", director);
        return "director";
    }
}
