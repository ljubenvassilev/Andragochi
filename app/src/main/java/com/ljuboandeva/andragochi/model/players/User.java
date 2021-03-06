package com.ljuboandeva.andragochi.model.players;

import com.ljuboandeva.andragochi.model.pet.Pet;
import com.ljuboandeva.andragochi.model.shop.Buyable;
import com.ljuboandeva.andragochi.model.shop.Food;
import com.ljuboandeva.andragochi.model.shop.Medicine;
import com.ljuboandeva.andragochi.model.shop.Toy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Evelina on 8/25/2016.
 */
public class User implements Serializable{
        private static final int START_MONEY=500;
        private final String username;
        private int age;
        private String password;
        private String email;
        private String name;
        private int money;
        private int difficultyLevel;
        Pet pet;

    private ArrayList<Food> foods;
    private ArrayList<Medicine> medicines;
    private ArrayList<Toy> toys;


        // ot google profile
    //inventory collection link to shop inventory

        public User(String username, String password,String email){
            this.username=username;
            this.password=password;
            this.email=email;
            this.money=START_MONEY;
            this.toys=new ArrayList<>();
            toys.add(new Toy(Toy.Type.BALL,15,15,0));
            toys.add(new Toy(Toy.Type.GIRDLE,25,25,0));
            toys.add(new Toy(Toy.Type.SHOVEL,40,40,0));
            this.medicines = new ArrayList<>();
            medicines.add(new Medicine(Medicine.Type.TABLET,15,15,0));
            medicines.add(new Medicine(Medicine.Type.NEEDLE,30,30,0));
            this.foods = new ArrayList<>();
            foods.add(new Food(Food.Type.BONE,5,5,0));
            foods.add(new Food(Food.Type.FLESH,10,10,0));
            foods.add(new Food(Food.Type.SKULL,15,15,0));

        }


        public void addMoney(int money){
            this.money += money;
        }

        public void clean(){
            //TODO
        }
        public void takeOut(){
            //TODO
        }
        public void takeHome(){
            //TODO
        }
        public void feed(Food food){
            //TODO
        }
        public void giveMedicine(Medicine meds){
            //TODO
        }

    public void setDifficultyLevel(int difficultyLevel){
        this.difficultyLevel=difficultyLevel;
    }
    public int getDifficultyLevel(){ return this.difficultyLevel; }
    public Pet getPet() {
        return this.pet;
    }
    public boolean petExists(){return pet!=null;}
    public String getEmail() {
        return email;
    }
    public void setPet(Pet pet){
        this.pet=pet;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public void addFood(int position){foods.get(position).increaseCount(); }
    public void addToy(int position){toys.get(position).increaseCount(); }
    public void addMedicine(int position){medicines.get(position).increaseCount(); }
    public boolean enoughMoney(int money){return this.money>=money;}
    public int getMoney(){return money;}
    public void spendMoney(int money) {this.money -= money; }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public ArrayList<Toy> getToys() {
        return toys;
    }

    public ArrayList<Medicine> getMeds() {return medicines;}

    public void setMoney(int money) {
        this.money = money;
    }


    public ArrayList<Buyable> getInventory(String type) {
        ArrayList<Buyable> items = new ArrayList<>();
        switch (type) {
            case "FOOD":
                items.addAll(foods);
                break;
            case "TOY":
                items.addAll(toys);
                break;
            case "MEDICINE":
                items.addAll(medicines);
        }
        return items;
    }

    public void removeFood(int position){foods.get(position).decreaseCount(); }
    public void removeToy(int position){toys.get(position).decreaseCount(); }
    public void removeMedicine(int position){medicines.get(position).decreaseCount(); }
}
