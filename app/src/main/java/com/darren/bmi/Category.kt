package com.darren.bmi

class Category {

    fun getCategory(BMI : Double): String{
        var category : String
        if(BMI < 15){
            category = "Very severely underweight"
        }
        else if(BMI >= 15 && BMI < 16){
            category = "Severely underweight"
        }
        else if(BMI >= 16 && BMI < 18.5){
            category = "Underweight"
        }
        else if(BMI >= 18.5 && BMI < 25){
            category = "Normal (Healthy weight)"
        }
        else if(BMI >= 25 && BMI < 30){
            category = "Overweight"
        }
        else if(BMI >= 30 && BMI < 35) {
            category = "Moderately obese"
        }
        else if(BMI >= 35 && BMI < 40){
            category = "Severely obese"
        }
        else{
            category ="Very severely obese";
        }


        return category
    }

}