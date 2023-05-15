package curso.java.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import curso.java.DAO.AlunoDAO;
import curso.java.R;
import curso.java.model.Aluno;

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
        dao.salva(new Aluno("vini", "123", "OI@OI"));
        dao.salva(new Aluno("teste", "456", "OI@1234"));

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
        final List<Aluno> alunos = dao.todos();
        listaDeAlunos.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, alunos));
        listaDeAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Aluno alunoEscolhido = alunos.get(position);
                Intent vaiParaFormularioActivity = new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class);
                vaiParaFormularioActivity.putExtra("aluno", alunoEscolhido);
                startActivity(vaiParaFormularioActivity);
            }
        });
    }
}