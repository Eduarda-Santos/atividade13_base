package ifpr.pgua.eic.listatelefonica.models.repositories;

import java.security.DrbgParameters.Reseed;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ifpr.pgua.eic.listatelefonica.models.Contato;
import ifpr.pgua.eic.listatelefonica.models.daos.ContatoDAO;
import ifpr.pgua.eic.listatelefonica.models.results.Result;

public class ContatoRespository {
    
    private ContatoDAO dao;

    public ContatoRespository(ContatoDAO dao) {
        this.dao = dao;
    }

    public Result cadastrar(String nome, String email, String telefone){
        //se email nao contem @
        if(!email.contains("@")){
            return Result.fail("E-mail invalido");
        }
        Contato contato = new Contato(nome, email, telefone);
        return dao.inserir(contato);
    }

    public List<Contato> listar(){
        return dao.buscarTodos();
    }
    //DAO filtrar por nome
    public List<Contato> filtrarPorNome(String nome){
        return Collections.emptyList();
    }
    
}
