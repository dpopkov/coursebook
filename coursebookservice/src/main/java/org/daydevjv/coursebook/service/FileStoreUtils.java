package org.daydevjv.coursebook.service;

import org.daydevjv.coursebook.model.FileStoreInfo;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;

public class FileStoreUtils {

    private static final String VOLUME_SERIAL_NUMBER_ATTRIBUTE_NAME_ON_WINDOWS = "volume:vsn";

    public static List<FileStoreInfo> getInfo() {
        ArrayList<FileStoreInfo> info = new ArrayList<>();
        try {
            for (FileStore fs : FileSystems.getDefault().getFileStores()) {
                String name = fs.name();
                Integer vsn = (Integer) fs.getAttribute(VOLUME_SERIAL_NUMBER_ATTRIBUTE_NAME_ON_WINDOWS);
                FileStoreInfo fsInfo = new FileStoreInfo(name, vsn, fs);
                info.add(fsInfo);
            }
        } catch (IOException e) {
            throw new RuntimeException("I/O Error", e);
        }
        return info;
    }
}
