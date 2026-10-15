/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class TestKoneksi {
    public static void main(String[] args){
        try (Connection conn = Koneksi.getConnection()){
            System.out.println("Koneksi berhasil!");
        } catch (SQLException e){
            System.out.println("Koneksi gagal");
            System.out.println("Error: " + e.getMessage());
        }
    }
}
