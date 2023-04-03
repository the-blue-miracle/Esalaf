import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu fileMenu;

    @FXML
    private MenuItem openMenuItem;

    @FXML
    private MenuItem saveMenuItem;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        openMenuItem.setOnAction(event -> openFile());
        saveMenuItem.setOnAction(event -> saveFile());
    }

    private void openFile() {
        // Code pour ouvrir un fichier
    }

    private void saveFile() {
        // Code pour sauvegarder un fichier
    }
}
