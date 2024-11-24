package com.example.arture.data

import com.example.arture.R
import model.LowonganTerbaruCardModel

object DummyData {
    val lowongancard = listOf(
      LowonganTerbaruCardModel(
          id = 1,
          judul = "Technical Salesss Feedmill",
          pt = "PT. Sreeya Sewu Indonesia, Tbk",
          alamat = "Blitar, Jawa Timur",
          jam = 13,
          img = R.drawable.lowongan_img_test,
          kualifikasi = "• Candidate must posses at least Bachelor degree in Animal Husbandry / Veterinarian\n" +
                  "• Candidate must posses at least Bachelor degree in Animal Husbandry / Veterinarian\n" +
                  "• Candidate must posses at least Bachelor degree in Animal Husbandry / Veterinarian\n",
          pertanyaan = "• Kualifikasi apa saja yang Anda miliki?\n" +
                  "• Apakah Anda memiliki SIM Indonesia saat ini?\n" +
                  "• Berapa gaji pokok bulanan yang Anda harapkan?\n" +
                  "• Apakah Anda memiliki pengalaman dalam peran penjualan?\n" +
                  "• Berapa tahun pengalaman Anda sebagai Peran Penjualan Teknis?\n" +
                  "• Apakah Anda memiliki Gelar Sarjana?\n"
      ),
        LowonganTerbaruCardModel(
            id = 2,
            judul = "Field Officer",
            pt = "PT Berindo Jaya",
            alamat = "Bandar Lampung, Lampung",
            jam = 13,
            img = R.drawable.lowongan_img_barindojaya,
            kualifikasi = "• Candidate must posses at least Bachelor degree in Animal Husbandry / Veterinarian",
            pertanyaan = "• Which of the following types of qualifications do you have?"
        )

    )
}