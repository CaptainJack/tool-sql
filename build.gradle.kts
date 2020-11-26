plugins {
	kotlin("jvm") version "1.4.20"
	id("nebula.release") version "15.3.0"
	id("ru.capjack.bintray") version "1.0.0"
}

group = "ru.capjack.tool"

repositories {
	jcenter()
}

kotlin {
	target.compilations.all { kotlinOptions.jvmTarget = "1.8" }
}