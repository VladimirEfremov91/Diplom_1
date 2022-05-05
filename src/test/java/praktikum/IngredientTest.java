package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.github.javafaker.Faker;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {
    static Faker faker = new Faker();
    private final IngredientType ingredientType;
    private final String name;
    private final float price;


    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {SAUCE, faker.lorem().characters(1,true, false), 100},
                {FILLING, faker.number().digits(1), 100},
                {SAUCE, faker.lorem().characters(100,true, true), 100},
                {FILLING, faker.lorem().characters(50,true, true), Float.MIN_NORMAL},
                {SAUCE, faker.lorem().characters(50,true, true), Float.MAX_VALUE},
                {FILLING, null, 100},
                {SAUCE, "", 100},
                {FILLING, faker.lorem().characters(50,true, true), 0},
                {SAUCE, faker.lorem().characters(50,true, true), -10},
                {FILLING, faker.lorem().characters(50,true, true), Float.MIN_VALUE},
        };
    }

    @Test
    public void shouldGetPrice() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void shouldGetName() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void shouldGetType() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(ingredientType, ingredient.getType());
    }
}