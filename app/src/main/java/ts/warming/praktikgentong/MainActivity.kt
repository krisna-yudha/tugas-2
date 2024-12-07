package ts.warming.praktikgentong

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ts.warming.praktikgentong.adapter.CityAdapter
import ts.warming.praktikgentong.model.City

class MainActivity : AppCompatActivity() {

    lateinit var recyclerViewCity: RecyclerView
    lateinit var cityAdapter: CityAdapter
    var listCity = ArrayList<City>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewCity = findViewById(R.id.recyclerViewCity)
        cityAdapter = CityAdapter(this, listCity)

        recyclerViewCity.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerViewCity.adapter = cityAdapter
        populateData()

        // Mengambil tombol About dan menambahkan listener untuk membuka AboutActivity
        val btnAbout: ImageButton = findViewById(R.id.btnAbout)
        btnAbout.setOnClickListener {
            // Membuka AboutActivity
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }

    private fun populateData() {
        val citiesInIndonesia = listOf(
            City("Jakarta", "The capital city, known for its bustling urban life and rich history.", R.drawable.jakarta),
            City("Bandung", "Known for its cooler climate and beautiful landscapes, popular for fashion and culinary tourism.", R.drawable.bandung),
            City("Medan", "The largest city in Sumatra, famous for its diverse cuisine and as a gateway to Lake Toba.", R.drawable.medan),
            City("Bali", "An island province renowned for its stunning beaches, rice terraces, and vibrant arts scene.", R.drawable.bali),
            City("Semarang", "A port city known for its blend of Javanese and Chinese cultures and colonial architecture.", R.drawable.semarang),
            City("Palembang", "Famous for its culinary delights, particularly the dish pempek, and the Musi River.", R.drawable.palembang),
            City("Makassar", "The largest city in Eastern Indonesia, known for its maritime culture and delicious seafood.", R.drawable.makasar),
            City("Yogyakarta", "A cultural hub known for its traditional arts, batik, and the nearby Borobudur Temple.", R.drawable.yogyakarta),
            City("Batam", "An industrial city close to Singapore, known for its economic zones and beaches.", R.drawable.batam),
            City("Denpasar", "The capital of Bali, a gateway to the island's tourist attractions and cultural sites.", R.drawable.denpasar),
            City("Tangerang", "Part of the Greater Jakarta area, known for its modern amenities and shopping centers.", R.drawable.tanggerang),
            City("Malang", "A city known for its cooler climate, beautiful parks, and as a base for Mount Bromo.", R.drawable.malang),
            City("Samarinda", "The capital of East Kalimantan, located by the Mahakam River, known for its natural beauty.", R.drawable.samarinda)
        )

        listCity.addAll(citiesInIndonesia)
        cityAdapter.notifyDataSetChanged()
    }
}
