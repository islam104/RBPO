package com.hrRecruting.demo.Controller;

import com.hrRecruting.demo.Entity.Vacancy;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vacancy")
public class VacancyController {
    private List<Vacancy> vacancies = new ArrayList<>();

    @PostMapping("/create")
    public Vacancy createVacancy (@RequestBody Vacancy vacancy) {
        vacancy.setCreatedAt(LocalDateTime.now());
        vacancies.add(vacancy);
        return vacancy;
    }

    @GetMapping("/getAll")
    public List<Vacancy> getAllVacancies() {
        return vacancies;
    }

    @GetMapping("/getById/{id}")
    public Vacancy getById(@PathVariable Long id) {
        for (Vacancy vacancy : vacancies) {
            if (id.equals(vacancy.getId())) {
                return vacancy;
            }
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteVacancy (@PathVariable Long id) {
    vacancies.removeIf(v -> v.getId().equals(id));
    return "Удален";
    }

    @PutMapping("/put/{id}")
    public Vacancy putVacancy (@PathVariable Long id,@RequestBody Vacancy vacancy){
        for (int i = 0; i < vacancies.size(); i++) {
            if (vacancies.get(i).getId().equals(id)) {
                vacancy.setId(id);
                vacancy.setTitle(vacancy.getTitle());
                vacancy.setDescription(vacancy.getDescription());
                vacancy.setStatus(vacancy.getStatus());
                vacancy.setCreatedAt(vacancy.getCreatedAt());
                return vacancy;
            }
        }
        return null;
    }
    }
