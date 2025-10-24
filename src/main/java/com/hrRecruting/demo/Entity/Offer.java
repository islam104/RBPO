package com.hrRecruting.demo.Entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Offer {
    private Long id;
    private Application application;
    private Double salary;
    private String position;
    private String status;
    private LocalDateTime createdAt;

    public Offer() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Application getApplication() { return application; }
    public void setApplication(Application application) { this.application = application; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}