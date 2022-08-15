plugins {
	kotlin("jvm") version "1.7.10"
	id("ru.capjack.publisher") version "1.0.0"
}

group = "ru.capjack.tool"

repositories {
	mavenCentral()
}

kotlin {
	target.compilations.all { kotlinOptions.jvmTarget = "17" }
}
