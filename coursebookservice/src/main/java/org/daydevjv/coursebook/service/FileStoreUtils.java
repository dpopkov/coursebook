package org.daydevjv.coursebook.service;

import org.daydevjv.coursebook.model.FileStoreInfo;
import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;
import oshi.hardware.HardwareAbstractionLayer;

import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class FileStoreUtils {
    private final static String OS = System.getProperty("os.name");
    private final static List<String> LINUX_FILE_STORE_TYPES = List.of("ext4", "fuseblk");
    private final static Predicate<String> FILE_STORE_TYPE_PREDICATE = s -> {
        if ("Linux".equals(OS)) {
            return LINUX_FILE_STORE_TYPES.contains(s);
        }
        // todo: check type for win
        return true;
    };

    public static List<FileStoreInfo> getInfo() {
        ArrayList<FileStoreInfo> info = new ArrayList<>();
        Map<String, FileStoreInfo> infoMap = new HashMap<>();
        for (FileStore fs : FileSystems.getDefault().getFileStores()) {
            String type = fs.type();
            if (FILE_STORE_TYPE_PREDICATE.test(type)) {
                String name = fs.name();
                FileStoreInfo fsInfo = new FileStoreInfo(name, fs);
                info.add(fsInfo);
                infoMap.put(name, fsInfo);
            }
        }

        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        List<HWDiskStore> stores = hal.getDiskStores();
        for (HWDiskStore diskStore : stores) {
            List<HWPartition> partitions =  diskStore.getPartitions();
            for (HWPartition hwPartition : partitions) {
                String identification = hwPartition.getIdentification();
                FileStoreInfo storeInfo = infoMap.get(identification);
                if (storeInfo != null) {
                    storeInfo.setDiskModel(diskStore.getModel());
                    storeInfo.setDiskSerial(diskStore.getSerial());
                    storeInfo.setPartitionUuid(hwPartition.getUuid());
                    storeInfo.setSize(hwPartition.getSize());
                }
            }
        }
        return info;
    }
}
