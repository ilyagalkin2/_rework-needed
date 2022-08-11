package ru.company01.ilyagalkin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.company01.ilyagalkin.model.Homies;

import java.util.List;
import java.util.Optional;


public interface HomiesRepository extends JpaRepository<Homies, Integer> {
    List<Homies> findByNameContaining(String name);

//    @Query("select u from User u where u.name like concat('%', ?1, '%')")
//    List<User> findByNameContaining(String name);

    Optional<Homies> findByNameLikeIgnoreCase(String name);



//    @Query("select u from User u where upper(u.name) like upper(:name)")
//    Optional<Homies> findByNameLikeIgnoreCase_same(@Param("name") String name);

    //same but extracted via JPA Inspector panel
//    @Query("select u from User u where upper(u.name) like upper(?1)")
//    Optional<User> findByNameLikeIgnoreCase_anyNameCanBeGiven(String name);

}
