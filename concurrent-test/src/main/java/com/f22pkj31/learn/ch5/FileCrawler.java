package com.f22pkj31.learn.ch5;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * @author bo.fan
 * @date 2019-06-19
 * @since JDK1.7
 */
public class FileCrawler implements Runnable {

    private final BlockingQueue<File> fileQueue;

    public FileCrawler(BlockingQueue<File> fileQueue) {
        this.fileQueue = fileQueue;
    }


    public void run() {

    }
}
