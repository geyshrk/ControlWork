package main;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControlWork {
    public static void main(String[] args) throws IOException {
        List<FileContent> files = new ArrayList<>();
        File dir = new File("/Users/misha/IdeaProjects/apps/NotTest/Test/src/main/resources/v22");
        Thread[] threads = new Thread[dir.listFiles().length];
        File[] listFiles = dir.listFiles();
        FileOutputStream fileOutputStream = new FileOutputStream("v22.png", true);
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new ReadTask(listFiles[i], files));
        }
        Arrays.stream(threads).forEach(Thread::start);
        Arrays.stream(threads).forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        files.sort((x, y) -> x.getPart() - y.getPart());
        for (FileContent file : files) {
            fileOutputStream.write(file.getData());
        }
    }
    public static boolean checkEven(byte[] data, int even){
        int oneCount = 0;
        byte[] copyData = new byte[data.length];
        System.arraycopy(data, 0, copyData, 0, data.length);
        for (int i = 0; i < data.length; i++) {
            while (copyData[i] != 0){
                oneCount += copyData[i] % 2;
                copyData[i] /= 2;
            }
        }
        return even == oneCount % 2;
    }
}
