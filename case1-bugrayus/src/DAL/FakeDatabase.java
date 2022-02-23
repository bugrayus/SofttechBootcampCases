package DAL;

import Model.House;
import Model.SummerHouse;
import Model.Villa;

import java.util.ArrayList;

public class FakeDatabase {
    ArrayList<House> HouseList;
    ArrayList<SummerHouse> SummerHouseList;
    ArrayList<Villa> VillaList;

    public FakeDatabase(){
        HouseList = new ArrayList<>();
        SummerHouseList = new ArrayList<>();
        VillaList = new ArrayList<>();
    }

    public ArrayList<House> getHouses() {
        return HouseList;
    }

    public void createHouse(House house) {
        HouseList.add(house);
    }

    public ArrayList<SummerHouse> getSummerHouses() {
        return SummerHouseList;
    }

    public void createSummerHouse(SummerHouse summerHouse) {
        SummerHouseList.add(summerHouse);
    }

    public ArrayList<Villa> getVillas() {
        return VillaList;
    }

    public void createVilla(Villa villa) {
        VillaList.add(villa);
    }
}
