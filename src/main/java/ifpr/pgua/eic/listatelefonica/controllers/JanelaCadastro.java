package ifpr.pgua.eic.listatelefonica.controllers;

import java.net.URL;
import java.util.ResourceBundle;


import ifpr.pgua.eic.listatelefonica.models.repositories.ContatoRespository;
import ifpr.pgua.eic.listatelefonica.models.results.Result;
import ifpr.pgua.eic.listatelefonica.models.results.SuccessResult;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class JanelaCadastro implements Initializable {
    
    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfEmail;


    private ContatoRespository repositorio;

    public JanelaCadastro(ContatoRespository repositorio){
        this.repositorio = repositorio;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }

    @FXML
    private void cadastrar(ActionEvent evento){
        String nome = tfNome.getText();
        String email = tfEmail.getText();
        String telefone = tfTelefone.getText();

        Result resultado = repositorio.cadastrar(nome, email, telefone);

        String msg = resultado.getMsg();

        if(resultado instanceof SuccessResult){
            limpar();
        }

        Alert alert = new Alert(AlertType.INFORMATION,msg);
        alert.showAndWait();

        /*if(!email.contains("@")){
            tfEmail.getStyleClass().add("erro-textfield");
            return;
        }
        if(!listaTelefonica.adicionarContato(nome, telefone, email)){
            msg = "Cadastro não realizado!";
        }else{
            limpar();
        }*/

        //String msg = "Cadstro realizado!";
        

    }

    private void limpar(){
        tfNome.clear();
        tfEmail.clear();
        tfTelefone.clear();
    }


}
