import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompile


plugins {
	kotlin("jvm") version "1.3.21"
	id("nebula.release") version "10.1.1"
	id("ru.capjack.bintray") version "0.17.0"
}

group = "ru.capjack.tool"

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