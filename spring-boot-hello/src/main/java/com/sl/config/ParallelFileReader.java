package com.sl.config;

/**
 * @package: com.sl.config
 * @author: shuliangzhao
 * @description:
 * @date 2023/11/29 21:39
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ParallelFileReader {
    public static void main(String[] args) {
        // 文件路径列表
        List<String> filePaths = new ArrayList<>();
        filePaths.add("D:\\aplus\\file1.txt");
        filePaths.add("D:\\aplus\\file2.txt");
        filePaths.add("D:\\aplus\\file3.txt");

        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(filePaths.size());

        // 存储读取结果的 Future 列表
        List<Future<List<String>>> futures = new ArrayList<>();

        // 提交任务
        for (String filePath : filePaths) {
            Callable<List<String>> fileReader = () -> readLinesFromFile(filePath);
            Future<List<String>> future = executorService.submit(fileReader);
            futures.add(future);
        }

        // 等待所有任务完成
        for (Future<List<String>> future : futures) {
            try {
                List<String> lines = future.get();
                // 处理读取的数据
                for (String line : lines) {
                    System.out.println(line);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // 关闭线程池
        executorService.shutdown();
    }

    // 从文件中读取所有行
    private static List<String> readLinesFromFile(String filePath) {
        List<String> lines = new ArrayList<>();
        System.out.println(Thread.currentThread().getName());
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
