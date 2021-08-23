pipeline {
  
  agent {
    label 'Slave_Induccion'
  }

  tools {
    jdk 'JDK8_Centos' 
  }

  //Aquí comienzan los “items” del Pipeline
  stages{
    stage('Checkout') {
		steps{
			echo "------------>Checkout<------------"
		}
    }
	
	stage('Build') {
      steps {
        echo "------------>Build<------------"
		sh 'gradlew clean assembleRelease'
		sh 'gradlew build -x test'
      }
    }  
    
    stage('Compile & Unit Tests') {
		steps{
			echo "------------>>Clean<------------"
			sh 'gradlew clean'

			echo "------------>Unit Tests<------------"
			sh 'gradlew test'
		}
    }

    stage('Static Code Analysis') {
      steps{
        echo '------------>Análisis de código estático<------------'
        withSonarQubeEnv('Sonar') {
sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
        }
      }
    }

    
  }

  post {
    always {
		echo 'This will always run'
    }
    success {
		echo 'This will run only if successful'
		junit 'app/build/test-results/testDebugUnitTest/*.xml'
    }
    failure {
		echo 'This will run only if failed'
		mail (to: 'jorge.gaviria@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
    }
    unstable {
		echo 'This will run only if the run was marked as unstable'
    }
    changed {
		echo 'This will run only if the state of the Pipeline has changed'
		echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}
