package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import model.Canvas;
import model.ICanvasModel;
import model.Snapshot;
import utility.ReadFile;
import view.IView;

/**
 * controller that takes in model and a view.
 */
public class Controller {
  private ICanvasModel model;
  private IView view;
  private File file;


  /**
   * controller constructor.
   * @parameter model.
   * @parameter view.
   */
  public Controller(ICanvasModel model, IView view) {
    this.model = model;
    this.view = view;
  }

  /**
   * this methods pareses the inFile which is the input File and parses the commands in the file.
   * it sets up the photo album on canvas.
   * @param file, and model.
   */
  public void go(File file) throws IOException {
    ReadFile readFile = new ReadFile();
    readFile.manageFiles(this.model, file); //this parses the file and tell model to execute file commands
    List<Snapshot> snapshots = this.model.getSnapshots();

    try {
      this.view.display(snapshots);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
