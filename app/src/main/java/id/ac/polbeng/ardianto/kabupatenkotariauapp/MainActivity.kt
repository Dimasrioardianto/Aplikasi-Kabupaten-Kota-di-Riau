package id.ac.polbeng.ardianto.kabupatenkotariauapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.polbeng.ardianto.kabupatenkotariauapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var title: String = "Mode List View"
    private var listData: ArrayList<KabKota> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        setActionBarTitle(title)

        listData.addAll(KabKotaData.listDataKabKota)

        showRecylerList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                title = "Mode List View"
                showRecylerList()
            }
            R.id.action_grid -> {
                title = "Mode Grid View"
                showRecyclerGrid()
            }
            R.id.action_cardview -> {
                title = "Mode Card View"
            }
        }
        setActionBarTitle(title)
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private fun showRecylerList(){
        binding.rvKabKota.layoutManager = LinearLayoutManager(this)
        val kabKotaAdapter = ListKabKotaAdapter(listData)
        binding.rvKabKota.adapter = kabKotaAdapter
    }

    private fun showRecyclerGrid() {
        binding.rvKabKota.layoutManager = GridLayoutManager(this, 2)
        val gridKabKotaAdapter = GridKabKotaAdapter(listData)
        binding.rvKabKota.adapter = gridKabKotaAdapter
    }
}