open class Paket(
    val nomorResi: String,
    val pengirim: String,
    val penerima: String,
    val beratKg: Double
) {
    var status: StatusPengiriman = StatusPengiriman.MenungguDiproses
        private set

    open fun hitungBiaya(): Double {
        return beratKg * 10000.0
    }

    fun updateStatus(statusBaru: StatusPengiriman) {
        status = statusBaru
    }

    open fun tampilkanInfo() {
        println("Nomor Resi  : $nomorResi")
        println("Pengirim     : $pengirim")
        println("Penerima     : $penerima")
        println("Status       : $status")
        println("Biaya        : Rp${hitungBiaya()}")
    }
}
