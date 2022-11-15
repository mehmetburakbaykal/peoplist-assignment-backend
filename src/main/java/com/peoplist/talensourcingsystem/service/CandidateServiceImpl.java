package com.peoplist.talensourcingsystem.service;

import com.peoplist.talensourcingsystem.model.Candidate;
import com.peoplist.talensourcingsystem.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService{

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public Candidate saveCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    @Override
    public Boolean deleteCandidate(Long id) {
        Optional<Candidate> candidate = candidateRepository.findById(Math.toIntExact(id));

        if(candidate.isPresent()) {
            candidateRepository.deleteById(Math.toIntExact(id));
            return true;
        }
        return false;
    }

    @Override
    public Candidate updateCandidate(Long id, Candidate candidate) {
        Optional<Candidate> resultCandidate = candidateRepository.findById(Math.toIntExact(id));

        if(resultCandidate.isPresent()) {
            resultCandidate.get().setEmail(candidate.getEmail());
            resultCandidate.get().setFullName(candidate.getFullName());
            resultCandidate.get().setStatus(candidate.getStatus());
            resultCandidate.get().setInteractions(candidate.getInteractions());
            resultCandidate.get().setPhone(candidate.getPhone());
            return candidateRepository.save(resultCandidate.get());
        }
        return null;
    }
}
