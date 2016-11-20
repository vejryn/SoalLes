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
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class BuatSoalActivity extends AppCompatActivity {

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
        etJumlah.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "15")});
        bBuat = (Button) findViewById(R.id.buttonBuat);
        bNext = (Button) findViewById(R.id.buttonNext);
        tvJudul = (TextView) findViewById(R.id.textViewJudul);

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuatSoalActivity.this, Tampil.class));
            }
        });

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

                        EditText etJawab = new EditText(BuatSoalActivity.this);
                        etJawab.setId(i + 1);
                        etJawab.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                        etJawab.setHint("Jawaban " + (i + 1));
                        lnrDynamicEditTextHolder.addView(etJawab);
                    }
                }
                tvJudul.setText(judul);
            }
        });
    }
}