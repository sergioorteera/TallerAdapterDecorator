package co.edu.unicauca.commandrestaurant.domain.decorator;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.unicauca.commandRestaurant.infra.Utilities;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase decorador criptografica.
 *
 * @author Sergio Erazo, Camilo Perafan
 */
public class CryptFood extends Food{
    
    /**
     * Comida decorada
    */
    private Food myDecoratedFood;
    /**
     * Costructor
     * @param id es el identificador
     * @param name es el nombre del plato
     * @param type es el tipo de plato
    */
    public CryptFood(int id, String name, FoodTypeEnum type){
        try {
            String cryptFoodName=Utilities.encrypt(name);
            myDecoratedFood=new Food(id, cryptFoodName, type);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CryptFood.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     *
     * @param id
     */
    @Override
    public void setId(int id) {
        myDecoratedFood.setId(id);
    }

    @Override
    public int getId() {
        return myDecoratedFood.getId();
    }
    
    
    @Override
    public void setName(String name) {
        myDecoratedFood.setName(name);
    }

    @Override
    public String getName() {
        return myDecoratedFood.getName();
    }

    @Override
    public void setType(FoodTypeEnum type) {
        myDecoratedFood.setType(type);
    }

    @Override
    public FoodTypeEnum getType() {
        return myDecoratedFood.getType();
    }
    @Override
    public String toString() {
        return "Food{" + "id=" + myDecoratedFood.getId() + ", name=" + myDecoratedFood.getName() + ", type=" + myDecoratedFood.getType() + '}';
    }
}
