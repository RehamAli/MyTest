package rehamali.mytest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);


        final EditText id = (EditText) findViewById(R.id.idText);
        final EditText name = (EditText) findViewById(R.id.nameText);
        final EditText model = (EditText) findViewById(R.id.modelText);
        final CheckBox status = (CheckBox) findViewById(R.id.isNew);

        Button add = (Button) findViewById(R.id.button);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Car car = new Car();
                car.setId(id.getText().toString());
                car.setName(name.getText().toString());
                car.setModel(model.getText().toString());
                car.setStatus(status.isChecked());

                Realm realm = Realm.getInstance(getApplicationContext());

                realm.beginTransaction();
                realm.copyToRealmOrUpdate(car);
                realm.commitTransaction();

                Toast.makeText(Activity3.this,"Done" ,Toast.LENGTH_SHORT).show();
                finish();


                //Intent i = new Intent(getApplicationContext(),Activity2.class);
                // startActivity(i);

            }
        });


            }

    }

