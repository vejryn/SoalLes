package id.sch.smktelkom_mlg.project.xirpl509182736.soalles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etTahun, etMapel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNama = (EditText) findViewById(R.id.editTextNama);
        etTahun = (EditText) findViewById(R.id.editTextTahun);
        etMapel = (EditText) findViewById(R.id.editTextMapel);

        setTitle("Soal");
        findViewById(R.id.btnBuatSoal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProses();

                startActivity(new Intent(MainActivity.this, BuatSoalActivity.class));
            }
        });
    }

    private void doProses() {
        if (isValid()) {
            String mapel = etMapel.getText().toString();
            String nama = etNama.getText().toString();
            int tahun = Integer.parseInt(etTahun.getText().toString());
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String mapel = etMapel.getText().toString();
        String nama = etNama.getText().toString();
        String tahun = etTahun.getText().toString();

        if (mapel.isEmpty()) {
            etMapel.setError("Mohon Isikan Mata Pelajaran Anda");
            valid = false;
        } else if (mapel.length() < 2) {
            etMapel.setError("Mata Pelajaran Minimal 2 karakter");
            valid = false;
        } else {
            etMapel.setError(null);
        }

        if (nama.isEmpty()) {
            etNama.setError("Mohon Isikan Nama Anda");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama Minimal 3 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (tahun.isEmpty()) {
            etTahun.setError("Mohon Isikan Tahun Pembuatan Soal Anda");
            valid = false;
        } else if (tahun.length() != 4) {
            etTahun.setError("Format Tahun Pembuatan Soal Bukan yyyy");
            valid = false;
        } else {
            etTahun.setError(null);
        }
        return valid;
    }
}
