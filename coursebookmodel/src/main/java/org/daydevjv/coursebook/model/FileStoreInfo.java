package org.daydevjv.coursebook.model;

import java.nio.file.FileStore;
import java.util.Objects;

public class FileStoreInfo {
    private Integer id;
    /** Name of files store depends on specific OS (e.g. /dev/sda2 on linux) */
    private final String name;
    private final FileStore fileStore;

    private String diskModel;
    private String diskSerial;
    private String partitionUuid;
    private long size;

    public FileStoreInfo(String name, FileStore fileStore) {
        this.name = name;
        this.fileStore = fileStore;
    }

    public String getDescription() {
        return name + " Size:" + (size / (1024*1024*1024)) + "Gb" + " at Disk:" + diskModel;
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

    public FileStore getFileStore() {
        return fileStore;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getDiskModel() {
        return diskModel;
    }

    public void setDiskModel(String diskModel) {
        this.diskModel = diskModel;
    }

    public String getDiskSerial() {
        return diskSerial;
    }

    public void setDiskSerial(String diskSerial) {
        this.diskSerial = diskSerial;
    }

    public String getPartitionUuid() {
        return partitionUuid;
    }

    public void setPartitionUuid(String partitionUuid) {
        this.partitionUuid = partitionUuid;
    }

    @Override
    public String toString() {
        return "FileStoreInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", diskModel='" + diskModel + '\'' +
                ", diskSerial='" + diskSerial + '\'' +
                ", partitionUuid='" + partitionUuid + '\'' +
                ", size=" + size +
                ", fileStore=" + fileStore +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileStoreInfo that = (FileStoreInfo) o;
        return size == that.size &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(fileStore, that.fileStore) &&
                Objects.equals(diskModel, that.diskModel) &&
                Objects.equals(diskSerial, that.diskSerial) &&
                Objects.equals(partitionUuid, that.partitionUuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, fileStore, diskModel, diskSerial, partitionUuid, size);
    }
}

