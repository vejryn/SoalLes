package id.sch.smktelkom_mlg.project.xirpl509182736.soalles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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


        lnrDynamicEditTextHolder = (LinearLayout) findViewById(R.id.lnrDynamicEditTextHolder);
        etJudul = (EditText) findViewById(R.id.editTextJudul);
        etJumlah = (EditText) findViewById(R.id.editTextJumlah);
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
                startActivity(new Intent(BuatSoalActivity.this, Tampil.class));
            }
        });
    }
}