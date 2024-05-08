package com.example.kuis_2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InvoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        // Temukan komponen UI
        TextView textViewPS = findViewById(R.id.tvTYPE);
        TextView textViewTambahan = findViewById(R.id.tvtambahan);
        TextView textViewWaktu = findViewById(R.id.tvWaktu);
        TextView textViewTotal = findViewById(R.id.tvtotal);

        // Ambil data dari Intent
        String selectedPS = getIntent().getStringExtra("selectedPS");
        String selectedTambahan = getIntent().getStringExtra("selectedTambahan");
        int waktu = getIntent().getIntExtra("waktu", 0);
        int totalPrice = getIntent().getIntExtra("totalPrice", 0);

        // Tampilkan data pada TextView
        textViewPS.setText("Tipe PS: " + selectedPS);
        textViewTambahan.setText("Tambahan Makanan: " + selectedTambahan);
        textViewWaktu.setText("waktu (jam): " + waktu);
        textViewTotal.setText("Total Biaya: Rp" + totalPrice);
    }
}