package main;

import java.io.*;
import java.util.List;

public class ReadTask implements Runnable{
    private final File file;
    private final List<FileContent> files;
    public ReadTask(File file, List<FileContent> files) {
        this.file = file;
        this.files = files;
    }
    public void run() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            int sz = dis.readInt();
            byte[] data = dis.readNBytes(sz);
            int even = dis.readInt();
            int part = dis.readInt();
            System.out.println(ControlWork.checkEven(data, even));
            files.add(new FileContent(data, even, part));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
