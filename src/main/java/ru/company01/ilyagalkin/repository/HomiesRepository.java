package ru.company01.ilyagalkin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.company01.ilyagalkin.model.Homies;

import java.util.List;
import java.util.Optional;


public interface HomiesRepository extends JpaRepository<Homies, Integer> {
    List<Homies> findByNameContaining(String name);

    Optional<Homies> findByNameLikeIgnoreCase(String name);

}
