package id.sch.smktelkom_mlg.project.xirpl509182736.soalles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Tampil extends AppCompatActivity {
    TextView tvNama, tvMapel, tvTahun;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);
        setTitle("Soal");
        String judul = getIntent().getStringExtra(BuatSoalActivity.JUDUL);
        tvMapel = (TextView) findViewById(R.id.tvHasilMapel);
        tvNama = (TextView) findViewById(R.id.tvHasilNama);
        tvTahun = (TextView) findViewById(R.id.tvHasilTahun);


    }

}
