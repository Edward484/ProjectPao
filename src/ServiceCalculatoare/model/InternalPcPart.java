package ServiceCalculatoare.model;

public abstract class InternalPcPart extends Item{
    protected Integer powerDrown;

    public InternalPcPart(Integer id, String modelName, String manufacturer) {
        super(id, modelName, manufacturer);
    }

    public InternalPcPart(Integer id, String modelName, String manufacturer, Integer powerDrown) {
        super(id, modelName, manufacturer);
        this.powerDrown = powerDrown;
    }

    public Integer getPowerDrown() {
        return powerDrown;
    }

    public void setPowerDrown(Integer powerDrown) {
        this.powerDrown = powerDrown;
    }

}
