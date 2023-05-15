package curso.java;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  Toast.makeText(this, "Vinicius", Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_main);  // R faz mapeamento de todos o layout do projeto
        List<String> alunos = new ArrayList<>(Arrays.asList("Vinicius", "Renan", "Michels", "Alice", "Batata"));
        ListView listaDeAlunos = findViewById(R.id.activity_main_lista_de_alunos);
        listaDeAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunos));
    }
}
