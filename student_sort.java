/*

    技术：集合   I/O流
    格式：学号   名字
    要求：按照学号排序   降序

*/

package ja.classset;

import java.io.*;
import java.util.*;
class Student{
    private Integer num;
    private String name;
    private String Class;
}
public class map {
    public static void main(String[] args) {

        Student[] stu=new Student[100];
        File file = new File("C:Users" + File.separator + "Administrator"
                + File.separator + "Desktop"+File.separator+"java3.txt");//文件java3.txt中存放的是学生信息

        if(file.exists()&&file.isFile()) {
            Map<Integer,String> map=new TreeMap<>(((o1, o2) -> o1.compareTo(o2)*(-1)));
            try {
               BufferedReader reader=new BufferedReader(new FileReader(file));
               String line;
               //按行读
               while((line=reader.readLine())!=null){
                   String[] values=line.split("\t");
                   if(values.length>=2){
                       map.put(Integer.parseInt(values[0]),values[1]);
                   }else{
                       System.out.println(line+"无效数据");
                   }
               }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("发生错误"+e.getMessage());
            }
            for(Map.Entry<Integer,String> entry:map.entrySet()){
                System.out.println(entry.getKey()+" "+entry.getValue());
            }
        }else{
            System.out.println("文件不存在或者不是文件");
        }
    }
}
