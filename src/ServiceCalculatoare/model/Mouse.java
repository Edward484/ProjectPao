package ServiceCalculatoare.model;

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

    public Integer getNumberOfButtons() {
        return numberOfButtons;
    }

    public void setNumberOfButtons(Integer numberOfButtons) {
        this.numberOfButtons = numberOfButtons;
    }

    public Integer getDpi() {
        return dpi;
    }

    public void setDpi(Integer dpi) {
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
        try {
            Mouse o = (Mouse) u;
            return dpi.compareTo(o.dpi);
        }
        catch (ClassCastException e){
            int t = id.compareTo(u.id);
            return t;
        }
    }
}
