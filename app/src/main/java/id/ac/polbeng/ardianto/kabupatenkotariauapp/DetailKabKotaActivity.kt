package id.ac.polbeng.ardianto.kabupatenkotariauapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import id.ac.polbeng.ardianto.kabupatenkotariauapp.databinding.ActivityDetailKabKotaBinding

class DetailKabKotaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailKabKotaBinding

    companion object {
        const val EXTRA_WISATA = "extra_wisata"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailKabKotaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val dataWisata = intent.getParcelableExtra<Wisata>(EXTRA_WISATA) as Wisata

        Glide.with(this)
            .load(dataWisata.gambar)
            .into(binding.imgItemPhoto)

        binding.tvNama.text = dataWisata.nama
        binding.tvLokasiWisata.text = dataWisata.lokasi
        binding.tvDetailWisata.text = dataWisata.detail
        binding.tvRatingWisata.text = dataWisata.rating.toString()
        binding.tvUlasanWisata.text = dataWisata.ulasan.toString()
    }
}
