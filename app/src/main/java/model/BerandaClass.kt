package model

import com.example.arture.app.home.component.JobStatus

data class ArtikelPopulerCardModel(
    val judul: String,
    val desc: String,
    val jam: Int,
    val img: Int
)

data class LowonganTerbaruCardModel(
    val id: Int,
    val judul: String,
    val pt: String,
    val alamat: String,
    val jam: Int,
    val img: Int,
    val kualifikasi: String,
    val pertanyaan: String
)

data class StatusPekerjaanCardModel(
    val judul: String,
    val pt: String,
    val jam: Int,
    val img: Int,
    val status: JobStatus
)

data class DiskusiCardModel(
    val profil: Int,
    val nama: String,
    val status: String,
    val pertanyaan: String,
    val jawaban: Int,
    val jam: Int
)

data class KomentarCardModel(
    val profil: Int,
    val nama: String,
    val status: String,
    val komentar: String
)