import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompile

plugins {
	kotlin("jvm") version "1.3.21"
	id("nebula.release") version "9.2.0"
	id("ru.capjack.capjack-bintray") version "0.16.0"
}

group = "ru.capjack.ktjvm"

repositories {
	jcenter()
}

dependencies {
	implementation(kotlin("stdlib-jdk8"))
}

tasks.withType<KotlinJvmCompile> {
	kotlinOptions.jvmTarget = "1.8"
}

tasks.create<Jar>("sourcesJar") {
	archiveClassifier.set("sources")
	from(sourceSets.main.get().allSource)
}