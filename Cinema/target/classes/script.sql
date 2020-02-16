#PostgreSQL
create database Cinema;

drop table if exists director cascade;
drop table if exists film cascade;
create table director (id  serial not null, birth_date timestamp, first_name varchar(255), last_name varchar(255), primary key (id));
create table film (id  serial not null, genre varchar(255), name varchar(255), release_date timestamp, director_id int, primary key (id));
alter table film add constraint film_director foreign key (director_id) references director(id);

INSERT INTO director(
    id, birth_date, first_name, last_name)
VALUES 	    (1, 'December 18, 1946', 'Steven', 'Spielberg'),
            (2, 'August 16, 1954', 'James', 'Cameron'),
            (3, '19770707', 'unknown', 'unknown'),
            (4, '19920505', 'Sad director', 'unknown'),
            (5, 'March 27, 1963', 'Quentin', 'Tarantino');

INSERT INTO film(
    id, genre, name, release_date, director_id)
VALUES 	      (1, 'Action', 'Jurassic Park', '19930101', 1),
              (2, 'Action, War', 'Saving Private Ryan', '19980101', 1),
              (3, 'Adventure', 'Indiana Jones and the Last Crusade', '19890101', 1),
              (4, 'Action', 'The Terminator', '19840101', 2),
              (5, 'Action, Science fiction', 'Aliens', '19860101', 2),
              (6, 'Drama, Romance', 'Titanic', '19970101', 2),
              (7, 'Some genre', 'Some name', '20100101', 4),
              (8, 'Action', 'Kill Bill: Volume 1', '20030101', 5),
              (9, 'Action', 'Kill Bill: Volume 2', '20030101', 5);