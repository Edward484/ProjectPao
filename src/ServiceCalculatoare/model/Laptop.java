package ServiceCalculatoare.model;

public class Laptop extends Item implements Monitor, Comparable<Item>{
    Processor cpu;
    Motherboard motherboard;
    RamMemory ramMemory;
    Integer refreshRate;
    Integer displaySize;

    public Laptop(Integer id, String modelName, String manufacturer, Processor cpu, Motherboard motherboard, RamMemory ramMemory, Integer refreshRate, Integer displaySize) {
        super(id, modelName, manufacturer);
        this.cpu = cpu;
        this.motherboard = motherboard;
        this.ramMemory = ramMemory;
        this.refreshRate = refreshRate;
        this.displaySize = displaySize;
    }

    @Override
    public Integer GetRefreshRate() {
        return refreshRate;
    }

    @Override
    public Integer GetDisplaySize() {
        return displaySize;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", cpu=" + cpu.getId() +
                ", motherboard=" + motherboard.getId() +
                ", ramMemory=" + ramMemory.getId() +
                ", refreshRate=" + refreshRate +
                ", displaySize=" + displaySize +
                '}';
    }


    @Override
    public int compareTo(Item u) {
        try {
            Laptop o = (Laptop) u;
            int r = cpu.compareTo(o.cpu);
            if (r == 0)
                return ramMemory.compareTo(o.ramMemory);
            return r;
        }
        catch (ClassCastException e){
            int t = id.compareTo(u.id);
            return t;
        }
    }
}
