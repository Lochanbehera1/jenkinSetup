package com.lochanit.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "job_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id_col")
    private  Long id;
    @Column(name = "job_tit_col")
    private String title;
    @Column(name = "job_des_col")
    private String description;
    @Column(name = "job_minSal_col")
    private String minSalary;
    @Column(name = "job_maxSal_col")
    private String maxSalary;
    @Column(name = "job_loc_col")
    private String location;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "com_id_col", referencedColumnName = "com_id_col")
    private Company company;

}
