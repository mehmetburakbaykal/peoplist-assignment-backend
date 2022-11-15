package com.peoplist.talensourcingsystem.service;

import com.peoplist.talensourcingsystem.model.Candidate;

import java.util.List;

public interface CandidateService {
    public Candidate saveCandidate(Candidate candidate);
    public List<Candidate> getAllCandidates();

    public Boolean deleteCandidate(Long id);

    Candidate updateCandidate(Long id, Candidate candidate);
}
