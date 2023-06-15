public class Toy {
    private String name;

    private int id;

    // Частота выпадения:
    private int dropChance;

    public Toy(String name, int id, int dropChance) {
        this.name = name;
        this.id = id;
        this.dropChance = dropChance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDropChance() {
        return dropChance;
    }

    public void setDropChance(int dropChance) {
        this.dropChance = dropChance;
    }

    @Override
    public String toString() {
        return "Toy: " +
                "name = " + name +
                ", id = " + id +
                ", drop chance = " + dropChance;
    }
}
