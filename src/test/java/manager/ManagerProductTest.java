package manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.Repository;
import ru.netology.Magazine;
import ru.netology.Product;
import ru.netology.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ManagerProductTest {
    private Repository repository = new Repository();
    private ManagerProduct manager = new ManagerProduct(repository);
    private Magazine first = new Magazine(1, 150, "Forbes", "Bertie Charles Forbes");
    private Magazine second = new Magazine(2, 100, "ADAC Motorwelt", "ADAC Verlag");
    private Smartphone third = new Smartphone(3, 1000, "Redmi", "Xiaomi");
    private Smartphone four = new Smartphone(4, 3000, "X10", "Nokia");


    @BeforeEach
    public void Data() {

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
        Product[] expected = new Product[] {first, second, third, four};
        assertArrayEquals(expected, actual);
    }


}