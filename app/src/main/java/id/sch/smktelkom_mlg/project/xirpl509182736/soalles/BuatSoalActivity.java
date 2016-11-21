package id.sch.smktelkom_mlg.project.xirpl509182736.soalles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BuatSoalActivity extends AppCompatActivity {

    public static final String JUDUL = "judul";
    public static final String JMLH = "jmlh";
    private LinearLayout lnrDynamicEditTextHolder;
    private EditText etJudul, etJumlah;
    private Button bBuat,bNext;
    private TextView tvJudul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_soal);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Buat Soal");
        String mapel = getIntent().getStringExtra(MainActivity.MAPEL);
        String nama = getIntent().getStringExtra(MainActivity.NAMA);
        int tahun = getIntent().getIntExtra(MainActivity.TAHUN, 0);

        TextView tvHasi1l = (TextView) findViewById(R.id.tvhasilMapel);
        tvHasi1l.setText("Mata Pelajaran : " + mapel);
        TextView tvHasil2 = (TextView) findViewById(R.id.tvHasilNama);
        tvHasil2.setText("Nama Pembimbing: " + nama);
        TextView tvHasil3 = (TextView) findViewById(R.id.tvHasilTahun);
        tvHasil3.setText("Tahun Pembuatan Soal : " + tahun);


        lnrDynamicEditTextHolder = (LinearLayout) findViewById(R.id.lnrDynamicEditTextHolder);
        etJudul = (EditText) findViewById(R.id.editTextJudul);
        etJumlah = (EditText) findViewById(R.id.editTextJumlah);
        etJumlah.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "15")});
        bBuat = (Button) findViewById(R.id.buttonBuat);
        tvJudul = (TextView) findViewById(R.id.textViewJudul);

        bBuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String judul = etJudul.getText().toString();

                if (etJumlah.getText().toString().length() > 0) {
                    try {
                        lnrDynamicEditTextHolder.removeAllViews();
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }

                    int length = Integer.parseInt(etJumlah.getText().toString());

                    for (int i = 0; i < length; i++) {
                        EditText etSoal = new EditText(BuatSoalActivity.this);
                        etSoal.setId(i + 1);
                        etSoal.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                        etSoal.setHint("Soal " + (i + 1));
                        lnrDynamicEditTextHolder.addView(etSoal);
                    }
                }
                tvJudul.setText(judul);
            }
        });
        findViewById(R.id.buttonNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String judul = etJudul.getText().toString();
                String jmlhStr = etJumlah.getText().toString();
                int jmlh = jmlhStr.isEmpty() ? 0 : Integer.parseInt(jmlhStr);

                Intent intent = new Intent(BuatSoalActivity.this, Tampil.class);
                intent.putExtra(JUDUL, judul);
                intent.putExtra(JMLH, jmlh);

                startActivity(intent);
                //startActivity(new Intent(MainA
                startActivity(new Intent(BuatSoalActivity.this, Tampil.class));
            }
        });
    }
}