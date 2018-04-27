package pe.bazan.jhosep.com.sugarormapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import pe.bazan.jhosep.com.sugarormapp.R;
import pe.bazan.jhosep.com.sugarormapp.adapters.ProductAdapter;
import pe.bazan.jhosep.com.sugarormapp.models.Product;
import pe.bazan.jhosep.com.sugarormapp.repositories.ProductRepository;

public class ContentActivity extends AppCompatActivity {

    private static final String TAG = ContentActivity.class.getSimpleName();

    private RecyclerView productsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        // Configure ReciclerView
        productsList = (RecyclerView) findViewById(R.id.product_list);
        productsList.setLayoutManager(new LinearLayoutManager(this));

        // Set Data Adapter to ReciclerView
        List<Product> products = ProductRepository.list();
        productsList.setAdapter(new ProductAdapter(products));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // refresh data
        ProductAdapter adapter = (ProductAdapter)productsList.getAdapter();

        List<Product> products = ProductRepository.list();
        adapter.setProducts(products);
        adapter.notifyDataSetChanged();

    }
}
