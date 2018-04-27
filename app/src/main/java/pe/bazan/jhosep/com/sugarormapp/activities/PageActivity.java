package pe.bazan.jhosep.com.sugarormapp.activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import pe.bazan.jhosep.com.sugarormapp.R;

public class PageActivity extends AppCompatActivity {

    private static final int REGISTER_FORM_REQUEST = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
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
            case R.id.action_register:
                startActivityForResult(new Intent(this, RegisterProductActivity.class), REGISTER_FORM_REQUEST);
            case R.id.action_list:
                Intent intent = new Intent(this, ContentActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
