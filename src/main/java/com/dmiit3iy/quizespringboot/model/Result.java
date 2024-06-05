package com.dmiit3iy.quizespringboot.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "difficulty",
        "category",
        "question",
        "correct_answer",
        "incorrect_answers"
})
@Entity
@Table(name = "results")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @JsonProperty("type")
    private String type;
    @JsonProperty("difficulty")
    private String difficulty;
    @JsonProperty("category")
    private String category;
    @JsonProperty("question")
    private String question;
    @JsonProperty("correct_answer")
    private String correctAnswer;
    @JsonProperty("incorrect_answers")
    @ElementCollection
    @CollectionTable(name = "incorrectAnswers", joinColumns = @JoinColumn(name = "result_id"))
    @Cascade(value = org.hibernate.annotations.CascadeType.DELETE)
    private List<String> incorrectAnswers = new ArrayList<>();
    @ManyToOne
   // @JoinColumn(name = "responseResult_id", nullable = false)
    @JoinColumn(name = "responseResult_id")
    private ResponseResultTrivia responseResult;



    @ToString.Exclude
    @OneToOne(mappedBy = "result", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Answer answer;
}
