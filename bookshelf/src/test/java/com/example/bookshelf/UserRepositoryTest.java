package com.example.bookshelf;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class UserRepositoryTest {

  @Autowired
  private UserRepository userRepository;

  public void testSaveAndFind() {
    var username = "Osar";
    var user = new User(username);
    userRepository.save(user);

    var found = userRepository.findByUsername(username);
    assertTrue(found.isPresent());
    assertEquals(username, found.get().getUsername());
  }
}