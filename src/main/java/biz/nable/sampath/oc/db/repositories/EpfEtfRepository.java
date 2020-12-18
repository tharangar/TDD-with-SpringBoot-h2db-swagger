package biz.nable.sampath.oc.db.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import biz.nable.sampath.oc.db.entity.EpfEtfRequest;

//@Repository
//@RepositoryRestResource
public interface EpfEtfRepository extends CrudRepository<EpfEtfRequest, Integer>{

	boolean existsByFromAccount(String account);

	List<EpfEtfRequest> findByCompanyId(String companyId);

}
