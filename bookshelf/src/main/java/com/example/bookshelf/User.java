package com.example.bookshelf;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {
  public User(String username) {
    this.username = username;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String username;

  @OneToMany(mappedBy = "user")
  public List<Book> books;
}
