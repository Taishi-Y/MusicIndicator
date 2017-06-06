# Music Indicator
<!-- [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-FlipProgressDialog-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/5054)
[ ![Download](https://api.bintray.com/packages/taishi-y/maven/flipprogressdialog/images/download.svg) ](https://bintray.com/taishi-y/maven/flipprogressdialog/_latestVersion)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0) -->

Music indicator for Android.🎧 ✨

You can show this when the audio is played.🎵

<img src="https://github.com/Taishi-Y/MusicIndicator/blob/master/art/samplegif.gif?raw=true"
alt="" width="240" border="10" />

Installation
============
Add it in your root build.gradle at the end of repositories:
```gradle
dependencies {
  compile 'com.taishi-y:musicindicator:0.1.0'
}
```

Usage
=====

1 - Include app namespace to the root element :

	xmlns:app="http://schemas.android.com/apk/res-auto"

2 - Add the Indicator View with custom params :

```
<com.taishi.library.Indicator
      android:id="@+id/indicator"
      android:layout_width="match_parent"
      android:layout_height="180dp"
      android:layout_alignParentTop="true"
      android:background="#000000"
      app:bar_num="50"
      app:bar_color="#1DD069"
      app:step_num="70"
      app:duration="20000"
      />
```

####  Supported Attributes

| XML Attribute        | Java Attribute           | Description  |
| ------------- |:-------------:| -----:|
| app:bar_num      | setBarNum(int)     | Number of Bars |
| app:bar_color     | setBarColor(int)      |  Color of the button |
| app:duration | setDuration(int)      |    Duration of a bar animation |
| app:step_num | setStepNum(int)      |    Number of bar animation steps|




Sample
=====

**1 - Normal Music Indicator**

![Normal Music Indicator ](https://github.com/Taishi-Y/MusicIndicator/blob/master/art/circlenormal.gif?raw=true)

```
<com.taishi.library.Indicator
      android:id="@+id/indicator"
      android:layout_width="match_parent"
      android:layout_height="180dp"
      android:layout_alignParentTop="true"
      android:background="#000000"
      app:bar_num="50"
      app:bar_color="#1DD069"
      app:step_num="70"
      app:duration="20000"
      />
```

**2 - Google Music Like**

![](https://github.com/Taishi-Y/MusicIndicator/blob/master/art/circlesample.gif?raw=true)

```
  <RelativeLayout
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:layout_margin="10dp"
          android:background="@drawable/circle">
          <com.taishi.library.Indicator
              android:layout_width="50dp"
              android:layout_height="50dp"
              android:layout_margin="20dp"
              app:bar_num="3"
              app:bar_color="#fff"
              app:step_num="10"
              app:duration="3000"/>
      </RelativeLayout>
```

```
<shape xmlns:android="http://schemas.android.com/apk/res/android"
       android:shape="oval">
    <solid
        android:color="#48b3ff"/>
</shape>
```

See the [example project](https://github.com/Taishi-Y/MusicIndicator/tree/master/app) for more samples




Developed By
============
```
Taishi Yamasaki
```
- Website (http://taishi.tech/)
- Twitter (https://twitter.com/taishi_yamasaki)
- LinkedIn (https://www.linkedin.com/in/taishi-yamasaki)
- For contact, shoot me an email at <taishi.dev@gmail.com>

# How to Contribute
1. Fork it
2. Create your feature branch (git checkout -b my-new-feature)
3. Commit your changes (git commit -am 'Add some feature')
4. Push to the branch (git push origin my-new-feature)
5. Create new Pull Request

# License

    Copyright 2017 Taishi Yamasaki

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
