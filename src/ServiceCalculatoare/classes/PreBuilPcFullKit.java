package ServiceCalculatoare.classes;

public class PreBuilPcFullKit extends Item implements Monitor, MouseAndKeyboardCombo{
    Processor cpu;
    Motherboard motherboard;
    RamMemory ramMemory;
    Integer refreshRate;
    Integer displaySize;
    Mouse mouse;
    Keyboard keyboard;

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

}
