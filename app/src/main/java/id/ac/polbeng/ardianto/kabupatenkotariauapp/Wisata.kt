package id.ac.polbeng.ardianto.kabupatenkotariauapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Wisata(
    var nama: String = "",
    var lokasi: String = "",
    var detail: String = "",
    var rating: Double = 0.0,
    var ulasan: Int = 0,
    var gambar: Int = 0
) : Parcelable
