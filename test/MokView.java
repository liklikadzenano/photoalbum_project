import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import model.IShape;
import model.Snapshot;
import view.IView;

public class MokView implements IView {
  private static final List<List>shapes = new ArrayList<>();

  @Override
  public void display(List<Snapshot> snapshot) throws IOException {

    for(int i = 0; i < snapshot.size(); i++) {
      shapes.add(snapshot.get(i).getShapesOnCanvas());
    }


  }

  @Override
  public void setxMax(int xMax) {

  }

  @Override
  public void setOutputFile(String outputFile) {

  }

  @Override
  public void setyMax(int yMax) {

  }

  /**
   * returns the list of shapes.
   * @return
   */
  public List<List> getShapes() {
    return shapes;
  }
}
