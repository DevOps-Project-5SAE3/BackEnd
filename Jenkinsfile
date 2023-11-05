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
        stage('Test') {
            steps {
                sh 'mvn test'
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
                                			  sh 'docker build -t rihabnasri/devops-0.0.1.jar .'
                                			}
                                		 }
                                	    }
                      stage('login Docker') {

                       script{
                                      // Log in to Docker Hub with your credentials
                                      withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                                          sh "docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD"

                                  }
                              }
                              }
                              stage('Push Docker image'){

                                    script{


                                          // Push the Docker image to Docker Hub
                                        sh "docker push rihabnasri/devopsproject-0.0.1.jar"

                                    }
                              }

    }

}