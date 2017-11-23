package Model;

import Controller.Controller;
import Model.place.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PlaceMap {
    public Hall hall;
    public Office1 office1;
    public Office2 office2;
    public Office3 office3;
    public Road road;

    public Controller controller;
    public Map<Rectangle, Door> map;

    public PlaceMap(Controller controller)
    {
        this.controller = controller;
        hall = new Hall(controller);
        office1 = new Office1(controller);
        office2 = new Office2(controller);
        office3 = new Office3(controller);
        road = new Road(controller);


        Door doorOffice1 = new Door(hall,office1);
        Door doorOffice2 = new Door(hall,office2);
        Door doorOffice3 = new Door(hall,office3);
        Door doorBackFrom1 = new Door(office1,hall);
        Door doorBackFrom2 = new Door(office2,hall);
        Door doorBackFrom3 = new Door(office3,hall);
        Door doorExit = new Door(hall,road);

        map = new HashMap<>();
        map.put(hall.door1,doorOffice1);
        map.put(hall.door2,doorOffice2);
        map.put(hall.door3,doorOffice3);
        map.put(office1.doorHall,doorBackFrom1);
        map.put(office2.doorHall,doorBackFrom2);
        map.put(office3.doorHall,doorBackFrom3);
        map.put(hall.doorExit,doorExit);
    }
}
