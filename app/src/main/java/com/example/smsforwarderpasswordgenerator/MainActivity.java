package com.example.smsforwarderpasswordgenerator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.smsforwarderpasswordgenerator.tools.copy_helper.CopyHelper;
import com.example.smsforwarderpasswordgenerator.tools.devices.Devices;
import com.example.smsforwarderpasswordgenerator.tools.texttools.TextTools;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CopyHelper.initialize(this).insert(TextTools.base64HighEncoding(Devices.getUniqueId(this)));

    }
}