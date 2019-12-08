package com.servlet.study.Bsql;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.Test;

/**
 * @ClassName: JdbcOperaClob
 * @Description: 使用JDBC操作MySQL的大文本
 *
 */
public class JdbcOperaClob {

    /**
     * @Method: add
     * @Description:向数据库中插入大文本数据
     * @Anthor:孤傲苍狼
     *
     */
    @Test
    public void add(){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Reader reader = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "insert into testclob(resume) values(?)";
            st = conn.prepareStatement(sql);
           //相对路径，web容器加载class文件的时候，就是加载这个文件夹下的class文件.
            File file = new File("target/classes/data.txt");
            reader = new FileReader(file);
            st.setCharacterStream(1, reader,(int) file.length());
            int num = st.executeUpdate();
            if(num>0){
                System.out.println("插入成功！！");
            }
            //关闭流
            reader.close();
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
           // JdbcUtils.release(conn, st, rs);
        }
    }

    /**
     * @Method: read
     * @Description: 读取数据库中的大文本数据
     */
    @Test
    public void read(){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "select resume from testclob where id=3";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            String contentStr ="";
            String content = "";
            if(rs.next()){
                //使用resultSet.getString("字段名")获取大文本数据的内容
                content = rs.getString("resume");
                //使用resultSet.getCharacterStream("字段名")获取大文本数据的内容
                Reader reader = rs.getCharacterStream("resume");
                char buffer[] = new char[1024];
                int len = 0;
                FileWriter out = new FileWriter("D:\\1.txt");
                while((len=reader.read(buffer))>0){
                    contentStr += new String(buffer);
                    out.write(buffer, 0, len);
                }
                out.close();
                reader.close();
            }
            System.out.println(content);
            System.out.println("-----------------------------------------------");
            System.out.println(contentStr);
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }
}
