package cinema.dao;

import cinema.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmRepo extends JpaRepository<Film, Long> {

    @Query("select f from Film f where f.release_date > '0' and f.release_date <= ?1")
    List<Film> findByDate(String date);

    @Query("select f from Film f where f.director.id = ?1 and f.release_date > '0' and f.release_date <= ?2")
    List<Film> findByIdAndDate(Integer id, String date);
}
