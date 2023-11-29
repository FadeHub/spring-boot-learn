package com.sl.config;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @package: com.sl.config
 * @author: shuliangzhao
 * @description:
 * @date 2023/11/29 22:02
 */
public class AsyncFileReadExample {
    public static void main(String[] args) {
        // 文件路径列表
        String[] filePaths = {"D:\\aplus\\file1.txt", "D:\\aplus\\file2.txt", "D:\\aplus\\file3.txt"};

        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(filePaths.length);

        for (String filePath : filePaths) {
            Path path = Paths.get(filePath);

            // 异步文件通道
            try (AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ)) {

                // 缓冲区
                ByteBuffer buffer = ByteBuffer.allocate(1024);

                // 异步读取文件
                fileChannel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                    @Override
                    public void completed(Integer result, ByteBuffer attachment) {
                        System.out.println(Thread.currentThread().getName());
                        System.out.println("Read " + result + " bytes from " + path);

                        // 处理读取的数据
                        attachment.flip();
                        byte[] data = new byte[attachment.limit()];
                        attachment.get(data);
                        System.out.println("Data: " + new String(data));

                        // 清空缓冲区
                        attachment.clear();

                        // 关闭文件通道等资源
                        try {
                            fileChannel.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {
                        exc.printStackTrace();
                    }
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 关闭线程池
        executorService.shutdown();
    }
}
