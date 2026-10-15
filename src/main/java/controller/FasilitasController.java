
package controller;

import java.util.ArrayList;
import models.Fasilitas;
import models.FasilitasUmum;
import models.FasilitasOlahraga;
import view.FasilitasView;
import dao.FasilitasDAO;

public class FasilitasController {
    
    private final FasilitasView view;
    private final FasilitasDAO fasilitasDAO;

    public FasilitasController(FasilitasView view){
        this.view = view;
        this.fasilitasDAO = new FasilitasDAO();
    }
        
    //READ
    public void tampilkanFasilitas() {
        view.tampilkanJudulProses(" DATA FASILITAS TAMAN KOTA");
        
        try {
            ArrayList<Fasilitas> daftarFasilitas = fasilitasDAO.tampilSemua();

            if (daftarFasilitas.isEmpty()){
                view.tampilkanPesan("Belum ada data fasilitas.");
                return;
            }

            for (Fasilitas fasilitas : daftarFasilitas){
                view.tampilkanDataFasilitas(fasilitas);
            }
        } catch (RuntimeException e){
            view.tampilkanPesan(e.getMessage());
        }
    }
    
    //CREATE
    public void tambahFasilitas() {
        view.tampilkanJudulProses(" TAMBAH DATA FASILITAS");
        
        String nama = view.inputNama();
        
        view.tampilkanPilihanJenis();
        int pilihanJenis = view.inputPilihanJenis();
        
        if (pilihanJenis != 1 && pilihanJenis != 2){
            view.tampilkanPilihanJenisTidakValid();
            return;
        }
        
        String kategori = (pilihanJenis == 1)
                ? "Umum" : "Olahraga";
        
        String kondisi = view.inputKondisi();
        int jumlah = view.inputJumlah();
                
        String jenis;
        
        if (pilihanJenis == 1){
            jenis = view.inputJenis();
        } else {
            jenis = view.inputJenisOlahraga();
        }
        
        try {
            if (pilihanJenis == 1){
                new FasilitasUmum(1, nama, kondisi, jumlah, jenis);
            } else {
                new FasilitasOlahraga(1, nama, kondisi, jumlah, jenis);
            }
            
            boolean berhasil = fasilitasDAO.tambah(nama, kategori, kondisi, jumlah, jenis);
            
            if (berhasil){
                view.tampilkanPesan("Berhasil!", "Fasilitas berhasil ditambahkan!");
            } else {
                view.tampilkanPesan("Fasilitas gagal ditambahkan!");
            }
        } catch (IllegalArgumentException e){
            view.tampilkanPesan("Validasi gagal: " + e.getMessage());
        }
    }
    
    //DELETE
    public void hapusFasilitas() {
        view.tampilkanJudulProses(" HAPUS DATA FASILITAS");
        
        int id = view.inputId();
        
        try {
            Fasilitas fasilitas = fasilitasDAO.cariBerdasarkanId(id);
            
            if (fasilitas == null){
                view.tampilkanPesan("Fasilitas tidak ditemukan!");
                return;
            }
            
            boolean berhasil = fasilitasDAO.hapus(id);
            
            if (berhasil){
                view.tampilkanPesan("Fasilitas berhasil dihapus!");
            } else {
                view.tampilkanPesan("Fasilitas gagal dihapus!");
            }
        } catch (RuntimeException e){
            view.tampilkanPesan(e.getMessage());
        }
    }
    
    //UPDATE
    public void updateFasilitas() {
        view.tampilkanJudulProses(" UPDATE DATA FASILITAS");
        
        int id = view.inputId();
        
        try {
            Fasilitas fasilitas = fasilitasDAO.cariBerdasarkanId(id);
            
            if (fasilitas == null){
                view.tampilkanPesan("Fasilitas dengan ID tersebut tidak ditemukan!");
                return;
            }
            
            String nama = view.inputNama();
            String kondisi = view.inputKondisi();
            int jumlah = view.inputJumlah();
            
            fasilitas.setNama(nama);
            fasilitas.setKondisi(kondisi);
            fasilitas.setJumlah(jumlah);
            
            boolean berhasil = fasilitasDAO.update(id, fasilitas.getNama(), fasilitas.getKondisi(), fasilitas.getJumlah());
            
            if (berhasil) {
                view.tampilkanPesan("Fasilitas berhasil diperbarui!");
            } else {
                view.tampilkanPesan("Fasilitas gagal diperbarui!");
            }
            
        } catch (IllegalArgumentException e){
            view.tampilkanPesan("Validasi gagal: " + e.getMessage());
        } catch (RuntimeException e){
            view.tampilkanPesan(e.getMessage());
        }
    }
}