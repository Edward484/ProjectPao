package ServiceCalculatoare.classes;

public class Motherboard extends InternalPcPart{
    String socket;
    String memoryType;
    String format;
    Integer numberOfSata;
    String chipsetName;

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getNumberOfSata() {
        return numberOfSata;
    }

    public void setNumberOfSata(Integer numberOfSata) {
        this.numberOfSata = numberOfSata;
    }

    public String getChipsetName() {
        return chipsetName;
    }

    public void setChipsetName(String chipsetName) {
        this.chipsetName = chipsetName;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }
}
