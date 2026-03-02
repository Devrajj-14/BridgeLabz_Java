package com.bridgelabz.fileio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import static java.nio.file.StandardWatchEventKinds.*;

public class DirectoryWatchService {

    private final WatchService watchService;

    public DirectoryWatchService() throws IOException {
        this.watchService = FileSystems.getDefault().newWatchService();
    }

    // register directory + subdirectories
    public void registerAll(Path start) throws IOException {
        Files.walkFileTree(start, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                register(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private void register(Path dir) throws IOException {
        dir.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
    }

    // run watcher (stop manually: Ctrl + C)
    public void processEvents() {
        System.out.println("Watching directory changes... (Ctrl+C to stop)");
        while (true) {
            WatchKey key;
            try {
                key = watchService.take();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            Path dir = (Path) key.watchable();
            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();
                if (kind == OVERFLOW) continue;

                @SuppressWarnings("unchecked")
                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                Path name = ev.context();
                Path child = dir.resolve(name);

                System.out.println(kind.name() + ": " + child);

                // if new directory is created, register it too
                if (kind == ENTRY_CREATE) {
                    try {
                        if (Files.isDirectory(child)) registerAll(child);
                    } catch (IOException ignored) {}
                }
            }

            boolean valid = key.reset();
            if (!valid) break;
        }
    }
}