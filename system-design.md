# System Design: Java Static Site Generator untuk Kamwis Demangan

## 1. Arsitektur Sistem
- **Tipe Aplikasi:** Web Statis (Static Site Generator)
- **Bahasa Pemrograman Utama:** Java
- **Pendekatan:** Program Java membaca data terkait Kampung Wisata Demangan (seperti deskripsi wisata, daftar fasilitas, dll.) dan memadukannya ke dalam template HTML untuk menghasilkan file statis.
- **Hosting/Deployment:** File HTML hasil *generate* bersifat murni statis, sehingga sangat mudah dan murah untuk di-hosting di layanan seperti GitHub Pages, Netlify, atau web server lainnya.

## 2. Alur Kerja (Workflow)
1. **Input:** File data (misalnya teks atau struktur data di dalam kode Java) dan template HTML mentah.
2. **Proses (Java):** Kelas `Main.java` berjalan untuk merakit template HTML dengan memasukkan data pariwisata.
3. **Output:** Menghasilkan halaman akhir (seperti `index.html`) di dalam folder `output/` yang siap untuk digunakan oleh pengguna.

## 3. Struktur Direktori
```text
kamwis-demangan/
│
├── src/
│   └── Main.java             # Kode utama Java generator
├── templates/
│   └── index_template.html   # Template HTML dasar
├── output/                   # Folder hasil akhir website (Website Statis)
│   ├── index.html            
│   ├── css/                  # Gaya dan desain (Vanilla CSS)
│   └── js/                   # Skrip tambahan untuk animasi ringan
├── system-design.md
└── system-document.md
```

## 4. Desain Antarmuka (HTML Output)
Sistem ini akan merender HTML dengan spesifikasi:
- **Hero Section:** Banner selamat datang interaktif untuk memukau pengunjung.
- **Daftar Fasilitas/Wisata:** Komponen UI elegan dengan *micro-animations* yang dibuat dengan Vanilla CSS.
- **Responsif:** Antarmuka yang mulus di perangkat *mobile* maupun *desktop*.
