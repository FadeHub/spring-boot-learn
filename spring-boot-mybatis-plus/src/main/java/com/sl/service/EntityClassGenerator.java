package com.sl.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EntityClassGenerator {

    public static void main(String[] args) throws IOException {
        String filePath = "D:\\shuqian\\user.txt"; // 文件路径
        String fileOutPath = "D:\\shuqian\\userOut.txt";
        List<String> lines = readFileLines(filePath);
        String className = "User"; // 实体类名称
        String packageName = "com.sl"; // 包名

        StringBuilder classContent = new StringBuilder();

        classContent.append("package ").append(packageName).append(";\n\n");
        classContent.append("public class ").append(className).append(" {\n");
        for (String line : lines) {
            String[] parts = line.split(",");
            String fieldName = parts[0];
            String fieldType = parts[1];
            classContent.append("\tprivate ").append(fieldType).append(" ").append(fieldName).append(";\n");
        }

        classContent.append("\n").append("// Getters and Setters").append("\n");

        for (String line : lines) {
            String[] parts = line.split(",");
            String fieldName = parts[0];
            String fieldType = parts[1];
            classContent.append("\tpublic ").append(fieldType).append(" get").append(fieldName).append("() {\n");
            classContent.append("\t\treturn ").append(fieldName).append(";\n");
            classContent.append("\t}\n\n");

            classContent.append("\tpublic void set").append(fieldName).append("(").append(fieldType).append(" ").append(fieldName).append(") {\n");
            classContent.append("\t\tthis.").append(fieldName).append(" = ").append(fieldName).append(";\n");
            classContent.append("\t}\n\n");
        }

        classContent.append("}");

        System.out.println(classContent.toString());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutPath))) {
            writer.write(classContent.toString()); // 写入文件
        } catch (IOException e) {
            e.printStackTrace(); // 处理异常
        }
        // 这里可以添加代码将classContent.toString()的内容写入到文件中，生成实体类文件
    }

    private static List<String> readFileLines(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }
}