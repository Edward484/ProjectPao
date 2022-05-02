package ServiceCalculatoare;

import ServiceCalculatoare.service.PcShopServices;

public class main {
    public static void main(String[] args) {
        PcShopServices service = new PcShopServices();
        service.addNewItemToStore();
    }
}
