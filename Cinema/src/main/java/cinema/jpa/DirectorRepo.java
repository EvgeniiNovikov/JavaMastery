package cinema.jpa;

import cinema.jpa.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DirectorRepo extends JpaRepository<Director, Long>
{
}
