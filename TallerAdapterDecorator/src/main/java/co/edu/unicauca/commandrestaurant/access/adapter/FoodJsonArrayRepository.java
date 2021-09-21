package co.edu.unicauca.commandrestaurant.access.adapter;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.domain.decorator.CryptFood;
import java.util.ArrayList;
import java.util.List;

/**
 * repositorio que permite grabar y recuperar comidas en un arreglo.
 *
 * @author Sergio Erazo, Camilo Perafan
 */
public class FoodJsonArrayRepository implements IFoodJsonRepository{
    
    
    private static List<Food> foods;
    
    public FoodJsonArrayRepository(){
        if (foods==null) {
            foods=new ArrayList<>();
            initialize();
        }
    }
    
    private void initialize(){
        foods.add(new CryptFood(0, "Arroz", FoodTypeEnum.ENTRADA));
        foods.add(new CryptFood(1, "jugo de mango", FoodTypeEnum.JUGO));
    }
    
    @Override
    public Food getById(int id) {
        for (Food dato : foods) {
            if (dato.getId()==id) {
                return dato;
            }
        }
        return null;
    }

    @Override
    public List<String> foods() {
        List<String> listAux=new ArrayList<>();
        for (Food dato : foods) {
            listAux.add(dato.getId()+","+dato.getName()+","+dato.getType());
        }
        return listAux;
    }

    @Override
    public boolean add(Food food) {
        for (Food dato : foods) {
            if (dato.equals(food)) {
                return false;
            }
        }
        foods.add(food);
        return true;
    }

    @Override
    public void remove(int id) {
        for (Food dato : foods) {
            if (dato.getId()==id) {
                foods.remove(dato);
                break;
            }
        }
    }

    @Override
    public boolean modify(Food food) {
        for (Food dato : foods) {
            if (dato.getId()==food.getId()) {
                foods.remove(dato);
                foods.add(food);
                return true;
            }
        }
        return false;
    }
}
