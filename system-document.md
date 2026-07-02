# System Document: Java Static Site Generator untuk Kamwis Demangan

## 1. Pendahuluan
Dokumen ini merangkum spesifikasi teknis untuk pengembangan web statis Kampung Wisata Demangan. Proyek ini menggunakan **Java** bukan sebagai *backend server* dinamis, melainkan sebagai alat pembuat (*generator*) HTML statis, sehingga menghasilkan website yang sangat cepat, aman, dan mudah di-deploy.

## 2. Komponen Teknis
- **Mesin Generator:** Java (Minimal Java 8). Akan memanfaatkan operasi File I/O bawaan (`java.nio` / `java.io`) untuk manipulasi file template.
- **Template HTML & CSS:** HTML5 dipadukan dengan Vanilla CSS modern. Desain akan memprioritaskan estetika premium, palet warna harmonis, dan tata letak responsif.
- **Placeholder Data:** Template menggunakan placeholder seperti `{{WISATA_TITLE}}` atau `{{GALLERY_ITEMS}}` yang nanti akan disuntikkan data aslinya oleh Java.

## 3. Panduan Pengembangan & Penggunaan
1. **Membangun Template:** Rancang desain web statis yang memukau di dalam folder `templates/`.
2. **Menulis Kode Generator (Java):** Kembangkan logika di `src/Main.java` untuk membaca file HTML di folder template, melakukan pencarian dan penggantian (search-and-replace) pada placeholder data, dan menyimpannya di folder `output/`.
3. **Kompilasi & Eksekusi:**
   ```bash
   javac src/Main.java
   java -cp src Main
   ```
4. **Validasi:** Buka `output/index.html` langsung dari *browser* untuk memvalidasi *layout*, warna, dan animasi.

## 4. Sinkronisasi Dokumen
Dokumen spesifikasi ini tersinkronisasi penuh dengan `system-design.md` yang merinci arsitektur umum dan alur kerja aplikasi generator. Pengembang harus selalu menjadikan dokumen desain tersebut sebagai acuan utama tata letak direktori dan konsep *Static Site Generation* (SSG).
