import Business.BuildingService;
import Model.House;
import Model.SummerHouse;
import Model.Villa;

public class Main {
    public static void main(String[] args) {
        BuildingService service = new BuildingService();

        service.createVilla(new Villa(200, 380, 3, 2));
        service.createVilla(new Villa(100, 120, 1, 1));
        service.createVilla(new Villa(300, 480, 2, 3));

        service.createSummerHouse(new SummerHouse(300, 180, 3, 2));
        service.createSummerHouse(new SummerHouse(100, 130, 1, 1));
        service.createSummerHouse(new SummerHouse(100, 480, 2, 3));

        service.createHouse(new House(200, 180, 3, 2));
        service.createHouse(new House(300, 120, 1, 1));
        service.createHouse(new House(400, 486, 2, 3));

        System.out.println("Ortalama villa metrekaresi = " + service.averageVillaSpaces());
        System.out.println("Ortalama yazlık metrekaresi = " + service.averageSummerHouseSpaces());
        System.out.println("Ortalama ev metrekaresi = " + service.averageHouseSpaces());
        System.out.println("Ortalama tüm binaların metrekaresi = " + service.averageAllBuildingSpaces());
        System.out.println();
        System.out.println("Toplam villa fiyatı = " + service.sumOfVillaPrices());
        System.out.println("Toplam yazlık fiyatı = " + service.sumOfSummerHousePrices());
        System.out.println("Toplam ev fiyatı = " + service.sumOfHousePrices());
        System.out.println("Toplam tüm binaların fiyatı = " + service.sumOfAllBuildingPrices());
        System.out.println();
        System.out.println("3 oda 2 salon olan tum binalar = ");
        service.printFilteredAllBuildings(3, 2);
    }
}
