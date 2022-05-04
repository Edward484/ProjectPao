package ServiceCalculatoare.classes;

public class RamMemory extends InternalPcPart implements Comparable<Item>{
    Integer size;
    String memoryType;
    Integer frequency;

    public RamMemory(Integer id, String modelName, String manufacturer, Integer powerDrown) {
        super(id, modelName, manufacturer, powerDrown);
    }

    public RamMemory(Integer id, String modelName, String manufacturer, Integer powerDrown, Integer size, String memoryType, Integer frequency) {
        super(id, modelName, manufacturer, powerDrown);
        this.size = size;
        this.memoryType = memoryType;
        this.frequency = frequency;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "RamMemory{" +
                "id=" + id +
                ",powerDrown=" + powerDrown +
                ", modelName='" + modelName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", size=" + size +
                ", memoryType='" + memoryType + '\'' +
                ", frequency=" + frequency +
                '}';
    }


    @Override
    public int compareTo(Item u) {
        RamMemory o = (RamMemory) u;
        int r = size.compareTo(o.size);
        if(r == 0){
            return frequency.compareTo(o.frequency);
        }
        return r;
    }
}
