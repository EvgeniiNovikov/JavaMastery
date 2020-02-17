package cinema.jpa.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "director")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    private Date birth_date;

    @OneToMany(mappedBy = "director", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "films")
    private List<Film> films;

    public Director() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "First name: " + this.first_name +
                ", Last name: " + this.last_name + ", Birth date: " + this.birth_date;
    }
}
