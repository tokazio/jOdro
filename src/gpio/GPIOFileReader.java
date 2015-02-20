/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpio;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michi
 */
public class GPIOFileReader extends Thread implements Runnable {

    private final GPIOPin gpio;
    private ArrayList<GPIOListener> listener;

    protected GPIOFileReader(GPIOPin gpio) {
        this.gpio = gpio;
        this.listener = new ArrayList<>();
    }

    protected void addListener(GPIOListener l) {
        this.listener.add(l);
    }

    private void notifyListener() {
        Object[] list = listener.toArray();
        for (int i = 0; i < list.length; i++) {
            GPIOListener l = (GPIOListener) list[i];
            l.valueChanged(gpio);
        }
    }

    @Override
    public void run() {
        try {
            Path myDir = Paths.get("/sys/class/gpio/gpio" + this.gpio.getPin().getOdroidCode());
            WatchService watcher = myDir.getFileSystem().newWatchService();
            myDir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
            WatchKey watckKey = watcher.take();
            while (true) {
                List<WatchEvent<?>> events = watckKey.pollEvents();
                for (WatchEvent event : events) {
                    if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                        this.notifyListener();
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
