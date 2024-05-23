package com.dmiit3iy.quizespringboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String otvet;
    @JsonFormat(pattern = "dd.MM.yyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime localDateTime = LocalDateTime.now();

    private boolean isRight;
    @NonNull
    @ToString.Exclude
    @JsonIgnore
    @OneToOne
    @MapsId
    @JoinColumn(name = "result_id")
    private Result result;
    @NonNull
    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "gamer_id")
    private Gamer gamer;

    public boolean check(String str){
        return result.getCorrectAnswer().equals(str);
    }
}
