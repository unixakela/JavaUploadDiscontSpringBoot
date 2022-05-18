package lex.JavaUploadDiscontSpringBoot.repository;



import lex.JavaUploadDiscontSpringBoot.entity.Trm_in_card_client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Trm_in_card_clientRepository extends JpaRepository<Trm_in_card_client,Long> {
    /*@Query("select t from Trm_in_card_client t where t.card = ?1")
    Optional<Trm_in_card_client> findByCard(Long card);*/



}
