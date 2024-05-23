package com.dmiit3iy.quizespringboot.model;

import com.dmiit3iy.quizespringboot.service.ExerciseService;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "gamers")
public class Gamer extends User {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gamer")
    @Cascade(value = org.hibernate.annotations.CascadeType.DELETE)
    List<ResponseResultTrivia> responseResults = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gamer")
    @Cascade(value = org.hibernate.annotations.CascadeType.DELETE)
    List<Exercise> exercises = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gamer")
    @Cascade(value = org.hibernate.annotations.CascadeType.DELETE)
    private List<Answer> answer;
}
