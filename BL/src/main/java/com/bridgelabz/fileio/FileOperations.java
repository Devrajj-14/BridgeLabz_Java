package com.bridgelabz.fileio;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileOperations {

    public boolean exists(Path path) {
        return Files.exists(path);
    }

    public boolean deleteIfExists(Path path) throws IOException {
        return Files.deleteIfExists(path);
    }

    public Path createDirectory(Path dir) throws IOException {
        return Files.createDirectories(dir);
    }

    public Path createEmptyFile(Path file) throws IOException {
        Path parent = file.getParent();
        if (parent != null) Files.createDirectories(parent);
        if (!Files.exists(file)) Files.createFile(file);
        return file;
    }

    public List<Path> listAll(Path dir) throws IOException {
        try (Stream<Path> stream = Files.list(dir)) {
            return stream.collect(Collectors.toList());
        }
    }

    public List<Path> listByExtension(Path dir, String extension) throws IOException {
        String ext = extension.startsWith(".") ? extension : "." + extension;
        try (Stream<Path> stream = Files.list(dir)) {
            return stream
                    .filter(p -> p.getFileName().toString().endsWith(ext))
                    .collect(Collectors.toList());
        }
    }
}