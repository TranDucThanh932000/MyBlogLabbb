/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Blog;

/**
 *
 * @author asus
 */
public class BlogDAO {

    public List<Blog> getAllBlog() {
        List<Blog> list = new ArrayList<Blog>();
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from blog";
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Blog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
            System.out.println("loi khi load sql:" + e.getMessage());
        }
        return list;
    }

    public List<Blog> getTop3(int top) {
        List<Blog> list = new ArrayList<Blog>();
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select top " + top + " * from blog order by timerelease desc";
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Blog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
            System.out.println("Loi khi load sql:" + e.getMessage());
        }
        return list;
    }

    public Blog getTop1() {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select top 1 * from blog order by timerelease desc";
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Blog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
        } catch (Exception e) {
            System.out.println("Loi khi load sql:" + e.getMessage());
        }
        return null;
    }

    public Blog getBlog(int id) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from blog where id =" + id;
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Blog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
        } catch (Exception e) {
            System.out.println("Loi khi load getBlog " + e.getMessage());
        }
        return null;
    }

    public List<String> getAllCategory() {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> list = new ArrayList<String>();
        try {
            String sql = "select distinct category from blog";
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("Loi khi load category:" + e.getMessage());
        }
        return list;
    }

    public List<Blog> getBlogbyCategory(String category) {
        List<Blog> list = new ArrayList<>();
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            db = new DBContext();
            con = db.getConnection();
            String sql = "select * from blog where category = '" + category + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Blog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
            System.out.println("Loi khi load getBlogbyCategory" + e.getMessage());
        }
        return list;
    }

    public int count(String name) {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select count(*) from blog where category like ?";
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Loi khi count" + e.getMessage());
        }
        return 0;
    }

    public List<Blog> getByIndex(String txt, int index, int pageSize) {
        String sql = "select *from("
                + "select ROW_NUMBER() over (order by id ASC) as rn, *\n"
                + "from blog where category \n"
                + "like ?"
                + ")as x\n"
                + "where rn between ?*?-1 "
                + "and ?*?";
        List<Blog> list = new ArrayList<>();
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, txt);
            ps.setInt(2, index);
            ps.setInt(3, pageSize);
            ps.setInt(4, index);
            ps.setInt(5, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Blog(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }
        } catch (Exception e) {
            System.out.println("Loi khi load getByIndex " + e.getMessage());
        }
        return list;
    }

    public static void main(String[] args) {
        BlogDAO dao = new BlogDAO();

    }

}
