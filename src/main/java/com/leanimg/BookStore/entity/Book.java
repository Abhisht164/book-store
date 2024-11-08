package com.leanimg.BookStore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false,unique=true)
    private String title;
    @Column(nullable=false)
    private String author;
    @Column(nullable=false,unique=true)
    private String description;
    @Column(nullable=false)
    private String genre;
}
