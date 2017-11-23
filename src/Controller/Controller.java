package Controller;


import Model.*;
import Model.place.Place;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Controller {
    public Player player;
    public PlayerCar playerCar;
    public List<Enemy> enemies;

    public Key key;
    public Place place;
    public PlaceMap placeMap;

    public Controller() {
        player = new Player();
        playerCar = new PlayerCar();
        enemies = new ArrayList<Enemy>();

        key = new Key();
        placeMap = new PlaceMap(this);
        place = placeMap.hall;
//        place = placeMap.road;
        //place = placeMap.office1;

    }

    public void changePlace(Rectangle door) {
        placeMap.map.get(door).changeLocation(this);
    }

}
