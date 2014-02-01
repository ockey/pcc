import scala.collection.mutable.ListBuffer

object ProgramingContest03 {
	def main(args: Array[String]) {
		var n = 10
		var max_value = 0
		var min_value = 0
		var x = List(2, 6, 8)
		var max = ListBuffer("Right", "Right", "Right")
		var min = ListBuffer("Right", "Right", "Right")
		if (n < 1 || n > 50) System.out.println("n: Domain error. Must be (1 <= n <= 50).")
		for(obj <- x) {
			if (obj < 1 || obj > n) System.out.println("x: Domain error. Must be (1 <= x <= " + n + ").")
		}
		for (i <- 0 until x.size) {
			if (x(i) < (n - x(i))) {
				min.update(i, "Left")
				if (max_value < (n - x(i))){
					max_value = (n - x(i))
				}
				if (min_value == 0 ||  min_value < x(i)){
					min_value = x(i)
				}
			} else {
				max.update(i, "Left")
				if (max_value < x(i)){
					max_value = x(i)
				}
				if (min_value == 0 || min_value < (n - x(i))){
					min_value = (n - x(i))
				}
			}
		}
		PrintArray("Max  " + max_value + " : ", max)
		PrintArray("Min  " + min_value + " : ", min)
	}
	def PrintArray (str: String, list: ListBuffer[String]) {
		System.out.print(str)
		for(obj <- list) {
			System.out.print(obj + ",")
		}
		System.out.println()
	}
}
