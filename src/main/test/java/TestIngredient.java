import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import org.junit.runner.RunWith;
import praktikum.IngredientType;
import org.junit.runners.Parameterized;

import static org.junit.runners.Parameterized.*;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class TestIngredient {

    private final float price;
    private final String name;
    private final IngredientType type;

    public TestIngredient(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameters(name = "Тестовые данные: {0}, {1}, {2}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {FILLING, "Хрустящие минеральные кольца", 000f},
                {SAUCE, "Spicy-X", 999f}
        };
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Тест для метода getType()", type, ingredient.getType());
    }

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Тест для метода getName()", name, ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Тест для метода getPrice()", price, ingredient.getPrice(),0.001);
    }
}