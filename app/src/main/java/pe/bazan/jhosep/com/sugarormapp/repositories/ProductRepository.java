package pe.bazan.jhosep.com.sugarormapp.repositories;

import com.orm.SugarRecord;

import java.util.List;

import pe.bazan.jhosep.com.sugarormapp.models.Product;

/**
 * Created by Sr. Doge on 27/04/2018.
 */

public class ProductRepository {

    private static List<Product> products;



    public static List<Product> list(){
        products = SugarRecord.listAll(Product.class);
        return products;
    }

    public static Product read(Long id){
        Product product = SugarRecord.findById(Product.class, id);
        return product;
    }

    public static void create(String nombre, String marca, String desc){
        Product product = new Product(nombre, marca, desc);
        SugarRecord.save(product);
    }

    public static void update(String nombre, String marca, String desc, Long id){
        Product product = SugarRecord.findById(Product.class, id);
        product.setProductname(nombre);
        product.setProductmarca(marca);
        product.setProductdesc(desc);
        SugarRecord.save(product);
    }

    public static void delete(Long id){
        Product product = SugarRecord.findById(Product.class, id);
        SugarRecord.delete(product);
    }
}
