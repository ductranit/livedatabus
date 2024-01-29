/*
 * Copyright (C) 2018 ductranit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package livedatabus.ductran.me.livedatabus.sample

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ductranit.me.livedatabus.ConsumableEvent
import ductranit.me.livedatabus.LiveDataBus
import livedatabus.ductran.me.livedatabus.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val textName: TextView = findViewById(R.id.txtName)
        findViewById<Button>(R.id.btnFireEvent).setOnClickListener {
            LiveDataBus.publish("click", ConsumableEvent(value = textName.text))
            finish()
        }
    }
}
