package curso.java;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  Toast.makeText(this, "Vinicius", Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_main);
    }
}
