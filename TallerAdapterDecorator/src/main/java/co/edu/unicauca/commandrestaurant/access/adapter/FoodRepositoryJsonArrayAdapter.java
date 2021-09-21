package co.edu.unicauca.commandrestaurant.access.adapter;

import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import java.util.ArrayList;
import java.util.List;

/**
 * Adaptador de FoodJsonArrayRepository
 * Implementa a IFoodJsonRepository
 * 
 * @author Sergio Erazo, Camilo Perafan
 */
public class FoodRepositoryJsonArrayAdapter implements IFoodRepository {

    private FoodJsonArrayRepository services;
    
    public FoodRepositoryJsonArrayAdapter(){
        services=new FoodJsonArrayRepository();
    }
    @Override
    public Food findById(int id) {
        return services.getById(id);
    }

    @Override
    public List<Food> findAll() {
        List<Food> foods=new ArrayList<>();
        String [] da=null;
        for (String fd : services.foods()) {
            da=fd.split(",");
            foods.add(new Food(Integer.parseInt(da[0]), da[1], FoodTypeEnum.valueOf(da[2])));
        }
        return foods;
    }

    @Override
    public boolean create(Food food) {
        return services.add(food);
    }

    @Override
    public boolean update(Food food) {
        return services.modify(food);
    }

    @Override
    public void delete(int id) {
        services.remove(id);
    }
}
