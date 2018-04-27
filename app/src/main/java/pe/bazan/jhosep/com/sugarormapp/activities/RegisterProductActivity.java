package pe.bazan.jhosep.com.sugarormapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import pe.bazan.jhosep.com.sugarormapp.R;
import pe.bazan.jhosep.com.sugarormapp.repositories.ProductRepository;

public class RegisterProductActivity extends AppCompatActivity {

    private static final int REGISTER_FORM_REQUEST = 100;

    private EditText name_productInput;
    private EditText marca_productInput;
    private EditText desc_productInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_product);

        name_productInput = (EditText)findViewById(R.id.name_productinput);
        marca_productInput = (EditText)findViewById(R.id.marca_productinput);
        desc_productInput = (EditText)findViewById(R.id.desc_productinput);
    }

    public void callRegister(View view){
        String nameproduct = name_productInput.getText().toString();
        String marcaproduct = marca_productInput.getText().toString();
        String descproduct = desc_productInput.getText().toString();

        if(nameproduct.isEmpty() || marcaproduct.isEmpty() || descproduct.isEmpty()){
            Toast.makeText(this, "You must complete these fields", Toast.LENGTH_SHORT).show();
            return;
        }

        ProductRepository.create(nameproduct, marcaproduct, descproduct);

        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_welcome, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_new:
                startActivityForResult(new Intent(this, RegisterProductActivity.class), REGISTER_FORM_REQUEST);
                return true;
            case R.id.action_list:
                Intent intent1 = new Intent(this, ContentActivity.class);
                startActivity(intent1);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
