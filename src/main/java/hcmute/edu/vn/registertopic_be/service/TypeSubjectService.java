package hcmute.edu.vn.registertopic_be.service;

import hcmute.edu.vn.registertopic_be.model.entity.TypeSubject;
import hcmute.edu.vn.registertopic_be.model.mapper.TypeSubjectMapper;
import hcmute.edu.vn.registertopic_be.model.request.TypeSubjectRequest;
import hcmute.edu.vn.registertopic_be.repository.TypeSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeSubjectService {
    @Autowired
    private TypeSubjectRepository typeSubjectRepository;
    @Autowired
    private TypeSubjectMapper typeSubjectMapper;

    public List<TypeSubject> findAll(){
        return typeSubjectRepository.getAllTypeSubject();
    }
    public TypeSubject createTypeSubject(TypeSubjectRequest typeSubjectRequest){
        var typeSubject = typeSubjectMapper.toEntity(typeSubjectRequest);
        return typeSubjectRepository.save(typeSubject);
    }
    public TypeSubject editTypeSubject(TypeSubject typeSubject){
        return typeSubjectRepository.save(typeSubject);
    }
}
