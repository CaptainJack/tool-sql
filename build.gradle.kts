plugins {
	kotlin("jvm") version "1.8.21"
	id("ru.capjack.publisher") version "1.1.0"
}

group = "ru.capjack.tool"

repositories {
	mavenCentral()
}

kotlin {
	jvmToolchain(17)
}
