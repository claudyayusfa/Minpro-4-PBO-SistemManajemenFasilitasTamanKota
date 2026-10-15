/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Fasilitas;
import models.FasilitasUmum;
import models.FasilitasOlahraga;

/**
 *
 * @author LENOVO
 */
public class FasilitasDAO {
    
    //READ
    public ArrayList<Fasilitas> tampilSemua(){
        ArrayList<Fasilitas> daftarFasilitas = new ArrayList<>();
        String sql = "SELECT * FROM fasilitas";
        
        try (Connection conn = Koneksi.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
            
            while (rs.next()){
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                String kategori = rs.getString("kategori");
                String kondisi = rs.getString("kondisi");
                int jumlah = rs.getInt("jumlah");
                String jenis = rs.getString("jenis");
                
                Fasilitas fasilitas;
                
                if (kategori.equalsIgnoreCase("Umum")){
                    fasilitas = new FasilitasUmum(id, nama, kondisi, jumlah, jenis);
                } else if (kategori.equalsIgnoreCase("Olahraga")){
                    fasilitas = new FasilitasOlahraga(id, nama, kondisi, jumlah, jenis);
                } else {
                    throw new SQLException("Kategori fasilitas tidak dikenal: " + kategori);
                }
                daftarFasilitas.add(fasilitas);
            }
        } catch (SQLException e){
            throw new RuntimeException("Gagal mengambil data: " + e.getMessage(), e);
        }
        return daftarFasilitas;
    }
    
    //CREATE
    public boolean tambah(String nama, String kategori, String kondisi, int jumlah, String jenis){
        String sql = "INSERT INTO fasilitas " + "(nama, kategori, kondisi, jumlah, jenis) " + "VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = Koneksi.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, nama);
            ps.setString(2, kategori);
            ps.setString(3, kondisi);
            ps.setInt(4, jumlah);
            ps.setString(5, jenis);
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e){
            System.out.println("Gagal menambahkan data: " + e.getMessage());
            return false;
        }
    }
    
    //READ DARI ID
    public Fasilitas cariBerdasarkanId(int id){
        String sql = "SELECT * FROM fasilitas WHERE id = ?";
        
        try (Connection conn = Koneksi.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    String nama = rs.getString("nama");
                    String kategori = rs.getString("kategori");
                    String kondisi = rs.getString("kondisi");
                    int jumlah = rs.getInt("jumlah");
                    String jenis = rs.getString("jenis");
                    
                    if (kategori.equalsIgnoreCase("Umum")){
                        return new FasilitasUmum(id, nama, kondisi, jumlah, jenis);
                    } else if (kategori.equalsIgnoreCase("Olahraga")){
                        return new FasilitasOlahraga(id, nama, kondisi, jumlah, jenis);
                    }
                    
                    throw new SQLException("Kategori tidak dikenal: " + kategori);
                }
            }
        } catch (SQLException e){
            throw new RuntimeException("Gagal mencari data: " + e.getMessage(), e);
        }
        return null;
    }
    
    //UPDATE
    public boolean update(int id, String nama, String kondisi, int jumlah){
        String sql = "UPDATE fasilitas " + "SET nama = ?, kondisi = ?, jumlah = ? " + "WHERE id = ?";
        
        try (Connection conn = Koneksi.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, nama);
            ps.setString(2, kondisi);
            ps.setInt(3, jumlah);
            ps.setInt(4, id);
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e){
            System.out.println("Gagal memperbarui data: " + e.getMessage());
            return false;
        }
    }
    
    //DELETE
    public boolean hapus(int id){
        String sql = "DELETE FROM fasilitas WHERE id = ?";
        
        try (Connection conn = Koneksi.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e){
            System.out.println("Gagal menghapus data: " + e.getMessage());
            return false;
        }
    }
}
