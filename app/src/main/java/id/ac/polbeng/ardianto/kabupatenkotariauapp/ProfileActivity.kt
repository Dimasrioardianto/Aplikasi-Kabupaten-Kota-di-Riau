package id.ac.polbeng.ardianto.kabupatenkotariauapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.ac.polbeng.ardianto.kabupatenkotariauapp.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgProfile.setImageResource(R.drawable.saya)
        binding.tvName.text = "Ardianto"
        binding.tvBirth.text = "Siak, 10 Januari 2000"
        binding.tvEmail.text = "ardianto@gmail..com"
        binding.tvPhone.text = "+62 812-3456-7890"
        binding.tvAddress.text = "Jl. Melati No.10, Bengkalis, Riau"
        binding.tvClass.text = "RPL-5C"
        binding.tvProdi.text = "Teknik Informatika"
        binding.tvDepartment.text = "Jurusan Rekayasa Perangkat Lunak"
    }
}
