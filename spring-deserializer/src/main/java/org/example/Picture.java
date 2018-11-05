package org.example;

public class Picture {
    
    private String title;
    private FileProxy file;
    private int year;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FileProxy getFile() {
        return file;
    }

    public void setFile(FileProxy file) {
        this.file = file;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
