    
package models;

/**
 *
 * @author LENOVO
 */
public class FasilitasUmum extends Fasilitas implements Evalutable{
    private String jenis;
    
    public FasilitasUmum(int id, String nama, String kondisi, int jumlah, String jenis){
        super(id, nama, kondisi, jumlah);
        setJenis(jenis);
    }
    
    public String getJenis(){
        return jenis;
    }
    
    public void setJenis(String jenis){
        if (jenis == null || jenis.trim(). isEmpty()){
            throw new IllegalArgumentException("Jenis tidak boleh kosong!");
        }
        this.jenis = jenis;
    }
    
    @Override
    public String getKategori(){
        return "Fasilitas Umum";
    }
    
    @Override
    public String evaluasiKelayakan(){
        if (getKondisi().equalsIgnoreCase("Baik")){
            return "Fasilitas layak digunakan";
        } else if (getKondisi().equalsIgnoreCase("Cukup")){
            return "Fasilitas perlu dipantau";
        } else {
            return "Fasilitas perlu perbaikan";
        }
    }
    
    @Override
    public void tampilkanInfo(){
        super.tampilkanInfo();
        System.out.println("Kategori: " + getKategori());
        System.out.println("Jenis   : " + jenis);
        System.out.println("Evaluasi: " + evaluasiKelayakan());
    }
}
