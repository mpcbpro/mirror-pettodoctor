package com.ssafy.pettodoctor.api.repository;

import com.ssafy.pettodoctor.api.domain.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DoctorRepository {
    private final EntityManager em;

    public List<Doctor> findByHospitalId(Long id){
        return em.createQuery("select d from Doctor d join d.hospital h where h.id = :id"
                , Doctor.class)
                .setParameter("id", id)
                .getResultList();
    }

    public Doctor findById(Long id){
        return em.find(Doctor.class, id);
    }
}
