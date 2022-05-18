package lex.JavaUploadDiscontSpringBoot.repository;


import lex.JavaUploadDiscontSpringBoot.entity.Trm_in_cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Trm_in_cardsRepository extends JpaRepository<Trm_in_cards,Long> {
    @Query("select t from Trm_in_cards t where t.start_card_code = ?1")
    Optional<Trm_in_cards> findByStart_card_code(String start_card_code);



    @Query("select " +
            "t " +
            "from Trm_in_cards as t " +
            "where LENGTH(t.start_card_code) = 11 " +
            "AND LOCATE('89',t.start_card_code) = 1")
    List<Trm_in_cards> findAllPhone();
}
