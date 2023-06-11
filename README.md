#### Test project where you can see how I use appium for automation testing on android device
##### You can download an app for testing from here https://drive.google.com/file/d/1gUEdTcSRkX5D0RIvBkoRkGkzCwddLA70/view?usp=drive_link
##### In these methods change information about your device and app path 
options.setDeviceName("Your device name");<br/>
options.setApp("Path to General-Store.apk");
##### Maybe you should change URL for appium and IP Address. I use these
 service = new AppiumServiceBuilder()<br/>
.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))<br/>
.withIPAddress("127.0.0.1")<br/>
.usingPort(4723).build();<br/>
service.start();<br/>

##### In BaseTest:
1. I run appium server
2. Set capabilities
3. initialize android driver

##### In Android actions class I use basic methods which I can use in other page object classes
##### In package PageObjects I have my page object classes
##### Run test in StoreTest classes. I am doing the following steps in tests:
1. LogIN
2. Select 2 items
3. Confirm terms
4. Go to website


