# Sasto Tickets SDK
SASTO TICKETS SDK INTEGRATION USER GUIDE

The Sasto Tickets SDK allows native android apps  to  easily search and book domestic and international flights. 

#### Transaction Flow
Client Mobile Application initiates Sasto Tickets SDK where the UI lets the user browse through different kinds of flights
Once user selects the flights, the user will have to fill up their information to then book the flight, this will be handled by the SDK. After successfully completing the booking, sdk will return the ticket and reference id, which will be used to initiate the payment later on. When the payment is successful, booking is complete and details can be fetched with the bookingReferenceId.


## Getting Started
Add SDK to your project
The .aar file must be added to libs folder of your projects app module (Your Project -> app -> libs ). After that add the following code in your apps build.gradle:

```
android{
...

repositories {
               flatDir {dirs ‘libs’}
             }
}

```

```
dependencies {
   implementation files('libs/stsdk.aar')
   implementation 'com.squareup.picasso:picasso:2.71828'
}
```


Add permissions to your Android Manifest.xml file

```
<uses-permission android:name=”android.permission.INTERNET” />
<uses-permission android:name=”android.permission.ACCESS_NETWORK_STATE” />
```

## Starting Flights Search

```
val intent = Intent(this, SplashActivity::class.java)
intent.putExtra(SastoTicketsSDK.USERNAME,"<username>")
intent.putExtra(SastoTicketsSDK.PASSWORD,"<password>")
startActivityForResult(intent,
    SastoTicketsSDK.RC_INIT
)
```

## Listening for response

```
override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == SastoTicketsSDK.RC_INIT) {
        if (resultCode == RESULT_OK) {
            //SDK:: RESPONSE OK! 
            val bookingReferenceID = data?.extras?.get("bookingReferenceID")

            //use booking & ticket reference ID to get details when necessary
        } else {
            //SDK:: CANCEL!
        }
    }
}
```

## Payment for ticket/booking
Still in development.
