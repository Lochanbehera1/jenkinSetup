package com.lochanit.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "com_tbl")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "com_id_col")
    private Long id;
    @Column(name = "com_name_col")
    private String name;
    @Column(name = "com_des_col")
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Job> jobs;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;
}
