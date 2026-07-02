import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Memulai Java Static Site Generator...");

        Path templatesDir = Paths.get("templates");
        Path outputDir = Paths.get("output");
        Path outputCssDir = outputDir.resolve("css");

        try {
            // 1. Buat folder output jika belum ada
            if (!Files.exists(outputDir)) {
                Files.createDirectories(outputDir);
            }
            if (!Files.exists(outputCssDir)) {
                Files.createDirectories(outputCssDir);
            }

            // 2. Data Wisata (Idealnya bisa dari JSON/Database, ini disederhanakan dalam kode)
            String wisataTitle = "Kampung Wisata Demangan";
            String heroTitle = "Selamat Datang di Kamwis Demangan";
            String heroSubtitle = "Temukan pesona budaya, kuliner, dan keramahan warga di jantung kota.";
            
            List<String> fasilitas = Arrays.asList(
                "Homestay Nyaman|Nikmati pengalaman menginap bersama warga lokal dengan fasilitas lengkap dan lingkungan yang asri.|images/homestay.jpg",
                "Wisata Pengolahan Sampah|Edukasi pengolahan sampah organik untuk pakan maggot, kreasi sampah kertas dan plastik menjadi wayang uwuh, serta produksi cabe jawa menjadi ragam minuman herbal.|images/wayang-uwuh.jpg",
                "Tur Budaya & Sejarah|Jelajahi situs-situs bersejarah dan pelajari kebudayaan lokal dipandu langsung oleh warga asli.|images/tur-budaya.jpg"
            );

            // 3. Merakit HTML untuk daftar fasilitas
            StringBuilder facilitiesHtml = new StringBuilder();
            for (String item : fasilitas) {
                String[] parts = item.split("\\|");
                facilitiesHtml.append("<div class=\"card\">\n");
                if (parts.length > 2 && !parts[2].isEmpty()) {
                    facilitiesHtml.append("  <img src=\"").append(parts[2]).append("\" alt=\"").append(parts[0]).append("\" class=\"card-img\">\n");
                }
                facilitiesHtml.append("  <h3>").append(parts[0]).append("</h3>\n")
                              .append("  <p>").append(parts[1]).append("</p>\n")
                              .append("</div>\n");
            }

            // 4. Membaca Template HTML Utama
            Path templateFile = templatesDir.resolve("index_template.html");
            if (!Files.exists(templateFile)) {
                System.err.println("Error: File template tidak ditemukan di " + templateFile.toAbsolutePath());
                return;
            }
            String content = new String(Files.readAllBytes(templateFile));

            // 5. Menyuntikkan Data ke Placeholder
            content = content.replace("{{WISATA_TITLE}}", wisataTitle);
            content = content.replace("{{HERO_TITLE}}", heroTitle);
            content = content.replace("{{HERO_SUBTITLE}}", heroSubtitle);
            content = content.replace("{{FACILITIES}}", facilitiesHtml.toString());

            // 6. Menulis Hasil ke Output HTML
            Path outputFile = outputDir.resolve("index.html");
            Files.write(outputFile, content.getBytes());
            System.out.println("Berhasil men-generate HTML: " + outputFile.toString());

            // 7. Menyalin CSS
            Path cssTemplate = templatesDir.resolve("style.css");
            if (Files.exists(cssTemplate)) {
                Path cssOutput = outputCssDir.resolve("style.css");
                Files.copy(cssTemplate, cssOutput, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Berhasil menyalin CSS ke: " + cssOutput.toString());
            }

            System.out.println("\n✅ Selesai! Website statis berhasil dibuat. Buka file 'output/index.html' di browser Anda.");

        } catch (IOException e) {
            System.err.println("Terjadi kesalahan saat I/O operasi: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
