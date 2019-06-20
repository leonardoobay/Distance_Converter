package unitconverter.obayleo.com.unitconverter

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var result: TextView
    lateinit var firstChoice: Spinner
    lateinit var firstUnitGiven : String
    lateinit var secondUnitGiven : String
    lateinit var secondChoice: Spinner
    lateinit var unitActualValue: TextView
    lateinit var converterBox : Button
    lateinit var actualValue: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById(R.id.ConvertedResult)
        firstChoice = findViewById(R.id.MeasurementTypeFROM)
        secondChoice = findViewById(R.id.MeasurementTypeTO)
        unitActualValue = findViewById(R.id.ReceivingNumber)
        converterBox = findViewById(R.id.convertButton)
        actualValue = unitActualValue.getText().toString();



        val firstAdapter = ArrayAdapter.createFromResource(this, R.array.UnitsFROM, android.R.layout.simple_spinner_item)
        firstAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        firstChoice.setAdapter(firstAdapter)
        firstChoice.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                firstUnitGiven = "Please Select an Item"
                Log.d("FIRSTY", firstUnitGiven)
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                firstUnitGiven = firstAdapter.getItem(position).toString()
                Log.d("FIRSTY", firstUnitGiven)

            }


        }


        val secondAdapter = ArrayAdapter.createFromResource(this, R.array.UnitsTO, android.R.layout.simple_spinner_item)
        secondAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        secondChoice.setAdapter(secondAdapter)
//        setContentView(R.layout.activity_main)
        secondChoice.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                secondUnitGiven = "Please Select an Item"
                Log.d("FIRSTYYYY", secondUnitGiven)

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                secondUnitGiven = secondAdapter.getItem(position).toString()
                Log.d("FIRSTYYYY", secondUnitGiven)

            }


        }

        converterBox.setOnClickListener(){
                    if (unitActualValue.length() == 0 ){
            Toast.makeText(applicationContext,"Please Input a Numerical Value",Toast.LENGTH_SHORT).show()
        }
        else {
                        // do conversions  if else statement hell

                        var DoubleNum: Double = unitActualValue.text.toString().toDouble()

                        when (firstUnitGiven) {
                            "Miles"          ->   when (secondUnitGiven) {
                                "Miles"          -> result.text = DoubleNum.toString()
                                "Feet"          -> result.text =  (DoubleNum * 5280).toString()
                                "Inches"          -> result.text =  (DoubleNum * 63360).toString()
                                "Yard"          -> result.text =  (DoubleNum * 1760).toString()
                                "Kilometer"          -> result.text =  (DoubleNum * 1.60934).toString()
                                "Meter"          -> result.text =  (DoubleNum * 1609.34).toString()
                                "Centimeter"          -> result.text =  (DoubleNum * 160934).toString()
                                "Millimeter"          -> result.text =  (DoubleNum * 1609344).toString()
                            }


                            "Feet"          -> when (secondUnitGiven) {
                                "Miles"          -> result.text = (DoubleNum * 0.000189394).toString()
                                "Feet"          -> result.text =   DoubleNum.toString()
                                "Inches"          -> result.text =  (DoubleNum * 12).toString()
                                "Yard"          -> result.text =  (DoubleNum * 0.333333 ).toString()
                                "Kilometer"          -> result.text =  (DoubleNum * 0.0003048).toString()
                                "Meter"          -> result.text =  (DoubleNum * 0.3048).toString()
                                "Centimeter"          -> result.text =  (DoubleNum * 30.48).toString()
                                "Millimeter"          -> result.text =  (DoubleNum * 304.8).toString()
                            }
                            "Inches"          -> when (secondUnitGiven) {
                                "Miles"          -> result.text = (DoubleNum * 00.0000157828).toString()
                                "Feet"          -> result.text =  (DoubleNum * 0.0833333).toString()
                                "Inches"          -> result.text =  DoubleNum.toString()
                                "Yard"          -> result.text =  (DoubleNum * 0.0277778).toString()
                                "Kilometer"          -> result.text =  (DoubleNum * 0.0000254).toString()
                                "Meter"          -> result.text =  (DoubleNum * 0.0254).toString()
                                "Centimeter"          -> result.text =  (DoubleNum * 2.54).toString()
                                "Millimeter"          -> result.text =  (DoubleNum * 25.4).toString()
                            }
                            "Yard"          -> when (secondUnitGiven) {
                                "Miles"          -> result.text = (DoubleNum * 0.000568182).toString()
                                "Feet"          -> result.text =  (DoubleNum * 3).toString()
                                "Inches"          -> result.text =  (DoubleNum * 36).toString()
                                "Yard"          -> result.text =  DoubleNum.toString()
                                "Kilometer"          -> result.text =  (DoubleNum * 0.0009144).toString()
                                "Meter"          -> result.text =  (DoubleNum * 0.9144).toString()
                                "Centimeter"          -> result.text =  (DoubleNum * 91.44).toString()
                                "Millimeter"          -> result.text =  (DoubleNum * 914.4).toString()
                            }
                            "Kilometer"          -> when (secondUnitGiven) {
                                "Miles"          -> result.text = (DoubleNum * 0.621371).toString()
                                "Feet"          -> result.text =  (DoubleNum * 3280.84).toString()
                                "Inches"          -> result.text =  (DoubleNum * 39370.1).toString()
                                "Yard"          -> result.text =  (DoubleNum * 1093.61).toString()
                                "Kilometer"          -> result.text = DoubleNum.toString()
                                "Meter"          -> result.text =  (DoubleNum * 1000).toString()
                                "Centimeter"          -> result.text =  (DoubleNum * 100000).toString()
                                "Millimeter"          -> result.text =  (DoubleNum * 1000000).toString()
                            }
                            "Meter"          -> when (secondUnitGiven) {
                                "Miles"          -> result.text = (DoubleNum * 0.000621371).toString()
                                "Feet"          -> result.text =  (DoubleNum * 3.28084).toString()
                                "Inches"          -> result.text =  (DoubleNum * 39.3701).toString()
                                "Yard"          -> result.text =  (DoubleNum * 1.09361).toString()
                                "Kilometer"          -> result.text =  (DoubleNum * 0.001).toString()
                                "Meter"          -> result.text =  DoubleNum.toString()
                                "Centimeter"          -> result.text =  (DoubleNum * 100).toString()
                                "Millimeter"          -> result.text =  (DoubleNum * 1000).toString()
                            }
                            "Centimeter"          -> when (secondUnitGiven) {
                                "Miles"          -> result.text = (DoubleNum * 0.0000062137).toString()
                                "Feet"          -> result.text =  (DoubleNum * 0.0328084).toString()
                                "Inches"          -> result.text =  (DoubleNum * 0.393701).toString()
                                "Yard"          -> result.text =  (DoubleNum * 0.0109361).toString()
                                "Kilometer"          -> result.text =  (DoubleNum * 0.00001).toString()
                                "Meter"          -> result.text =  (DoubleNum * 0.01).toString()
                                "Centimeter"          -> result.text =  DoubleNum.toString()
                                "Millimeter"          -> result.text =  (DoubleNum * 10).toString()
                            }
                            "Millimeter"          -> when (secondUnitGiven) {
                                "Miles"          -> result.text = (DoubleNum * 0.000000621371).toString()
                                "Feet"          -> result.text =  (DoubleNum * 0.00328084).toString()
                                "Inches"          -> result.text =  (DoubleNum * 0.0393701).toString()
                                "Yard"          -> result.text =  (DoubleNum * 0.00109361).toString()
                                "Kilometer"          -> result.text =  (DoubleNum * 0.000001 ).toString()
                                "Meter"          -> result.text =  (DoubleNum * 0.001).toString()
                                "Centimeter"          -> result.text =  (DoubleNum * 0.1).toString()
                                "Millimeter"          -> result.text =  DoubleNum.toString()
                            }
                        }



        }
        }




    }
}



