# TUGAS PRAKTIK: Sistem Manajemen Ekspedisi (Logistics Management System)

**Deskripsi Tugas:**
Anda diminta untuk membangun sebuah sistem simulasi perusahaan ekspedisi (pengiriman barang) menggunakan Kotlin. Sistem ini harus mampu mengelola berbagai jenis paket, menghitung biaya pengiriman secara dinamis, dan melacak status pengiriman dengan aman.

Silakan bangun program tersebut dengan spesifikasi dan batasan berikut:

## 1\. Buat `Sealed Class` untuk Status Pengiriman (Modul 4)

Buatlah sebuah *sealed class* bernama `StatusPengiriman` yang merepresentasikan status paket:

* `MenungguDiproses` (objek)
* `DalamPerjalanan` (data class, memiliki properti: `namaKurir: String`)
* `Terkirim` (data class, memiliki properti: `namaPenerima: String`, `waktuSelesai: String`)
* `Gagal` (data class, memiliki properti: `alasan: String`)

## 2\. Buat Kelas Induk `Paket` (Modul 1, 2, \& 3)

Buatlah sebuah *open class* bernama `Paket` dengan spesifikasi:

* **Properti Dasar (Read-only):** `nomorResi` (String), `pengirim` (String), `penerima` (String), `beratKg` (Double).
* **Properti Terenkapsulasi:** `status` (tipe `StatusPengiriman`). Properti ini harus menggunakan **private setter** agar statusnya tidak bisa diubah sembarangan dari luar kelas. Nilai default-nya adalah `StatusPengiriman.MenungguDiproses`.
* **Metode `hitungBiaya()` (open):** Mengembalikan nilai `Double`. Secara default mengembalikan `beratKg \* 10000.0`.
* **Metode `updateStatus(statusBaru: StatusPengiriman)`:** Metode publik untuk mengubah properti `status`.
* **Metode `tampilkanInfo()` (open):** Menampilkan nomor resi, pengirim, penerima, status saat ini, dan biaya pengiriman.

## 3\. Buat Kelas Anak (Modul 3 \& 4)

Buat tiga kelas yang mewarisi kelas `Paket` dan terapkan *Method Overriding*:

* **`PaketReguler`:** Tidak ada properti tambahan. `hitungBiaya()` sama dengan kelas induk.
* **`PaketEkspres`:**

  * Memiliki properti tambahan: `biayaAsuransi` (Double).
  * *Override* `hitungBiaya()` menjadi: `(beratKg \* 15000.0) + biayaAsuransi`.
* **`PaketFragile` (Barang Pecah Belah):**

  * Memiliki properti tambahan: `biayaPackingKayu` (Double).
  * *Override* `hitungBiaya()` menjadi: `(beratKg \* 12000.0) + biayaPackingKayu`.

## 4\. Buat Kelas `EkspedisiManager` (Modul 2 \& 4)

Buat kelas untuk mengelola data dengan spesifikasi:

* **Properti:** `daftarPaket` (private) yang merupakan sekumpulan daftar (`MutableList`) dari kelas `Paket` (**Polymorphic reference**).
* **Metode `terimaPaket(paket: Paket)`:** Menambahkan paket ke dalam `daftarPaket`.
* **Metode `lacakPaket(resi: String)`:** Mencari paket berdasarkan nomor resi dan menampilkan infonya menggunakan *Smart Casting* (tampilkan pesan khusus jika paket itu adalah `PaketEkspres` atau `PaketFragile`).
* **Metode `tampilkanSemuaPaket()`:** Melakukan *looping* ke semua paket dan memanggil metode `tampilkanInfo()`.
* **Metode `hitungTotalPendapatan()`:** Mengembalikan total seluruh biaya pengiriman dari semua paket yang ada di dalam sistem.

## 5\. Implementasi Fungsi `main()`

Di dalam fungsi `main()`:

1. Buat satu objek dari `EkspedisiManager`.
2. Buat minimal 4 objek paket yang berbeda (contoh: 2 Reguler, 1 Ekspres, 1 Fragile) dan masukkan ke dalam manajer.
3. Ubah status paket-paket tersebut melalui metode `updateStatus()` (misal: satu paket diubah menjadi `DalamPerjalanan`, satu menjadi `Terkirim`, satu menjadi `Gagal`).
4. Panggil metode `tampilkanSemuaPaket()`.
5. Panggil metode pencarian `lacakPaket()` untuk menguji *Smart Casting*.
6. Tampilkan **Total Pendapatan Ekspedisi** dari metode `hitungTotalPendapatan()`.

\---

## 📋 Kriteria Penilaian (Rubrik Evaluasi)

|Kriteria|Bobot|Indikator Keberhasilan|
|-|:-:|-|
|**Enkapsulasi \& State**|**25%**|Properti `status` menggunakan *private setter*. Perubahan status hanya melalui metode khusus dan tervalidasi dengan baik.|
|**Pewarisan (Inheritance)**|**20%**|Penggunaan keyword `open` yang tepat pada kelas induk. Subclass menggunakan `:` dan menginisialisasi *constructor* induk (menggunakan `super`).|
|**Polimorfisme**|**25%**|*Overriding* pada `hitungBiaya()` bekerja sesuai aturan subclass. *List* mampu menyimpan berbagai bentuk objek `Paket` secara polimorfik.|
|**Sealed Class \& Casting**|**20%**|*Sealed class* dideklarasikan dengan benar. Penggunaan `is` / *Smart Casting* terimplementasi tanpa error.|
|**Clean Code \& Output**|**10%**|Kode bersih, rapi, fungsi `main()` berjalan sesuai skenario tanpa *error* / *crash*.|

\---

