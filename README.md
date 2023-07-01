![Logo](https://raw.githubusercontent.com/foobnix/LirbiReader/master/logo.jpg)

**The development and support of Librera is frozen for an unpredictable time, there is a big war in my country
Ukraine.**
[Russian invasion of Ukraine](https://en.wikipedia.org/wiki/2022_Russian_invasion_of_Ukraine)

[OFFICIAL FUNDRAISING PLATFORM OF UKRAINE](https://u24.gov.ua/)

# Librera Reader

Librera Reader is an e-book reader for Android devices;
it supports the following formats: PDF, EPUB, EPUB3, MOBI, DjVu, FB2, TXT, RTF, AZW, AZW3, HTML, CBZ, CBR, DOC, DOCX,
and OPDS Catalogs

### Download application

[Librera Reader on Google Play](https://play.google.com/store/apps/details?id=com.foobnix.pdf.reader)

[Librera PRO on Google Play](https://play.google.com/store/apps/details?id=com.foobnix.pro.pdf.reader)

[Librera F-Droid](https://f-droid.org/en/packages/com.foobnix.pro.pdf.reader/)

[Beta testing .apk](http://beta.librera.mobi/)

[Application Fonts.zip](https://github.com/foobnix/LirbiReader/tree/master/Builder/fonts)

### Links

[web: https://librera.mobi/](https://librera.mobi/)

[What is new/Changes](https://librera.mobi/what-is-new/)

[FAQ](https://librera.mobi/faq/)

[Telegram Info](https://t.me/LibreraReader)

[Telegram Chat](https://t.me/librera_reader_chat)

[Support/Donations on Patreon](https://www.patreon.com/librera)

[Email: librera.reader@gmail.com](mailto:librera.reader@gmail.com)

## Required build libs

~~~~
mesa-common-dev libxcursor-dev libxrandr-dev libxinerama-dev libglu1-mesa-dev libxi-dev pkg-config libgl-dev
~~~~

You also need the Android NDK in version 20+
Please ensure to download it using android studio and add the NDK to your PATH.

## Create a keystore

Even if you do not plan to upload a version yourself you need a keystore with a certificate to build.
The keystore needs to be in PKCS12 format.
You can create a keystore in your actual directory using the following call
(replace ALIAS by your alias, it is just a name):

~~~~
keytool -genkey -v -storetype PKCS12 -keystore keystore.pkcs12 -alias ALIAS -keyalg RSA -keysize 2048 -validity 10000
~~~~

Now edit or create the file ~/.gradle/gradle.properties and set following values
(replacing PASSWD by the password you typed while creating the keystore, ALIAS as before and using the path to your
keystore):

~~~~
RELEASE_STORE_FILE=/PATH/TO/YOUR/keystore.pkcs12
RELEASE_STORE_PASSWORD=PASSWD
RELEASE_KEY_PASSWORD=PASSWD
RELEASE_KEY_ALIAS=ALIAS
~~~~

## Create Firebase Authentication file

To build with firebase support (all version but the ones for Fdroid) you need to get an
authentication file for firebase services offered by google. Therefore please follow
https://firebase.google.com/docs/android/setup to create your own project. You need to
register for the packages com.foobnix.pdf.info and com.foobnix.pdf.reader.a1. This way
you will get a google-services.json file that you have to place in the app folder of
the repository.

For this project only Analytics is used, so a spakling plan is all you need.

## Librera Build on MuPdf

~~~~
cd Builder
./link_to_mupdf_x.x.x.sh (Change the paths to mupdf and jniLibs folders)
./gradlew assembleLibrera
~~~~

## Building for F-Droid for Android

If you wish to build for F-Droid (e.g. not using google services, Internet) you can run the build with

~~~~
cd Builder
./link_to_mupdf_x.x.x.sh
./gradlew assembleFdroid
~~~~

F-Droid build does also not need a **google-services.json**

## Build on mac
Before proceeding make sure you have android NDK set up.
Check the file Builder/link_to_mupdf_x.x.x.sh. Check the if ndk-build commands are using the proper path where NDK is installed.
If not modify this path to point to the correct path of NDK whihc can be something like 
~~~
/Users/<usename>/Library/Android/Sdk/ndk/<ndk-version-number>>/ndk-build
~~~

* Set ndk project path
~~~
 export NDK_PROJECT_PATH=<path_to_project_root>/Builder/mupdf-x.x.x/platform/librera
~~~ 

* Build mupdf
~~~~
cd Builder
./link_to_mupdf_x.x.x.sh
~~~~
this will checkout mupdf repo and build it

* build apk
~~~
./gradlew assembleFdroid
~~~
Please note: Above command must be run in project root folder

* Install on device:

Adb command to install apk
~~~
 adb install Librera\ Librera-8.9.18-uni.apk 
~~~
Please make sure you escape the space as it can make the command format invalid.
If you are unable to run adb in terminal you can find out the path on which adb exists. 
It would be something like
~~~
/Users/<username>/Library/Android/sdk/platform-tools/
~~~
you can set this on the PATH temporarily like below and this try to install the apk again.
~~~
export PATH=/Users/<username>/Library/Android/sdk/platform-tools/:$PATH
~~~


### Below link might be helpful in case you face any build issues on mac
https://stackoverflow.com/questions/46872922/broken-c-std-libraries-on-macos-high-sierra-10-13/47401866#47401866:~:text=102-,I%20had%20exactly,-the%20same%20problem


## Librera depends on:

MuPDF - (AGPL License) https://mupdf.com/downloads/archive/

* ebookdroid
* djvulibre
* hpx
* junrar
* glide
* libmobi
* commons-compress
* eventbus
* greendao
* jsoup
* juniversalchardet
* commons-compress
* okhttp3
* okhttp-digest
* okio
* rtfparserkit
* java-mammoth
* zip4j

Librera is distributed under the GPL

## License

See the [LICENSE](LICENSE.txt) file for license rights and limitations (GPL v.3).
