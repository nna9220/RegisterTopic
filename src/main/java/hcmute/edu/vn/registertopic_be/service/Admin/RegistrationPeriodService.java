package hcmute.edu.vn.registertopic_be.service.Admin;

import hcmute.edu.vn.registertopic_be.model.entity.RegistrationPeriod;
import hcmute.edu.vn.registertopic_be.model.mapper.RegistrationPeriodMapper;
import hcmute.edu.vn.registertopic_be.model.request.RegistrationPeriodRequest;
import hcmute.edu.vn.registertopic_be.repository.RegistrationPeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationPeriodService {
    @Autowired
    private RegistrationPeriodRepository registrationPeriodRepository;
    @Autowired
    private RegistrationPeriodMapper registrationPeriodMapper;

    public List<RegistrationPeriod> findAll(){
        return registrationPeriodRepository.findAllPeriod();
    }

    public RegistrationPeriod createPeriod(RegistrationPeriodRequest registrationPeriodRequest){
        var period = registrationPeriodMapper.toEntity(registrationPeriodRequest);
        return registrationPeriodRepository.save(period);
    }
    public RegistrationPeriod editPeriod(RegistrationPeriod registrationPeriodRequest){
        return registrationPeriodRepository.save(registrationPeriodRequest);
    }

}
