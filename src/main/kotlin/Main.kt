import parser.CSVParser
import parser.JSONParser
import utilities.Constant
import utilities.Converter

fun main() {

    val apps = CSVParser(Constant.FILE_NAME, Converter()).getAllApps()
    val appsJson = JSONParser(Constant.FILE_NAME_JSON, Converter()).getAllApps()

    val analyzer = Analyzer(Converter())
    analyzer.apply {
        do {
            println("1- how many apps were developed by Google in the dataset.")
            println("2- the percentage of Medical apps. ")
            println("3- what is the oldest app in the dataset. ")
            println("4- the percentage of apps running on android 9 and up only. ")
            println("5- what are the largest 10 apps in the dataset. ")
            println("6- what are the top 10 installed apps. ")
            println("7- exit")
            println("Please enter the number of the app you want to know more about: ")
            val inputToCheck = readLine()!!.toInt()
            when (inputToCheck) {
                1 -> println("This is a develop by google${findNumberOfAppsByCompanyName(apps, "Google")} apps")
                2 -> println("The percentage of Medical apps is${getPercentageOfCategory(apps, "Medical")} %")
                3 -> println("The oldest app in the dataset is ${findOldestApp(apps)}")
                4 -> println(
                    "The percentage of apps running on android 9 and up only is${
                        getPercentageAppsRunningOnSpecificVersion(
                            apps,
                            9.0
                        )
                    }%"
                )
                5 -> println("The largest 10 apps in the dataset are: ${getLargestApp(apps, 10)}")
                6 -> {
                    println("The top 10 installed apps are: ")
                    println(topNAppsInstall(apps, 10))
                }
                7 -> println("List of apps in JSON format: $appsJson")
                8 -> println("Goodbye...")

                else -> println("Please enter a valid number")
            }
        } while (inputToCheck != 7)
    }
}

