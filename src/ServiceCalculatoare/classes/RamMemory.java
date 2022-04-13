package ServiceCalculatoare.classes;

public class RamMemory extends InternalPcPart{
    Integer size;
    String MemoryType;
    Integer frequency;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getMemoryType() {
        return MemoryType;
    }

    public void setMemoryType(String memoryType) {
        MemoryType = memoryType;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}
