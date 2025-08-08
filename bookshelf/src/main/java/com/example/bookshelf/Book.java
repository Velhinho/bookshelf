package com.example.bookshelf;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Book {
  public Book(String title, String author, Status status) {
    this.title = title;
    this.author = author;
    this.status = status;
  }

  public enum Status {
    TO_READ,
    READING,
    FINISHED
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String title;
  private String author;
  private Status status;
  private int rating;
  private String notes;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;
}
