package Business;

import DAL.FakeDatabase;
import Model.Building;
import Model.House;
import Model.SummerHouse;
import Model.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BuildingService {
    FakeDatabase db = new FakeDatabase();

    public void createVilla(Villa villa) {
        db.createVilla(villa);
    }

    public void createHouse(House house) {
        db.createHouse(house);
    }

    public void createSummerHouse(SummerHouse summerHouse) {
        db.createSummerHouse(summerHouse);
    }

    public int sumOfHousePrices() {
        List<Integer> prices = db.getHouses().stream().map(Building::getPrice).collect(Collectors.toList());

        return prices.stream().mapToInt(Integer::intValue).sum();
    }

    public int sumOfSummerHousePrices() {
        List<Integer> prices = db.getSummerHouses().stream().map(Building::getPrice).collect(Collectors.toList());

        return prices.stream().mapToInt(Integer::intValue).sum();
    }

    public int sumOfVillaPrices() {
        List<Integer> prices = db.getVillas().stream().map(Building::getPrice).collect(Collectors.toList());

        return prices.stream().mapToInt(Integer::intValue).sum();
    }

    public int sumOfAllBuildingPrices() {
        return sumOfHousePrices() + sumOfSummerHousePrices() + sumOfVillaPrices();
    }

    public int averageHouseSpaces() {
        List<Integer> space = db.getHouses().stream().map(Building::getM2).collect(Collectors.toList());

        return space.stream().mapToInt(Integer::intValue).sum() / space.size();
    }

    public int averageSummerHouseSpaces() {
        List<Integer> space = db.getSummerHouses().stream().map(Building::getM2).collect(Collectors.toList());

        return space.stream().mapToInt(Integer::intValue).sum() / space.size();
    }

    public int averageVillaSpaces() {
        List<Integer> space = db.getVillas().stream().map(Building::getM2).collect(Collectors.toList());

        return space.stream().mapToInt(Integer::intValue).sum() / space.size();
    }

    public int averageAllBuildingSpaces() {
        return (averageVillaSpaces() + averageHouseSpaces() + averageVillaSpaces()) / 3;
    }

    private List<Building> filterHouses(int rooms, int livingRooms) {
        return db.getHouses().stream().filter(x -> x.getLivingRooms() == livingRooms && x.getRooms() == rooms).collect(Collectors.toList());
    }

    private List<Building> filterSummerHouses(int rooms, int livingRooms) {
        return db.getSummerHouses().stream().filter(x -> x.getLivingRooms() == livingRooms && x.getRooms() == rooms).collect(Collectors.toList());
    }

    private List<Building> filterVillas(int rooms, int livingRooms) {
        return db.getVillas().stream().filter(x -> x.getLivingRooms() == livingRooms && x.getRooms() == rooms).collect(Collectors.toList());
    }

    public List<List<Building>> filterAllBuildings(int rooms, int livingRooms) {
        List<List<Building>> response = new ArrayList<>();
        response.add(filterVillas(rooms, livingRooms));
        response.add(filterHouses(rooms, livingRooms));
        response.add(filterSummerHouses(rooms, livingRooms));

        return response;
    }

    public void printFilteredAllBuildings(int rooms, int livingRooms) {
        var filteredBuildings = filterAllBuildings(rooms, livingRooms);

        if (filteredBuildings.get(0).size() == 0 && filteredBuildings.get(1).size() == 0 && filteredBuildings.get(2).size() == 0) {
            System.out.println("Yok");
            return;
        }

        for (List<Building> filteredBuilding : filteredBuildings) {
            for (Building building : filteredBuilding) {
                System.out.println();
                System.out.print("M2 = ");
                System.out.print(building.getM2());
                System.out.print(", Fiyat = ");
                System.out.print(building.getPrice());
                System.out.print(", Oda = ");
                System.out.print(building.getRooms());
                System.out.print(", Salon = ");
                System.out.print(building.getLivingRooms());
            }
        }

    }
}
