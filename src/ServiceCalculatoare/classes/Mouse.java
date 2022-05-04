package ServiceCalculatoare.classes;

public class Mouse extends PeripheralPcPart implements Comparable<Item>{
    Integer numberOfButtons;
    Integer dpi;

    public Mouse(Integer id, String modelName, String manufacturer, String connectionInterface) {
        super(id, modelName, manufacturer, connectionInterface);
    }

    public Mouse(Integer id, String modelName, String manufacturer, String connectionInterface, Integer numberOfButtons, Integer dpi) {
        super(id, modelName, manufacturer, connectionInterface);
        this.numberOfButtons = numberOfButtons;
        this.dpi = dpi;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", numberOfButtons=" + numberOfButtons +
                ", dpi=" + dpi +
                ", connectionInterface='" + connectionInterface + '\'' +
                '}';
    }

    @Override
    public int compareTo(Item u) {
        Mouse o = (Mouse) u;
        return dpi.compareTo(o.dpi);
    }
}
