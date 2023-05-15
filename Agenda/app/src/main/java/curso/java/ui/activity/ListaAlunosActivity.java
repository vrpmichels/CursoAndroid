package curso.java.ui.activity;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import curso.java.R;

public class ListaAlunosActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  Toast.makeText(this, "Vinicius", Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_lista_alunos);  // R faz mapeamento de todos o layout do projeto
        setTitle("Lista de Aluno");
        List<String> alunos = new ArrayList<>(Arrays.asList("Vinicius", "Renan", "Michels", "Alice", "Batata"));
        ListView listaDeAlunos = findViewById(R.id.activity_lista_de_alunos_listview);
        listaDeAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunos));
    }
}
