class PaketFragile(
    nomorResi: String,
    pengirim: String,
    penerima: String,
    beratKg: Double,
    val biayaPackingKayu: Double
) : Paket(nomorResi, pengirim, penerima, beratKg) {

    override fun hitungBiaya(): Double {
        return (beratKg * 12000.0) + biayaPackingKayu
    }
}
