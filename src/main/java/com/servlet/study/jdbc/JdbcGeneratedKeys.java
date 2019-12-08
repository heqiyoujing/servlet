package com.servlet.study.jdbc;
import com.servlet.study.Bsql.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author: yiqq
 * @date: 2018/8/23
 * @description:
 */
public class JdbcGeneratedKeys {

    @Test
    public void test() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "insert into testgeneratedkeys(name) values(?)";
            //使用mysql-connector-java-5.1.33-bin.jar作为驱动，添加参数Statement.RETURN_GENERATED_KEYS
            //mysql-connector-java-3.0.10.jar作为驱动，可添加可不添加。
            st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, "哈哈哈哈哈");
            st.executeUpdate();
            //获取数据库自动生成的主键
            rs = st.getGeneratedKeys();
            if(rs.next()){
                System.out.println(rs.getInt(1));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }
}
