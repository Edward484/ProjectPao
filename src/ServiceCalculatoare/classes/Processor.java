package ServiceCalculatoare.classes;

public class Processor extends InternalPcPart implements Comparable<Item> {
    String socket;
    Integer manufacturingProcess;
    Integer numberOfCores;
    Integer numberOfThreads;
    Integer frequency;

    public Processor(Integer id, String modelName, String manufacturer, Integer powerDrown) {
        super(id, modelName, manufacturer, powerDrown);
    }

    public Processor(Integer id, String modelName, String manufacturer, Integer powerDrown,
                     String socket, Integer manufacturingProcess, Integer numberOfCores,
                     Integer numberOfThreads, Integer frequency) {
        super(id, modelName, manufacturer, powerDrown);
        this.socket = socket;
        this.manufacturingProcess = manufacturingProcess;
        this.numberOfCores = numberOfCores;
        this.numberOfThreads = numberOfThreads;
        this.frequency = frequency;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public Integer getManufacturingProcess() {
        return manufacturingProcess;
    }

    public void setManufacturingProcess(Integer manufacturingProcess) {
        this.manufacturingProcess = manufacturingProcess;
    }

    public Integer getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(Integer numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public Integer getNumberOfThreads() {
        return numberOfThreads;
    }

    public void setNumberOfThreads(Integer numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Processor{" +
                "id=" + id +
                ",powerDrown=" + powerDrown +
                ", modelName='" + modelName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", socket='" + socket + '\'' +
                ", manufacturingProcess=" + manufacturingProcess +
                ", numberOfCores=" + numberOfCores +
                ", numberOfThreads=" + numberOfThreads +
                ", frequency=" + frequency +
                '}';
    }



    @Override
    public int compareTo(Item u) {
        Processor o = (Processor) u;
        int r = numberOfCores.compareTo(o.numberOfCores);
        if(r == 0)
            return frequency.compareTo(o.frequency);
        return r;
    }
}
