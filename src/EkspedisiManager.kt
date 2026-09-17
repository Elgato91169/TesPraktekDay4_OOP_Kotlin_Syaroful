class EkspedisiManager {
    private val daftarPaket = mutableListOf<Paket>()

    fun terimaPaket(paket: Paket) {
        daftarPaket.add(paket)
    }

    fun lacakPaket(resi: String) {
        val paket = daftarPaket.find { it.nomorResi == resi }

        if (paket != null) {
            paket.tampilkanInfo()

            if (paket is PaketEkspres) {
                println("Jenis paket : Ekspres")
                println("Biaya asuransi : Rp${paket.biayaAsuransi}")
            } else if (paket is PaketFragile) {
                println("Jenis paket : Fragile")
                println("Biaya packing kayu : Rp${paket.biayaPackingKayu}")
            } else {
                println("Jenis paket : Reguler")
            }
        } else {
            println("Paket dengan nomor resi $resi tidak ditemukan.")
        }
    }

    fun tampilkanSemuaPaket() {
        println("=== DAFTAR SEMUA PAKET ===")
        for (paket in daftarPaket) {
            paket.tampilkanInfo()
            println("---------------------------")
        }
    }

    fun hitungTotalPendapatan(): Double {
        var total = 0.0

        for (paket in daftarPaket) {
            total += paket.hitungBiaya()
        }

        return total
    }
}
