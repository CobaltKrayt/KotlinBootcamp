package Books

import kotlin.random.Random

class Puppy {

    fun playWithBook(sample: Book){

        sample.tornPages(Random.nextInt(12))

    }
}