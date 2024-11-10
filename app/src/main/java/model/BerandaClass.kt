package model

data class ArtikelPopulerCardModel(
    val judul: String,
    val desc: String,
    val jam: Int,
    val img: Int
)

data class LowonganTerbaruCardModel(
    val judul: String,
    val pt: String,
    val alamat: String,
    val jam: Int,
    val img: Int
)

data class DiskusiCardModel(
    val profil: Int,
    val nama: String,
    val status: String,
    val pertanyaan: String,
    val jawaban: Int
)