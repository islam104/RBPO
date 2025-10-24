package com.hrRecruting.demo.Entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Data
public class Candidate {
    private Long id;
    private String name;
    private String phone;

    public Candidate() {}

    public Candidate(Long id, String name, String email, String phone, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
