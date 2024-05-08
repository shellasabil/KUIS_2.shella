 package com.example.kuis_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private RadioGroup itmRadioGroup, tambahanRadioGroup;

    private RadioButton radioPS5, RadioPS4, RadioPS3, RadioPSVR, radioIndomie, radioMieayam, radioSiomay;
    private Button btnProcess;

    private TextView tvtittle, tvtype, tvtambahan, tvWaktu;
    private EditText etJam;
    // Harga PS
    private final int PS5_PRICE = 10000;
    private final int PS4_PRICE = 8000;
    private final int PS3_PRICE = 5000;
    private final int PSVR_PRICE = 20000;

    // Harga makanan
    private final int INDOME_PRICE = 7000;
    private final int MIE_AYAM_PRICE = 10000;
    private final int SIOMAY_PRICE = 5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup itmRadioGroup = findViewById(R.id.itmRadioGroup);
        RadioGroup tambahanRadioGrup = findViewById(R.id.tambahanRadioGroup);
        EditText etJam = findViewById(R.id.etJam);
        Button btnProcess = findViewById(R.id.btnProcess);

        btnProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int psPrice = 0;
                String selectedPS = "";

                // Hitung harga berdasarkan PS yang dipilih
                int selectedPSId = itmRadioGroup.getCheckedRadioButtonId();
                if (selectedPSId == R.id.radioPS5) {
                    psPrice = PS5_PRICE;
                    selectedPS = "PS5";
                } else if (selectedPSId == R.id.radioPS4) {
                    psPrice = PS4_PRICE;
                    selectedPS = "PS4";
                } else if (selectedPSId == R.id.radioPS3) {
                    psPrice = PS3_PRICE;
                    selectedPS = "PS3";
                } else if (selectedPSId == R.id.radioPSVR) {
                    psPrice = PSVR_PRICE;
                    selectedPS = "PSVR";
                } else {
                    Toast.makeText(MainActivity.this, "Pilih tipe PS", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Hitung harga makanan tambahan yang dipilih
                int tambahanPrice = 0;
                String selectedTambahan = "";
                int selectedTambahanId = tambahanRadioGrup.getCheckedRadioButtonId();
                if (selectedTambahanId == R.id.radioIndomie) {
                    tambahanPrice = INDOME_PRICE;
                    selectedTambahan = "Indomie";
                } else if (selectedTambahanId == R.id.radioMieayam) {
                    tambahanPrice = MIE_AYAM_PRICE;
                    selectedTambahan = "MieAyam";
                } else if (selectedTambahanId == R.id.radioSiomay) {
                    tambahanPrice = SIOMAY_PRICE;
                    selectedTambahan = "Siomay";
                }

                // Validasi waktu yang dimasukkan
                String timeInput = etJam.getText().toString();
                if (timeInput.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Masukkan waktu yang valid", Toast.LENGTH_SHORT).show();
                    return;
                }

                int waktu = 0;
                try {
                    waktu = Integer.parseInt(timeInput);
                    if (waktu <= 0) {
                        Toast.makeText(MainActivity.this, "Masukkan waktu lebih dari 0", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Masukkan angka yang valid", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Hitung total harga
                int totalPrice = (psPrice * waktu) + tambahanPrice;

                // Buat Intent untuk pindah ke InvoiceActivity
                Intent intent = new Intent(MainActivity.this, InvoiceActivity.class);
                intent.putExtra("selectedPS", selectedPS);
                intent.putExtra("selectedTambahan", selectedTambahan);
                intent.putExtra("waktu", waktu);
                intent.putExtra("totalPrice", totalPrice);

                // Untuk debugging, tambahkan log atau toast jika diperlukan
                Toast.makeText(MainActivity.this, "Total Harga: Rp" + totalPrice, Toast.LENGTH_SHORT).show();

                // Pindah ke halaman Invoice
                startActivity(intent);
            }
        });
    }
}