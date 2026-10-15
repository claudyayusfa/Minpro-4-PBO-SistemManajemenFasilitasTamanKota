# 🌳 Sistem Manajemen Fasilitas Taman Kota 𖦹˙🍎.°🌱٭.

**Mini Project 4 — Praktikum Pemrograman Berorientasi Objek**

Sistem Manajemen Fasilitas Taman Kota adalah sistem berbasis **Java Command Line Interface (CLI)** yang digunakan untuk mengelola data fasilitas taman kota. Program ini dikembangkan menggunakan konsep **Object-Oriented Programming (OOP)**, arsitektur **Model-View-Controller (MVC)**, dan integrasi database **MySQL** melalui **JDBC, PreparedStatement, dan DAO Pattern**.

---

## 📌 1. Deskripsi Program

Program ini merupakan pengembangan dari **Mini Project 3**, dengan penambahan penyimpanan data secara permanen menggunakan database MySQL.

Sistem mengelola dua kategori fasilitas:

- **Fasilitas Umum**, seperti gazebo, kursi, dan lampu.
- **Fasilitas Olahraga**, seperti lapangan basket dan fasilitas olahraga lainnya.

### Fitur Program

| Fitur | Deskripsi |
|---|---|
| **Create** | Menambahkan data fasilitas ke database. |
| **Read** | Menampilkan seluruh data fasilitas dari database. |
| **Update** | Memperbarui nama, kondisi, dan jumlah fasilitas. |
| **Delete** | Menghapus fasilitas berdasarkan ID. |
| **Validasi Data** | Memastikan data sesuai dengan ketentuan. |
| **Evaluasi Kelayakan** | Menentukan kelayakan fasilitas berdasarkan kondisinya. |

Dengan menggunakan database MySQL, data fasilitas tetap tersimpan meskipun program ditutup dan dijalankan kembali.

---

## 📂 2. Struktur Package

Program menerapkan struktur **MVC (Model-View-Controller)** yang dipadukan dengan **DAO (Data Access Object)** untuk memisahkan pengelolaan data, tampilan, logika program, dan koneksi database.

### Struktur Project

<img width="762" height="1080" alt="Screenshot 2026-10-15 144930" src="https://github.com/user-attachments/assets/6bdb331d-d859-433a-a71f-9db75ef443c4" />

### Penjelasan Package

| Package | Fungsi |
|---|---|
| `config` | Mengatur dan menguji koneksi database MySQL. |
| `controller` | Mengatur proses CRUD dan menghubungkan View dengan DAO. |
| `dao` | Menjalankan query SQL menggunakan JDBC dan PreparedStatement. |
| `helper` | Menangani input pengguna dan validasi input. |
| `main` | Menjalankan program dan mengatur alur menu utama. |
| `models` | Menyimpan atribut, method,dan penerapan konsep OOP. |
| `view` | Menampilkan menu, data fasilitas, dan pesan kepada pengguna. |

---

## 🔄 3. Alur Program

Program dijalankan melalui class `Main.java` yang menginisialisasi objek View dan Controller.

<img width="1092" height="146" alt="image" src="https://github.com/user-attachments/assets/d0251b1e-9892-4cdf-86dc-42c68962a37d" />

Alur kerja program:

1. **Main** menjalankan program dan menampilkan menu utama.
2. **View** menerima pilihan menu dan input dari pengguna.
3. **Controller** memproses input serta menjalankan validasi.
4. **DAO** mengakses database melalui JDBC.
5. **MySQL** menyimpan, memperbarui, menghapus, atau menyediakan data.
6. Hasil proses ditampilkan kembali kepada pengguna melalui View.

### 3.1 Create — Menambahkan Fasilitas

Fitur Create digunakan untuk menambahkan fasilitas baru berdasarkan nama, kategori, kondisi, jumlah, dan jenis fasilitas.

Sebelum disimpan, data divalidasi melalui constructor Model. Setelah validasi berhasil, Controller memanggil method `tambah()` pada DAO.

- <img width="1286" height="44" alt="image" src="https://github.com/user-attachments/assets/2419598c-8a93-4788-8614-d4541db20ecb" />

### 3.2 Read — Menampilkan Fasilitas

Fitur Read digunakan untuk menampilkan seluruh fasilitas yang tersimpan di database.

<img width="1128" height="400" alt="image" src="https://github.com/user-attachments/assets/5e46abdc-360c-406f-95e6-e1086d47bda9" />

Data diambil melalui DAO, kemudian ditampilkan berdasarkan jenis objek fasilitas.

### 3.3 Update — Memperbarui Fasilitas

Fitur Update digunakan untuk memperbarui data fasilitas berdasarkan ID.

Program mencari fasilitas terlebih dahulu, kemudian memvalidasi perubahan menggunakan setter Model sebelum menjalankan query UPDATE.

<img width="1786" height="184" alt="image" src="https://github.com/user-attachments/assets/891e23ed-6f7b-43d6-9736-8c8c7705a5a8" />

### 3.4 Delete — Menghapus Fasilitas

Fitur Delete digunakan untuk menghapus fasilitas berdasarkan ID.

Program terlebih dahulu memeriksa apakah fasilitas tersedia di database.

<img width="992" height="332" alt="image" src="https://github.com/user-attachments/assets/87f9e857-e413-4716-90c2-0d8143bce1c8" />

## 🔐 4. Penerapan Encapsulation

**Encapsulation** adalah konsep OOP yang digunakan untuk melindungi atribut agar tidak dapat diakses atau diubah secara langsung dari luar class.

Pada program ini, encapsulation diterapkan dalam abstract class `Fasilitas` melalui atribut `private` dan method getter dan setter.

### Contoh Atribut Private

<img width="550" height="194" alt="image" src="https://github.com/user-attachments/assets/a01f7ec7-26c9-4897-9b2b-0db290a1cace" />

### Contoh Setter dengan Validasi

<img width="1194" height="216" alt="image" src="https://github.com/user-attachments/assets/eae61997-2c38-4413-b627-18e28df67ab7" />

Method `setJumlah()` memastikan jumlah fasilitas tidak bernilai negatif. Validasi juga diterapkan pada ID, nama, kondisi, dan atribut khusus fasilitas.

Pada proses Create dan Update, Controller menggunakan validasi Model sebelum data dikirim ke database.

## 🧬 5. Penerapan Inheritance

**Inheritance** adalah konsep pewarisan atribut dan method dari superclass kepada subclass.

Program menggunakan abstract class `Fasilitas` sebagai superclass, dengan dua subclass:

- `FasilitasUmum`
- `FasilitasOlahraga`

<img width="408" height="182" alt="image" src="https://github.com/user-attachments/assets/d3097a8c-714a-452b-963d-9c697a6d5cd7" />

### Contoh Implementasi
