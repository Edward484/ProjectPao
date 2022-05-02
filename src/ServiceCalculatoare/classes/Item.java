package ServiceCalculatoare.classes;

public class Item {
    protected Integer id;
    protected String modelName;
    protected String manufacturer;

    public Item() {
        this.id = 0;
        this.modelName = "modelName";
        this.manufacturer = "manufacturer";
    }

    public Item(Integer id, String modelName, String manufacturer) {
        this.id = id;
        this.modelName = modelName;
        this.manufacturer = manufacturer;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
