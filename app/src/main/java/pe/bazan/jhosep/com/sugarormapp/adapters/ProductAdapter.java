package pe.bazan.jhosep.com.sugarormapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.bazan.jhosep.com.sugarormapp.R;
import pe.bazan.jhosep.com.sugarormapp.models.Product;

/**
 * Created by Sr. Doge on 27/04/2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<Product> products;

    public ProductAdapter(List<Product> products){
        this.products = products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView picture;
        public TextView name_product;
        public TextView marca_product;
        public TextView desc_product;

        public ViewHolder(View itemView) {
            super(itemView);
            picture = (ImageView) itemView.findViewById(R.id.picture_image);
            name_product = (TextView) itemView.findViewById(R.id.name_product_text);
            marca_product = (TextView) itemView.findViewById(R.id.marca_product_text);
            desc_product = (TextView) itemView.findViewById(R.id.desc_product_text);
        }
    }

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ViewHolder viewHolder, int position) {
        Product product = this.products.get(position);
        viewHolder.name_product.setText(product.getProductname());
        viewHolder.marca_product.setText(product.getProductmarca());
        viewHolder.desc_product.setText(product.getProductdesc());

    }

    @Override
    public int getItemCount() {
        return this.products.size();
    }
}
