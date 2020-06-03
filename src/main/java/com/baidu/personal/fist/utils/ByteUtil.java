package com.baidu.personal.fist.utils;

import com.google.protobuf.ByteString;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @author lujinchao@baidu.com
 * @date 2020-05-11 19:26:33
 */

@Slf4j
public class ByteUtil {

    public static final String CHARSET_GBK = "utf8";

    /**
     * String转为ByteString
     * @param text
     * @return
     */
    public static ByteString getByteString(String text) {
        return getByteString(text, CHARSET_GBK);
    }

    /**
     * String转为ByteString
     * @param text
     * @param charset
     * @return
     */
    public static ByteString getByteString(String text, String charset) {
        try {
            return ByteString.copyFrom(text.getBytes(charset));
        } catch (Exception exception) {
            log.error("transfer string to byteString error, string is: {}, charset is: {}", text, charset, exception);
        }
        return ByteString.EMPTY;
    }

    /**
     * ByteString转为String
     * @param byteString
     * @return
     */
    public static String getString(ByteString byteString) {
        return getString(byteString, CHARSET_GBK);
    }

    /**
     * ByteString转为String
     * @param byteString
     * @param charset
     * @return
     */
    public static String getString(ByteString byteString, String charset) {
        String res = "";
        if (byteString == null) {
            return res;
        }
        try {
            res = byteString.toString(charset);
        } catch (Exception exception) {
            log.error("transfer string to byteString error, string is: {}, charset is: {}", byteString, charset, exception);
        }
        return res;
    }

    /**
     * 文件转为byte数组
     * @param file
     * @return
     */
    public static byte[] getBytesFromFile(File file) {
        try {
            // 获取输入流
            FileInputStream fis = new FileInputStream(file);
            // 新的byte数组输出流，缓冲区容量1024byte
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
            // 缓存数组
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            // 改变为byte[]
            byte[] data = bos.toByteArray();
            bos.close();
            return data;
        } catch (Exception exception) {
            log.error("transfer file to byte[] error, the file is: {}", file.getAbsolutePath(), exception);
        }
        return null;
    }

    public static void writeFileFromBytes(byte[] bytes, String fileName) {
        writeFileFromBytes(bytes, fileName, false);
    }

    /**
     * 读取byte数组到文件中
     * @param bytes
     * @param fileName 文件绝对路径
     * @param append 是否覆盖
     */
    public static void writeFileFromBytes(byte[] bytes, String fileName, boolean append) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName, append);
            fileWriter.write(new String(bytes));
        } catch (Exception exception) {
            log.error("write file error, file is: {}", fileName, exception);
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (Exception exception) {
                    log.error("close file error, file is: {}", fileName, exception);
                }
            }
        }
    }
}
