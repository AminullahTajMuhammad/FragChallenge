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
    ArrayList<Person> data;

    TextView tvOwnerName, tvOwnerNumber;            // in frag carname = owner info

    TextView tvCarName;         // in frag car info
    ImageView imgCar;           // in frag car info

    TextView tvListCarName, tvlistOwnerName;        // in list_item layout
    ImageView imgListCarLogo;                       // in list_item layout


    Button btnCarInfo;
    Button btnOwnerInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCarInfo = findViewById(R.id.btnCarInfo);
        btnOwnerInfo = findViewById(R.id.btnOwnerInfo);

        btnCarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceWithCarInfoFragment();
            }
        });
        btnOwnerInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceWithOwnerInfoFragment();
            }
        });

        tvOwnerName = findViewById(R.id.tvOwnerName);
        tvOwnerNumber = findViewById(R.id.tvOwnerNumber);
        tvCarName = findViewById(R.id.CarName);
        tvListCarName = findViewById(R.id.tvListCarName);
        tvlistOwnerName = findViewById(R.id.tvListOwnerName);

        FragmentManager fragmentManager;
        Fragment listFrag, CarinfoFrag, ownerInfoFrag, ButtonFrag;

        fragmentManager = getSupportFragmentManager();
        listFrag = fragmentManager.findFragmentById(R.id.ListFrag);
        ButtonFrag = fragmentManager.findFragmentById(R.id.ButtonFrag);

        fragmentManager.beginTransaction()
                .show(listFrag).show(ButtonFrag).commit();


    }

    void replaceWithCarInfoFragment(){
        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.container, new FragCarInfo());
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the changes added above
        ft.commit();
    }

    void replaceWithOwnerInfoFragment(){
        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.container, new FragCarName());
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the changes added above
        ft.commit();
    }
    @Override
    public void onClick(int index) {
        tvOwnerName.setText(ApplicationClass.data.get(index).getName());
        tvOwnerNumber.setText(ApplicationClass.data.get(index).getNumber());
        tvlistOwnerName.setText(ApplicationClass.data.get(index).getName());
        tvListCarName.setText(ApplicationClass.data.get(index).getModelName());

    }
}
