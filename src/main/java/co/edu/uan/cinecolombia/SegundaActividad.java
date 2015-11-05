package co.edu.uan.cinecolombia;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.MediaController;
import android.util.Log;
import java.util.Objects;

public class SegundaActividad extends Activity {
    ProgressDialog pDialog;
    VideoView videoview;
    String URL = "";
    TextView sinopsis;
    String texsinop = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);

        Intent nuevaact=getIntent();
        String pos=nuevaact.getStringExtra("pos");



        Toast.makeText(getApplicationContext(), "presionee " + pos, Toast.LENGTH_SHORT).show();

        videoview = (VideoView) findViewById(R.id.videoView);
        pDialog=new ProgressDialog(SegundaActividad.this);
        sinopsis = (TextView) findViewById(R.id.textView);
switch(Integer.valueOf(pos))
        {
            case 0:
                texsinop="un Aviaodor que le gustaban mucho los aviones, y cn las mujeres era todo un avion";
                sinopsis.setText(texsinop);
                URL ="http://www.mp4point.com/downloads/9de7027baa3f.mp4";
                break;
            case 1:
                texsinop="Batman: No es extraterrestre, es solo humano, no tiene super poderes pero es grandioso";
                sinopsis.setText(texsinop);
                URL ="http://www.mp4point.com/downloads/fe16ba593113.mp4";
                break;
            case 2:
                texsinop="Desde  lo que el viento e llevo no ha habido una pelicula tan romantica como esta, ademas es de vampiros";
                sinopsis.setText(texsinop);
                URL ="http://www.mp4point.com/downloads/bb67d0422381.mp4";
                break;
            case 3:
                texsinop="Harry Potter es la bella ostoria de un mago que queria encontrar a su padre  el Mago GUSTAVO LORGIA";
                sinopsis.setText(texsinop);
                URL ="http://www.mp4point.com/downloads/2ddf2fe4e3d7.mp4";
                break;
        }

        pDialog.setTitle("TRAILER CINE COLOMBIA");
        pDialog.setMessage("Cargando...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        try {
            // Start the MediaController
            MediaController mediaController = new MediaController(SegundaActividad.this);

            mediaController.setAnchorView(videoview);
            // Get the URL from String VideoURL


            Uri video = Uri.parse(URL);
            videoview.setMediaController(mediaController);
            videoview.setVideoURI(video);

        } catch (Exception e) {
            // TODO: handle exception
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        videoview.requestFocus();
        videoview.setOnPreparedListener(new OnPreparedListener() {
            // Close the progress bar and play the video
            @Override
            public void onPrepared(MediaPlayer mp) {
                // TODO Auto-generated method stub
                pDialog.dismiss();
                videoview.start();
            }
        });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_segunda_actividad, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
