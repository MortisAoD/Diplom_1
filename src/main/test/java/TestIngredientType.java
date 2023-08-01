import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class TestIngredientType {

    @Test
    public void testSauceType() {
        Assert.assertEquals("SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    public void testFillingType() {
        Assert.assertEquals("FILLING", IngredientType.FILLING.name());
    }
}