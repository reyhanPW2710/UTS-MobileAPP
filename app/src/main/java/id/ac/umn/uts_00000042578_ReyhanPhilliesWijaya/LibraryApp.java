package id.ac.umn.uts_00000042578_ReyhanPhilliesWijaya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class LibraryApp extends AppCompatActivity implements VideoInterface{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Item> List = new ArrayList<>();

    private BottomSheetDialog hapus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_app);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        hapus = new BottomSheetDialog(this);

        Intent intent = getIntent();
        String message = intent.getExtras().getString("hasil").toString();
        setTitle(message);
        Toast.makeText(getApplicationContext(), getIntent().getStringExtra("hasil").toString(), Toast.LENGTH_SHORT).show();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
        List.add(new Item(R.drawable.ic_video, "ULTIMA SONORA", "Ultima Sonora merupakan UKM Seni Budaya", R.raw.bumper));
        List.add(new Item(R.drawable.ic_video, "VESA RASA 2022", "Vesa Rasa adalah inagurasi 2020", R.raw.bumper1));
        List.add(new Item(R.drawable.ic_video, "US BERDIRI", "Ultima Sonora terbentuk sejak tahun 2007", R.raw.bumper2));
        List.add(new Item(R.drawable.ic_video, "HARSA GANDARA", "Harsa Gandara merupakan Konser Prakompetisi Ultima Sonora ", R.raw.bumper3));
        List.add(new Item(R.drawable.ic_video, "HARSA GANTARI", "Harsa Gantari merupakan kampanye aksi Sosial Ultima Sonora", R.raw.bumper4));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new Adapter(this,List,this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_profil:
                Intent intent = new Intent(LibraryApp.this, Profile.class );
                startActivity(intent);
                return true;
            case R.id.menu_notif:
                Intent home = new Intent(LibraryApp.this, MainActivity.class );
                startActivity(home);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(LibraryApp.this, PlayVideo.class);

        intent.putExtra("JUDUL", List.get(position).getText1());
        intent.putExtra("Deskripsi Video", List.get(position).getText2());
        intent.putExtra("Link Video", List.get(position).getText3());

        startActivity(intent);
    }

    @Override
    public void onDeleteClick(int position) {
        openDialog(position);
        hapus.show();
        hapus.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    public void openDialog(int position) {
        View inflater = getLayoutInflater().inflate(R.layout.hapus, null, false);
        Button buttonYes  = inflater.findViewById(R.id.ya_hapus);
        Button buttonNo  = inflater.findViewById(R.id.tidak_hapus);
        buttonYes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                List.remove(position);
                mAdapter.notifyItemRemoved(position);
                hapus.dismiss();
            }
        });

        buttonNo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                hapus.dismiss();
            }
        });

        hapus.setContentView(inflater);
    }
}