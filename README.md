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
