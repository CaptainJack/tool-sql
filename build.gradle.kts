plugins {
	kotlin("jvm") version "1.5.0"
	id("ru.capjack.publisher") version "0.2.0"
}

group = "ru.capjack.tool"

repositories {
	mavenCentral()
}

kotlin {
	target.compilations.all { kotlinOptions.jvmTarget = "11" }
}