package co.edu.uan.cinecolombia;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;



public class MyActivity extends Activity implements View.OnClickListener, OnItemClickListener {

    ListViewAdapter adapter;

    String[] titulo = new String[]{
            "titulo1",
            "titulo2",
            "titulo3",
            "titulo4",
    };

    int[] imagenes = {
            R.drawable.aviator,
            R.drawable.batman,
            R.drawable.crepucsulo,
            R.drawable.harry
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        final ListView lista = (ListView) findViewById(R.id.listView1);
        adapter = new ListViewAdapter(this, titulo, imagenes);
        lista.setAdapter(adapter);
//        lista.setOnClickListener(this);
        lista.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), "presiono " + position, Toast.LENGTH_SHORT).show();

        Intent nuevact=new Intent(MyActivity.this  ,SegundaActividad.class);
        String pos= String.valueOf(position);
        nuevact.putExtra("pos",pos);
        startActivity(nuevact);

    }
}