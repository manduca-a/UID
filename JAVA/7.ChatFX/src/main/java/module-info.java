module com.example.chatfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.datatransfer;


    opens com.example.chatfx to javafx.fxml;
    exports com.example.chatfx;
}