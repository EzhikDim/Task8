package com.company.lab8;

import utils.*;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class MainForm extends JFrame {
    private JTable firstTable;
    private JButton openButton;
    private JButton deleteButton;
    private JButton saveButton;
    private JTable changedTable;
    private JPanel panel;
    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;


    public MainForm(int[][]matrix){
        this.setTitle("Удаление одинаковых столбцов");
        this.setContentPane(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();

        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        JTableUtils.writeArrayToJTable(firstTable, matrix);

        this.pack();

        openButton.addActionListener(actionEvent -> {
            try {
                if (fileChooserOpen.showOpenDialog(panel) == JFileChooser.APPROVE_OPTION) {
                    int[][] arr = ArrayUtils.readIntArray2FromFile(fileChooserOpen.getSelectedFile().getPath());
                    JTableUtils.writeArrayToJTable(firstTable, arr);
                }
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });



        saveButton.addActionListener(actionEvent -> {
            try {
                if (fileChooserSave.showSaveDialog(panel) == JFileChooser.APPROVE_OPTION) {
                    String file = fileChooserSave.getSelectedFile().getPath();
                    if (!file.toLowerCase().endsWith(".txt")) {
                        file += ".txt";
                    }
                    int[][] arr = JTableUtils.readIntMatrixFromJTable(changedTable);
                    ArrayUtils.writeArrayToFile(file, arr);
                }
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });

        deleteButton.addActionListener(actionEvent -> {
            try {
                int[][] arr = JTableUtils.readIntMatrixFromJTable(firstTable);
                int[][] myArr = Solution.Sort_Vib(arr);
                JTableUtils.writeArrayToJTable(changedTable, myArr);
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });


    }
}
