import javafx.animation.AnimationTimer;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import java.util.ArrayList;


public class Earth extends Group {
        private Rotate r = new Rotate(0, new Point3D(0,1,0));
        private Sphere s = new Sphere(300);
        ArrayList<Sphere> yellowSphere = new ArrayList<>();

        /*public Sphere createSphere(Airports a, Color c){
            Double X,Y,Z;
            X = s.
        }*/

        public Earth() {
            this.getChildren().add(s);
            PhongMaterial pm = new PhongMaterial();
            try {
                Image im = new Image("C/Users/DIARIETOU/IdeaProjects/Resources/earth_lights_4800.png");
                pm.setDiffuseMap(im);
                s.getTransforms().add(r);
                s.setMaterial(pm);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            AnimationTimer anim = new AnimationTimer() {
                double angle = 0;
                @Override
                public void handle(long time) {
                    r.setAngle(time/70000000);
                }
            };
            anim.start();
        }
    }


