package com.insurance.policies.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "policy")
public class Policies implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_policy")
    private Integer id_policy;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "usd_price")
    private double usd_price;

}   
