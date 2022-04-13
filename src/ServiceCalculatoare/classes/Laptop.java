package ServiceCalculatoare.classes;

public class Laptop extends Item implements Monitor{
    Processor cpu;
    Motherboard motherboard;
    RamMemory ramMemory;
    Integer refreshRate;
    Integer displaySize;

    @Override
    public Integer GetRefreshRate() {
        return refreshRate;
    }

    @Override
    public Integer GetDisplaySize() {
        return displaySize;
    }
}
