import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import praktikum.Bun;
import org.junit.Test;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.Assert;
import praktikum.Burger;
import org.mockito.Mockito;
import praktikum.Ingredient;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;
import static praktikum.IngredientType.FILLING;

public class TestBurger {

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    Bun bun;
    Burger burger = new Burger();
    Ingredient ingredient;

    @Test
    public void testSetBuns() {
        bun = new Bun("Булочка с кунжутом",550f);
        burger.setBuns(bun);
        MatcherAssert.assertThat("Тест для метода setBuns()",burger.getReceipt(), CoreMatchers.containsString("Булочка с кунжутом"));
    }

    @Test
    public void testAddIngredient() {
        ingredient = new Ingredient(FILLING, "Хрустящие минеральные кольца", 000f);
        burger.addIngredient(ingredient);
        assertEquals("Тест для метода addIngredient()", ingredient, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        ingredient = new Ingredient(SAUCE, "HOT", 999f);
        burger.addIngredient(ingredient);
        burger.deleteIngredient(0);
        Assert.assertTrue("Тест для метода removeIngredient()", burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ingredientIndexZero = new Ingredient(SAUCE, "PAPERS", 567f);
        Ingredient ingredientIndexOne = new Ingredient(FILLING, "Кристальные минералы", 999f);
        burger.addIngredient(ingredientIndexZero);
        burger.addIngredient(ingredientIndexOne);
        burger.moveIngredient(0,1);
        assertEquals("Тест для метода moveIngredient()", ingredientIndexZero, burger.ingredients.get(1));
    }

    @Mock
    private Bun mockBun;

    @Test
    public void testGetPrice() {
        Mockito.when(mockBun.getPrice()).thenReturn(999f);
        burger.setBuns(mockBun);
        assertEquals("Тест для метода getPrice()",1998f, burger.getPrice(), 0.001);
    }

    @Test
    public void testGetReceipt() {
        Mockito.when(mockBun.getName()).thenReturn("MOCK_VALUE");
        burger.setBuns(mockBun);
        ingredient = new Ingredient(SAUCE, "PAPERS", 567f);
        burger.addIngredient(ingredient);
        MatcherAssert.assertThat("Тест для метода getReceipt()",burger.getReceipt(), CoreMatchers.containsString("MOCK_VALUE"));
    }
}