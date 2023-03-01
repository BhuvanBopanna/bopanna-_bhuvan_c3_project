import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {
    Restaurant restaurant;
    @BeforeEach
    public void mockRestaurant() {
        restaurant = mockito.spy(Restaurant.class);
        restaurant.OpeningTime(LocalTime.parse("08:30:00"));
        restaurant.ClosingTime(LocalTime.parse("22:30:00"));
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);
        restaurant.addToMenu("Apple Juice", 40);
        restaurant.addToMenu("Mango Juice", 40);

    }



    //>>>>>>>>>>>>>>>>>>>>>>>>>OPEN/CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    //-------FOR THE 2 TESTS BELOW, YOU MAY USE THE CONCEPT OF MOCKING, IF YOU RUN INTO ANY TROUBLE
    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time(){
        LocalTime time = LocalTime.parse("11:00:00");
       mockito.when((restaurant.getCurrentTime().thenReturn(time));
       assertTrue(restaurant.isRestaurantOpen());
    }






    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){
      LocalTime time = LocalTime.parse("7:00:00");
      mockito.when(restaurant.getCurrentTime().thenReturn(time));
      assertFalse(restaurant.isRestaurantOpen());

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<OPEN/CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1(){


        int initialMenuSize = restaurant.getMenu().size();
        restaurant.addToMenu("Sizzling brownie",319);
        assertEquals(initialMenuSize+1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws itemNotFoundException {


        int initialMenuSize = restaurant.getMenu().size();
        restaurant.removeFromMenu("Vegetable lasagne");
        assertEquals(initialMenuSize-1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {


        assertThrows(itemNotFoundException.class,
                ()->restaurant.removeFromMenu("French fries"));
    }


    @Test
    public void getting_value_of_item_ordered(){
        int totalValue = 0;
        List<String>myMenu = new ArrayList<>();
        myMenu.add(burger,150);
        myMenu.add(nuggets,90);
        assertEquals(240,restaurant.calcTotal(myMenu));

    }

}
