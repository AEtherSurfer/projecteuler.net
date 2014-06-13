//Counting Sundays
val noon = 12 * 60 * 60 * 1000L
val day = 24 * 60 * 60 * 1000L
val sixtyNineYears = day * (365 * 69 + 12)
val firstMillis: Long = noon - sixtyNineYears
val rangeMillis = firstMillis to firstMillis + (day * (365 * 100 + 19)) by (day * 7)
val date = new java.util.Date
rangeMillis.map{d => date.setTime(d); date.getDate()}.count(_ == 1)