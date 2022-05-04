package ServiceCalculatoare.classes;

public class PreBuilPcFullKit extends Item implements Monitor, MouseAndKeyboardCombo, Comparable<Item>{
    Processor cpu;
    Motherboard motherboard;
    RamMemory ramMemory;
    Integer refreshRate;
    Integer displaySize;
    Mouse mouse;
    Keyboard keyboard;

    public PreBuilPcFullKit(Integer id, String modelName, String manufacturer,
                            Processor cpu, Motherboard motherboard, RamMemory ramMemory,
                            Integer refreshRate, Integer displaySize, Mouse mouse, Keyboard keyboard) {
        super(id, modelName, manufacturer);
        this.cpu = cpu;
        this.motherboard = motherboard;
        this.ramMemory = ramMemory;
        this.refreshRate = refreshRate;
        this.displaySize = displaySize;
        this.mouse = mouse;
        this.keyboard = keyboard;
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
    public Mouse getMouse() {
        return mouse;
    }

    @Override
    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Processor getCpu() {
        return cpu;
    }

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

    public Integer getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(Integer refreshRate) {
        this.refreshRate = refreshRate;
    }

    public Integer getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(Integer displaySize) {
        this.displaySize = displaySize;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    @Override
    public String toString() {
        return "PreBuilPcFullKit{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", cpu=" + cpu.getId() +
                ", motherboard=" + motherboard.getId() +
                ", ramMemory=" + ramMemory.getId() +
                ", refreshRate=" + refreshRate +
                ", displaySize=" + displaySize +
                ", mouse=" + mouse.getId() +
                ", keyboard=" + keyboard.getId() +
                '}';
    }

    @Override
    public int compareTo(Item u) {
        PreBuilPcFullKit o = (PreBuilPcFullKit) u;
        int r = cpu.compareTo(o.cpu);
        if(r == 0)
            return ramMemory.compareTo(o.ramMemory);
        return r;
    }
}
