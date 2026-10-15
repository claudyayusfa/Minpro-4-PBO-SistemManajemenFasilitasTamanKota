# 🌳 Sistem Manajemen Fasilitas Taman Kota 𖦹˙🍎.°🌱٭.

|Identitas|Keterangan|
|---|---|
|Nama: | Claudya Yusfa Ariyani |
|NIM: | 2509116043 |
|Kelas: | B2025 |

**Mini Project 4 Praktikum Pemrograman Berorientasi Objek**

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

### 3.1 Menambahkan Fasilitas

Fitur Create digunakan untuk menambahkan fasilitas baru berdasarkan nama, kategori, kondisi, jumlah, dan jenis fasilitas.

Sebelum disimpan, data divalidasi melalui constructor Model. Setelah validasi berhasil, Controller memanggil method `tambah()` pada DAO.

<img width="1286" height="44" alt="image" src="https://github.com/user-attachments/assets/2419598c-8a93-4788-8614-d4541db20ecb" />

ID fasilitas tidak dimasukkan secara manual karena dihasilkan otomatis oleh MySQL melalui `AUTO_INCREMENT`.

### 3.2 Menampilkan Fasilitas

Fitur Read digunakan untuk menampilkan seluruh fasilitas yang tersimpan di database.

<img width="1128" height="400" alt="image" src="https://github.com/user-attachments/assets/5e46abdc-360c-406f-95e6-e1086d47bda9" />

Data diambil melalui DAO, kemudian ditampilkan berdasarkan jenis objek fasilitas.

### 3.3 Memperbarui Fasilitas

Fitur Update digunakan untuk memperbarui data fasilitas berdasarkan ID.

Program mencari fasilitas terlebih dahulu, kemudian memvalidasi perubahan menggunakan setter Model sebelum menjalankan query UPDATE.

<img width="1786" height="184" alt="image" src="https://github.com/user-attachments/assets/891e23ed-6f7b-43d6-9736-8c8c7705a5a8" />

### 3.4 Menghapus Fasilitas

Fitur Delete digunakan untuk menghapus fasilitas berdasarkan ID.

Program terlebih dahulu memeriksa apakah fasilitas tersedia di database.

<img width="992" height="332" alt="image" src="https://github.com/user-attachments/assets/87f9e857-e413-4716-90c2-0d8143bce1c8" />

---

## 🔐 4. Penerapan Encapsulation

**Encapsulation** adalah konsep OOP yang digunakan untuk melindungi atribut agar tidak dapat diakses atau diubah secara langsung dari luar class.

Pada program ini, encapsulation diterapkan dalam abstract class `Fasilitas` melalui atribut `private` dan method getter dan setter.

### Contoh Atribut Private

<img width="550" height="194" alt="image" src="https://github.com/user-attachments/assets/a01f7ec7-26c9-4897-9b2b-0db290a1cace" />

### Contoh Setter dengan Validasi

<img width="1194" height="216" alt="image" src="https://github.com/user-attachments/assets/eae61997-2c38-4413-b627-18e28df67ab7" />

Method `setJumlah()` memastikan jumlah fasilitas tidak bernilai negatif. Validasi juga diterapkan pada ID, nama, kondisi, dan atribut khusus fasilitas.

Pada proses Create dan Update, Controller menggunakan validasi Model sebelum data dikirim ke database.

---

## 🧬 5. Penerapan Inheritance

**Inheritance** adalah konsep pewarisan atribut dan method dari superclass kepada subclass.

Program menggunakan abstract class `Fasilitas` sebagai superclass, dengan dua subclass:

- `FasilitasUmum`
- `FasilitasOlahraga`

<img width="408" height="182" alt="image" src="https://github.com/user-attachments/assets/d3097a8c-714a-452b-963d-9c697a6d5cd7" />

### Contoh Implementasi

- <img width="1096" height="38" alt="image" src="https://github.com/user-attachments/assets/461ce871-0b99-4b68-91e0-163a0c19e184" />

- <img width="1156" height="32" alt="image" src="https://github.com/user-attachments/assets/5d5ef18c-97d5-4564-bb3f-5c3680561e7d" />

