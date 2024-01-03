package aboutbioindofile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class getRemainedFile {
    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>();

        // 假设要读取的文件名为"A.txt"
        String fileName = "C:\\Users\\couco\\Desktop\\hrpc_assemblyList.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            // 逐行读取文件并将其添加到Set中
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                stringSet.add(currentLine);
            }
        } catch (Exception e) {
            System.out.println("读取文件时发生错误: " + e.getMessage());
            return;
        }

        String fileName1 = "C:\\Users\\couco\\Desktop\\already_download_hm.txt";
        // 再次打开文件并检查每一行是否包含在Set中
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName1))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                if (stringSet.contains(currentLine)) {
                    stringSet.remove(currentLine);
                }
            }
        } catch (Exception e) {
            System.out.println("读取文件时发生错误: " + e.getMessage());
            return;
        }

        for(String a:stringSet){
            System.out.println(a);
        }
    }



    }

