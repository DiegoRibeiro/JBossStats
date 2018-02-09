# JBossStats
An agent to collect statistics about bosses from tibia's website kill statistics using web scraping.

Dependencies:

	jsoup: https://jsoup.org/
	maven: https://maven.apache.org/
	
Configuration:

	Initialize project:
		Maven in five minutes: https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
		mvn archetype:generate -DgroupId=br.com.jbossstats.app -DartifactId=jbossstats -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
	
	compile:
		mvn package
	
	run:
		java -cp target\jbossstats-1.0-SNAPSHOT.jar br.com.jbossstats.app.App
