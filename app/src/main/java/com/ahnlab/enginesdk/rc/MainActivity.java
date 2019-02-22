package com.ahnlab.enginesdk.rc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StringBuffer buffer = new StringBuffer();
        new EngineManagerWrapper().getSignatureVersion(buffer);

        RootCheckElement rootCheckElement = new RootCheckElement.Builder(this).build();
        RootCheckInfo rootCheckInfo = new RootCheckInfo();
        int result = new EngineManagerWrapper().check(rootCheckElement, rootCheckInfo);

        TextView tv = findViewById(R.id.sample_text);
        tv.setText(String.format(Locale.KOREA, "%s\n%s\n%d\n%d\n%s\n%d", buffer.toString(), EngineManagerWrapper.getCurrentABI(), result, rootCheckInfo.getRuleID(), rootCheckInfo.getDescription(), rootCheckInfo.getDetectedType()));
    }
}
