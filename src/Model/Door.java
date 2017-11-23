package Model;


import Controller.Controller;
import Model.place.Place;

public class Door {
    public Place placeLeft;
    public Place placeRight;

    public Door(Place placeLeft, Place locationRight) {
        this.placeLeft = placeLeft;
        this.placeRight = locationRight;
    }

    public void changeLocation(Controller controller)
    {
        if(placeLeft==controller.place) controller.place= placeRight;
        else controller.place = placeLeft;
    }
}