Kedua subclass mewarisi atribut umum, yaitu ID, nama, kondisi, jumlah, dan menggunakan `super()` untuk memanggil constructor superclass.

Setiap subclass memiliki atribut khusus:

- `FasilitasUmum` memiliki atribut `jenis`.
- `FasilitasOlahraga` memiliki atribut `jenisOlahraga`.

Dengan inheritance, atribut dan method yang sama tidak perlu ditulis ulang pada setiap subclass.

---

## 🔀 6. Penerapan Polymorphism

**Polymorphism** adalah konsep OOP yang dapat membuat method dengan nama yang sama memiliki perilaku berbeda.

Program menerapkan **method overriding** dan **method overloading**.

### 6.1 Method Overriding

Overriding diterapkan ketika subclass memberikan implementasi khusus terhadap method yang diwarisi dari superclass.

Contohnya adalah method `tampilkanInfo()` pada `FasilitasUmum` dan `FasilitasOlahraga`.

<img width="968" height="278" alt="image" src="https://github.com/user-attachments/assets/799e5555-8b4a-47f4-b689-7a720769778d" />

<img width="964" height="268" alt="image" src="https://github.com/user-attachments/assets/9797d138-5373-4a04-b37f-a1def7c7742a" />

Meskipun method memiliki nama yang sama, informasi tambahan yang ditampilkan menyesuaikan kategori fasilitas.

### 6.2 Method Overloading

Overloading diterapkan melalui penggunaan nama method yang sama dengan parameter berbeda.

Contohnya pada `FasilitasView.java`:

<img width="900" height="300" alt="image" src="https://github.com/user-attachments/assets/22fa2a48-0542-4460-a6ec-0e8e65f5e01c" />

Method pertama menampilkan satu pesan, sedangkan method kedua menampilkan judul beserta pesan.

---

## 🧩 7. Penerapan Abstraction

**Abstraction** digunakan untuk menyediakan struktur dasar tanpa harus menampilkan seluruh detail implementasi.

Program menerapkan abstraction melalui **abstract class** dan **abstract method**.

### 7.1 Abstract Class

Class `Fasilitas` dideklarasikan sebagai abstract class yang menjadi dasar bagi kedua kategori fasilitas.

- <img width="548" height="42" alt="image" src="https://github.com/user-attachments/assets/fb183e77-b765-4f16-80f6-b24196196f14" />

- <img width="620" height="50" alt="image" src="https://github.com/user-attachments/assets/de1f4ad9-7093-42a4-afdc-9d56df108126" />

Method `getKategori()` wajib diimplementasikan oleh subclass sesuai kategorinya.

Contoh pada `FasilitasUmum`:

<img width="464" height="154" alt="image" src="https://github.com/user-attachments/assets/b9d086b3-3a27-4b81-b670-7691cf89a11d" />

### 7.2 Interface

Program juga menerapkan interface `Evalutable` untuk menentukan evaluasi kelayakan fasilitas.

<img width="516" height="332" alt="image" src="https://github.com/user-attachments/assets/9823ecaa-00f2-4edf-bb2f-6035f0a139b9" />

Method `evaluasiKelayakan()` diimplementasikan oleh kedua subclass berdasarkan kondisi fasilitas.

| Kondisi | Evaluasi |
|---|---|
| **Baik** | Fasilitas layak digunakan. |
| **Cukup** | Fasilitas perlu dipantau. |
| **Rusak** | Fasilitas perlu perbaikan. |

---

## 🔌 8. Penerapan JDBC, PreparedStatement, dan DAO

Pada Mini Project 4, program menggunakan database **MySQL** sebagai media penyimpanan utama.

Integrasi database dilakukan menggunakan JDBC, PreparedStatement, dan DAO Pattern.

### 8.1 JDBC (Java Database Connectivity)

JDBC digunakan untuk menghubungkan aplikasi Java dengan database MySQL.

Konfigurasi koneksi dikelola melalui class `Koneksi.java`.

<img width="1440" height="724" alt="image" src="https://github.com/user-attachments/assets/f647d3a6-dbf2-475e-92bf-c0b8e6175efe" />

