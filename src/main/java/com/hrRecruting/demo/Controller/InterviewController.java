package com.hrRecruting.demo.Controller;

import com.hrRecruting.demo.Entity.Interview;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/interviews")
public class InterviewController {
    private List<Interview> interviews = new ArrayList<>();

    @PostMapping
    public Interview scheduleInterview(@RequestBody Interview interview) {
        boolean slotAvailable = true;

        for (Interview i : interviews) {
            if (i.getInterviewer().equals(interview.getInterviewer()) &&
                    i.getInterviewDate().equals(interview.getInterviewDate())) {
                slotAvailable = false;
                break;
            }
        }

        if (!slotAvailable) {
            throw new RuntimeException("Interview slot not available for this interviewer");
        }

        // Устанавливаем ID и статус, добавляем в список
        interview.setStatus("SCHEDULED");
        interviews.add(interview);
        return interview;
    }

    @GetMapping
    public List<Interview> getAllInterviews() {
        return interviews;
    }

    @GetMapping("/{id}")
    public Interview getInterview(@PathVariable Long id) {
        for (Interview interview : interviews) {
            if (interview.getId().equals(id)) {
                return interview;
            }
        }
        return null;
    }

    @PutMapping("/{id}")
    public Interview updateInterview(@PathVariable Long id, @RequestBody Interview interview) {
        for (int i = 0; i < interviews.size(); i++) {
            if (interviews.get(i).getId().equals(id)) {
                interview.setId(id);
                interviews.set(i, interview);
                return interview;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void cancelInterview(@PathVariable Long id) {
        interviews.removeIf(i -> i.getId().equals(id));
    }

    @PutMapping("/{id}/feedback")
    public Interview addFeedback(@PathVariable Long id, @RequestParam String feedback) {
        Interview interview = getInterview(id);
        if (interview != null) {
            interview.setFeedback(feedback);
            interview.setStatus("COMPLETED");
        }
        return interview;
    }
}

