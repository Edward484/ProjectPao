package ServiceCalculatoare.classes;

public class GamingMonitor extends PeripheralPcPart implements Monitor{
    Integer refreshRate;
    Integer diagonal;

    @Override
    public Integer GetRefreshRate() {
        return refreshRate;
    }


    @Override
    public Integer GetDisplaySize() {
        return diagonal;
    }

}
