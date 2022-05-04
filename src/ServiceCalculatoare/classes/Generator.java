package ServiceCalculatoare.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Generator {
    ArrayList<Integer> refreshRateList;
    ArrayList<Integer> diagonalList;
    ArrayList<Integer> powerDrown;
    ArrayList<String> modelName;
    ArrayList<String> manufacturer;
    ArrayList<String> layout;
    ArrayList<String> socket;
    ArrayList<String> format;
    ArrayList<String> memoryType;
    ArrayList<String> chipsetName;
    ArrayList<Integer> numberOfSata;
    ArrayList<Integer> numberOfButtons;
    ArrayList<Integer> dpi;
    ArrayList<String> connectionInterface;
    ArrayList<Integer> manufacturingProcess;
    ArrayList<Integer> numberOfCores;
    ArrayList<Integer> frequency;
    ArrayList<Integer> size;

    public Generator() {
        this.refreshRateList = new ArrayList<>(Arrays.asList(60,70,120,144,180));
        this.diagonalList =new ArrayList<>(Arrays.asList(21,23,24,27,32));
        this.powerDrown =new ArrayList<>(Arrays.asList(20,30,50,100,200,300,400,450));
        this.modelName =new ArrayList<>(Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M"));
        this.manufacturer =new ArrayList<>(Arrays.asList("Asus","Acer","Apple","Huawei","Gigabyte","Dell","HP","Intel","AMD"));
        this.layout =new ArrayList<>(Arrays.asList("US","UK","RO","US-UK","FR","ES"));
        this.socket =new ArrayList<>(Arrays.asList("LGA1150","LGA1151","LGA1155","LGA775","AM4","AM3","LGA1700"));
        this.format =new ArrayList<>(Arrays.asList("ATX", "micro-ATX", "mATX","mini-ITX"));
        this.memoryType =new ArrayList<>(Arrays.asList("DDR5","DDR4","DDR3","DDR2","DDR"));
        this.chipsetName =new ArrayList<>(Arrays.asList("A450","B450","X470","B550","X570","H670","B660","H610"));
        this.numberOfSata =new ArrayList<>(Arrays.asList(8,6,4,2));
        this.numberOfButtons =new ArrayList<>(Arrays.asList(8,6,4,2,10,20));
        this.dpi =new ArrayList<>(Arrays.asList(160,240,3200,4800,8000));
        this.connectionInterface =new ArrayList<>(Arrays.asList("USB3.2","USB3.0","USB2.0","USB-c"));
        this.manufacturingProcess =new ArrayList<>(Arrays.asList(22,16,10,7,6,5));
        this.numberOfCores =new ArrayList<>(Arrays.asList(4,6,8,10,12));
        this.frequency =new ArrayList<>(Arrays.asList(2200,2500,3100,3300,3600,3800,4200,4600,4800));
        this.size =new ArrayList<>(Arrays.asList(4,8,16,32,64));
    }

    public boolean generateBool(){
        Random r = new Random();
        int randomInt = r.nextInt(2);
        if(1 == randomInt){
            return true;
        }
        else{
            return false;
        }
    }

    public Integer generateId (){
        Random r = new Random();
        return r.nextInt(10000);
    }

    public Integer generateRefreshRate (){
        Random r = new Random();
        int randomInt = r.nextInt(refreshRateList.size());
        return refreshRateList.get(randomInt);
    }

    public Integer generatEdiagonalList (){
        Random r = new Random();
        int randomInt = r.nextInt(diagonalList.size());
        return diagonalList.get(randomInt);
    }

    public Integer generatePowerDrown (){
        Random r = new Random();
        int randomInt = r.nextInt(powerDrown.size());
        return powerDrown.get(randomInt);
    }

    public String generateModelName(){
        Random r = new Random();
        int randomInt = r.nextInt(modelName.size());
        return modelName.get(randomInt);
    }

    public String generateManufacturer (){
        Random r = new Random();
        int randomInt = r.nextInt(manufacturer.size());
        return manufacturer.get(randomInt);
    }

    public String generateLayout (){
        Random r = new Random();
        int randomInt = r.nextInt(layout.size());
        return layout.get(randomInt);
    }

    public String generateSocket (){
        Random r = new Random();
        int randomInt = r.nextInt(socket.size());
        return socket.get(randomInt);
    }

    public String generateFormat(){
        Random r = new Random();
        int randomInt = r.nextInt(format.size());
        return format.get(randomInt);
    }

    public String generateMemoryType (){
        Random r = new Random();
        int randomInt = r.nextInt(memoryType.size());
        return memoryType.get(randomInt);
    }

    public String generateChipsetName (){
        Random r = new Random();
        int randomInt = r.nextInt(chipsetName.size());
        return chipsetName.get(randomInt);
    }

    public Integer generateNumberOfSata(){
        Random r = new Random();
        int randomInt = r.nextInt(numberOfSata.size());
        return numberOfSata.get(randomInt);
    }

    public Integer generateNumberOfButtons (){
        Random r = new Random();
        int randomInt = r.nextInt(numberOfButtons.size());
        return numberOfButtons.get(randomInt);
    }

    public Integer generateDpi (){
        Random r = new Random();
        int randomInt = r.nextInt(dpi.size());
        return dpi.get(randomInt);
    }

    public String generateConnectionInterface (){
        Random r = new Random();
        int randomInt = r.nextInt(connectionInterface.size());
        return connectionInterface.get(randomInt);
    }

    public Integer generateManufacturingProcess(){
        Random r = new Random();
        int randomInt = r.nextInt(manufacturingProcess.size());
        return manufacturingProcess.get(randomInt);
    }

    public Integer generateNumberOfCores (){
        Random r = new Random();
        int randomInt = r.nextInt(numberOfCores.size());
        return numberOfCores.get(randomInt);
    }

    public Integer generateFrequency (){
        Random r = new Random();
        int randomInt = r.nextInt(frequency.size());
        return frequency.get(randomInt);
    }

    public Integer generateSize (){
        Random r = new Random();
        int randomInt = r.nextInt(size.size());
        return size.get(randomInt);
    }


}
