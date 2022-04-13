package ServiceCalculatoare.classes;

public class Processor extends InternalPcPart {
    String socket;
    Integer manufacturingProcess;
    Integer numberOfCores;
    Integer numberOfThreads;
    Integer frequency;

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
}
