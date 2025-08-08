package com.example.bookshelf;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class BookController {
  private final HashMap<String, ArrayList<Book>> booksMap = new HashMap<>();

  @GetMapping("/books")
  public ArrayList<Book> getBooks(@RequestParam String user) {
    var books = booksMap.get(user);
    if (books == null) {
      throw new RuntimeException("Invalid User");
    }
    return books;
  }

  @PostMapping("/books")
  public void postBooks(@RequestParam String user, @RequestBody Book book) {
    if (!booksMap.containsKey(user)) {
      throw new RuntimeException("Invalid User");
    }
    var books = booksMap.get(user);
    if (books == null) {
      books = new ArrayList<>();
      books.add(book);
      booksMap.put(user, books);
    } else {
      books.add(book);
    }
  }
}
