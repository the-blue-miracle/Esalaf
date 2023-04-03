package com.example.esalaf;

import com.exemple.model.Credit;
import com.exemple.model.CreditDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreditController implements Initializable {
    @FXML
    private TextField nom;

    @FXML
    private TextField montant;


    @FXML
    private TableView<Credit> mytab;

    @FXML
    private TableColumn<Credit, Long> col_id;

    @FXML
    private TableColumn<Credit, String> col_nom;


    @FXML
    protected void onSaveButtonClick(){

        Credit cre = new Credit(0l , nom.getText() , tele.getText());

        try {
            CreditDAO credao = new CreditDAO();

            credao.save(cre);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        UpdateTable();

    }
    @FXML
    private void onDeleteButtonClick() {
        Credit selectedCredit = mytab.getSelectionModel().getSelectedItem();
        if (selectedClient == null) {
            // No item selected, display error message
            System.out.println("Error: no item selected for deletion");
            return;
        }
        try {
            CreditDAO creditDAO = new CreditDAO();
            creditDAO.delete(selectedCredit);
            UpdateTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onUpdateButtonClick() {

        Credit selecteCredit = mytab.getSelectionModel().getSelectedItem();

        if (selecteClient == null) {
            // No item selected, display error message
            System.out.println("Error: no item selected for update");
            return;
        }

        try {
            CreditDAO creditDAO = new CreditDAO();

            // Update the credit  object with the new data
            selecteCredit.setNom(nom.getText());
            selecteCredit.setMontant(montant.getText());

            creditDAO.update(selecteCredit);

            UpdateTable();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



    public void UpdateTable(){
        col_id.setCellValueFactory(new PropertyValueFactory<Credit,Long>("id_client"));
        col_nom.setCellValueFactory(new PropertyValueFactory<Credit,String>("nom"));
        col_montant.setCellValueFactory(new PropertyValueFactory<Credit,String>("montant"));


        mytab.setItems(getDataCredits());
    }

    public static ObservableList<Credit> getDataCredits(){

        CreditDAO credao = null;

        ObservableList<Credit> listfx = FXCollections.observableArrayList();

        try {
            credao = new CreditDAO();
            for(Credit ettemp : credao.getAll())
                listfx.add(ettemp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listfx ;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UpdateTable();
    }
}
