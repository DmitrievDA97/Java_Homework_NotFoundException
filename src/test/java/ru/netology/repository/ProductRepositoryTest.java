package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;


import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
  private ProductRepository repository = new ProductRepository();
  private Book firstBook = new Book(1, "FirstBook", 200, "Author", 40, 2010);

  @BeforeEach
  public void setup() {
    repository.save(firstBook);
  }

  @Test
  void removeExistingElement() {
    repository.removeById(1);
    Product[] actual = repository.findAll();
    Product[] expected = new Product[0];
    assertArrayEquals(expected, actual);
  }
  @Test
  void removeNonExistingElement() {
    assertThrows(NotFoundException.class, () -> repository.removeById(2));
  }


}
