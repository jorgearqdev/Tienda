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
			checkout([
                $class: 'GitSCM', 
                branches: [[name: '*/master']], 
                doGenerateSubmoduleConfigurations: false, 
                extensions: [], 
                gitTool: 'Default', 
                submoduleCfg: [], 
                userRemoteConfigs: [[
                    credentialsId: 'GitHub_jorgearqdev', 
                    url:'https://github.com/jorgearqdev/Tienda.git'
            	]]
        	])
		}
    }
	
	stage('Clean') {
         steps{
			sh 'chmod +x ./microservicio/gradlew'
            sh './microservicio/gradlew --b ./microservicio/build.gradle clean'
		}
	}
	
	stage('Build') {
      steps {
        echo "------------>Build<------------"
		sh './microservicio/gradlew --b ./microservicio/build.gradle build -x test'
      }
    }  
    

    stage('Static Code Analysis') {
      steps{
        echo '------------>Análisis de código estático<------------'
        withSonarQubeEnv('Sonar') {
			sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
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
		junit '**/test-results/test/*.xml'
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
