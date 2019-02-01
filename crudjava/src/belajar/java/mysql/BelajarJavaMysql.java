package belajar.java.mysql;
//import yang dibutuhkan class and interface
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

//import sekaligus menggunakan import java.sql.*

public class BelajarJavaMysql {
//    parameter JDBC koneksi database
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost/perpustakaan";
    static final String USER="root";
    static final String PASS="";

//    siapkan objek untuk mengelola database
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    public static void main(String[] args) {
//        koneksi ke database menggunakan try/catch method

        try {
//            register driver
            Class.forName(JDBC_DRIVER);

//            buat koneksi
            conn=DriverManager.getConnection(DB_URL,USER,PASS);

//            buat objek statement untuk execute
            stmt=conn.createStatement();

//            buat query ke database
            String sql="SELECT*FROM buku";

//            eksekusi query dan simpan hasil di obj ResultSet
            rs=stmt.executeQuery(sql);

//            tampilkan hasil query
//            selama rs masih punya isi
            while(rs.next()) {

                System.out.println("ID Buku : " +rs.getInt("id_buku"));
                System.out.println("Judul: " +rs.getString("judul"));
                System.out.println("Pengarang: "+rs.getString("pengarang"));

            }

            stmt.close();
            conn.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
