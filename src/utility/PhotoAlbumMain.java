package utility;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import controller.Controller;
import model.Canvas;
import model.ICanvasModel;
import view.GraphicalView;
import view.IView;
import view.WebView;

/**
 * this Class is an entry point to the photo album display.
 * It includes the main method.
 */
public class PhotoAlbumMain {

  /**
   * this is the entry point of the photo album.
   */
  public static void main(String[] args) throws IOException {
    List<String> commandArgs = new ArrayList<>();
    String inputFile = "";
    String outputFile = "";
    String viewType = "";
    String width = null;
    String height = null;

    // below loop parses the command line arguments.
    for(String argument : args)
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-in")) {
        inputFile = args[++i];
      } else if (args[i].equals("-out")) {
         outputFile =  args[++i];
      } else if (args[i].equals("-v") || args[i].equals("view")) {
        viewType = args[++i];
      } else if (args[i].matches("\\d+")) {
        width = args[i];
        height = args[++i];
      }
    }

    ICanvasModel model = new Canvas();
    IView view;
    File fileIn = new File(inputFile);

    if(viewType.equalsIgnoreCase("web")) {
      view = new WebView();
      view.setOutputFile(outputFile);
      if (width != null) {
        view.setxMax(Integer.parseInt(width));}
      else if(height != null) {
        view.setyMax(Integer.parseInt(height));}
    } else if (viewType.equalsIgnoreCase("graphical")) {
      view = new GraphicalView();
      view.setOutputFile(outputFile);
      if (width != null) {
      view.setxMax(Integer.parseInt(width));}
      else if(height != null) {
      view.setyMax(Integer.parseInt(height));}
    } else {
      throw new IllegalArgumentException("the view you specified does not exist");
    }

      try {
        Controller controller = new Controller(model, view);
        controller.go(fileIn);
      } catch (IOException e) {
        System.out.println("no input file was found");
      }
  }

}
