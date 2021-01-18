package com.a302.webcuration.domain.Sample;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter @NoArgsConstructor @AllArgsConstructor
public class Sample {
    @Column(name = "sample_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
