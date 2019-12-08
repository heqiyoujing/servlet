package com.servlet.study.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import com.servlet.study.Bsql.JdbcUtils;
import org.junit.Test;

/**
 * @ClassName: TransactionDemo1
 * @Description:
 * JDBC中使用事务来模似转帐
create table account(
id int primary key auto_increment,
name varchar(40),
money float
);
insert into account(name,money) values('A',1000);
insert into account(name,money) values('B',1000);
insert into account(name,money) values('C',1000);
 * @author: 孤傲苍狼
 * @date: 2014-9-22 下午11:16:17
 *
 */
public class TransactionDemo2 {


    @Test
    public void testTransaction1(){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Savepoint sp = null;
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);//通知数据库开启事务(start transaction)
            String sql1 = "update account set money=money+100 where username='jack'";
            st = conn.prepareStatement(sql1);
            st.executeUpdate();
            //设置事务回滚点
            sp = conn.setSavepoint();
            String sql2 = "update account set money=money+100 where username='rose'";
            st = conn.prepareStatement(sql2);
            st.executeUpdate();
            //程序执行到这里出现异常，后面的sql3语句执行将会中断
            int x = 1/0;
            String sql3 = "update account set money=money+100 where username='davie'";
            st = conn.prepareStatement(sql3);
            st.executeUpdate();
            conn.commit();

        }catch (Exception e) {
            try {
                /**上面的三条update语句中，sql1这条语句的修改操作起作用了,sql2的修改操作
                 * 由于事务回滚没有起作用，sql3由于程序异常没有机会执行
                 */
                conn.rollback(sp);//回滚到设置的事务回滚点
                //回滚了要记得通知数据库提交事务
                conn.commit();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }
}
