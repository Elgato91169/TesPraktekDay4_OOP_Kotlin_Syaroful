class PaketEkspres(
    nomorResi: String,
    pengirim: String,
    penerima: String,
    beratKg: Double,
    val biayaAsuransi: Double
) : Paket(nomorResi, pengirim, penerima, beratKg) {

    override fun hitungBiaya(): Double {
        return (beratKg * 15000.0) + biayaAsuransi
    }
}
