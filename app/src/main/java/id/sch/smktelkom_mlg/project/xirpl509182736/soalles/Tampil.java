package id.sch.smktelkom_mlg.project.xirpl509182736.soalles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Tampil extends AppCompatActivity {

    TextView judul, jmlh, tanggal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);
        setTitle("Soal");
        String judul = getIntent().getStringExtra(BuatSoalActivity.JUDUL);
        int jmlh = getIntent().getIntExtra(BuatSoalActivity.JMLH, 0);
        String tanggal = getIntent().getStringExtra(BuatSoalActivity.TGL);


        TextView judulsoal = (TextView) findViewById(R.id.tvJudul);
        TextView jumlah = (TextView) findViewById(R.id.tvJumlah);
        TextView tgl = (TextView) findViewById(R.id.tvTanggal);

        judulsoal.setText(judul);
        jumlah.setText(jmlh);
        tgl.setText(tanggal);
    }
}



