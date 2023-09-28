package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.config.AppConfig;
import org.example.models.FileInfo;

import java.io.File;

public class Download_Manager {

    @FXML
    private TextField downloadURL;

    @FXML
    private TableView<FileInfo> tableView;

    public int index=0;
    @FXML
    void downloadButtonClicked(MouseEvent event) {

            String fileURL = downloadURL.getText().trim();
            String fileName = fileURL.substring(fileURL.lastIndexOf('/')+1);
            String fileStatus = "Starting";
            String fileAction = "OPEN";
            String filePath = AppConfig.downloadPath + File.separator + fileName;
            FileInfo file = new FileInfo((index+1)+"",fileName,fileURL,fileStatus,fileAction,filePath);
            this.index = this.index+1;
            DownloadThread thread = new DownloadThread(this,file);
            this.tableView.getItems().add(file);
            thread.start();
            downloadURL.setText("");

    }

    public void updateUI(FileInfo metaFile) {
        System.out.println(metaFile.toString());
        FileInfo fileInfo = this.tableView.getItems().get(Integer.parseInt(metaFile.getIndex())-1);
        fileInfo.setStatus(metaFile.getStatus());
        this.tableView.refresh();
    }

    @FXML
    public void initialize(){
        System.out.println("View Updated");
        TableColumn<FileInfo,String> Sno = (TableColumn<FileInfo, String>) this.tableView.getColumns().get(0);
        Sno.setCellValueFactory(p->{
            return p.getValue().indexProperty();
        });

        TableColumn<FileInfo,String> fileName = (TableColumn<FileInfo, String>) this.tableView.getColumns().get(1);
        fileName.setCellValueFactory(p->{
            return p.getValue().nameProperty();
        });

        TableColumn<FileInfo,String> fileURL = (TableColumn<FileInfo, String>) this.tableView.getColumns().get(2);
        fileURL.setCellValueFactory(p->{
            return p.getValue().URLProperty();
        });

        TableColumn<FileInfo,String> fileStatus = (TableColumn<FileInfo, String>) this.tableView.getColumns().get(3);
        fileStatus.setCellValueFactory(p->{
            return p.getValue().statusProperty();
        });

        TableColumn<FileInfo,String> fileAction = (TableColumn<FileInfo, String>) this.tableView.getColumns().get(4);
        fileAction.setCellValueFactory(p->{
            return p.getValue().actionProperty();
        });

    }
}
