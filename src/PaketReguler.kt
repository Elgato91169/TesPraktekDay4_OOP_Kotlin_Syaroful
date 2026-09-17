class PaketReguler(
    nomorResi: String,
    pengirim: String,
    penerima: String,
    beratKg: Double
) : Paket(nomorResi, pengirim, penerima, beratKg) {

    override fun hitungBiaya(): Double {
        return super.hitungBiaya()
    }
}
