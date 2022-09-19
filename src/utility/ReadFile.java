package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Scanner;

import model.Canvas;
import model.Color;
import model.ICanvasModel;

/**
 * practicing how to manage files.
 */
public final class ReadFile {


  /**
   * this class manages the file data.
   */
  public static void manageFiles(ICanvasModel model, File in) throws IOException {


    try (Scanner scan = new Scanner(in);
    ) {
      while (scan.hasNextLine()) {
        String[]fileToLines = (scan.nextLine().strip()).split("\\s+");
        switch(fileToLines[0].toLowerCase()) {
          case "#":
            break;
          case "shape":
            
            model.createShape(fileToLines[1],fileToLines[2],
                    Integer.parseInt(fileToLines[3]), Integer.parseInt(fileToLines[4]),
                    Integer.parseInt(fileToLines[5]), Integer.parseInt(fileToLines[6]),
                    Integer.parseInt(fileToLines[7]), Integer.parseInt(fileToLines[8]),
                    Integer.parseInt(fileToLines[9]));
            break;
          case "move":
            model.movesShape(fileToLines[1],Integer.parseInt(fileToLines[2]),
                    Integer.parseInt(fileToLines[3]));
            break;

          case "resize":
            model.changesSize(fileToLines[1],Integer.parseInt(fileToLines[2]),
                    Integer.parseInt(fileToLines[3]));
            break;
          case "color":
            model.changeColorOfTheShape(fileToLines[1],Integer.parseInt(fileToLines[2]),
                    Integer.parseInt(fileToLines[3]),  Integer.parseInt(fileToLines[4]));
            break;

          case "remove":
            model.removesShape(fileToLines[1]);
            break;

          case "snapshot":
            StringBuilder snapDescription = new StringBuilder();
            for (int i = 1; i < fileToLines.length; i++) {
              snapDescription.append(fileToLines[i] + " ");
            }
            model.takeSnapshot(snapDescription.toString());
            break;
        }
      }

    } catch (IOException e) {
      throw e;
    }
  }

}