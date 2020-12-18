package biz.nable.sampath.oc.services;


import org.springframework.beans.factory.annotation.Autowired;

import biz.nable.sampath.oc.db.entity.EpfEtfRequest;
import biz.nable.sampath.oc.db.repositories.EpfEtfRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public interface EpfEtfRequestService {
	
	
	EpfEtfRequest addEpfEtfRequest(EpfEtfRequest epfEtfRequest);
	

}
