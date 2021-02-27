package com.example.demo.domain;

import com.example.demo.data.transfer.objects.AuthorDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "books_data")
public class BookDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("book_id")
    private int id;
    private String name;
    @JsonProperty("author_name")
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private AuthorDomain author;
}
