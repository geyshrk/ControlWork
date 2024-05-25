package main;

public class FileContent {
    private byte[] data;
    private int even;
    private int part;
    public FileContent(byte[] data, int even, int part) {
        this.data = data;
        this.even = even;
        this.part = part;
    }

    public byte[] getData() {
        return data;
    }

    public int getEven() {
        return even;
    }

    public int getPart() {
        return part;
    }
}
