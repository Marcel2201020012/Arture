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
            kualifikasi = "• Candidate must posses at least Bachelor degree in Animal Husbandry / Veterinarian\n" +
                    "• At least 2 year of working experience in sales Feedmill / Animal Pharmaceutical (OVDF)\n" +
                    "• Candidate must posses at least Bachelor degree in Animal Husbandry / Veterinarian\n" +
                    "• Strong Communication skill, analytical skill and can assess customer opportunities and competitor behavior\n" +
                    "• Skill-full in planning tactics and approach, negotiating and closing the deal, networking with customer’s organization and maintaining the relationship\n",
            pertanyaan = "• Which of the following types of qualifications do you have?\n" +
                    "• Do you have a current Indonesian driver's licence?\n" +
                    "• What's your expected monthly basic salary?\n" +
                    "• Do you have experience in a sales role?\n" +
                    "• How many years' experience do you have as a Technical Sales Role?\n" +
                    "• Do you have a Bachelor Degree?\n"
        )

    )
}