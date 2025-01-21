package com.patrick.whatsappclone.file;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
public class FileUtils {
    private FileUtils() {}
    public static byte[] readFileFromLocation(String fileUrl){
        if (StringUtils.isBlank(fileUrl)){
            return new byte[0];
        }
        try {
            Path file = new File(fileUrl).toPath();
            return Files.readAllBytes(file);
        }catch (IOException e){
            log.error("No file found in the path {}", fileUrl);
        }
        return new byte[0];
    }
}
