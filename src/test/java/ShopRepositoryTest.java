import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product product1 = new Product(11, "хлеб", 47);
    Product product2 = new Product(25, "булка", 22);
    Product product3 = new Product(58, "картошка", 57);

    @Test
    public void shouldDeleteExistingElement() {
        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.remove(product2.getId());

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldDeleteNoExistingElement(){
        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () ->{
            repo.remove(-4);
        });
    }
}

