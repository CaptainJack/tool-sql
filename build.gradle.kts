plugins {
	kotlin("jvm") version "1.6.21"
	id("ru.capjack.publisher") version "1.0.0"
}

group = "ru.capjack.tool"

repositories {
	mavenCentral()
}

kotlin {
	target.compilations.all { kotlinOptions.jvmTarget = "11" }
}
