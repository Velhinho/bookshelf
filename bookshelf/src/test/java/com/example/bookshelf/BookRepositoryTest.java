package com.example.bookshelf;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class BookRepositoryTest {

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private UserRepository userRepository;

  @Test
  public void testSave() {
    var user = new User("Osar");
    userRepository.save(user);

    var title = "Oscar Wilde";
    var author = "The Picture of Dorian Gray";
    var status = Book.Status.FINISHED;
    var book = new Book(title, author, status);
    book.setUser(user);
    var saved = bookRepository.save(book);

    assertEquals(author, saved.getAuthor());
    assertEquals(title, saved.getTitle());
    assertEquals(status, saved.getStatus());
    assertEquals(user, book.getUser());
  }
}