package ServiceCalculatoare.classes;

public class GamingMonitor extends PeripheralPcPart implements Monitor, Comparable<Item>{
    Integer refreshRate;
    Integer diagonal;

    public GamingMonitor(Integer id, String modelName, String manufacturer, String connectionInterface) {
        super(id, modelName, manufacturer, connectionInterface);
    }

    public GamingMonitor(Integer id, String modelName, String manufacturer, String connectionInterface, Integer refreshRate, Integer diagonal) {
        super(id, modelName, manufacturer, connectionInterface);
        this.refreshRate = refreshRate;
        this.diagonal = diagonal;
    }

    @Override
    public Integer GetRefreshRate() {
        return refreshRate;
    }


    @Override
    public Integer GetDisplaySize() {
        return diagonal;
    }

    @Override
    public String toString() {
        return "GamingMonitor{" +
                "id=" + id +
                ", refreshRate=" + refreshRate +
                ", diagonal=" + diagonal +
                ", modelName='" + modelName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", connectionInterface='" + connectionInterface + '\'' +
                '}';
    }


    @Override
    public int compareTo(Item u) {
        GamingMonitor o = (GamingMonitor) u;
        return refreshRate.compareTo(o.refreshRate);
    }
}
