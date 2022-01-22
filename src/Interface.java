import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;


public class Interface extends Application {
    private Double mouseposX = 0.0;
    private Double mouseposY = 0.0;
    private Translate tz;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello world");
        Earth root = new Earth();
        Pane pane = new Pane(root);
        Scene theScene = new Scene(pane, 600, 400,false);
        theScene.setFill(new ImagePattern(new Image("file:ressources_java/téléchargement.png")));
        primaryStage.setScene(theScene);
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-1000);
        camera.setNearClip(0.1);
        camera.setFarClip(2000.0);
        camera.setFieldOfView(35);
        theScene.setCamera(camera);
        theScene.addEventHandler(MouseEvent.ANY, event -> {
            //    if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
            //        System.out.println("Clicked on : ("+ event.getSceneX()+ ", "+ event.getSceneY()+")");
            //  }
            if (event.getButton()== MouseButton.SECONDARY && event.getEventType()==MouseEvent.MOUSE_CLICKED) {
                PickResult pickResult = event.getPickResult();
                Double getX = 0.0;
                Double getY = 0.0;
                Double longitude = 0.0;
                Double latitude = 0.0;
                Airports near;
                if (pickResult.getIntersectedNode() != null) {
                    getX = pickResult.getIntersectedTexCoord().getX();
                    getY = pickResult.getIntersectedTexCoord().getY();
                    longitude = 360*(getX-0.5);
                    latitude = Math.toDegrees(Math.atan(Math.exp((0.5-getY)/0.2678)-Math.PI/2));
                    System.out.println("long="+longitude + " lat=" + latitude);
                    World w = new World("ressources_java/airport-codes_no_comma.csv");
                    near = w.findNearestAirport(longitude, latitude);
                    System.out.println(near);
                    root.displayRedSphere(near);
                }
            }
        });
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }

}
