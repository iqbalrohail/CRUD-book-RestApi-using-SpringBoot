package com.example.demo.data.transfer.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookDto {
    @JsonProperty("book_id")
    private int id;
    private String name;
    @JsonProperty("author_name")
    private AuthorDto author;
}
