package livedatabus.ductran.me.livedatabus.sample

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import ductranit.me.livedatabus.LiveDataBus
import kotlinx.android.synthetic.main.activity_main.*
import livedatabus.ductran.me.livedatabus.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnViewDetail.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }

        LiveDataBus.subscribe("click", this, Observer {
            it.runAndConsume {
                Toast.makeText(this, "Hello ${it.value}", Toast.LENGTH_LONG).show()
            }
        })
    }
}
