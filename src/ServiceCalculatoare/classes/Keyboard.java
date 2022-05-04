package ServiceCalculatoare.classes;

public class Keyboard extends PeripheralPcPart implements Comparable<Item> {
    String layout;
    Boolean isMechanical;

    public Keyboard() {
        this.layout = "layout";
        this.isMechanical = false;
    }

    public Keyboard(Integer id, String modelName, String manufacturer, String connectionInterface, String layout, Boolean isMechanical) {
        super(id, modelName, manufacturer, connectionInterface);
        this.layout = layout;
        this.isMechanical = isMechanical;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public void setMechanical(Boolean mechanical) {
        isMechanical = mechanical;
    }

    public String getLayout() {
        return layout;
    }

    public Boolean getMechanical() {
        return isMechanical;
    }

    @Override
    public String toString() {
        return "Keyboard{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", layout='" + layout + '\'' +
                ", isMechanical=" + isMechanical +
                ", connectionInterface='" + connectionInterface + '\'' +
                '}';
    }

    @Override
    public int compareTo(Item u) {
        Keyboard o = (Keyboard) u;
        return isMechanical.compareTo(o.isMechanical);
    }
}
