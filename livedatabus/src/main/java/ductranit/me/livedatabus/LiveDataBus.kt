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

package ductranit.me.livedatabus

import androidx.annotation.NonNull
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

/**
 * Singleton object to manage bus events.
 */
object LiveDataBus {

    private val subjectMap = HashMap<String, EventLiveData>()

    /**
     * Get the live data or create it if it's not already in memory.
     */
    @NonNull
    private fun getLiveData(subjectCode: String): EventLiveData {
        var liveData: EventLiveData? = subjectMap[subjectCode]
        if (liveData == null) {
            liveData = EventLiveData(subjectCode)
            subjectMap[subjectCode] = liveData
        }

        return liveData
    }

    /**
     * Subscribe to the specified subject and listen for updates on that subject.
     */
    fun subscribe(subject: String, @NonNull lifecycle: LifecycleOwner, @NonNull action: Observer<ConsumableEvent>) {
        try {
            // avoid register same instance
            getLiveData(subject).observe(lifecycle, action)
        } catch (throwable: IllegalArgumentException) {
            throwable.printStackTrace()
        }
    }

    /**
     * Removes this subject when it has no observers.
     */
    fun unregister(subject: String) {
        subjectMap.remove(subject)
    }

    /**
     * Publish an object to the specified subject for all subscribers of that subject.
     */
    fun publish(subject: String, message: ConsumableEvent = ConsumableEvent()) {
        getLiveData(subject).update(message)
    }
}