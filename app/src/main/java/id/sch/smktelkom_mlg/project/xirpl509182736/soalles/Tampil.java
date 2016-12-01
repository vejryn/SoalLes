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
        int jmlah = getIntent().getIntExtra(BuatSoalActivity.JMLH, 0);


    }

}
