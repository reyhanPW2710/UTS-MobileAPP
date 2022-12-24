package id.ac.umn.uts_00000042578_ReyhanPhilliesWijaya;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class PlayVideo extends AppCompatActivity {
    TextView judul, deskripsi;
    int link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playvideo);

        judul = findViewById(R.id.judul);
        deskripsi = findViewById(R.id.isideskripsi);
        link = getIntent().getIntExtra("Link Video",10);

        String judulvid = getIntent().getStringExtra("JUDUL");
        String deskripsivid = getIntent().getStringExtra("Deskripsi Video");
        judul.setText(judulvid);
        deskripsi.setText(deskripsivid);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(judulvid);
        }

        VideoView videoView = findViewById(R.id.video_view);
        String videoPath = "android.resource://" + getPackageName() + "/" + link;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
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
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menu_profil:
                Intent intent = new Intent(PlayVideo.this, Profile.class );
                startActivity(intent);
                return true;
            case R.id.menu_notif:
                Intent home = new Intent(PlayVideo.this, MainActivity.class );
                startActivity(home);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}