Method `getConnection()` digunakan untuk membuka koneksi ketika DAO menjalankan operasi database.

Program menggunakan dependency **MySQL Connector/J 8.3.0** melalui Maven.

<img width="824" height="254" alt="image" src="https://github.com/user-attachments/assets/1b23939d-7f7b-454e-8f52-4912f6f9bc84" />

<img width="1046" height="272" alt="image" src="https://github.com/user-attachments/assets/7f968d31-5dcf-4d99-8e93-6ed7b53718cb" />

### 8.2 PreparedStatement

**PreparedStatement** digunakan untuk menjalankan query SQL dengan parameter `?`.

Contoh penerapan pada operasi INSERT:

<img width="1526" height="724" alt="image" src="https://github.com/user-attachments/assets/47ac39ae-f74f-4616-8261-b75b4cc0f2f2" />

Parameter `?` digunakan sebagai tempat nilai input yang kemudian diisi menggunakan `setString()` atau `setInt()`.

Penggunaan PreparedStatement membantu memisahkan data input dari struktur query SQL dan mengurangi risiko SQL Injection.

### 8.3 DAO (Data Access Object)

**DAO Pattern** digunakan untuk memisahkan proses pengaksesan database dari logika utama program.

Seluruh operasi database dikelola melalui class `FasilitasDAO.java`.

| Method | Operasi SQL | Fungsi |
|---|---|---|
| `tampilSemua()` | SELECT | Menampilkan seluruh fasilitas. |
| `cariBerdasarkanId()` | SELECT | Mencari fasilitas berdasarkan ID. |
| `tambah()` | INSERT | Menambahkan fasilitas baru. |
| `update()` | UPDATE | Memperbarui data fasilitas. |
| `hapus()` | DELETE | Menghapus fasilitas. |

Dengan penerapan DAO, Controller tidak perlu menuliskan query SQL secara langsung. Controller cukup memanggil method DAO sesuai kebutuhan.

- <img width="992" height="106" alt="image" src="https://github.com/user-attachments/assets/2bd834ea-c781-44ff-8e16-a4b280831f45" />

- <img width="920" height="78" alt="image" src="https://github.com/user-attachments/assets/deee26ad-ed69-4709-8bed-c8f7a8e6e819" />

- <img width="1522" height="146" alt="image" src="https://github.com/user-attachments/assets/0038f247-63ee-43c1-a54c-dc6ed7acc068" />

- <img width="1574" height="72" alt="image" src="https://github.com/user-attachments/assets/d1454f51-60cb-40b5-b416-e45bf49ac22b" />

- <img width="888" height="76" alt="image" src="https://github.com/user-attachments/assets/421d7fb3-7dbf-4cff-9ec7-d2fa13efd0c5" />

---

## 🗄️ 9. Database MySQL

Program menggunakan database bernama **`fasilitas_taman_kota`** dengan tabel `fasilitas`.

<img width="452" height="136" alt="image" src="https://github.com/user-attachments/assets/97f285e4-d4d8-42b8-a2fa-b4cf622013ec" />

### 9.1 Struktur Tabel

<img width="1928" height="624" alt="image" src="https://github.com/user-attachments/assets/33344533-2f9e-47df-96c6-e84fdf1cb0d4" />

### 9.2 Dummy Data Awal

Program menyediakan dummy data langsung melalui database SQL agar data fasilitas sudah tersedia ketika fitur Read pertama kali dijalankan.

<img width="1320" height="190" alt="image" src="https://github.com/user-attachments/assets/f5e54c92-398e-4bed-bf34-c9e7c1cc1d42" />

Dummy data dimasukkan melalui file **`fasilitas_taman_kota.sql`**, bukan melalui kode Java.

Database juga menggunakan `AUTO_INCREMENT` untuk menghasilkan ID fasilitas secara otomatis saat pengguna menambahkan data baru.

---

## ▶️ 10. Alur Menjalankan Program

Program **Sistem Manajemen Fasilitas Taman Kota** dijalankan melalui class `Main.java` pada Apache NetBeans. Setelah program dijalankan, pengguna dapat mengakses fitur pengelolaan fasilitas melalui terminal.

