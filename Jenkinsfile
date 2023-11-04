pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                script {
                    // Checkout the code from the repository
                    checkout scm
                }
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test and JaCoCo Report') {
            steps {
                sh 'mvn clean verify'
            }
            post {
                always {
                    script {
                        sh 'mvn jacoco:report'
                    }
                }
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQubeServer') {
                    script {
                        sh 'mvn sonar:sonar'
                    }
                }
            }
        }
        stage('Nexus Deployment') {
            steps {

                      sh "mvn deploy -DskipTests"
                             }
                       }
        stage('Building Docker image') {
        	   steps {
        		 script {
        			// Generating image from Dockerfile
        			  sh 'docker build -t fedii97/DevOps_Project-2.1.jar .'
        			}
        		 }
        	    }
        stage('Push Docker Image') {
            steps {


                // Log in to Docker Hub with your credentials
                withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sh "docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD"
                }

                // Push the Docker image to Docker Hub
                sh "docker push fedii97/DevOps_Project-2.1.jar"
            }
        }
    }
}
