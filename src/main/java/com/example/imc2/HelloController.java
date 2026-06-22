package com.example.imc2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML
    private TextField txtPeso;
    @FXML
    private TextField txtAltura;
    @FXML
    private Label lblResultado;

    @FXML
    public void calcularIMC() {
        double peso = Double.parseDouble(txtPeso.getText());
        double altura = Double.parseDouble(txtAltura.getText());

        imcCalculado = peso / (altura * altura);

        lblResultado.setText(
                String.format("IMC: %.2f", imcCalculado)
        );
    }

    @FXML
    private Label welcomeText;

    @FXML private TableView tabela;
    @FXML private TableColumn colNome;
    @FXML private TableColumn colEmail;
    @FXML private TableColumn colImc;
    @FXML private TableColumn colStatus;
    @FXML private TextField inputName;
    @FXML private TextField inputEmail;
    @FXML private double imcCalculado;
    ObservableList lista;

    @FXML
    public void initialize() {
        colNome.setCellValueFactory(
                new PropertyValueFactory<>("nome")
        );

        colEmail.setCellValueFactory(
                new PropertyValueFactory<>("email")
        );

        colImc.setCellValueFactory(
                new PropertyValueFactory<>("imc")
        );

        colStatus.setCellValueFactory(
                new PropertyValueFactory<>("status")
        );

        lista = FXCollections.observableArrayList(
                new Usuario("Maria", "maria@email.com", 21.3, "normal"),
                new Usuario("João", "joao@email.com", 21.3, "normal")
        );
        tabela.setItems(lista);
        colEmail.setText("E-mail");
        colNome.setText("Nome");
        colImc.setText("Imc");
        colStatus.setText("Status");
    }

    @FXML
    protected void onHelloButtonClick() {

        String nome = inputName.getText();
        String email = inputEmail.getText();
        String status;

        double peso = Double.parseDouble(txtPeso.getText());
        double altura = Double.parseDouble(txtAltura.getText());

        double imc = peso / (altura * altura);

        imc = Math.round(imc * 10.0) / 10.0;

        lblResultado.setText(
                String.format("IMC: %.1f", imc)
        );

        if(imc<18.5){
            status = "abaixo do peso";
        }else if(imc<24.9){
            status = "normal";
        }else
            status = "sobrepeso";

        lista.add(new Usuario(nome, email, imc, status));
    }

}
