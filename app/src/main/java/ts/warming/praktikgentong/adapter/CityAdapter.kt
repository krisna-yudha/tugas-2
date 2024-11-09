package ts.warming.praktikgentong.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ts.warming.praktikgentong.DetailCityActivity
import ts.warming.praktikgentong.R
import ts.warming.praktikgentong.model.City

class CityAdapter(var context: Context, var listCity: ArrayList<City>) :
    RecyclerView.Adapter<CityAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title: TextView = itemView.findViewById(R.id.tvCityName)
        var image: ImageView = itemView.findViewById(R.id.ivCity)

        fun initView(city: City) {
            // Mengatur teks nama kota
            title.text = city.cityName

            // Mengatur gambar kota menggunakan ID resource
            image.setImageResource(city.cityImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_city, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listCity.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listCity[position]
        holder.initView(data)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailCityActivity::class.java)
            intent.putExtra("city_image", data.cityImage)
            intent.putExtra("city_name", data.cityName)
            intent.putExtra("city_description", data.cityDescription)
            context.startActivity(intent)
        }
    }
}

private fun Any.setImageResource(cityImage: String?) {

}
