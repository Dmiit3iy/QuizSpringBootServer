package com.dmiit3iy.quizespringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ToString.Exclude
    @OneToOne
    @MapsId
    @JoinColumn(name = "result_id")
    private Result result;
    @ManyToOne
    @JoinColumn(name = "gamer_id")
    private Gamer gamer;
}
