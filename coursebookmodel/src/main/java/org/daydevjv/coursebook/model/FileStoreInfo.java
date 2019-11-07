package org.daydevjv.coursebook.model;

import java.io.IOException;
import java.nio.file.FileStore;
import java.util.Objects;

public class FileStoreInfo {
    private Integer id;
    private final String name;
    private final Integer volumeSerialNumber;
    private final FileStore fileStore;
    private long totalSize;

    public FileStoreInfo(String name, Integer volumeSerialNumber, FileStore fileStore) throws IOException {
        this.name = name;
        this.volumeSerialNumber = volumeSerialNumber;
        this.fileStore = fileStore;
        totalSize = fileStore.getTotalSpace();
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVolumeSerialNumber() {
        return volumeSerialNumber;
    }

    public FileStore getFileStore() {
        return fileStore;
    }

    public long getTotalSize() {
        return totalSize;
    }

    @Override
    public String toString() {
        return "FileStoreInfo{id=" + id + ", name='" + name + "', volumeSerialNumber=" + volumeSerialNumber
                + ", totalSize=" + totalSize + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FileStoreInfo that = (FileStoreInfo) o;
        return totalSize == that.totalSize && Objects.equals(id, that.id) && Objects.equals(name, that.name)
                && Objects.equals(volumeSerialNumber, that.volumeSerialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, volumeSerialNumber, totalSize);
    }
}

