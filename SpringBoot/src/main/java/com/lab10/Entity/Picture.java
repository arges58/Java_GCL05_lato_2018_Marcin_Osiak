package com.lab10.Entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class Picture {

    private int index;
    private String name;
    private String resolution;
    private long size;
    private String created;
    private BasicFileAttributes basicFileAttributes;
    private BufferedImage bufferedImage;

    public Picture(int index, String name, String resolution, long size, String created) {
        this.index = index;
        this.name = name;
        this.resolution = resolution;
        this.size = size;
        this.created = created;
    }

    public Picture(String path, int index) throws IOException {

        this.index = index;
        this.name = getFileName(path);
        this.resolution = getFileResolution(path);
        this.size = getFileSize(path);
        this.created = getFileCreationDate(path);

    }
    public String getFileCreationDate(String path) throws IOException{
        Path file = Paths.get(path);
        basicFileAttributes = Files.readAttributes(file, BasicFileAttributes.class);
        return (String.valueOf(basicFileAttributes.creationTime()));
    }
    public long getFileSize(String path) throws IOException{
        Path file = Paths.get(path);
        basicFileAttributes = Files.readAttributes(file, BasicFileAttributes.class);
        return basicFileAttributes.size();
    }
    public String getFileName(String path){
        Path file = Paths.get(path);
        return (file.getFileName().toString());
    }
    public String getFileResolution(String path) throws IOException{
        bufferedImage = ImageIO.read(new File(path));
        String width = Integer.toString(bufferedImage.getWidth());
        String height = Integer.toString(bufferedImage.getHeight());
        String res = width + "x" + height;
        return res;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}

