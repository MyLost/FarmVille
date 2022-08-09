package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;

public class FarmvilleTests {

    private Animal lion;
    private Animal chiken;

    @Before
    public void setup() {
        lion = new Animal("lion", 10);
        chiken = new Animal("chiken", 10);
    }

    @Test
    public void testShouldCreateFarmSuccess() {
        Farm farm = new Farm("SoftUni", 15);
        Assert.assertEquals("SoftUni", farm.getName());
        Assert.assertEquals(15, farm.getCapacity());
        Assert.assertEquals(0, farm.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testCreateShouldTrowExceptionBecouseNameIsNull() {
        new Farm(null , 15);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateShouldTrowExceptionBecouseNameIsWhiteSpace() {
        new Farm(" " , 15);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateShouldTrowExceptionBecouseNameIsEmpty() {
        new Farm("" , 15);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateShouldTrowExceptionBecouseCapacityIsnegative() {
        new Farm("SoftUni" , -15);
    }

    //add success
    @Test
    public void testAddAshouldAddSuccess() {
        Farm farm = new Farm("SoftUni", 3);
        farm.add(lion);
        assertEquals(1, farm.getCount());
        farm.add(chiken);
        assertEquals(2, farm.getCount());
    }

    //add exception
    @Test(expected = IllegalArgumentException.class)
    public void testAddAshouldThrowBecouseOfNoCapacity() {
        Farm farm = new Farm("SoftUni", 1);
        farm.add(lion);
        farm.add(chiken);

    }
    //add exception
    @Test(expected = IllegalArgumentException.class)
    public void testAddAshouldThrowBecouseOfDuplicateAnimal() {
        Farm farm = new Farm("SoftUni", 3);
        farm.add(lion);
        farm.add(lion);
    }

    @Test
    public void testRemoveShouldRemove() {
        Farm farm = new Farm("SoftUni", 3);
        farm.add(lion);
        assertTrue(farm.remove(lion.getType()));
        assertEquals(0, farm.getCount());
    }

    @Test
    public void testRemoveShouldNotRemove() {
        Farm farm = new Farm("SoftUni", 3);
        farm.add(lion);
        assertFalse(farm.remove(chiken.getType()));
        assertEquals(1, farm.getCount());
    }

}
