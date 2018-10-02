package fragchallenge.com.fragchallenge;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.onItemClicked{
    //ArrayList<Person> data;

    TextView tvOwnerName, tvOwnerNumber;            // in frag carname = owner info

    TextView tvCarName;         // in frag car info
    ImageView imgCar;           // in frag car info


    Button btnCarInfo;
    Button btnOwnerInfo;

    FragmentManager fragmentManager;
    Fragment listFrag, CarInfoFrag, OwnerInfoFrag, ButtonFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCarInfo = findViewById(R.id.btnCarInfo);
        btnOwnerInfo = findViewById(R.id.btnOwnerInfo);

        btnCarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .show(CarInfoFrag).hide(OwnerInfoFrag).commit();
            }
        });
        btnOwnerInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager.beginTransaction()
                        .hide(CarInfoFrag).show(OwnerInfoFrag).commit();
            }
        });

        tvOwnerName = findViewById(R.id.tvOwnerName);
        tvOwnerNumber = findViewById(R.id.tvOwnerNumber);
        tvCarName = findViewById(R.id.CarName);
        imgCar = findViewById(R.id.imgCar);



        fragmentManager = getSupportFragmentManager();
        listFrag = fragmentManager.findFragmentById(R.id.ListFrag);
        ButtonFrag = fragmentManager.findFragmentById(R.id.ButtonFrag);
        CarInfoFrag = fragmentManager.findFragmentById(R.id.FragCarIngo);
        OwnerInfoFrag = fragmentManager.findFragmentById(R.id.FragOwnerInfo);

        fragmentManager.beginTransaction()
                .show(listFrag).show(ButtonFrag).show(CarInfoFrag).hide(OwnerInfoFrag).commit();


    }

    @Override
    public void onClick(int index) {
        tvOwnerName.setText(ApplicationClass.data.get(index).getName());
        tvCarName.setText(ApplicationClass.data.get(index).getModelName());
        tvOwnerNumber.setText(ApplicationClass.data.get(index).getNumber());

        if(ApplicationClass.data.get(index).getCarlogo().equals("Volkswagen")) {
            imgCar.setImageResource(R.drawable.volkswagen);
        }
        if(ApplicationClass.data.get(index).getCarlogo().equals("Nissan")) {
            imgCar.setImageResource(R.drawable.nissan);
        }
        if(ApplicationClass.data.get(index).getCarlogo().equals("Mercedes")) {
            imgCar.setImageResource(R.drawable.mercedes);
        }
    }
}