### 10.1 Menampilkan Menu Utama

Ketika program dijalankan, sistem menampilkan menu utama yang berisi lima pilihan, yaitu menampilkan fasilitas, menambahkan fasilitas, menghapus fasilitas, memperbarui fasilitas, dan keluar dari program.

Pengguna dapat memilih fitur dengan memasukkan nomor menu yang tersedia.

<img width="548" height="342" alt="image" src="https://github.com/user-attachments/assets/99b615b3-6957-46a3-a83f-558059dddeae" />

### 10.2 Menampilkan Data Fasilitas (Read)

Pengguna memilih **menu 1** untuk menampilkan seluruh data fasilitas yang tersimpan dalam database MySQL.

Program mengambil data melalui `FasilitasDAO`, kemudian menampilkan informasi fasilitas berupa ID, nama, kategori, kondisi, jumlah, jenis, serta hasil evaluasi kelayakan.

<img width="546" height="694" alt="image" src="https://github.com/user-attachments/assets/94cbbe90-a41a-4a55-b5d2-cae25241708e" />

### 10.3 Menambahkan Data Fasilitas (Create)

Pengguna memilih **menu 2** untuk menambahkan fasilitas baru.

Program meminta pengguna memasukkan nama fasilitas, kategori fasilitas (Umum atau Olahraga), kondisi, jumlah, dan jenis fasilitas. Data yang dimasukkan akan divalidasi terlebih dahulu sebelum disimpan ke database menggunakan JDBC dan PreparedStatement.

Apabila proses berhasil, program menampilkan pesan bahwa fasilitas berhasil ditambahkan.

<img width="558" height="668" alt="image" src="https://github.com/user-attachments/assets/77b5d61b-d254-428d-b566-cbbfa01f4b05" />

<img width="566" height="574" alt="image" src="https://github.com/user-attachments/assets/d41cf01c-5ec6-45fb-8f1d-a0dee810d9a9" />

### 10.4 Menghapus Data Fasilitas (Delete)

Pengguna memilih **menu 3** untuk menghapus data fasilitas.

Program meminta ID fasilitas yang ingin dihapus, kemudian memeriksa keberadaan data tersebut di database. Apabila ID ditemukan, data fasilitas akan dihapus menggunakan method `hapus()` pada `FasilitasDAO`.

<img width="546" height="224" alt="image" src="https://github.com/user-attachments/assets/e72eea1e-5ebf-4dc3-908d-8b14f86517da" />

### 10.5 Memperbarui Data Fasilitas (Update)

Pengguna memilih **menu 4** untuk memperbarui data fasilitas.

Program meminta ID fasilitas yang ingin diperbarui, kemudian pengguna dapat mengubah nama, kondisi, dan jumlah fasilitas. Setiap perubahan divalidasi melalui setter Model sebelum disimpan kembali ke database.

<img width="546" height="482" alt="image" src="https://github.com/user-attachments/assets/4bf30e55-efd8-45db-b239-e18773c503bc" />

<img width="1384" height="264" alt="image" src="https://github.com/user-attachments/assets/5d7a42eb-e572-452a-b4be-9bf9345a90ba" />

### 10.6 Keluar dari Program

Pengguna memilih **menu 5** untuk mengakhiri program.

Setelah menu tersebut dipilih, proses perulangan menu utama dihentikan dan program selesai dijalankan.

<img width="1024" height="270" alt="image" src="https://github.com/user-attachments/assets/951c59f0-94f7-4389-a7f5-804044a7602b" />

---

## 📝 11. Kesimpulan

Mini Project 4 berhasil mengembangkan Sistem Manajemen Fasilitas Taman Kota menjadi aplikasi Java yang terintegrasi dengan database MySQL.

Penerapan **MVC, encapsulation, inheritance, polymorphism, abstraction, JDBC, PreparedStatement, dan DAO** membantu memisahkan tanggung jawab setiap bagian program serta mendukung pengelolaan data fasilitas melalui operasi CRUD secara permanen.
