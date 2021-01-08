package MyHallBooking2;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ConfirmBox
{
    static boolean answer;
    public static boolean display(String title,String message)
    {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);//force user to close it down first
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label(message);

        Button yesBtn = new Button("Yes");
        Button noBtn = new Button("No");

        yesBtn.setOnAction(e -> {
            answer = true;
            window.close();
        });


        noBtn.setOnAction(e -> {
            answer = false;
            window.close();
        });


        VBox layout = new VBox(20);
        layout.getChildren().addAll(label,yesBtn,noBtn);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout,250,200);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}