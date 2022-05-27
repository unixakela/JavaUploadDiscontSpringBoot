package lex.JavaUploadDiscontSpringBoot.repository;


import lex.JavaUploadDiscontSpringBoot.entity.Trm_in_clients;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Trm_in_clientsRepository extends CrudRepository<Trm_in_clients,String> {
    @Query("select t from Trm_in_clients t where t.classifclient = ?1")
    Iterable<Trm_in_clients> findAllByClassifclient(Long classifclient);

}
