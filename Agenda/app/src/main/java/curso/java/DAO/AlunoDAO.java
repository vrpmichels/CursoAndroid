package curso.java.DAO;

import java.util.ArrayList;
import java.util.List;

import curso.java.model.Aluno;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList();
    public void salva(Aluno aluno) {alunos.add(aluno);}
    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }
}
