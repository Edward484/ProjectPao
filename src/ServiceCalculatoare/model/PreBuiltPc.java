package ServiceCalculatoare.model;

public class PreBuiltPc extends Item implements Comparable<Item>{
    Processor cpu;
    Motherboard motherboard;
    RamMemory ramMemory;

    public PreBuiltPc(Integer id, String modelName, String manufacturer, Processor cpu, Motherboard motherboard, RamMemory ramMemory) {
        super(id, modelName, manufacturer);
        this.cpu = cpu;
        this.motherboard = motherboard;
        this.ramMemory = ramMemory;
    }

    public Processor getCpu() {return cpu;}

    public void setCpu(Processor cpu) {
        this.cpu = cpu;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public RamMemory getRamMemory() {
        return ramMemory;
    }

    public void setRamMemory(RamMemory ramMemory) {
        this.ramMemory = ramMemory;
    }

    @Override
    public String toString() {
        return "PreBuiltPc{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", cpu=" + cpu.getId() +
                ", motherboard=" + motherboard.getId() +
                ", ramMemory=" + ramMemory.getId() +
                '}';
    }

    @Override
    public int compareTo(Item u) {
        try {
            PreBuiltPc o = (PreBuiltPc) u;
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
