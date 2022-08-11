package ru.company01.ilyagalkin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.company01.ilyagalkin.model.Homies;
import ru.company01.ilyagalkin.repository.HomiesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HomiesController {

    @Autowired
    HomiesRepository homiesRepository;

    @GetMapping("/homies")
    public ResponseEntity<List<Homies>> getAllHomies(@RequestParam(required = false) String title) {

        try {

            List<Homies> homies = new ArrayList<>();

            if (title == null) {
                homies.addAll(homiesRepository.findAll());
            } else {
                homies.addAll(homiesRepository.findByNameContaining(title));
                var example = new Homies();
                example.setName(title);
                homies.addAll(homiesRepository.findAll(Example.of(example)));
            }

            if (homies.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(homies, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/homies/{id}")
    public ResponseEntity<Homies> getUserById(@PathVariable("id") int id) {
        Optional<Homies> userData = homiesRepository.findById(id);

        return userData.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/homies")
    public ResponseEntity<Homies> createAHomie(@RequestBody Homies homies) {
        try {
            Homies _homies = homiesRepository.save(homies);
            return new ResponseEntity<>(_homies, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/homies/{id}")
    public ResponseEntity<Homies> updateAHomie(@PathVariable("id") int id, @RequestBody Homies homies) {
        Optional<Homies> homiesData = homiesRepository.findById(id);

        if (homiesData.isPresent()) {
            Homies _homies = homiesData.get();
            _homies.setName(homies.getName());
            return new ResponseEntity<>(homiesRepository.save(_homies), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/homies/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id) {
        try {
            homiesRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/homies")
    public ResponseEntity<HttpStatus> deleteAllUsers() {
        try {
            homiesRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}




//GET http://localhost:8080/api/users

//[
//    {
//        "id": 1,
//        "name": "User1",
//        "contacts": [
//            {
//                "id": 2,
//                "contactName": "Second",
//                "phone": "+7 9** *** ***2",
//                "email": "user2@gmail.com"
//            },
//            {
//                "id": 1,
//                "contactName": "First",
//                "phone": "+7 9** *** ***1",
//                "email": "user01@gmail.com"
//            }
//        ]
//    },
//    {
//        "id": 2,
//        "name": "User2",
//        "contacts": []
//    },
//    {
//        "id": 3,
//        "name": "User3",
//        "contacts": [
//            {
//                "id": 3,
//                "contactName": "Main",
//                "phone": "+7 9** *** ***3",
//                "email": "user03@gmail.com"
//            }
//        ]
//    }
//]







//in console

//2022-08-09 10:36:55.991 DEBUG 12020 --- [nio-8080-exec-1] org.hibernate.SQL                        :
//    select
//        user0_.id as id1_1_,
//        user0_.name as name2_1_
//    from
//        "Users" user0_
//Hibernate:
//    select
//        user0_.id as id1_1_,
//        user0_.name as name2_1_
//    from
//        "Users" user0_
//2022-08-09 10:36:56.409 DEBUG 12020 --- [nio-8080-exec-1] org.hibernate.SQL                        :
//    select
//        contacts0_."customerId" as customer5_0_0_,
//        contacts0_.id as id1_0_0_,
//        contacts0_.id as id1_0_1_,
//        contacts0_."contactName" as contactn2_0_1_,
//        contacts0_.email as email3_0_1_,
//        contacts0_.phone as phone4_0_1_,
//        contacts0_."customerId" as customer5_0_1_
//    from
//        "Contacts" contacts0_
//    where
//        contacts0_."customerId"=?
//Hibernate:
//    select
//        contacts0_."customerId" as customer5_0_0_,
//        contacts0_.id as id1_0_0_,
//        contacts0_.id as id1_0_1_,
//        contacts0_."contactName" as contactn2_0_1_,
//        contacts0_.email as email3_0_1_,
//        contacts0_.phone as phone4_0_1_,
//        contacts0_."customerId" as customer5_0_1_
//    from
//        "Contacts" contacts0_
//    where
//        contacts0_."customerId"=?
//2022-08-09 10:36:56.493 DEBUG 12020 --- [nio-8080-exec-1] org.hibernate.SQL                        :
//    select
//        contacts0_."customerId" as customer5_0_0_,
//        contacts0_.id as id1_0_0_,
//        contacts0_.id as id1_0_1_,
//        contacts0_."contactName" as contactn2_0_1_,
//        contacts0_.email as email3_0_1_,
//        contacts0_.phone as phone4_0_1_,
//        contacts0_."customerId" as customer5_0_1_
//    from
//        "Contacts" contacts0_
//    where
//        contacts0_."customerId"=?
//Hibernate:
//    select
//        contacts0_."customerId" as customer5_0_0_,
//        contacts0_.id as id1_0_0_,
//        contacts0_.id as id1_0_1_,
//        contacts0_."contactName" as contactn2_0_1_,
//        contacts0_.email as email3_0_1_,
//        contacts0_.phone as phone4_0_1_,
//        contacts0_."customerId" as customer5_0_1_
//    from
//        "Contacts" contacts0_
//    where
//        contacts0_."customerId"=?
//2022-08-09 10:36:56.498 DEBUG 12020 --- [nio-8080-exec-1] org.hibernate.SQL                        :
//    select
//        contacts0_."customerId" as customer5_0_0_,
//        contacts0_.id as id1_0_0_,
//        contacts0_.id as id1_0_1_,
//        contacts0_."contactName" as contactn2_0_1_,
//        contacts0_.email as email3_0_1_,
//        contacts0_.phone as phone4_0_1_,
//        contacts0_."customerId" as customer5_0_1_
//    from
//        "Contacts" contacts0_
//    where
//        contacts0_."customerId"=?
//Hibernate:
//    select
//        contacts0_."customerId" as customer5_0_0_,
//        contacts0_.id as id1_0_0_,
//        contacts0_.id as id1_0_1_,
//        contacts0_."contactName" as contactn2_0_1_,
//        contacts0_.email as email3_0_1_,
//        contacts0_.phone as phone4_0_1_,
//        contacts0_."customerId" as customer5_0_1_
//    from
//        "Contacts" contacts0_
//    where
//        contacts0_."customerId"=?


















//GET http://localhost:8080/api/users?title=User1

//[
//    {
//        "id": 1,
//        "name": "User1",
//        "contacts": [
//            {
//                "id": 2,
//                "contactName": "Second",
//                "phone": "+7 9** *** ***2",
//                "email": "user2@gmail.com"
//            },
//            {
//                "id": 1,
//                "contactName": "First",
//                "phone": "+7 9** *** ***1",
//                "email": "user01@gmail.com"
//            }
//        ]
//    }
//]