package com.ravishrajput.bff

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.ravishrajput.bff")
		.start()
}

