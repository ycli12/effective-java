package avoid_over_due_reference;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// 资源未挂壁，有些可能随着gc持续地占用内存，可能会严重地拖累系统
public class SourceNotClose {
    public static void main(String[] args) {
        FileInputStream fio = null;
        try {
            fio = new FileInputStream(new File(""));

            // 一些流操作
            // ...

            fio.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 上面如果在关闭之前发生异常的话也是无法关闭的，因此需要下面的关闭，而不上上面的
        if (fio != null) {
            try {
                fio.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 也可以使用下面的资源使用方式
        try (FileInputStream fio2 = new FileInputStream(new File(""));) {
            // 一些流操作
            // ...
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
