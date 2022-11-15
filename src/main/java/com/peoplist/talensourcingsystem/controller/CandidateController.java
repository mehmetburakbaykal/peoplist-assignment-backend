package com.peoplist.talensourcingsystem.controller;

import com.peoplist.talensourcingsystem.model.Candidate;
import com.peoplist.talensourcingsystem.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
@CrossOrigin
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @PostMapping("/add")
    public String add(@RequestBody Candidate candidate){
        candidateService.saveCandidate(candidate);
        return "New candidate is added";
    }

    @GetMapping("/getAllCandidates")
    public List<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Boolean> deleteCandidate (@PathVariable("id") Long id)
    {
        Boolean status = candidateService.deleteCandidate(id);
        return ResponseEntity.ok(status);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Candidate> updateCandidate(@PathVariable("id") Long id,@RequestBody Candidate candidate)
    {
        Candidate resultCandidate = candidateService.updateCandidate(id,candidate);
        return ResponseEntity.ok(resultCandidate);
    }
}
