package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "author_data")
public class AuthorDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("author_id")
    private int authorId;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("author_language")
    private String authorLanguage;
    @OneToOne(mappedBy = "author")
    @JsonBackReference
    BookDomain bookDomain;
}
