package curso.java.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import curso.java.DAO.AlunoDAO;
import curso.java.R;

public class ListaAlunosActivity extends AppCompatActivity {

    public static final String LISTA_APP_BAR = "Lista de Aluno";
    private final AlunoDAO dao = new AlunoDAO();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  Toast.makeText(this, "Vinicius", Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_lista_alunos);  // R faz mapeamento de todos o layout do projeto

        setTitle(LISTA_APP_BAR);

        configuraNovoALuno();

    }

    private void configuraNovoALuno() {
        FloatingActionButton botaNovoAluno = findViewById(R.id.activity_lista_fab_novo_aluno);
        botaNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abriFormularioAlunoActivity();
            }
        });
    }

    private void abriFormularioAlunoActivity() {
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configuraLista();
    }

    private void configuraLista() {
        ListView listaDeAlunos = findViewById(R.id.activity_lista_de_alunos_listview);
        listaDeAlunos.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, dao.todos()));
    }
}
