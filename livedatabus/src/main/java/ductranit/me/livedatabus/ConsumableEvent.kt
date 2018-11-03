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

/**
 *  A consumable event, make sure event can run only one time
 *  If you don't consume it, an event can be run multiple times
 */
data class ConsumableEvent(var isConsumed: Boolean = false, var value: Any? = null) {
    /**
     *  run task & consume event after that
     */
    fun runAndConsume(runnable: () -> Unit) {
        if (!isConsumed) {
            runnable()
            isConsumed = true
        }
    }
}