package test;

import java.io.*;

/**
 * @ClassName Study_JavaIO
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/08/01 10:44
 */
public class Study_JavaIO {

	public static void studyInputStream(){
		try (
				InputStream fis = new FileInputStream("src/test/input.txt")
		) {
			System.out.println("Number of remaining bytes:"
						+ fis.available());
			 int content;
			 long skip = fis.skip(2);
			 System.out.println("The actual number of bytes skipped:" + skip);
			 System.out.print("The content read from file:");
			 while ((content = fis.read()) != -1) {
			 	System.out.print((char) content);
			 }
			// 新建一个 BufferedInputStream 对象
			BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("src/test/input.txt"));
			// 读取文件的内容并复制到 String 对象中
			String result =new String(bufferedInputStream.readAllBytes());
			System.out.println("result:"+result);

			FileInputStream fileInputStream = new FileInputStream("src/test/input.txt");
			//必须将fileInputStream作为构造参数才能使用
			DataInputStream dataInputStream = new DataInputStream(fileInputStream);
			//可以读取任意具体的类型数据
			dataInputStream.readBoolean();
			dataInputStream.readInt();
			dataInputStream.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static  void studyOutPutStream(){
		try (FileOutputStream output = new FileOutputStream("src/test/output.txt")) {
			byte[] array = "JavaGuide".getBytes();
			output.write(array);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		studyOutPutStream();
	}
}
