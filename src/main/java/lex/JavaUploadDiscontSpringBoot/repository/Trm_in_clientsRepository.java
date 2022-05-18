package lex.JavaUploadDiscontSpringBoot.repository;


import lex.JavaUploadDiscontSpringBoot.entity.Trm_in_clients;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Trm_in_clientsRepository extends CrudRepository<Trm_in_clients,String> {
}
