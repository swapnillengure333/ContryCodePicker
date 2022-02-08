# ContryCodePicker
Android bottomsheet country code picker

# AndroidDateRangePicker
Android Date Range Picker

<p align="center">
  <img src="https://github.com/swapnillengure333/ContryCodePicker/blob/master/Screenshots/Screenshot_2021-08-22-22-03-06-562_com.swapnillengure.contrycodepicker.jpg" width="250" title="Screenshot">
  <img src="https://github.com/swapnillengure333/ContryCodePicker/blob/master/Screenshots/Screenshot_2021-08-22-22-03-11-722_com.swapnillengure.contrycodepicker.jpg" width="250" alt="Screenshot">
 <img src="https://github.com/swapnillengure333/ContryCodePicker/blob/master/Screenshots/Screenshot_2021-08-22-22-03-24-408_com.swapnillengure.contrycodepicker.jpg" width="250" alt="Screenshot">
 <img src="https://github.com/swapnillengure333/ContryCodePicker/blob/master/Screenshots/Screenshot_2021-08-22-22-03-32-265_com.swapnillengure.contrycodepicker.jpg" width="250" alt="Screenshot">
</p>

>Step 1. Add the JitPack repository to your build file
<h3>Add it in your root build.gradle at the end of repositories:</h3>

```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  
  >Step 2. Add the dependency
  
  ```gradle
  dependencies {
	        implementation 'com.github.swapnillengure333:ContryCodePicker:1.0'
	}
  ```
  
  >Step 3. Create CountryClickListener to get selected country code in your activity
  
  
  ```gradle
        CountryClickListener countryClickListener = new CountryClickListener() {
            @Override
            public void onItemClick(String name, String code) {
                Toast.makeText(MainActivity.this,name+ " " +code, Toast.LENGTH_LONG).show();
            }
        };
  ```
  
  >Step 4. Call CalenderInit method with param activity and DateSelectListener
  
  
  ```gradle
       CountryCodePicker.PickerInit(MainActivity.this, countryClickListener);
  ```
  
  

