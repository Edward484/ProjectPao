package ServiceCalculatoare.classes;

public class PreBuiltPc extends Item{
    Processor cpu;
    Motherboard motherboard;
    RamMemory ramMemory;

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
}
