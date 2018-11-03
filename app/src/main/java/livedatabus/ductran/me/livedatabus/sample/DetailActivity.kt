package livedatabus.ductran.me.livedatabus.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ductranit.me.livedatabus.ConsumableEvent
import ductranit.me.livedatabus.LiveDataBus
import kotlinx.android.synthetic.main.activity_detail.*
import livedatabus.ductran.me.livedatabus.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        btnFireEvent.setOnClickListener {
            LiveDataBus.publish("click", ConsumableEvent(value = txtName.text))
            finish()
        }
    }
}
