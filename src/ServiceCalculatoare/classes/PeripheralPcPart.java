package ServiceCalculatoare.classes;

public class PeripheralPcPart extends Item{
    protected String connectionInterface;

    public PeripheralPcPart() {
        this.connectionInterface = "connectionInterface";
    }

    public PeripheralPcPart(Integer id, String modelName, String manufacturer, String connectionInterface) {
        super(id, modelName, manufacturer);
        this.connectionInterface = connectionInterface;
    }

    public String getConnectionInterface() {
        return connectionInterface;
    }

    public void setConnectionInterface(String connectionInterface) {
        this.connectionInterface = connectionInterface;
    }
}
