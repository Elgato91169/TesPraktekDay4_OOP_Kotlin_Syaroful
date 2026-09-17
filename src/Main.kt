fun main() {
    val manager = EkspedisiManager()

    val paket1 = PaketReguler(
        "REG001",
        "Andi",
        "Budi",
        2.0
    )

    val paket2 = PaketReguler(
        "REG002",
        "Citra",
        "Deni",
        1.5
    )

    val paket3 = PaketEkspres(
        "EXP001",
        "Eko",
        "Fajar",
        3.0,
        20000.0
    )

    val paket4 = PaketFragile(
        "FRG001",
        "Gina",
        "Hadi",
        2.5,
        30000.0
    )

    manager.terimaPaket(paket1)
    manager.terimaPaket(paket2)
    manager.terimaPaket(paket3)
    manager.terimaPaket(paket4)

    paket1.updateStatus(StatusPengiriman.DalamPerjalanan("Rian"))
    paket2.updateStatus(StatusPengiriman.Terkirim("Deni", "17-09-2026 09:30"))
    paket3.updateStatus(StatusPengiriman.Gagal("Alamat penerima tidak ditemukan"))
    paket4.updateStatus(StatusPengiriman.DalamPerjalanan("Bambang"))

    manager.tampilkanSemuaPaket()

    println("=== HASIL LACAK PAKET ===")
    manager.lacakPaket("EXP001")

    println("=== TOTAL PENDAPATAN EKSPEDISI ===")
    println("Rp${manager.hitungTotalPendapatan()}")
}
