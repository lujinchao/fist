package com.baidu.personal.fist.utils;

import com.google.protobuf.ByteString;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

/**
 * @author lujinchao@baidu.com
 * @date 2020-05-11 22:05:25
 */

@Slf4j
public class FileUtil {

    /**
     * 删除文件/文件夹（非递归式）
     * @param fileName
     */
    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * 覆盖式的写文件
     * @param fileName
     * @param byteString
     */
    public static void overwriteFile(String fileName, ByteString byteString) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException exception) {
                log.error("overwrite file error, file is: {}", fileName, exception);
            }
        }
        ByteUtil.writeFileFromBytes(ByteUtil.getString(byteString).getBytes(), fileName);
    }

    /**
     * 新建文件夹
     * @param directory
     */
    public static void createDirectory(String directory) {
        File file = new File(directory);
        if (!file.exists()) {
            try {
                file.mkdir();
            } catch (Exception exception) {
                log.error("create directory error, directory is: {}", directory, exception);
            }
        }
    }

}
