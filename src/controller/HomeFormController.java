package controller;

import com.jfoenix.controls.JFXRippler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HomeFormController {

    public JFXRippler rprAddNewStudent;
    public AnchorPane pneAddNewStudent;
    public JFXRippler rprSearchStudents;
    public AnchorPane pneSearchStudents;

    public void initialize() {
        rprAddNewStudent.setControl(pneAddNewStudent);
        rprSearchStudents.setControl(pneSearchStudents);
        pneAddNewStudent.setFocusTraversable(true);
        pneSearchStudents.setFocusTraversable(true);
    }

    public void pneAddNewStudent_OnKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER || keyEvent.getCode() == KeyCode.SPACE) {
            rprAddNewStudent.createManualRipple().run();
        }
    }

    public void pneSearchStudents_OnKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER || keyEvent.getCode() == KeyCode.SPACE) {
            rprSearchStudents.createManualRipple().run();
        }
    }

    public void pneSearchStudents_OnMouseClicked(MouseEvent mouseEvent) {
        navigate("Search Students", "/view/SearchStudentsForm.fxml");
    }

    public void pneAddNewStudent_OnMouseClicked(MouseEvent mouseEvent) throws IOException {
        MainFormController ctrl = (MainFormController) pneAddNewStudent.getScene().getUserData();
        navigate("Add New Student", "/view/StudentForm.fxml");
    }

    public void pneAddNewStudent_OnKeyReleased(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode() == KeyCode.ENTER || keyEvent.getCode() == KeyCode.SPACE) {
            navigate("Add New Student", "/view/StudentForm.fxml");
        }
    }

    public void pneSearchStudents_OnKeyReleased(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER || keyEvent.getCode() == KeyCode.SPACE) {
            navigate("Search Students", "/view/SearchStudentsForm.fxml");
        }
    }

    private void navigate(String title, String url) {
        MainFormController ctrl = (MainFormController) pneSearchStudents.getScene().getUserData();
        ctrl.navigate(title, url, MainFormController.NAV_ICON_BACK, () -> ctrl.navigate("Student Managemant System", "/view/HomeForm.fxml", MainFormController.NAV_ICON_NONE));
    }
}
