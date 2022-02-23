package Model;

public abstract class Building {
    int price;
    int m2;
    int rooms;
    int livingRooms;

    public Building(int price, int m2, int rooms, int livingRooms) {
        this.price = price;
        this.m2 = m2;
        this.rooms = rooms;
        this.livingRooms = livingRooms;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getM2() {
        return m2;
    }

    public void setM2(int m2) {
        this.m2 = m2;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getLivingRooms() {
        return livingRooms;
    }

    public void setLivingRooms(int livingRooms) {
        this.livingRooms = livingRooms;
    }
}
