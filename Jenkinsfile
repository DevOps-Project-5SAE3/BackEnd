pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
               checkout([$class: 'GitSCM', branches: [[name: '*/salma']], userRemoteConfigs: [[url: 'https://github.com/DevOps-Project-5SAE3/BackEnd.git']]])
            }
        }
        stage('cleaning project') {
            steps {
                sh 'mvn clean '
            }
        }
        stage('compiling project') {
            steps {
                sh 'mvn compile'
            }

}
stage('tests JUnit Mockito') {
            steps {
                sh "mvn test"  

                sh "mvn jacoco:report"
            }
        }
stage('Run Sonar')  {
            steps {
                withCredentials([string(credentialsId: 'sonar', variable: 'SONAR_TOKEN')]) {
                    sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.1.3:9000/ -Dsonar.login=$SONAR_TOKEN'
                }
            }
      }


        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }

	}
	stage("Deploy Artifact to Nexus") {
                steps {
                    sh "mvn deploy -DskipTests"
                }
            }



                }




}
