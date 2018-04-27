package pe.bazan.jhosep.com.sugarormapp.models;

import com.orm.dsl.Table;

@Table
public class Product {

    private Long id_p;
    private String productname;
    private String productmarca;
    private String productdesc;

    public Product(){

    }

    public Product(String productname, String productmarca, String productdesc) {
        this.productname = productname;
        this.productmarca = productmarca;
        this.productdesc = productdesc;
    }

    public Long getId_p() {
        return id_p;
    }

    public void setId_p(Long id_p) {
        this.id_p = id_p;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductmarca() {
        return productmarca;
    }

    public void setProductmarca(String productmarca) {
        this.productmarca = productmarca;
    }

    public String getProductdesc() {
        return productdesc;
    }

    public void setProductdesc(String productdesc) {
        this.productdesc = productdesc;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id_p=" + id_p +
                ", productname='" + productname + '\'' +
                ", productmarca='" + productmarca + '\'' +
                ", productdesc='" + productdesc + '\'' +
                '}';
    }
}
