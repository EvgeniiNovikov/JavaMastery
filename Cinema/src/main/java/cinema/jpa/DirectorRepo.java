package cinema.jpa;

import cinema.jpa.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectorRepo extends JpaRepository<Director, Integer>
{
    List<Director> findDirectorById(Integer id);
}
