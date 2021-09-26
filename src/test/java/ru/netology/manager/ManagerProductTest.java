package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.NotFoundException.NotFoundException;
import ru.netology.repository.Repository;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ManagerProductTest {
    private Repository repository = new Repository();
    private ManagerProduct manager = new ManagerProduct(repository);
    private Book first = new Book(1, 150, "Forbes", "Bertie Charles Forbes");
    private Book second = new Book(2, 100, "ADAC Motorwelt", "ADAC Verlag");
    private Smartphone third = new Smartphone(3, 1000, "Redmi", "Xiaomi");
    private Smartphone four = new Smartphone(4, 3000, "X10", "Nokia");


    @BeforeEach
    public void data() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);
    }


    @Test
    void shouldSearchByAuthor() {
        Product[] actual = manager.searchBy("Bertie Charles Forbes");
        Product[] expected = new Product[]{first};
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchByName() {
        Product[] actual = manager.searchBy("Redmi");
        Product[] expected = new Product[]{third};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByManufacture() {
        Product[] actual = manager.searchBy("Nokia");
        Product[] expected = new Product[]{four};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByVoid() {
        Product[] actual = manager.searchBy("");
        Product[] expected = new Product[]{first, second, third, four};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNameBook() {
        Product[] actual = manager.searchBy("ADAC Motorwelt");
        Product[] expected = new Product[]{second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchEmptySearch() {
        Product[] actual = manager.searchBy("Glamour");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdOut() {
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(10);
        });
    }

    @Test
    public void removeByIdIn() {
        repository.removeById(4);
        assertArrayEquals(new Product[]{first, second, third}, repository.findAll());
    }


}