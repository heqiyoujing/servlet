package com.servlet.study.Bsql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.Test;

public class JdbcOperaBloblmgs {

    /**
     * @Description:向数据库中插入二进制数据
     */
    @Test
    public void add(){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "insert into testblobim(image) values(?)";
            st = conn.prepareStatement(sql);
            //相对路径，class下的相对路径
            File file = new File("target/classes/迪丽热巴.jpg");
            FileInputStream fis = new FileInputStream(file);//生成的流
            st.setBinaryStream(1, fis,(int) file.length());
            int num = st.executeUpdate();
            if(num>0){
                System.out.println("插入成功！！");
            }
            fis.close();
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }

    /**
     * @Description: 读取数据库中的二进制数据
     */
    @Test
    public void read() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select image from testblobim where id=?";
            st = conn.prepareStatement(sql);
            st.setInt(1, 1);
            rs = st.executeQuery();
            if (rs.next()) {
                //InputStream in = rs.getBlob("image").getBinaryStream();//这种方法也可以
                InputStream in = rs.getBinaryStream("image");
                int len = 0;
                byte buffer[] = new byte[1024];

                FileOutputStream out = new FileOutputStream("D:\\1.jpg");
                while ((len = in.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }
                in.close();
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}

