import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompile


plugins {
	kotlin("jvm") version "1.3.41"
	id("nebula.release") version "11.1.0"
	id("ru.capjack.bintray") version "0.19.0"
}

group = "ru.capjack.tool"

repositories {
	jcenter()
}

kotlin {
	target {
		compilations.all { kotlinOptions.jvmTarget = "1.8" }
	}
}

dependencies {
	implementation(kotlin("stdlib-jdk8"))
}

/*
tasks.create<Jar>("sourcesJar") {
	archiveClassifier.set("sources")
	from(sourceSets.main.get().allSource)
}*/
