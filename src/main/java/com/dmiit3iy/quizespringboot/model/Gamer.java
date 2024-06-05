package com.dmiit3iy.quizespringboot.model;

import com.dmiit3iy.quizespringboot.service.ExerciseService;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    public Gamer(@NonNull String login, @NonNull String password, @NonNull String firstName, @NonNull String surname) {
        super(login, password, firstName, surname);
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gamer")
    @Cascade(value = org.hibernate.annotations.CascadeType.DELETE)
            @JsonIgnore
    List<ResponseResultTrivia> responseResults = new ArrayList<>();
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gamer")
    @Cascade(value = org.hibernate.annotations.CascadeType.DELETE)
    List<Exercise> exercises = new ArrayList<>();
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gamer")
    @Cascade(value = org.hibernate.annotations.CascadeType.DELETE)
    private List<Answer> answer;
}
