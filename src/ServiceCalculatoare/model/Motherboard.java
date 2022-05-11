package ServiceCalculatoare.model;

public class Motherboard extends InternalPcPart implements Comparable<Item>{
    String socket;
    String memoryType;
    String format;
    Integer numberOfSata;
    String chipsetName;

    public Motherboard(Integer id, String modelName, String manufacturer, Integer powerDrown) {
        super(id, modelName, manufacturer, powerDrown);
    }


    public Motherboard(Integer id, String modelName, String manufacturer, Integer powerDrown,
                       String socket, String memoryType, String format, Integer numberOfSata,
                       String chipsetName) {
        super(id, modelName, manufacturer, powerDrown);
        this.socket = socket;
        this.memoryType = memoryType;
        this.format = format;
        this.numberOfSata = numberOfSata;
        this.chipsetName = chipsetName;
    }

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

    @Override
    public String toString() {
        return "Motherboard{" +
                "id=" + id +
                ",powerDrown=" + powerDrown +
                ", modelName='" + modelName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", socket='" + socket + '\'' +
                ", memoryType='" + memoryType + '\'' +
                ", format='" + format + '\'' +
                ", numberOfSata=" + numberOfSata +
                ", chipsetName='" + chipsetName + '\'' +
                '}';
    }


    @Override
    public int compareTo(Item u) {
        try {
            Motherboard o = (Motherboard) u;
            return numberOfSata.compareTo(o.numberOfSata);
        }
        catch (ClassCastException e){
            int t = id.compareTo(u.id);
            return t;
        }

    }
}
