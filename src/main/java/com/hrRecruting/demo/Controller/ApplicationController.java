package com.hrRecruting.demo.Controller;

import com.hrRecruting.demo.Entity.Application;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
    private List<Application> applications = new ArrayList<>();

    @PostMapping("/create")
    public Application createApplication(@RequestBody Application application) {
        if (application.getCandidate() == null || application.getVacancy() == null) {
            throw new RuntimeException("Candidate and Vacancy are required");
        }

        application.setAppliedAt(LocalDateTime.now());
        application.setStatus("NEW");
        applications.add(application);
        return application;
    }

    @GetMapping("/getAll")
    public List<Application> getAllApplications() {
        return applications;
    }

    @GetMapping("/{id}")
    public Application getApplication(@PathVariable Long id) {
        for (Application application : applications) {
            if (application.getId().equals(id)) {
                return application;
            }
        }
        return null;
    }

    @PutMapping("/{id}")
    public Application updateApplication(@PathVariable Long id, @RequestBody Application application) {
        for (int i = 0; i < applications.size(); i++) {
            if (applications.get(i).getId().equals(id)) {
                application.setId(id);
                applications.set(i, application);
                return application;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable Long id) {
        applications.removeIf(a -> a.getId().equals(id));
    }
}