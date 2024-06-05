package com.lochanit.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "rev_tbl")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rev_id_col")
    private Long id;
    @Column(name = "rev_tit_col")
    private String title;
    @Column(name = "rev_des_col")
    private String description;
    @Column(name = "rev_rat_col")
    private Double rating;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "com_id_col", referencedColumnName = "com_id_col")
    private Company company;
}
