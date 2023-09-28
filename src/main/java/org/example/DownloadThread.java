package org.example;

import org.example.models.FileInfo;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DownloadThread extends Thread {

    Download_Manager manager;
    FileInfo file;

    public DownloadThread(Download_Manager manager, FileInfo file) {
        this.manager = manager;
        this.file = file;
    }

    @Override
    public void run() {
        this.file.setStatus("Downloading");
        this.manager.updateUI(this.file);


        try {
            Files.copy(new URL(this.file.getURL()).openStream(), Paths.get(this.file.getPath()));
            file.setStatus("Done");
        } catch (IOException e) {
            file.setStatus("Failed");
            System.out.println("Downloading Error");
            e.printStackTrace();
        }


        this.manager.updateUI(this.file);
    }
}
