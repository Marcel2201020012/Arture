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