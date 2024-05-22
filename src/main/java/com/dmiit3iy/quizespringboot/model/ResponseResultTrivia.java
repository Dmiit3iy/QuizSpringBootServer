package com.dmiit3iy.quizespringboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "response_code",
        "results"
})
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResultTrivia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("response_code")
    private int responseCode;

    @JsonProperty("results")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "responseResult")
    @Cascade(value = org.hibernate.annotations.CascadeType.DELETE)
    private List<Result> results = new ArrayList<Result>();

    @ManyToOne
   // @JoinColumn(name = "gamer_id", nullable = false)
    @JoinColumn(name = "gamer_id")
    private Gamer gamer;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime localDateTime = LocalDateTime.now();
}