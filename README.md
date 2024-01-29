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
- Add it in your root build.gradle at the end of repositories:
```gradle
dependencyResolutionManagement {
 repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
   mavenCentral()
   maven { url 'https://jitpack.io' }
 }
}
```
- Add the dependency
```gradle
implementation 'com.github.ductranit:livedatabus:1.1.0'
```

## Prerequisites
- Android API Level >= 19
- Android X (architecture component)[https://developer.android.com/topic/libraries/architecture]

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
