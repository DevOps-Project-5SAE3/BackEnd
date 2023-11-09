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
stage('JUnit Test') {
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


	stage("Deploy Artifact to Nexus") {
                steps {
                    sh "mvn deploy -DskipTests"
                }
            }

        stage('Image Docker Creation') {
                	   steps {
                		 script {
                			// Generating image from Dockerfile
                			  sh 'docker build -t salmaaz/devops_project_2.1.jar .'
                			}
                		 }
                	    }

        stage('Testing DockerHub') {
                    steps {
                     script {
                    // Define your Docker access token
                          def dockerAccessToken = 'dckr_pat_9QHNOif1fB_woh2c-EZLwRyNQNM'

                    // Log in to Docker Hub with --password-stdin
                            sh "echo '${dockerAccessToken}' | docker login -u salmaaz --password-stdin"
                    // Tag and push the Docker image

                            sh "docker push salmaaz/devops_project_2.1.jar"
                    }
                    }
                }



                }




}
