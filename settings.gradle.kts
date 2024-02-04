enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "jellyfin-androidtv"

// Application
include(":app")

// Modules
include(":playback:core")
include(":playback:exoplayer")
include(":playback:jellyfin")
include(":playback:ui")
include(":preference")

include(":sdk")
project(":sdk").projectDir = file("../jellyfin-sdk-kotlin")
project(":sdk").buildFileName = "build.gradle"

pluginManagement {
	repositories {
		gradlePluginPortal()
		mavenCentral()
		google()
	}
}

dependencyResolutionManagement {
	repositories {


//		var ALIYUN_REPOSITORY_URL = "https://maven.aliyun.com/repository/public"
//		var ALIYUN_JCENTER_URL = "https://maven.aliyun.com/repository/public"
//		val ALIYUN_GOOGLE_URL = "https://maven.aliyun.com/repository/google"
//		val ALIYUN_GRADLE_PLUGIN_URL = "https://maven.aliyun.com/repository/gradle-plugin"
//
//		maven (ALIYUN_REPOSITORY_URL)
//		maven (ALIYUN_JCENTER_URL)
//		maven (ALIYUN_GOOGLE_URL)
//		maven (ALIYUN_GRADLE_PLUGIN_URL)


		mavenCentral()
		google()

		// Jellyfin SDK
		mavenLocal {
			content {
				includeVersionByRegex("org.jellyfin.sdk", ".*", "latest-SNAPSHOT")
			}
		}
		maven("https://s01.oss.sonatype.org/content/repositories/snapshots/") {
			content {
				includeVersionByRegex("org.jellyfin.sdk", ".*", "master-SNAPSHOT")
				includeVersionByRegex("org.jellyfin.sdk", ".*", "openapi-unstable-SNAPSHOT")
			}
		}

		// Jellyfin apiclient
//		maven("https://jitpack.io") {
//			content {
//				// Only allow legacy apiclient
//				includeVersionByRegex("com.github.jellyfin.jellyfin-sdk-kotlin", ".*", "v0.7.10")
//			}
//		}


	}
}
