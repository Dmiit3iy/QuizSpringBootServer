package com.dmiit3iy.quizespringboot.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
}