// 1 mile 5280 feet
// 1 mile is 63360 inches
// 1 mile is 1760 yard
// 1 mile is 1.60934 kilometer
// 1 mile is 1609.34 meter
// 1 mile is 160934 centimeter
// 1 mile is 1,609,344 millimeter

// 1 feet is 0.000189394 miles
// 1 feet is 12 inches
// 1 feet is 0.333333 yard
// 1 feet is 0.0003048 kilometer
// 1 feet is 0.3048 meter
// 1 feet is 30.48 centimeter
// 1 feet is 304.8 millimeter

// 1 inch is 00.0000157828 miles
// 1 inch is 0.0833333 foot
// 1 inch is 0.0277778 yard
// 1 inch is 0.0000254 kilometer
// 1 inch is  0.0254 meter
// 1 inch is  2.54 centimeter
// 1 inch is  25.4 millimeter

//1 yard is 0.000568182 mile
//1 yard is 3 feet
//1 yard is 36 inches
 //1 yard is 0.0009144 kilkometer
//1 yard is  0.9144 meter
//1 yard is  91.44 centimeter
//1 yard is  914.4 millimeter

// 1 kilo meter is 0.621371 miles
// 1 kilo meter is  3280.84 feet
// 1 kilo meter is 39370.1 inches
// 1 kilo meter is 1093.61 yard
// 1 kilo meter is 1000 meter
// 1 kilo meter is 100000 centimeters
// 1 kilo meter is 1000000 millimeter

// 1  meter is 0.000621371 miles
// 1  meter is 3.28084 feet
// 1  meter is 39.3701 inches
// 1  meter is 1.09361 yard
// 1  meter is 0.001 kilometer
// 1  meter is 100 centimeter
// 1  meter is 1000 millimeter

// 1  centimeter is 0.0000062137 miles
// 1  centimeter is 0.0328084 foot
// 1  centimeter is 0.393701 inches
// 1  centimeter is 0.0109361 yard
// 1  centimeter is 0.00001 kilometer
// 1  centimeter is 0.01 meters
// 1  centimeter is 10 millimeter

// 1  millimeter is0.000000621371 miles
// 1  millimeter is 0.00328084 feet
// 1  millimeter is 0.0393701 inches
// 1  millimeter is 0.00109361 yard
// 1  millimeter is 0.000001 kilometer
// 1  millimeter is 0.001 meter
// 1  millimeter is 0.1 centimeter



