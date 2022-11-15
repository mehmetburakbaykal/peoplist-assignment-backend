package com.peoplist.talensourcingsystem.repository;

import com.peoplist.talensourcingsystem.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Integer> {
}
