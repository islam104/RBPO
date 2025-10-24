package com.hrRecruting.demo.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrRecruting.demo.Entity.Candidate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    private List<Candidate> candidates = new ArrayList<>();
    @PostMapping
    public Candidate createCandidate(@RequestBody Candidate candidate) {
        candidates.add(candidate);
        return candidate;
    }

    @GetMapping
    public List<Candidate> getAllCandidates() {
        return candidates;
    }

    @GetMapping("/{id}")
    public Candidate getCandidate(@PathVariable Long id) {
        for (Candidate candidate : candidates) {
            if (candidate.getId().equals(id)) {
                return candidate;
            }
        }
        return null;
    }

    @PutMapping("/{id}")
    public Candidate updateCandidate(@PathVariable Long id, @RequestBody Candidate candidate) {
        for (int i = 0; i < candidates.size(); i++) {
            if (candidates.get(i).getId().equals(id)) {
                candidate.setId(id);
                candidates.set(i, candidate);
                return candidate;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCandidate(@PathVariable Long id) {
        candidates.removeIf(c -> c.getId().equals(id));
    }
}
