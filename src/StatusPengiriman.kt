sealed class StatusPengiriman {
    object MenungguDiproses : StatusPengiriman()

    data class DalamPerjalanan(val namaKurir: String) : StatusPengiriman()

    data class Terkirim(
        val namaPenerima: String,
        val waktuSelesai: String
    ) : StatusPengiriman()

    data class Gagal(val alasan: String) : StatusPengiriman()
}
