package biz.nable.sampath.oc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biz.nable.sampath.oc.db.entity.EpfEtfRequest;
import biz.nable.sampath.oc.db.repositories.EpfEtfRepository;


@Service
public class EpfEtfRequestServiceImpl implements EpfEtfRequestService {
	

@Autowired
EpfEtfRepository epfEtfRequestRepository;

	@Override
	public EpfEtfRequest addEpfEtfRequest(EpfEtfRequest epfEtfRequest) {
		
		return epfEtfRequestRepository.save(epfEtfRequest);
		
	}
	
	

}
