package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.github.javafaker.Faker;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    static Faker faker = new Faker();
    private Bun bun;
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                //немножко по-другому сделал генерацию тестового названия бургера
                {faker.lorem().characters(1,true, false), 100},     //тут название булочки всегда из буквы
                {faker.number().digits(1), 100},                                                        // на всякий случай вариант с одной цифрой в названии
                {faker.lorem().characters(100,true, true), 100},
                {faker.lorem().characters(50,true, true), Float.MIN_NORMAL},
                {faker.lorem().characters(50,true, true), Float.MAX_VALUE},
                {null, 100},
                {"", 100},
                {faker.lorem().characters(50,true, true), 0},
                {faker.lorem().characters(50,true, true), -10},             //кейсы с отрицательным числом
                {faker.lorem().characters(50,true, true), Float.MIN_VALUE},
        };
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void getName() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPrice() {
        assertEquals(price, bun.getPrice(), 0);
    }
}