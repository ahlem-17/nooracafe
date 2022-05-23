package noora.demo.global;

import java.util.ArrayList;
import java.util.List;

import noora.demo.Entity.Product;

public class GlobalData {
    
    public static List<Product> cart;
    static {
        cart = new ArrayList<Product>();
    }
    
}
