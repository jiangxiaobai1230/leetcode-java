package src;

/**
 * @author: Yuan Yuqing
 * @date: 2025-08-21 20:23
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PathConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入相对路径: ");
        String relativePath = scanner.nextLine();

        try {
            // 创建File对象，将相对路径作为参数
            File file = new File(relativePath);

            // 获取规范的绝对路径，会自动处理.和..
            String absolutePath = file.getCanonicalPath();

            System.out.println("对应的绝对路径: " + absolutePath);
        } catch (IOException e) {
            System.out.println("路径转换出错: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
