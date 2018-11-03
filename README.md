# LivedataBus
Make an Event Bus with LiveData

## Why this library?
- It uses `LiveData`, which can be used to help manage propagating data to your views, while respecting the activity and fragment lifecycles.
- Simplifies the communication between components, just like [EventBus](https://github.com/greenrobot/EventBus).
- Makes your code simpler.
- Tiny codes.

## How to use?
- Subscribe
```
  LiveDataBus.subscribe("event_name", this, Observer {
            it.runAndConsume {
                Toast.makeText(this, "Hello ${it.value}", Toast.LENGTH_LONG).show()
            }
        })
```
- Publish
```
  val obj = SomeEvent()
  LiveDataBus.publish("event_name", ConsumableEvent(value = obj))
```
## Install
Via Gradle:
```gradle
implementation 'ductranit.me.livedatabus:livedatabus:1.0.0'
```

Via Maven:
```xml
<dependency>
  <groupId>ductranit.me.livedatabus</groupId>
  <artifactId>livedatabus</artifactId>
  <version>1.0.0</version>
  <type>pom</type>
</dependency>
```

## Prerequisites
- Android API Level >= 14
- Android X (architecture component)[https://developer.android.com/topic/libraries/architecture]
- Kotlin >= `1.3.0`

## References
https://hisblog.yoursun.me/2018/02/12/Android-Replace-EventBus-with-LiveData.html
https://android.jlelse.eu/how-to-make-an-event-bus-with-googles-livedata-5efcc50d818f

## License
-------

Copyright (C) 2018 ductranit

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.
