package id.ac.polbeng.ardianto.kabupatenkotariauapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.polbeng.ardianto.kabupatenkotariauapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var title: String = "Daftar Wisata Di Riau"
    private var listData: ArrayList<Wisata> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        setActionBarTitle(title)

        listData.addAll(WisataData.listDataWisata)

        showRecyclerCardView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_profile -> {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            }
        }
        setActionBarTitle(title)
        return super.onOptionsItemSelected(item)
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private fun showRecyclerCardView() {
        binding.rvKabKota.layoutManager = LinearLayoutManager(this)
        val cardKabKotaAdapter = CardKabKotaAdapter(listData)
        binding.rvKabKota.adapter = cardKabKotaAdapter
        cardKabKotaAdapter.setOnItemClickCallback(object : CardKabKotaAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Wisata) {
                showDataKabKota(data)
            }
        })
    }

    private fun showDataKabKota(data: Wisata) {
        val moveWithObjectIntent = Intent(this@MainActivity, DetailKabKotaActivity::class.java)
        moveWithObjectIntent.putExtra(DetailKabKotaActivity.EXTRA_WISATA, data)
        startActivity(moveWithObjectIntent)
    }
}
